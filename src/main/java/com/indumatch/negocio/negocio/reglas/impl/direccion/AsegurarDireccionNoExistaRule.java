package com.indumatch.negocio.negocio.reglas.impl.direccion;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.dominio.DireccionDominio;
import com.indumatch.negocio.negocio.assembler.impl.DireccionEntidadAssembler;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;

// DIR-P-0005
public class AsegurarDireccionNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarDireccionNoExistaRule();

	private AsegurarDireccionNoExistaRule() {
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

		var direccion = (DireccionDominio) datos[0];
		var daoFactory = (DAOFactory) datos[1];

		var entidadFiltro = DireccionEntidadAssembler.getInstance().convertirAEntidad(direccion);

		var resultados = daoFactory.obtenerDireccionDAO().consultarPorFiltro(entidadFiltro);

		var existeDireccionIgual = resultados.stream()
				.anyMatch(resultado -> resultado.getComplemento().equals(entidadFiltro.getComplemento()));

		if (existeDireccionIgual) {
			var mensajeUsuario = CatalogoMensajes.DireccionNegocioImpl.DIRECCION_EXISTE_CON_MISMOS_DATOS;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
