package DAO;

import Modelo.HabitacionesM;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HabitacionesDao extends Dao {

    public List<HabitacionesM> listarHab() throws Exception {
        this.Conectar();
        List<HabitacionesM> lista;
        ResultSet rs;

        try {
            String sql = "select COD_HAB,NUM_HAB,EST_HAB,DES_EST,COS_HAB,DES_HAB,COD_TIP From T_HABITACIONES Order by COD_HAB";
            PreparedStatement ps = this.getCn().prepareCall(sql);
            rs = ps.executeQuery();
            lista = new ArrayList<>();
            HabitacionesM Model;
            while (rs.next()) {
                Model = new HabitacionesM();
                Model.setCod_Hab(rs.getString("COD_HAB"));
                Model.setNum_Hab(rs.getString("NUM_HAB"));
                Model.setEst_Hab(rs.getString("EST_HAB"));
                Model.setDes_Est(rs.getString("DES_EST"));
                Model.setCos_Hab(rs.getString("COS_HAB"));
                Model.setDes_Hab(rs.getString("DES_HAB"));
                Model.setTipo(rs.getString("COD_TIP"));
                lista.add(Model);
            }
            return lista;
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }

    public void Ingresar(HabitacionesM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "insert into T_HABITACIONES (COD_HAB,NUM_HAB,EST_HAB,DES_EST,COS_HAB,DES_HAB,COD_TIP) values (?,?,?,?,?,?,?)";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getCod_Hab());
            ps.setString(2, Model.getNum_Hab());
            ps.setString(3, Model.getEst_Hab());
            ps.setString(4, Model.getDes_Est());
            ps.setString(5, Model.getCos_Hab());
            ps.setString(6, Model.getDes_Hab());
            ps.setString(7, Model.getTipo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }

    }

    public void Actualizar(HabitacionesM Model) throws Exception {
        this.Conectar();
        try {
            String sql = "UPDATE T_HABITACIONES set NUM_HAB = ? ,EST_HAB = ? ,DES_EST = ? ,COS_HAB = ?,DES_HAB = ?,COD_TIP = ? WHERE COD_HAB like ?";
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, Model.getNum_Hab());
            ps.setString(2, Model.getEst_Hab());
            ps.setString(3, Model.getDes_Est());
            ps.setString(4, Model.getCos_Hab());
            ps.setString(5, Model.getDes_Hab());
            ps.setString(6, Model.getTipo());
            ps.setString(7, Model.getCod_Hab());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            this.Cerrar();
        }
    }
}
