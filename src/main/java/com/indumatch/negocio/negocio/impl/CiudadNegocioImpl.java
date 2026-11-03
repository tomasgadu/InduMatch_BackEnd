package com.indumatch.negocio.negocio.impl;

import java.util.List;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dominio.CiudadDominio;
import com.indumatch.negocio.negocio.CiudadNegocio;
import com.indumatch.negocio.negocio.assembler.impl.CiudadEntidadAssembler;

public class CiudadNegocioImpl implements CiudadNegocio {

	private DAOFactory daoFactory;

	public CiudadNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<CiudadDominio> consultarTodos() {
		var ciudadesEntidad = daoFactory.obtenerCiudadDAO().consultarTodos();
		return ciudadesEntidad.stream().map(CiudadEntidadAssembler.getInstance()::convertirADominio).toList();
	}

}
