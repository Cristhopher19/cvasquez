
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dao {
    
    private Connection Dao;

    public void Conectar() throws Exception {       //Metodo con los datos de acceso
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Dao = DriverManager.getConnection("jdbc:oracle:thin:@localhost:XE", "HotelManagement", "admin");
        } catch (ClassNotFoundException | SQLException e) {
            throw e;
        }
    }

    public void Cerrar() throws SQLException {      //Cerrar la coneccion
        if (Dao != null) {
            if (Dao.isClosed() == false) {
                Dao.close();
            }
        }
    }

    public Connection getCn() {
        return Dao;
    }

    public void setCn(Connection cn) {
        this.Dao = cn;
    }

    public static void main(String[] args) throws Exception {
        Dao dao = new Dao();
        dao.Conectar();
        if (dao.getCn() != null) {
            System.out.println("conectado");
        } else {
            System.out.println("error");
        }
    }
}
