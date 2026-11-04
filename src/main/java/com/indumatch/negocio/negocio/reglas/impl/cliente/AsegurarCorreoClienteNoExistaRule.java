package com.indumatch.negocio.negocio.reglas.impl.cliente;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.entidad.ClienteEntidad;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;

// CLI-P-0005
public class AsegurarCorreoClienteNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarCorreoClienteNoExistaRule();

	private AsegurarCorreoClienteNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		if (datos.length < 2) {
			var mensajeUsuario = CatalogoMensajes.Reglas.DATOS_INSUFICIENTES_PARA_EJECUTAR_REGLA;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

		var correo = (String) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = new ClienteEntidad();
		entidadFiltro.setCorreo(correo);

		var resultados = daoFactory.obtenerClienteDAO().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CLIENTE_EXISTE_CON_MISMO_CORREO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
