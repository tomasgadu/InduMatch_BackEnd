package com.indumatch.negocio.negocio.reglas.impl.direccion;

import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilTexto;

public class AsegurarComplementoDireccionValidoRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarComplementoDireccionValidoRule();

	private AsegurarComplementoDireccionValidoRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var complemento = datos[0];

		if (UtilTexto.getUtilTexto().esVacia(complemento)) {
			return;
		}

		validarFormato(complemento);
		validarLongitud(complemento, 0, 30);

	}

	private void validarFormato(String dato) {

		if (!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.ALFANUMERICO_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.FORMATO_COMPLEMENTO_DIRECCION_NO_VALIDO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {

		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.LONGITUD_COMPLEMENTO_DIRECCION_NO_VALIDA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
