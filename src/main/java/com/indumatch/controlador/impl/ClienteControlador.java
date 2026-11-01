package com.indumatch.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indumatch.controlador.AbstractRestController;
import com.indumatch.controlador.respuesta.RespuestaOk;
import com.indumatch.dto.ClienteDTO;
import com.indumatch.negocio.fachada.ClienteFachada;
import com.indumatch.negocio.fachada.impl.ClienteFachadaImpl;
import com.indumatch.transversal.catalogo.CatalogoMensajes;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteControlador extends AbstractRestController {

	@PostMapping
	public ResponseEntity<RespuestaOk<String>> registrarInformacionNuevoCliente(@RequestBody ClienteDTO cliente) {
		ClienteFachada fachada = new ClienteFachadaImpl();
		fachada.registrarInformacionNuevoCliente(cliente);
		RespuestaOk<String> respuesta = RespuestaOk
				.crear(CatalogoMensajes.ClienteControlador.CLIENTE_REGISTRADO_EXITOSAMENTE);
		return ResponseEntity.ok(respuesta);
	}

}
