package com.indumatch.negocio.negocio.assembler.impl;

import com.indumatch.dominio.ClienteDominio;
import com.indumatch.entidad.ClienteEntidad;
import com.indumatch.negocio.negocio.assembler.EntidadAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class ClienteEntidadAssembler implements EntidadAssembler<ClienteDominio, ClienteEntidad> {

	private static final EntidadAssembler<ClienteDominio, ClienteEntidad> instancia = new ClienteEntidadAssembler();
	
	private ClienteEntidadAssembler() {

	}

	public static EntidadAssembler<ClienteDominio, ClienteEntidad> getInstance() {
		return instancia;
	}

	@Override
	public ClienteEntidad convertirAEntidad(ClienteDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new ClienteDominio.Builder().build());
		return new ClienteEntidad(dominioTmp.getId(),
				TipoIdentificacionEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getTipoIdentificacion()),
				dominioTmp.getNumeroDocumento(),
				dominioTmp.getTelefono(),
				dominioTmp.getCorreo(),
				DireccionEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getDireccion()));
	}

	@Override
	public ClienteDominio convertirADominio(ClienteEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new ClienteEntidad());
		return new ClienteDominio.Builder()
				.id(entidadTmp.getId())
				.tipoIdentificacion(TipoIdentificacionEntidadAssembler.getInstance().convertirADominio(entidadTmp.getTipoIdentificacion()))
				.numeroDocumento(entidadTmp.getNumeroDocumento())
				.telefono(entidadTmp.getTelefono())
				.correo(entidadTmp.getCorreo())
				.direccion(DireccionEntidadAssembler.getInstance().convertirADominio(entidadTmp.getDireccion()))
				.build();
	}
}
