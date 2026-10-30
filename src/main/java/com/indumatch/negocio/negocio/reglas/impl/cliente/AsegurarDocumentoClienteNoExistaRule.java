package com.indumatch.negocio.negocio.reglas.impl.cliente;

import java.util.UUID;

import com.indumatch.dao.factoria.DAOFactory;
import com.indumatch.entidad.ClienteEntidad;
import com.indumatch.entidad.TipoIdentificacionEntidad;
import com.indumatch.negocio.negocio.reglas.Rule;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchNegocioException;

// CLI-P-0004: Asegurar que no exista otro cliente con el mismo tipo de identificación y número de documento
public class AsegurarDocumentoClienteNoExistaRule implements Rule<Object> {

	private static final Rule<Object> instancia = new AsegurarDocumentoClienteNoExistaRule();

	private AsegurarDocumentoClienteNoExistaRule() {
	}

	public static final Rule<Object> obtenerInstancia() {
		return instancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		var idTipoIdentificacion = (UUID) datos[0];
		var numeroDocumento = (String) datos[1];
		var daoFactory = (DAOFactory) datos[2];

		var tipoIdentificacionFiltro = new TipoIdentificacionEntidad();
		tipoIdentificacionFiltro.setId(idTipoIdentificacion);

		var entidadFiltro = new ClienteEntidad();
		entidadFiltro.setTipoIdentificacion(tipoIdentificacionFiltro);
		entidadFiltro.setNumeroDocumento(numeroDocumento);

		var resultados = daoFactory.obtenerClienteDAO().consultarPorFiltro(entidadFiltro);

		if (!resultados.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.ClienteNegocioImpl.CLIENTE_EXISTE_CON_MISMO_TIPO_Y_NUMERO_DOCUMENTO;
			throw InduMatchNegocioException.crear(mensajeUsuario);
		}

	}

}
