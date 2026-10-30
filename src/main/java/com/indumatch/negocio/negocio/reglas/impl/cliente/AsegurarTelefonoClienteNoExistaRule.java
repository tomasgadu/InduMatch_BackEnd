package com.indumatch.negocio.negocio.reglas.impl.cliente;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.entidad.ClienteEntidad;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;

// CLI-P-0006: Asegurar que no exista otro cliente con el mismo número de teléfono
public class AsegurarTelefonoClienteNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarTelefonoClienteNoExistaRule();

	private AsegurarTelefonoClienteNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		var telefono = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = new ClienteEntidad();
		entidadFiltro.setTelefono(telefono);

		var resultados = daoFactory.obtenerClienteDAO().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CLIENTE_EXISTE_CON_MISMO_TELEFONO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
