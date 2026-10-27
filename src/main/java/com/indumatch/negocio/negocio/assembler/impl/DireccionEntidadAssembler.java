package com.indumatch.negocio.negocio.assembler.impl;

import com.indumatch.dominio.DireccionDominio;
import com.indumatch.entidad.DireccionEntidad;
import com.indumatch.negocio.negocio.assembler.EntidadAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class DireccionEntidadAssembler implements EntidadAssembler<DireccionDominio, DireccionEntidad> {

	private static final EntidadAssembler<DireccionDominio, DireccionEntidad> instancia = new DireccionEntidadAssembler();
	
	private DireccionEntidadAssembler() {

	}

	public static EntidadAssembler<DireccionDominio, DireccionEntidad> getInstance() {
		return instancia;
	}

	@Override
	public DireccionEntidad convertirAEntidad(DireccionDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new DireccionDominio.Builder().build());
		return new DireccionEntidad(dominioTmp.getId(),
				CiudadEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getCiudad()),
				dominioTmp.getViaPrincipal(),
				dominioTmp.getNumeroCruce(),
				dominioTmp.getNumeroCasa(),
				dominioTmp.getComplemento());
	}

	@Override
	public DireccionDominio convertirADominio(DireccionEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DireccionEntidad());
		return new DireccionDominio.Builder()
				.id(entidadTmp.getId())
				.ciudad(CiudadEntidadAssembler.getInstance().convertirADominio(entidadTmp.getCiudad()))
				.viaPrincipal(entidadTmp.getViaPrincipal())
				.numeroCruce(entidadTmp.getNumeroCruce())
				.numeroCasa(entidadTmp.getNumeroCasa())
				.complemento(entidadTmp.getComplemento())
				.build();
	}
}
