package com.indumatch.negocio.fachada.assembler.impl;

import java.util.List;

import com.indumatch.dominio.DireccionDominio;
import com.indumatch.dto.DireccionDTO;
import com.indumatch.negocio.fachada.assembler.DTOAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class DireccionDTOAssembler implements DTOAssembler<DireccionDominio, DireccionDTO> {

	private static final DTOAssembler<DireccionDominio, DireccionDTO> instancia = new DireccionDTOAssembler();

	private DireccionDTOAssembler() {

	}

	public static DTOAssembler<DireccionDominio, DireccionDTO> getInstance() {
		return instancia;
	}

	@Override
	public DireccionDTO convertirADTO(DireccionDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new DireccionDominio.Builder().build());

		var dto = new DireccionDTO();
		dto.setId(dominioTmp.getId());
		dto.setCiudad(CiudadDTOAssembler.getInstance().convertirADTO(dominioTmp.getCiudad()));
		dto.setViaPrincipal(dominioTmp.getViaPrincipal());
		dto.setNumeroCruce(dominioTmp.getNumeroCruce());
		dto.setNumeroCasa(dominioTmp.getNumeroCasa());
		dto.setComplemento(dominioTmp.getComplemento());
		return dto;
	}

	@Override
	public DireccionDominio convertirADominio(DireccionDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new DireccionDTO());

		return new DireccionDominio.Builder()
				.id(dtoTmp.getId())
				.ciudad(CiudadDTOAssembler.getInstance().convertirADominio(dtoTmp.getCiudad()))
				.viaPrincipal(dtoTmp.getViaPrincipal())
				.numeroCruce(dtoTmp.getNumeroCruce())
				.numeroCasa(dtoTmp.getNumeroCasa())
				.complemento(dtoTmp.getComplemento())
				.build();
	}

	@Override
	public List<DireccionDTO> convertirADTO(List<DireccionDominio> listaDominios) {
		return listaDominios.stream().map(this::convertirADTO).toList();
	}

}
