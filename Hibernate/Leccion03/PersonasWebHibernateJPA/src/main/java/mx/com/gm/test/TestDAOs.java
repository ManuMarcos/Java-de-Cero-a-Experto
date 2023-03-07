package mx.com.gm.test;

import java.util.List;
import mx.com.gm.dao.AlumnoDAO;

public class TestDAOs {
    public static void main(String[] args) {
        AlumnoDAO alumnoDao = new AlumnoDAO();
        System.out.println("Alumnos: ");
        imprimir(alumnoDao.listar());
    }
    
    private static void imprimir(List coleccion){
        for(Object o : coleccion){
            System.out.println("valor = " + o);
        }
    }
}
