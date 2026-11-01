package com.indumatch.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import com.indumatch.controlador.respuesta.RespuestaError;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchExcepcion;

@RestControllerAdvice
public abstract class AbstractRestController {

	@ExceptionHandler(InduMatchExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarInduMatchException(InduMatchExcepcion excepcion) {
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario());
		// Logger.printException(excepcion);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> controlarNoResourceFoundException(
			NoResourceFoundException excepcion) {
		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.RECURSO_SOLICITADO_NO_EXISTE;
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		// Logger.printException(excepcion);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<RespuestaError<String>> controlarException(Exception excepcion) {
		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.PROBLEMA_INESPERADO_LLEVANDO_A_CABO_OPERACION;
		var respuesta = RespuestaError.crear(mensajeRespuesta);
		// Logger.printException(excepcion);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}

}
