package com.indumatch.negocio.fachada.assembler.impl;

import java.util.List;

import com.indumatch.dominio.CiudadDominio;
import com.indumatch.dto.CiudadDTO;
import com.indumatch.negocio.fachada.assembler.DTOAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class CiudadDTOAssembler implements DTOAssembler<CiudadDominio, CiudadDTO> {

	private static final DTOAssembler<CiudadDominio, CiudadDTO> instancia = new CiudadDTOAssembler();

	private CiudadDTOAssembler() {

	}

	public static DTOAssembler<CiudadDominio, CiudadDTO> getInstance() {
		return instancia;
	}

	@Override
	public CiudadDTO convertirADTO(CiudadDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio, new CiudadDominio.Builder().build());
		
		var dto = new CiudadDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		dto.setDepartamento(DepartamentoDTOAssembler.getInstance().convertirADTO(dominioTmp.getDepartamento()));
		return dto;
	}

	@Override
	public CiudadDominio convertirADominio(CiudadDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new CiudadDTO());
		
		return new CiudadDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.departamento(DepartamentoDTOAssembler.getInstance().convertirADominio(dtoTmp.getDepartamento()))
				.build();
	}

	@Override
	public List<CiudadDTO> convertirADTO(List<CiudadDominio> listaDominios) {
		return listaDominios.stream().map(this::convertirADTO).toList();
	}
	
}
