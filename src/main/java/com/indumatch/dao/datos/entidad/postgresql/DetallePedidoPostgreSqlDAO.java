package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.DetallePedidoDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.DetallePedidoEntidad;

public class DetallePedidoPostgreSqlDAO extends SqlDAO implements DetallePedidoDAO {

	public DetallePedidoPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(DetallePedidoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetallePedidoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePedidoEntidad> consultarPorFiltro(DetallePedidoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DetallePedidoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, DetallePedidoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
