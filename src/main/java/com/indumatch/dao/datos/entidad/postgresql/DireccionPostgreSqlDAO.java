package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.DireccionDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.DireccionEntidad;

public class DireccionPostgreSqlDAO extends SqlDAO implements DireccionDAO {

	public DireccionPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(DireccionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DireccionEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DireccionEntidad> consultarPorFiltro(DireccionEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DireccionEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, DireccionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
