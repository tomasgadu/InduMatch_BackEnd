package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.PedidoDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.PedidoEntidad;

public class PedidoPostgreSqlDAO extends SqlDAO implements PedidoDAO {

	public PedidoPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(PedidoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PedidoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoEntidad> consultarPorFiltro(PedidoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, PedidoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
