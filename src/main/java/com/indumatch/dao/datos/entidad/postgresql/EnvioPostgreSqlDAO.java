package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.EnvioDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.EnvioEntidad;

public class EnvioPostgreSqlDAO extends SqlDAO implements EnvioDAO {

	public EnvioPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(EnvioEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EnvioEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnvioEntidad> consultarPorFiltro(EnvioEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EnvioEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, EnvioEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

}
