package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.LineaModeloDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.LineaModeloEntidad;

public class LineaModeloPostgreSqlDAO extends SqlDAO implements LineaModeloDAO {

	public LineaModeloPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(LineaModeloEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LineaModeloEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaModeloEntidad> consultarPorFiltro(LineaModeloEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LineaModeloEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, LineaModeloEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
