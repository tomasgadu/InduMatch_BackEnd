package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.PaisDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.PaisEntidad;

public class PaisPostgreSqlDAO extends SqlDAO implements PaisDAO {

	public PaisPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(PaisEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PaisEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(PaisEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, PaisEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
