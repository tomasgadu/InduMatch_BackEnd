package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.CiudadDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.CiudadEntidad;

public class CiudadPostgreSqlDAO extends SqlDAO implements CiudadDAO {

	public CiudadPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(CiudadEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadEntidad> consultarPorFiltro(CiudadEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, CiudadEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
