package mx.com.gm.domain;


import java.io.Serializable;
import javax.persistence.*;


@Entity
public class Domicilio implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_domicilio")
    private int idDomicilio;
    
    private String calle;
    
    @Column(name = "no_calle")
    private String noCalle;
    
    public Domicilio(){
        
    }
    
    public Domicilio(int idDomicilio){
        this.idDomicilio = idDomicilio;
    }

    public int getIdDomicilio() {
        return idDomicilio;
    }

    public void setIdDomicilio(int idDomicilio) {
        this.idDomicilio = idDomicilio;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNoCalle() {
        return noCalle;
    }

    public void setNoCalle(String noCalle) {
        this.noCalle = noCalle;
    }

    @Override
    public String toString() {
        return "Domicilio{" + "idDomicilio=" + idDomicilio + ", calle=" + calle + ", noCalle=" + noCalle + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.idDomicilio;
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
        final Domicilio other = (Domicilio) obj;
        return this.idDomicilio == other.idDomicilio;
    }

}
