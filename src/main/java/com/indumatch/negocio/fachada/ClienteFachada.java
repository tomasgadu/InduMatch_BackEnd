package com.indumatch.negocio.fachada;

import java.util.List;
import java.util.UUID;

import com.indumatch.dto.ClienteDTO;

public interface ClienteFachada {

	void registrarInformacionNuevoCliente(ClienteDTO datos);

	void modificarInformacionContactoClienteExistente(UUID id, ClienteDTO datos);

	void darBajaInformacionClienteExistente(UUID id);

	List<ClienteDTO> consultarPorFiltro(ClienteDTO filtro);

	List<ClienteDTO> consultarTodos();

	ClienteDTO consultarPorId(UUID id);

}
