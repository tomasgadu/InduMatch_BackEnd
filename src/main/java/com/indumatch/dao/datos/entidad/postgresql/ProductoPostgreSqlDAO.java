package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.ProductoDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.ProductoEntidad;

public class ProductoPostgreSqlDAO extends SqlDAO implements ProductoDAO {

	public ProductoPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(ProductoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoEntidad> consultarPorFiltro(ProductoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, ProductoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
