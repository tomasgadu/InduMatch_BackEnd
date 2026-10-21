package com.indumatch.dao.datos.entidad;

import java.sql.Connection;

import com.indumatch.transversal.utilitarios.UtilSQL;

public abstract class SqlDAO {
	
	private Connection conexion;
	
	protected SqlDAO(Connection conexion) {
		setConexion(conexion);
	}

	private Connection getConexion() {
		return conexion;
	}

	private void setConexion(Connection conexion) {
		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion = conexion;
	}
}
