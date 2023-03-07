package mx.com.gm.domain;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Curso implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private int idCurso;
    
    private String nombre;
    
    private double precio;
    
    @OneToMany(mappedBy = "curso")
    private List<Asignacion> asignaciones;
    
    public Curso(){}
    
    public Curso(int idCurso){
        this.idCurso = idCurso;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Asignacion> getAsignaciones() {
        return asignaciones;
    }

    public void setAsignaciones(List<Asignacion> asignaciones) {
        this.asignaciones = asignaciones;
    }
    
    @Override
    public String toString() {
        return "Curso{" + "idCurso=" + idCurso + ", nombre=" + nombre + ", precio=" + precio + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.idCurso;
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
        final Curso other = (Curso) obj;
        return this.idCurso == other.idCurso;
    }
    
    
    
}
