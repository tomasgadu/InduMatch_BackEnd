package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.TipoIdentificacionDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.TipoIdentificacionEntidad;

public class TipoIdentificacionPostgreSqlDAO extends SqlDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(TipoIdentificacionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoIdentificacionEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarPorFiltro(TipoIdentificacionEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, TipoIdentificacionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
