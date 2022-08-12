package com.misiontic.reto5.model.Dao;

import com.misiontic.reto5.model.Vo.ProyectoUbicacionVo;
import com.misiontic.reto5.utilities.JDBCUtilities;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProyectoUbicacionDao {

    public ArrayList<ProyectoUbicacionVo> listar() throws SQLException {

        ArrayList<ProyectoUbicacionVo> resultado = new ArrayList<ProyectoUbicacionVo>();
        Connection conn = JDBCUtilities.getConnection();
        try {
            String sql = "SELECT p.ID_Proyecto, p.Constructora, p.Numero_Habitaciones, p.Ciudad "
                    + "FROM Proyecto p "
                    + "WHERE p.Ciudad IN('Santa Marta','Cartagena','Barranquilla')"
                    + "AND p.Clasificacion = 'Casa Campestre';";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                ProyectoUbicacionVo ubicacion = new ProyectoUbicacionVo (
                        rs.getInt("ID_Proyecto"),
                        rs.getString("Constructora"),
                        rs.getDouble("Numero_Habitaciones"),
                        rs.getString("Ciudad")
                );
                resultado.add(ubicacion);
            }
            rs.close();
            stmt.close();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
        return resultado;
    }
}
