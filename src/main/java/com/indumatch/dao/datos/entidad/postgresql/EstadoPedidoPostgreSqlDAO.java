package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.EstadoPedidoDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.EstadoPedidoEntidad;

public class EstadoPedidoPostgreSqlDAO extends SqlDAO implements EstadoPedidoDAO {

	public EstadoPedidoPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(EstadoPedidoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EstadoPedidoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoPedidoEntidad> consultarPorFiltro(EstadoPedidoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstadoPedidoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, EstadoPedidoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
