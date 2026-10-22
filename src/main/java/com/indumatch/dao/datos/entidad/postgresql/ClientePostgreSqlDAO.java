package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.ClienteDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.ClienteEntidad;

public class ClientePostgreSqlDAO extends SqlDAO implements ClienteDAO {

	public ClientePostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(ClienteEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteEntidad> consultarPorFiltro(ClienteEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, ClienteEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
