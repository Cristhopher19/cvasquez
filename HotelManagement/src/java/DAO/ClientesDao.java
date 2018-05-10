package DAO;

import Modelo.ClientesM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientesDao extends Dao {

    public List<ClientesM> listarHab() throws Exception {
        this.Conectar();
        List<ClientesM> lista;
        ResultSet rs;

        try {
            String sql = "select Dni_Cli, Nom_Cli,Ape_Cli,IdUbi,Dir_Cli From T_CLIENTE";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            ClientesM Model;
            while (rs.next()) {
                Model = new ClientesM();
                Model.setDni_Cli(rs.getString("DNI_CLI"));
                Model.setNom_Cli(rs.getString("NOM_CLI"));
                Model.setApe_Cli(rs.getString("APE_CLI"));
                Model.setUbigeo(rs.getString("IDUBI"));
                Model.setDir_Cli(rs.getString("DIR_CLI"));
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void Ingresar(ClientesM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "insert into T_CLIENTE (Dni_Cli, Nom_Cli,Ape_Cli,IdUbi,Dir_Cli) values (?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getDni_Cli());
            ps.setString(2, Model.getNom_Cli());
            ps.setString(3, Model.getApe_Cli());
            ps.setString(4, Model.getUbigeo());
            ps.setString(5, Model.getDir_Cli());

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public void Actualizar(ClientesM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE T_CLIENTE set Nom_Cli=? ,Ape_Cli=? ,IdUbi=? ,Dir_Cli=?  WHERE Dni_Cli like ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getNom_Cli());
            ps.setString(2, Model.getApe_Cli());
            ps.setString(3, Model.getUbigeo());
            ps.setString(4, Model.getDir_Cli());
            ps.setString(5, Model.getDni_Cli());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
