package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.HomologacionDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.HomologacionEntidad;

public class HomologacionPostgreSqlDAO extends SqlDAO implements HomologacionDAO {

	public HomologacionPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(HomologacionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HomologacionEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HomologacionEntidad> consultarPorFiltro(HomologacionEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HomologacionEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, HomologacionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
