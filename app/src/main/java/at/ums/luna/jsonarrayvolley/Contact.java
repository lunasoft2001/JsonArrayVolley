package at.ums.luna.jsonarrayvolley;

/**
 * Created by luna-aleixos on 07.11.2016.
 */

public class Contact {

    private String idAlumno, nombre, direccion;

    public Contact(String idAlumno, String nombre, String direccion) {

        this.setIdAlumno(idAlumno);
        this.setNombre(nombre);
        this.setDireccion(direccion);

    }

    public String getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(String idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
