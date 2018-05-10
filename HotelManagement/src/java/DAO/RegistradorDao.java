package DAO;

import Modelo.RegistradorM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RegistradorDao extends Dao {

    public List<RegistradorM> listarHab() throws Exception {
        this.Conectar();
        List<RegistradorM> lista;
        ResultSet rs;

        try {
            String sql = "select DNI_REG, NOM_REG, APE_REG, IDUBI From T_REGISTRADOR";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            RegistradorM Model;
            while (rs.next()) {
                Model = new RegistradorM();
                Model.setDNI_REG(rs.getString("DNI_REG"));
                Model.setNOM_REG(rs.getString("NOM_REG"));
                Model.setAPE_REG(rs.getString("APE_REG"));
                Model.setIDUBI(rs.getString("IDUBI"));
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void Ingresar(RegistradorM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "insert into T_REGISTRADOR (DNI_REG, NOM_REG, APE_REG, IDUBI) values (?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getDNI_REG());
            ps.setString(2, Model.getNOM_REG());
            ps.setString(3, Model.getAPE_REG());
            ps.setString(4, Model.getIDUBI());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public void Actualizar(RegistradorM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE T_REGISTRADOR set NOM_REG=? , APE_REG=? , IDUBI=?   WHERE DNI_REG like ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getNOM_REG());
            ps.setString(2, Model.getAPE_REG());
            ps.setString(3, Model.getIDUBI());
            ps.setString(4, Model.getDNI_REG());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
