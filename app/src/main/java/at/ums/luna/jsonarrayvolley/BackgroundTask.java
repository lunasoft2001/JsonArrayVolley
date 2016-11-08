package at.ums.luna.jsonarrayvolley;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by luna-aleixos on 07.11.2016.
 */

public class BackgroundTask {

    Context context;
    ArrayList<Contact> arrayList = new ArrayList<>();
    String json_url = "http://192.168.0.108/fran/obtener_alumnos.php";

    public  BackgroundTask (Context context){
        this.context = context;
    }

    public ArrayList<Contact> getList(){

        JsonArrayRequest jsonArrayRequest =  new JsonArrayRequest(Request.Method.POST, json_url, (String) null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        int count = 0;
                        while (count < response.length()){
                            try {
                                JSONObject jsonObject = response.getJSONObject(count);
                                Contact contact = new Contact(jsonObject.getString("idAlumno"),
                                        jsonObject.getString("nombre"),
                                        jsonObject.getString("direccion"));
                                arrayList.add(contact);
                                Log.i("JJ", "El array contiene ahora " + arrayList.size() + " registros");

                                count++;

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context,"Error....", Toast.LENGTH_SHORT).show();
                error.printStackTrace();

            }
        });

        MySingleton.getInstance(context).addToRequestque(jsonArrayRequest);

        Log.i("JJ", "El array total contiene " + arrayList.size() + " registros");
        return arrayList;

    }
}
