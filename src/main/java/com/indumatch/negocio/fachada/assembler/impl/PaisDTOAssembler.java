package com.indumatch.negocio.fachada.assembler.impl;

import java.util.List;

import com.indumatch.dominio.PaisDominio;
import com.indumatch.dto.PaisDTO;
import com.indumatch.negocio.fachada.assembler.DTOAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class PaisDTOAssembler implements DTOAssembler<PaisDominio, PaisDTO> {

	private static final DTOAssembler<PaisDominio, PaisDTO> instancia = new PaisDTOAssembler();

	private PaisDTOAssembler() {

	}

	public static DTOAssembler<PaisDominio, PaisDTO> getInstance() {
		return instancia;
	}

	@Override
	public PaisDTO convertirADTO(PaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new PaisDominio.Builder().build());

		var dto = new PaisDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setCodigo(dominioTmp.getCodigo());

		return dto;
	}

	@Override
	public PaisDominio convertirADominio(PaisDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new PaisDTO());
		
		return new PaisDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.codigo(dtoTmp.getCodigo())
				.build();
	}

	@Override
	public List<PaisDTO> convertirADTO(List<PaisDominio> listaDominios) {
		return listaDominios.stream().map(this::convertirADTO).toList();
	}

}
