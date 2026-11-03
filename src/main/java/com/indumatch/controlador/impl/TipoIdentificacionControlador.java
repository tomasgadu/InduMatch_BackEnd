package com.indumatch.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indumatch.controlador.AbstractRestController;
import com.indumatch.controlador.respuesta.RespuestaOk;
import com.indumatch.dto.TipoIdentificacionDTO;
import com.indumatch.negocio.fachada.TipoIdentificacionFachada;
import com.indumatch.negocio.fachada.impl.TipoIdentificacionFachadaImpl;

@RestController
@RequestMapping("/api/v1/tipos-identificacion")
public class TipoIdentificacionControlador extends AbstractRestController {

	@GetMapping
	public ResponseEntity<RespuestaOk<TipoIdentificacionDTO>> consultarTodos() {
		TipoIdentificacionFachada fachada = new TipoIdentificacionFachadaImpl();
		var tiposIdentificacion = fachada.consultarTodos();
		RespuestaOk<TipoIdentificacionDTO> respuesta = RespuestaOk.crear(tiposIdentificacion);
		return ResponseEntity.ok(respuesta);
	}

}
