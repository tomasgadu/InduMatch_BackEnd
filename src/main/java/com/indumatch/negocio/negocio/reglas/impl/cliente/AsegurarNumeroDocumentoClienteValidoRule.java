package com.indumatch.negocio.negocio.reglas.impl.cliente;

import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilTexto;

public class AsegurarNumeroDocumentoClienteValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarNumeroDocumentoClienteValidoRule();

	private AsegurarNumeroDocumentoClienteValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var numeroDocumento = datos[0];

		validarObligatoriedad(numeroDocumento);
		validarFormato(numeroDocumento);
		validarLongitud(numeroDocumento, 5, 15);

	}

	private void validarObligatoriedad(String dato) {

		if (UtilTexto.getUtilTexto().esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.NUMERO_DOCUMENTO_CLIENTE_OBLIGATORIO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {

		if (!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.ALFANUMERICO)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.FORMATO_NUMERO_DOCUMENTO_CLIENTE_NO_VALIDO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {

		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.LONGITUD_NUMERO_DOCUMENTO_CLIENTE_NO_VALIDA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
