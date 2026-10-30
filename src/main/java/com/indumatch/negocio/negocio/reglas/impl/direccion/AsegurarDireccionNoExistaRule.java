package com.indumatch.negocio.negocio.reglas.impl.direccion;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dominio.DireccionDominio;
import com.indumatch.negocio.negocio.assembler.impl.DireccionEntidadAssembler;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;

// DIR-P-0005: Asegurar que no exista otra dirección con la misma combinación de datos
public class AsegurarDireccionNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarDireccionNoExistaRule();

	private AsegurarDireccionNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		var direccion = (DireccionDominio) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = DireccionEntidadAssembler.getInstance().convertirAEntidad(direccion);

		var resultados = daoFactory.obtenerDireccionDAO().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.DIRECCION_EXISTE_CON_MISMOS_DATOS;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
