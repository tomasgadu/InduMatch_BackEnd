package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.MarcaComercialDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.MarcaComercialEntidad;

public class MarcaComercialPostgreSqlDAO extends SqlDAO implements MarcaComercialDAO {

	public MarcaComercialPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(MarcaComercialEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MarcaComercialEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarcaComercialEntidad> consultarPorFiltro(MarcaComercialEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MarcaComercialEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, MarcaComercialEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
