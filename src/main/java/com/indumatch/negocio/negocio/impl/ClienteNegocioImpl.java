package com.indumatch.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dominio.ClienteDominio;
import com.indumatch.negocio.negocio.ClienteNegocio;
import com.indumatch.negocio.negocio.DireccionNegocio;
import com.indumatch.negocio.negocio.assembler.impl.ClienteEntidadAssembler;
import com.indumatch.negocio.negocio.assembler.impl.DireccionEntidadAssembler;
import com.indumatch.negocio.negocio.reglas.impl.cliente.AsegurarCorreoClienteNoExistaRule;
import com.indumatch.negocio.negocio.reglas.impl.cliente.AsegurarDocumentoClienteNoExistaRule;
import com.indumatch.negocio.negocio.reglas.impl.cliente.AsegurarTelefonoClienteNoExistaRule;
import com.indumatch.negocio.negocio.reglas.impl.cliente.AsegurarTipoIdentificacionExistaRule;
import com.indumatch.negocio.negocio.reglas.impl.cliente.ValidarDatosRegistrarInformacionNuevoClienteRule;
import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteNegocioImpl implements ClienteNegocio {

	private DAOFactory daoFactory;
	private DireccionNegocio direccionNegocio;

	public ClienteNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
		this.direccionNegocio = new DireccionNegocioImpl(daoFactory);
	}

	@Override
	public void registrarInformacionNuevoCliente(ClienteDominio datos) {
		ValidarDatosRegistrarInformacionNuevoClienteRule.obtenerInstancia().ejecutar(datos);									// CLI-P-0001

		AsegurarTipoIdentificacionExistaRule.obtenerInstancia().ejecutar(datos.getTipoIdentificacion().getId(), daoFactory);	// CLI-P-0003
		AsegurarDocumentoClienteNoExistaRule.obtenerInstancia().ejecutar(datos.getTipoIdentificacion().getId(),
				datos.getNumeroDocumento(), daoFactory);																		// CLI-P-0004
		AsegurarCorreoClienteNoExistaRule.obtenerInstancia().ejecutar(datos.getCorreo(), daoFactory);							// CLI-P-0005
		AsegurarTelefonoClienteNoExistaRule.obtenerInstancia().ejecutar(datos.getTelefono(), daoFactory);						// CLI-P-0006

		var direccionRegistrada = direccionNegocio.registrarInformacionNuevaDireccion(datos.getDireccion());

		var clienteEntidad = ClienteEntidadAssembler.getInstance().convertirAEntidad(datos);
		clienteEntidad.setDireccion(DireccionEntidadAssembler.getInstance().convertirAEntidad(direccionRegistrada));
		clienteEntidad.setId(generarIdClienteUnico());																			// CLI-P-0002

		daoFactory.obtenerClienteDAO().crear(clienteEntidad);

	}

	private UUID generarIdClienteUnico() {
		var id = UUID.randomUUID();
		
		if (existeClienteConId(id)) {
			return generarIdClienteUnico();
		} else {
			return id;
		}
	}

	private boolean existeClienteConId(UUID id) {
		var resultado = daoFactory.obtenerClienteDAO().consultarPorId(id);
		return !UtilObjeto.esNulo(resultado) && !UtilUUID.obtenerUUIDDefecto().equals(resultado.getId());
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
