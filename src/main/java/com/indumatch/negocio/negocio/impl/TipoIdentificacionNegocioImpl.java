package com.indumatch.negocio.negocio.impl;

import java.util.List;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dominio.TipoIdentificacionDominio;
import com.indumatch.negocio.negocio.TipoIdentificacionNegocio;
import com.indumatch.negocio.negocio.assembler.impl.TipoIdentificacionEntidadAssembler;

public class TipoIdentificacionNegocioImpl implements TipoIdentificacionNegocio {

	private DAOFactory daoFactory;

	public TipoIdentificacionNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<TipoIdentificacionDominio> consultarTodos() {
		var tiposIdentificacionEntidad = daoFactory.obtenerTipoIdentificacionDAO().consultarTodos();
		return tiposIdentificacionEntidad.stream().map(TipoIdentificacionEntidadAssembler.getInstance()::convertirADominio).toList();
	}

}
