package com.indumatch.negocio.fachada.assembler.impl;

import java.util.List;

import com.indumatch.dominio.TipoIdentificacionDominio;
import com.indumatch.dto.TipoIdentificacionDTO;
import com.indumatch.negocio.fachada.assembler.DTOAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class TipoIdentificacionDTOAssembler implements DTOAssembler<TipoIdentificacionDominio, TipoIdentificacionDTO> {

	private static final DTOAssembler<TipoIdentificacionDominio, TipoIdentificacionDTO> instancia = new TipoIdentificacionDTOAssembler();

	private TipoIdentificacionDTOAssembler() {

	}

	public static DTOAssembler<TipoIdentificacionDominio, TipoIdentificacionDTO> getInstance() {
		return instancia;
	}

	@Override
	public TipoIdentificacionDTO convertirADTO(TipoIdentificacionDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new TipoIdentificacionDominio.Builder().build());

		var dto = new TipoIdentificacionDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		return dto;
	}

	@Override
	public TipoIdentificacionDominio convertirADominio(TipoIdentificacionDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dto, new TipoIdentificacionDTO());

		return new TipoIdentificacionDominio.Builder()
				.id(dtoTmp.getId())
				.nombre(dtoTmp.getNombre())
				.build();
	}

	@Override
	public List<TipoIdentificacionDTO> convertirADTO(List<TipoIdentificacionDominio> listaDominios) {
		return listaDominios.stream().map(this::convertirADTO).toList();
	}

}
