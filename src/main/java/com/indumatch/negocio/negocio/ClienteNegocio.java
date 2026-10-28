package com.indumatch.negocio.negocio;

import java.util.List;
import java.util.UUID;

import com.indumatch.dominio.ClienteDominio;

public interface ClienteNegocio {
	
	void registrarInformacionNuevoCliente(ClienteDominio datos);
	void modificarInformacionContactoClienteExistente(UUID id, ClienteDominio datos);
	void darBajaInformacionClienteExistente(UUID id);
	
	List<ClienteDominio> consultarPorFiltro(ClienteDominio filtro);
	List<ClienteDominio> consultarTodos();
	ClienteDominio consultarPorId(UUID id);

}
