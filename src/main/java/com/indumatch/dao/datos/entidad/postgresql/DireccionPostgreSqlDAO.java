package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.DireccionDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.CiudadEntidad;
import com.indumatch.entidad.DireccionEntidad;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchDatosException;
import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DireccionPostgreSqlDAO extends SqlDAO implements DireccionDAO {

	private static final String SELECT_BASE = "SELECT id_direccion, id_ciudad, via_principal, numero_cruce, numero_casa, complemento FROM direccion";

	public DireccionPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(DireccionEntidad entidad) {
		var sentencia = "INSERT INTO direccion (id_direccion, id_ciudad, via_principal, numero_cruce, numero_casa, complemento) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			sentenciaPreparada.setObject(1, entidad.getId());
			sentenciaPreparada.setObject(2, entidad.getCiudad().getId());
			sentenciaPreparada.setString(3, entidad.getViaPrincipal());
			sentenciaPreparada.setString(4, entidad.getNumeroCruce());
			sentenciaPreparada.setString(5, entidad.getNumeroCasa());
			sentenciaPreparada.setString(6, entidad.getComplemento());

			sentenciaPreparada.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.DireccionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_REGISTRANDO_DIRECCION;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.DireccionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_DIRECCION;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public DireccionEntidad consultarPorId(UUID id) {
		var sentencia = SELECT_BASE + " WHERE id_direccion = ?";

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			sentenciaPreparada.setObject(1, id);

			try (var resultado = sentenciaPreparada.executeQuery()) {
				return resultado.next() ? mapearDireccion(resultado) : new DireccionEntidad();
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.DireccionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DIRECCION_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.DireccionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DIRECCION_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<DireccionEntidad> consultarPorFiltro(DireccionEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new DireccionEntidad());
		var sentencia = new StringBuilder(SELECT_BASE);
		var parametros = new ArrayList<Object>();

		// Solo se filtra por los datos que vienen diligenciados
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			agregarCondicion(sentencia, parametros, "id_direccion", filtroTmp.getId());
		}
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getCiudad().getId())) {
			agregarCondicion(sentencia, parametros, "id_ciudad", filtroTmp.getCiudad().getId());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getViaPrincipal())) {
			agregarCondicion(sentencia, parametros, "via_principal", filtroTmp.getViaPrincipal());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNumeroCruce())) {
			agregarCondicion(sentencia, parametros, "numero_cruce", filtroTmp.getNumeroCruce());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNumeroCasa())) {
			agregarCondicion(sentencia, parametros, "numero_casa", filtroTmp.getNumeroCasa());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getComplemento())) {
			agregarCondicion(sentencia, parametros, "complemento", filtroTmp.getComplemento());
		}

		var resultados = new ArrayList<DireccionEntidad>();

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			for (int posicion = 0; posicion < parametros.size(); posicion++) {
				sentenciaPreparada.setObject(posicion + 1, parametros.get(posicion));
			}

			try (var resultado = sentenciaPreparada.executeQuery()) {
				while (resultado.next()) {
					resultados.add(mapearDireccion(resultado));
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.DireccionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_DIRECCIONES_POR_FILTRO;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.DireccionPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DIRECCIONES_POR_FILTRO;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

		return resultados;
	}

	@Override
	public List<DireccionEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, DireccionEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}


	private void agregarCondicion(StringBuilder sentencia, List<Object> parametros, String columna, Object valor) {
		sentencia.append(parametros.isEmpty() ? " WHERE " : " AND ").append(columna).append(" = ?");
		parametros.add(valor);
	}

	private DireccionEntidad mapearDireccion(ResultSet resultado) throws SQLException {
		var ciudad = new CiudadEntidad();
		ciudad.setId(resultado.getObject("id_ciudad", UUID.class));

		return new DireccionEntidad(resultado.getObject("id_direccion", UUID.class), ciudad,
				resultado.getString("via_principal"), resultado.getString("numero_cruce"),
				resultado.getString("numero_casa"), resultado.getString("complemento"));
	}

}
