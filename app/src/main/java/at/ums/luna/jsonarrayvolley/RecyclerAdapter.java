package at.ums.luna.jsonarrayvolley;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by luna-aleixos on 07.11.2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Contact> arraylist = new ArrayList<>();

    public RecyclerAdapter (ArrayList<Contact> arraylist){
        this.arraylist = arraylist;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.idAlumno.setText(arraylist.get(position).getIdAlumno());
        holder.nombre.setText(arraylist.get(position).getNombre());
        holder.direccion.setText(arraylist.get(position).getDireccion());

    }

    @Override
    public int getItemCount() {
        return arraylist.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView idAlumno, nombre, direccion;

        public MyViewHolder(View itemView) {
            super(itemView);
            idAlumno = (TextView)itemView.findViewById(R.id.idAlumno);
            nombre = (TextView)itemView.findViewById(R.id.nombre);
            direccion = (TextView)itemView.findViewById(R.id.direccion);
        }
    }
}
