package com.indumatch.negocio.fachada.assembler.impl;

import java.util.List;

import com.indumatch.dominio.DepartamentoDominio;
import com.indumatch.dto.DepartamentoDTO;
import com.indumatch.negocio.fachada.assembler.DTOAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class DepartamentoDTOAssembler implements DTOAssembler<DepartamentoDominio, DepartamentoDTO> {

	private static final DTOAssembler<DepartamentoDominio, DepartamentoDTO> instancia = new DepartamentoDTOAssembler();

	private DepartamentoDTOAssembler() {

	}

	public static DTOAssembler<DepartamentoDominio, DepartamentoDTO> getInstance() {
		return instancia;
	}

	@Override
	public DepartamentoDTO convertirADTO(DepartamentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new DepartamentoDominio.Builder().build());
		
		var dto = new DepartamentoDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setPais(PaisDTOAssembler.getInstance().convertirADTO(dominioTmp.getPais()));
		return dto;
	}

	@Override
	public DepartamentoDominio convertirADominio(DepartamentoDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DepartamentoDTO());
		
		return new DepartamentoDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.pais(PaisDTOAssembler.getInstance().convertirADominio(dtoTmp.getPais()))
				.build();
	}

	@Override
	public List<DepartamentoDTO> convertirADTO(List<DepartamentoDominio> listaDominios) {
		return listaDominios.stream().map(this::convertirADTO).toList();
	}
	
}
