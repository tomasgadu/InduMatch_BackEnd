package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.ClienteDistribuidorDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.ClienteDistribuidorEntidad;

public class ClienteDistribuidorPostgreSqlDAO extends SqlDAO implements ClienteDistribuidorDAO {

	public ClienteDistribuidorPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(ClienteDistribuidorEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteDistribuidorEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDistribuidorEntidad> consultarPorFiltro(ClienteDistribuidorEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDistribuidorEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, ClienteDistribuidorEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
