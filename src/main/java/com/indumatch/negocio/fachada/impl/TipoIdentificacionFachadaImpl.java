package com.indumatch.negocio.fachada.impl;

import java.util.List;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dto.TipoIdentificacionDTO;
import com.indumatch.negocio.fachada.TipoIdentificacionFachada;
import com.indumatch.negocio.fachada.assembler.impl.TipoIdentificacionDTOAssembler;
import com.indumatch.negocio.negocio.TipoIdentificacionNegocio;
import com.indumatch.negocio.negocio.impl.TipoIdentificacionNegocioImpl;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchExcepcion;
import com.indumatch.transversal.excepciones.InduMatchFachadaException;

public class TipoIdentificacionFachadaImpl implements TipoIdentificacionFachada {

	private DAOFactory daoFactory;
	private TipoIdentificacionNegocio tipoIdentificacionNegocio;

	public TipoIdentificacionFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		tipoIdentificacionNegocio = new TipoIdentificacionNegocioImpl(daoFactory);
	}

	@Override
	public List<TipoIdentificacionDTO> consultarTodos() {

		try {
			var tiposIdentificacionDominio = tipoIdentificacionNegocio.consultarTodos();
			return TipoIdentificacionDTOAssembler.getInstance().convertirADTO(tiposIdentificacionDominio);
		} catch (InduMatchExcepcion excepcion) {
			throw excepcion;
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionFachadaImpl.PROBLEMA_INESPERADO_CONSULTANDO_TODOS_TIPOS_IDENTIFICACION;
			throw InduMatchFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}
	}

}
