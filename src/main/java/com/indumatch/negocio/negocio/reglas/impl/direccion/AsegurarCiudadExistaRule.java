package com.indumatch.negocio.negocio.reglas.impl.direccion;

import java.util.UUID;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;
import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilUUID;

// DIR-P-0004: Asegurar que la ciudad indicada exista
public class AsegurarCiudadExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarCiudadExistaRule();

	private AsegurarCiudadExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		var idCiudad = (UUID) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var resultado = daoFactory.obtenerCiudadDAO().consultarPorId(idCiudad);

		if (UtilObjeto.esNulo(resultado) || UtilUUID.obtenerUUIDDefecto().equals(resultado.getId())) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.CIUDAD_DIRECCION_NO_EXISTE;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
