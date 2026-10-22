package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.TransportadoraDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.TransportadoraEntidad;

public class TransportadoraPostgreSqlDAO extends SqlDAO implements TransportadoraDAO {

	public TransportadoraPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(TransportadoraEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TransportadoraEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransportadoraEntidad> consultarPorFiltro(TransportadoraEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TransportadoraEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, TransportadoraEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
