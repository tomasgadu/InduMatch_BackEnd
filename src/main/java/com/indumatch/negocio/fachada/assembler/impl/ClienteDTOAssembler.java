package com.indumatch.negocio.fachada.assembler.impl;

import java.util.List;

import com.indumatch.dominio.ClienteDominio;
import com.indumatch.dto.ClienteDTO;
import com.indumatch.negocio.fachada.assembler.DTOAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class ClienteDTOAssembler implements DTOAssembler<ClienteDominio, ClienteDTO> {

	private static final DTOAssembler<ClienteDominio, ClienteDTO> instancia = new ClienteDTOAssembler();

	private ClienteDTOAssembler() {

	}

	public static DTOAssembler<ClienteDominio, ClienteDTO> getInstance() {
		return instancia;
	}

	@Override
	public ClienteDTO convertirADTO(ClienteDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new ClienteDominio.Builder().build());

		var dto = new ClienteDTO();
		dto.setId(dominioTmp.getId());
		dto.setTipoIdentificacion(TipoIdentificacionDTOAssembler.getInstance().convertirADTO(dominioTmp.getTipoIdentificacion()));
		dto.setNumeroDocumento(dominioTmp.getNumeroDocumento());
		dto.setTelefono(dominioTmp.getTelefono());
		dto.setCorreo(dominioTmp.getCorreo());
		dto.setDireccion(DireccionDTOAssembler.getInstance().convertirADTO(dominioTmp.getDireccion()));
		return dto;
	}

	@Override
	public ClienteDominio convertirADominio(ClienteDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new ClienteDTO());

		return new ClienteDominio.Builder()
				.id(dtoTmp.getId())
				.tipoIdentificacion(TipoIdentificacionDTOAssembler.getInstance().convertirADominio(dtoTmp.getTipoIdentificacion()))
				.numeroDocumento(dtoTmp.getNumeroDocumento())
				.telefono(dtoTmp.getTelefono())
				.correo(dtoTmp.getCorreo())
				.direccion(DireccionDTOAssembler.getInstance().convertirADominio(dtoTmp.getDireccion()))
				.build();
	}

	@Override
	public List<ClienteDTO> convertirADTO(List<ClienteDominio> listaDominios) {
		return listaDominios.stream().map(this::convertirADTO).toList();
	}

}
