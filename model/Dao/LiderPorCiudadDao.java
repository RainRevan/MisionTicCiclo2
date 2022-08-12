package com.misiontic.reto5.model.Dao;

import com.misiontic.reto5.model.Vo.LiderPorCiudadVo;
import com.misiontic.reto5.utilities.JDBCUtilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;

public class LiderPorCiudadDao {

    public ArrayList<LiderPorCiudadVo> listar() throws SQLException {
        ArrayList<LiderPorCiudadVo> resultado = new ArrayList<LiderPorCiudadVo>();
        Connection conn = JDBCUtilities.getConnection();
        try {
            String sql = "SELECT l.ID_Lider, l.Nombre, l.Primer_Apellido, l.Ciudad_Residencia" +
                    " FROM Lider l " +
                    " ORDER BY l.Ciudad_Residencia; ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                LiderPorCiudadVo lider = new LiderPorCiudadVo(
                        rs.getInt("ID_Lider"),
                        rs.getString("Nombre"),
                        rs.getString("Primer_Apellido"),
                        rs.getString("Ciudad_Residencia")
                );
                resultado.add(lider);
            }
            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println("Error en la consulta ");
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return resultado;
    }
}
