package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.ModeloMotoDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.ModeloMotoEntidad;

public class ModeloMotoPostgreSqlDAO extends SqlDAO implements ModeloMotoDAO {

	public ModeloMotoPostgreSqlDAO(Connection conexion) {
		super(conexion);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(ModeloMotoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ModeloMotoEntidad consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModeloMotoEntidad> consultarPorFiltro(ModeloMotoEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ModeloMotoEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, ModeloMotoEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}

}
