package com.indumatch.negocio.negocio.assembler.impl;

import com.indumatch.dominio.TipoIdentificacionDominio;
import com.indumatch.entidad.TipoIdentificacionEntidad;
import com.indumatch.negocio.negocio.assembler.EntidadAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class TipoIdentificacionEntidadAssembler implements EntidadAssembler<TipoIdentificacionDominio, TipoIdentificacionEntidad> {

	private static final EntidadAssembler<TipoIdentificacionDominio, TipoIdentificacionEntidad> instancia = new TipoIdentificacionEntidadAssembler();
	
	private TipoIdentificacionEntidadAssembler() {

	}

	public static EntidadAssembler<TipoIdentificacionDominio, TipoIdentificacionEntidad> getInstance() {
		return instancia;
	}

	@Override
	public TipoIdentificacionEntidad convertirAEntidad(TipoIdentificacionDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new TipoIdentificacionDominio.Builder().build());
		return new TipoIdentificacionEntidad(dominioTmp.getId(), dominioTmp.getNombre());
	}

	@Override
	public TipoIdentificacionDominio convertirADominio(TipoIdentificacionEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new TipoIdentificacionEntidad());
		return new TipoIdentificacionDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.build();
	}
}
