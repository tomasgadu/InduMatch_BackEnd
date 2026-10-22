package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.CategoriaProductoDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.CategoriaProductoEntidad;

public class CategoriaProductoPostgreSqlDAO extends SqlDAO implements CategoriaProductoDAO {

	public CategoriaProductoPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(CategoriaProductoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CategoriaProductoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoEntidad> consultarPorFiltro(CategoriaProductoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CategoriaProductoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, CategoriaProductoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
