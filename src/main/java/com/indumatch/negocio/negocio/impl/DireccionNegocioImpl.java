package com.indumatch.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dominio.DireccionDominio;
import com.indumatch.negocio.negocio.DireccionNegocio;
import com.indumatch.negocio.negocio.assembler.impl.DireccionEntidadAssembler;
import com.indumatch.negocio.negocio.reglas.impl.direccion.AsegurarCiudadExistaRule;
import com.indumatch.negocio.negocio.reglas.impl.direccion.AsegurarDireccionNoExistaRule;
import com.indumatch.negocio.negocio.reglas.impl.direccion.ValidarDatosRegistrarInformacionNuevaDireccionRule;
import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DireccionNegocioImpl implements DireccionNegocio {

	private DAOFactory daoFactory;

	public DireccionNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public DireccionDominio registrarInformacionNuevaDireccion(DireccionDominio datos) {
		ValidarDatosRegistrarInformacionNuevaDireccionRule.obtenerInstancia().ejecutar(datos);			// DIR-P-0001, DIR-P-0002
		AsegurarCiudadExistaRule.obtenerInstancia().ejecutar(datos.getCiudad().getId(), daoFactory);		// DIR-P-0004
		AsegurarDireccionNoExistaRule.obtenerInstancia().ejecutar(datos, daoFactory);					// DIR-P-0005

		var direccionEntidad = DireccionEntidadAssembler.getInstance().convertirAEntidad(datos);
		direccionEntidad.setId(generarIdDireccionUnico());												// DIR-P-0003

		daoFactory.obtenerDireccionDAO().crear(direccionEntidad);

		return DireccionEntidadAssembler.getInstance().convertirADominio(direccionEntidad);
	}

	private UUID generarIdDireccionUnico() {
		var id = UUID.randomUUID();

		if (existeDireccionConId(id)) {
			return generarIdDireccionUnico();
		} else {
			return id;
		}
	}

	private boolean existeDireccionConId(UUID id) {
		var resultado = daoFactory.obtenerDireccionDAO().consultarPorId(id);
		return !UtilObjeto.esNulo(resultado) && !UtilUUID.obtenerUUIDDefecto().equals(resultado.getId());
	}

	@Override
	public void modificarInformacionDireccionExistente(UUID id, DireccionDominio datos) {
		// TODO Auto-generated method stub

	}

	@Override
	public void darBajaInformacionDireccionExistente(UUID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<DireccionDominio> consultarPorFiltro(DireccionDominio filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DireccionDominio> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DireccionDominio consultarPorId(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
