package com.indumatch.negocio.negocio.reglas.impl.direccion;

import com.indumatch.dominio.DireccionDominio;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilUUID;

// DIR-P-0001 y DIR-P-0002: Asegurar que los datos requeridos sean válidos y que se sanitice el contenido
public class ValidarDatosRegistrarInformacionNuevaDireccionRule implements Rule<DireccionDominio> {

	private static final Rule<DireccionDominio> instancia = new ValidarDatosRegistrarInformacionNuevaDireccionRule();

	private ValidarDatosRegistrarInformacionNuevaDireccionRule() {
	}

	public static final Rule<DireccionDominio> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public void ejecutar(DireccionDominio... datos) {
		var dominio = datos[0];
		
		validarCiudadObligatoria(dominio);
		AsegurarViaPrincipalDireccionValidaRule.obtenerInstancia().ejecutar(dominio.getViaPrincipal());
		AsegurarNumeroCruceDireccionValidoRule.obtenerInstancia().ejecutar(dominio.getNumeroCruce());
		AsegurarNumeroCasaDireccionValidoRule.obtenerInstancia().ejecutar(dominio.getNumeroCasa());
		AsegurarComplementoDireccionValidoRule.obtenerInstancia().ejecutar(dominio.getComplemento());
	}
	
	private void validarCiudadObligatoria(DireccionDominio dominio) {
		
		if (UtilUUID.obtenerUUIDDefecto().equals(dominio.getCiudad().getId())) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.CIUDAD_DIRECCION_OBLIGATORIA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

}
