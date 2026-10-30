package com.indumatch.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.indumatch.dominio.DireccionDominio;

public interface DireccionNegocio {
	
	DireccionDominio registrarInformacionNuevaDireccion(DireccionDominio datos);
	void modificarInformacionDireccionExistente(UUID id, DireccionDominio datos);
	void darBajaInformacionDireccionExistente(UUID id);
	
	List<DireccionDominio> consultarPorFiltro(DireccionDominio filtro);
	List<DireccionDominio> consultarTodos();
	DireccionDominio consultarPorId(UUID id);

}
