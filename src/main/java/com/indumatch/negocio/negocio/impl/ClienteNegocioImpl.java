package com.indumatch.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dominio.ClienteDominio;
import com.indumatch.negocio.negocio.ClienteNegocio;
import com.indumatch.negocio.negocio.assembler.impl.ClienteEntidadAssembler;

public class ClienteNegocioImpl implements ClienteNegocio {

	private DAOFactory daoFactory;

	public ClienteNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoCliente(ClienteDominio datos) {
		// Aquí se ejecutarán las reglas de negocio (CLI-P-0001, 0004, 0005, 0006, 0007, 0008 y 0010)

		var clienteEntidad = ClienteEntidadAssembler.getInstance().convertirAEntidad(datos);
		clienteEntidad.setId(generarIdClienteUnico());

		daoFactory.obtenerClienteDAO().crear(clienteEntidad);

	}

	private UUID generarIdClienteUnico() {
		return UUID.randomUUID();
	}

	@Override
	public void modificarInformacionContactoClienteExistente(UUID id, ClienteDominio datos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void darBajaInformacionClienteExistente(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ClienteDominio> consultarPorFiltro(ClienteDominio filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClienteDominio> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClienteDominio consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
