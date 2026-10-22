package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.MarcaFabricanteDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.MarcaFabricanteEntidad;

public class MarcaFabricantePostgreSqlDAO extends SqlDAO implements MarcaFabricanteDAO {

	public MarcaFabricantePostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(MarcaFabricanteEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MarcaFabricanteEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarcaFabricanteEntidad> consultarPorFiltro(MarcaFabricanteEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarcaFabricanteEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, MarcaFabricanteEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
