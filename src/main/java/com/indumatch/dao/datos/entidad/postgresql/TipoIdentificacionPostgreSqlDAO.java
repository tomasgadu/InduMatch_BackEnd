package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.TipoIdentificacionDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.TipoIdentificacionEntidad;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchDatosException;

public class TipoIdentificacionPostgreSqlDAO extends SqlDAO implements TipoIdentificacionDAO {

	public TipoIdentificacionPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(TipoIdentificacionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TipoIdentificacionEntidad consultarPorId(UUID id) {
		var sentencia = "SELECT id_tipo_identificacion, nombre FROM tipo_identificacion WHERE id_tipo_identificacion = ?";

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			sentenciaPreparada.setObject(1, id);

			try (var resultado = sentenciaPreparada.executeQuery()) {
				return resultado.next() ? mapearTipoIdentificacion(resultado) : new TipoIdentificacionEntidad();
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TIPO_IDENTIFICACION_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.TipoIdentificacionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TIPO_IDENTIFICACION_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarPorFiltro(TipoIdentificacionEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TipoIdentificacionEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, TipoIdentificacionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}


	private TipoIdentificacionEntidad mapearTipoIdentificacion(ResultSet resultado) throws SQLException {
		return new TipoIdentificacionEntidad(resultado.getObject("id_tipo_identificacion", UUID.class),
				resultado.getString("nombre"));
	}

}
