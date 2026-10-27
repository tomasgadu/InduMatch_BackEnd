package com.indumatch.negocio.negocio.assembler.impl;

import com.indumatch.dominio.DepartamentoDominio;
import com.indumatch.entidad.DepartamentoEntidad;
import com.indumatch.negocio.negocio.assembler.EntidadAssembler;
import com.indumatch.transversal.utilitarios.UtilObjeto;

public class DepartamentoEntidadAssembler implements EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> {

	private static final EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> instancia = new DepartamentoEntidadAssembler();
	
	private DepartamentoEntidadAssembler() {

	}

	public static EntidadAssembler<DepartamentoDominio, DepartamentoEntidad> getInstance() {
		return instancia;
	}

	@Override
	public DepartamentoEntidad convertirAEntidad(DepartamentoDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(dominio,
				new DepartamentoDominio.Builder().build());
		return new DepartamentoEntidad(dominioTmp.getId(),
				dominioTmp.getNombre(),
				PaisEntidadAssembler.getInstance().convertirAEntidad(dominioTmp.getPais()));
	}

	@Override
	public DepartamentoDominio convertirADominio(DepartamentoEntidad entidad) {
		var entidadTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(entidad, new DepartamentoEntidad());
		return new DepartamentoDominio.Builder()
				.id(entidadTmp.getId())
				.nombre(entidadTmp.getNombre())
				.pais(PaisEntidadAssembler.getInstance().convertirADominio(entidadTmp.getPais()))
				.build();
	}
}
