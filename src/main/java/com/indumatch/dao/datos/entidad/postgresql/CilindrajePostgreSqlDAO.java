package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.CilindrajeDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.CilindrajeEntidad;

public class CilindrajePostgreSqlDAO extends SqlDAO implements CilindrajeDAO {

	public CilindrajePostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(CilindrajeEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CilindrajeEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CilindrajeEntidad> consultarPorFiltro(CilindrajeEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CilindrajeEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, CilindrajeEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
