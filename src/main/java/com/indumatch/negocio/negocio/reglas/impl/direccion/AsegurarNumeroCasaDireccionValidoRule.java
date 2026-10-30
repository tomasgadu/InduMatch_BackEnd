package com.indumatch.negocio.negocio.reglas.impl.direccion;

import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilTexto;

public class AsegurarNumeroCasaDireccionValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarNumeroCasaDireccionValidoRule();

	private AsegurarNumeroCasaDireccionValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var numeroCasa = datos[0];

		validarObligatoriedad(numeroCasa);
		validarFormato(numeroCasa);
		validarLongitud(numeroCasa, 1, 6);

	}

	private void validarObligatoriedad(String dato) {

		if (UtilTexto.getUtilTexto().esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.NUMERO_CASA_DIRECCION_OBLIGATORIO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {

		if (!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.ALFANUMERICO)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.FORMATO_NUMERO_CASA_DIRECCION_NO_VALIDO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {

		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.LONGITUD_NUMERO_CASA_DIRECCION_NO_VALIDA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
