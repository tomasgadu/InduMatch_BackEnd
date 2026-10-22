package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.DepartamentoDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.DepartamentoEntidad;

public class DepartamentoPostgreSqlDAO extends SqlDAO implements DepartamentoDAO {

	public DepartamentoPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(DepartamentoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DepartamentoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoEntidad> consultarPorFiltro(DepartamentoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DepartamentoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, DepartamentoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
