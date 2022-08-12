package com.misiontic.reto5.controller;

import com.misiontic.reto5.model.Dao.CompraPorProveedorDao;
import com.misiontic.reto5.model.Dao.LiderPorCiudadDao;
import com.misiontic.reto5.model.Dao.ProyectoUbicacionDao;
import com.misiontic.reto5.model.Vo.CompraPorProveedorVo;
import com.misiontic.reto5.model.Vo.LiderPorCiudadVo;
import com.misiontic.reto5.model.Vo.ProyectoUbicacionVo;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReportesController {

    private final LiderPorCiudadDao LiderPorCiudadDao;
    private final ProyectoUbicacionDao ProyectoUbicacionDao;
    private final CompraPorProveedorDao CompraPorProveedorDao;
    
    public ReportesController() {
        LiderPorCiudadDao = new LiderPorCiudadDao();
        ProyectoUbicacionDao = new ProyectoUbicacionDao();
        CompraPorProveedorDao = new CompraPorProveedorDao();
    }

    public ArrayList<LiderPorCiudadVo> consultarLiderPorCiudad() throws SQLException {
        return LiderPorCiudadDao.listar();
    }

    public ArrayList<ProyectoUbicacionVo> consultarProyectoUbicacion() throws SQLException {
        return ProyectoUbicacionDao.listar();
    }

    public ArrayList<CompraPorProveedorVo> consultarCompraPorProveedor() throws SQLException {
        return CompraPorProveedorDao.listar();
    }
}
