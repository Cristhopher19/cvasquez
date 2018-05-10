
package Controller;

import DAO.ClientesDao;
import Modelo.ClientesM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;


@Named(value = "clientesCrontroller")
@SessionScoped
public class ClientesCrontroller implements Serializable {

   List<ClientesM> LstCli = new ArrayList();
    ClientesM clientesM = new ClientesM();

    @PostConstruct
    public void star() {
       try {
           listMantenimiento();
       } catch (Exception ex) {
           Logger.getLogger(ClientesCrontroller.class.getName()).log(Level.SEVERE, null, ex);
       }
       
       
    }

    public void listMantenimiento() throws Exception {
        ClientesDao dao;
        try {
            dao = new ClientesDao();
            LstCli = dao.listarHab();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresar() throws Exception {
        ClientesDao dao;
        try {
            dao = new ClientesDao();
            dao.Ingresar(clientesM);
            listMantenimiento();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizar() throws Exception {
        ClientesDao dao;
        try {
            dao = new ClientesDao();
            dao.Actualizar(clientesM);
            listMantenimiento();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        clientesM = new ClientesM();

    }

    public List<ClientesM> getLstCli() {
        return LstCli;
    }

    public void setLstCli(List<ClientesM> LstCli) {
        this.LstCli = LstCli;
    }


    public ClientesM getClientesM() {
        return clientesM;
    }

    public void setClientesM(ClientesM clientesM) {
        this.clientesM = clientesM;
    }
    
}
