package com.indumatch.negocio.negocio.reglas.impl.cliente;

import java.util.UUID;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilUUID;

// CLI-P-0003: Asegurar que el tipo de identificación indicado exista
public class AsegurarTipoIdentificacionExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarTipoIdentificacionExistaRule();

	private AsegurarTipoIdentificacionExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		var idTipoIdentificacion = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var resultado = daoFactory.obtenerTipoIdentificacionDAO().consultarPorId(idTipoIdentificacion);

		if (UtilObjeto.esNulo(resultado) || UtilUUID.obtenerUUIDDefecto().equals(resultado.getId())) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.TIPO_IDENTIFICACION_CLIENTE_NO_EXISTE;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
