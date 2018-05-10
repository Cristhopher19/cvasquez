package DAO;

import Modelo.TipoHabitacionM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoHabitacionDao extends Dao {

    public List<TipoHabitacionM> listarTip() throws Exception {
        this.Conectar();
        List<TipoHabitacionM> lista;
        ResultSet rs;

        try {
            String sql = "select Cod_Tip, Tip_Hab From T_TipoHabitacion Order by Cod_Tip";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            TipoHabitacionM Model;
            while (rs.next()) {
                Model = new TipoHabitacionM();
                Model.setCod_Tip(rs.getString("Cod_Tip"));
                Model.setTip_Hab(rs.getString("Tip_Hab"));
                lista.add(Model);

            }
            return lista;
        } catch (Exception e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void Ingresar(TipoHabitacionM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "insert into T_TIPOHABITACION (Cod_Tip,Tip_Hab) values (?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getCod_Tip());
            ps.setString(2, Model.getTip_Hab());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public void Actualizar(TipoHabitacionM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE T_TIPOHABITACION set Tip_Hab= ? WHERE Cod_Tip like ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getTip_Hab());
            ps.setString(2, Model.getCod_Tip());

            ps.executeUpdate();

        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

}
