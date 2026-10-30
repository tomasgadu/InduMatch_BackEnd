package com.indumatch.negocio.negocio.reglas.impl.cliente;

import com.indumatch.dominio.ClienteDominio;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilUUID;

// CLI-P-0001: Asegurar que los datos requeridos sean válidos y que no contengan contenido malicioso
public class ValidarDatosRegistrarInformacionNuevoClienteRule implements Rule<ClienteDominio> {

	private static final Rule<ClienteDominio> instancia = new ValidarDatosRegistrarInformacionNuevoClienteRule();

	private ValidarDatosRegistrarInformacionNuevoClienteRule() {
	}

	public static final Rule<ClienteDominio> obtenerInstancia() {
		return instancia;
	}
	
	@Override
	public void ejecutar(ClienteDominio... datos) {
		var dominio = datos[0];
		
		validarTipoIdentificacionObligatorio(dominio);
		AsegurarNumeroDocumentoClienteValidoRule.obtenerInstancia().ejecutar(dominio.getNumeroDocumento());
		AsegurarTelefonoClienteValidoRule.obtenerInstancia().ejecutar(dominio.getTelefono());
		AsegurarCorreoClienteValidoRule.obtenerInstancia().ejecutar(dominio.getCorreo());
	}
	
	private void validarTipoIdentificacionObligatorio(ClienteDominio dominio) {
		
		if (UtilUUID.obtenerUUIDDefecto().equals(dominio.getTipoIdentificacion().getId())) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.TIPO_IDENTIFICACION_CLIENTE_OBLIGATORIO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}
	}

}
