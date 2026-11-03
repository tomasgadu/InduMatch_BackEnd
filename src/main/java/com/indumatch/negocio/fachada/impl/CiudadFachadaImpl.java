package com.indumatch.negocio.fachada.impl;

import java.util.List;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dto.CiudadDTO;
import com.indumatch.negocio.fachada.CiudadFachada;
import com.indumatch.negocio.fachada.assembler.impl.CiudadDTOAssembler;
import com.indumatch.negocio.negocio.CiudadNegocio;
import com.indumatch.negocio.negocio.impl.CiudadNegocioImpl;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchExcepcion;
import com.indumatch.transversal.excepciones.InduMatchFachadaException;

public class CiudadFachadaImpl implements CiudadFachada {

	private DAOFactory daoFactory;
	private CiudadNegocio ciudadNegocio;

	public CiudadFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		ciudadNegocio = new CiudadNegocioImpl(daoFactory);
	}

	@Override
	public List<CiudadDTO> consultarTodos() {

		try {
			var ciudadesDominio = ciudadNegocio.consultarTodos();
			return CiudadDTOAssembler.getInstance().convertirADTO(ciudadesDominio);
		} catch (InduMatchExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadFachadaImpl.PROBLEMA_INESPERADO_CONSULTANDO_TODAS_CIUDADES;
			throw InduMatchFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
