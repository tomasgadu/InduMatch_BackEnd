package com.indumatch.negocio.negocio.reglas.impl.direccion;

import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilTexto;

public class AsegurarViaPrincipalDireccionValidaRule implements Rule<String> {

	private static final Rule<String> instancia = new AsegurarViaPrincipalDireccionValidaRule();

	private AsegurarViaPrincipalDireccionValidaRule() {
	}

	public static final Rule<String> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(String... datos) {
		var viaPrincipal = datos[0];

		validarObligatoriedad(viaPrincipal);
		validarFormato(viaPrincipal);
		validarLongitud(viaPrincipal, 4, 20);

	}

	private void validarObligatoriedad(String dato) {

		if (UtilTexto.getUtilTexto().esVacia(dato)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.VIA_PRINCIPAL_DIRECCION_OBLIGATORIA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarFormato(String dato) {

		if (!UtilTexto.getUtilTexto().formatoEsValido(dato, UtilTexto.ALFANUMERICO_ESPACIOS)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.FORMATO_VIA_PRINCIPAL_DIRECCION_NO_VALIDO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

	private void validarLongitud(String dato, int longitudMinima, int longitudMaxima) {

		if (!UtilTexto.getUtilTexto().obtenerLongitudCadenaEsValida(dato, longitudMinima, longitudMaxima, true)) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.LONGITUD_VIA_PRINCIPAL_DIRECCION_NO_VALIDA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
