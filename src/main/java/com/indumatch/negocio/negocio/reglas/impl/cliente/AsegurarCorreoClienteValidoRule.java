package com.indumatch.negocio.negocio.reglas.impl.cliente;

import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilTexto;

public class AsegurarCorreoClienteValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarCorreoClienteValidoRule();

	private AsegurarCorreoClienteValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var correo = datos[0];

		validarObligatoriedad(correo);
		validarFormato(correo);
		validarLongitud(correo, 6, 60);

	}

	private void validarObligatoriedad(String dato) {

		if (UtilTexto.getUtilTexto().esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CORREO_CLIENTE_OBLIGATORIO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {

		if (!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.CORREO_ELECTRONICO)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.FORMATO_CORREO_CLIENTE_NO_VALIDO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {

		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.LONGITUD_CORREO_CLIENTE_NO_VALIDA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
