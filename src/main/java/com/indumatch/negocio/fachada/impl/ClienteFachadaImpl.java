package com.indumatch.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dto.ClienteDTO;
import com.indumatch.negocio.fachada.ClienteFachada;
import com.indumatch.negocio.fachada.assembler.impl.ClienteDTOAssembler;
import com.indumatch.negocio.negocio.ClienteNegocio;
import com.indumatch.negocio.negocio.impl.ClienteNegocioImpl;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchExcepcion;
import com.indumatch.transversal.excepciones.InduMatchFachadaException;

public class ClienteFachadaImpl implements ClienteFachada {

	private DAOFactory daoFactory;
	private ClienteNegocio clienteNegocio;

	public ClienteFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();
		clienteNegocio = new ClienteNegocioImpl(daoFactory);
	}

	@Override
	public void registrarInformacionNuevoCliente(ClienteDTO datos) {
		daoFactory.iniciarTransaccion();

		try {
			var clienteDominio = ClienteDTOAssembler.getInstance().convertirADominio(datos);
			clienteNegocio.registrarInformacionNuevoCliente(clienteDominio);
			daoFactory.confirmarTransaccion();
		} catch (InduMatchExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();

			var mensajeUsuario = CatalogoMensajes.ClienteFachadaImpl.PROBLEMA_INESPERADO_REGISTRANDO_CLIENTE;
			throw InduMatchFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public void modificarInformacionContactoClienteExistente(UUID id, ClienteDTO datos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void darBajaInformacionClienteExistente(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ClienteDTO> consultarPorFiltro(ClienteDTO filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDTO> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDTO consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
