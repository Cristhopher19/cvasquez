
package Controller;

import DAO.RegistradorDao;
import Modelo.RegistradorM;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

@Named(value = "registradorController")
@SessionScoped
public class RegistradorController implements Serializable {


     List<RegistradorM> LstReg = new ArrayList();
    RegistradorM registradorM = new RegistradorM();

    @PostConstruct
    public void star() {
       
         try {
             listMantenimiento();
         } catch (Exception ex) {
             Logger.getLogger(RegistradorController.class.getName()).log(Level.SEVERE, null, ex);
         }
       
    }

    public void listMantenimiento() throws Exception {
        RegistradorDao dao;
        try {
            dao = new RegistradorDao();
            LstReg = dao.listarHab();
        } catch (Exception e) {
            throw e;
        }
    }

    public void ingresar() throws Exception {
        RegistradorDao dao;
        try {
            dao = new RegistradorDao();
            dao.Ingresar(registradorM);
            listMantenimiento();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void actualizar() throws Exception {
        RegistradorDao dao;
        try {
            dao = new RegistradorDao();
            dao.Actualizar(registradorM);
            listMantenimiento();
            limpiar();
        } catch (Exception e) {
            throw e;
        }
    }

    public void limpiar() {
        registradorM = new RegistradorM();

    }

    public List<RegistradorM> getLstReg() {
        return LstReg;
    }

    public void setLstReg(List<RegistradorM> LstReg) {
        this.LstReg = LstReg;
    }

    public RegistradorM getRegistradorM() {
        return registradorM;
    }

    public void setRegistradorM(RegistradorM registradorM) {
        this.registradorM = registradorM;
    }
    
}
