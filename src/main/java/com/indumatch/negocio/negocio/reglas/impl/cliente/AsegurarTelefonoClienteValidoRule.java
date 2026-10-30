package com.indumatch.negocio.negocio.reglas.impl.cliente;

import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilTexto;

public class AsegurarTelefonoClienteValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarTelefonoClienteValidoRule();

	private AsegurarTelefonoClienteValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var telefono = datos[0];

		validarObligatoriedad(telefono);
		validarFormato(telefono);
		validarLongitud(telefono, 7, 15);

	}

	private void validarObligatoriedad(String dato) {

		if (UtilTexto.getUtilTexto().esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.TELEFONO_CLIENTE_OBLIGATORIO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {

		if (!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.ALFANUMERICO)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.FORMATO_TELEFONO_CLIENTE_NO_VALIDO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {

		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.LONGITUD_TELEFONO_CLIENTE_NO_VALIDA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
