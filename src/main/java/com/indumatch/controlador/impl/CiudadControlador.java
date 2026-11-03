package com.indumatch.controlador.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indumatch.controlador.AbstractRestController;
import com.indumatch.controlador.respuesta.RespuestaOk;
import com.indumatch.dto.CiudadDTO;
import com.indumatch.negocio.fachada.CiudadFachada;
import com.indumatch.negocio.fachada.impl.CiudadFachadaImpl;

@RestController
@RequestMapping("/api/v1/ciudades")
public class CiudadControlador extends AbstractRestController {

	@GetMapping
	public ResponseEntity<RespuestaOk<CiudadDTO>> consultarTodos() {
		CiudadFachada fachada = new CiudadFachadaImpl();
		var ciudades = fachada.consultarTodos();
		RespuestaOk<CiudadDTO> respuesta = RespuestaOk.crear(ciudades);
		return ResponseEntity.ok(respuesta);
	}

}
