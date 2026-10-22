package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.ClienteNaturalDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.ClienteNaturalEntidad;

public class ClienteNaturalPostgreSqlDAO extends SqlDAO implements ClienteNaturalDAO {

	public ClienteNaturalPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(ClienteNaturalEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClienteNaturalEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteNaturalEntidad> consultarPorFiltro(ClienteNaturalEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteNaturalEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, ClienteNaturalEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
