package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Alumno implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_alumno")
    private int idAlumno;
    
    private String nombre;
    
    private String apellido;
    
    @JoinColumn(name = "id_domicilio", referencedColumnName = "id_domicilio")
    @ManyToOne
    private Domicilio domicilio;
    
    @JoinColumn(name = "id_contacto", referencedColumnName = "id_contacto")
    @ManyToOne
    private Contacto contacto;

    @OneToMany(mappedBy = "alumno")
    private List<Asignacion> asignaciones;

    public Alumno() {
    }

    public Alumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idAlumno=" + idAlumno + ", nombre=" + nombre + ", apellido=" + apellido + ", domicilio=" + domicilio + ", contacto=" + contacto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.idAlumno;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        return this.idAlumno == other.idAlumno;
    }
    
    
    
}
