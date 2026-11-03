package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.ClienteDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.ClienteEntidad;
import com.indumatch.entidad.DireccionEntidad;
import com.indumatch.entidad.TipoIdentificacionEntidad;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchDatosException;
import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClientePostgreSqlDAO extends SqlDAO implements ClienteDAO {

	private static final String SELECT_BASE = "SELECT id_cliente, id_tipo_identificacion, numero_documento, telefono, correo, id_direccion FROM cliente";

	public ClientePostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(ClienteEntidad entidad) {
		var sentencia = "INSERT INTO cliente (id_cliente, id_tipo_identificacion, numero_documento, telefono, correo, id_direccion) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			sentenciaPreparada.setObject(1, entidad.getId());
			sentenciaPreparada.setObject(2, entidad.getTipoIdentificacion().getId());
			sentenciaPreparada.setString(3, entidad.getNumeroDocumento());
			sentenciaPreparada.setString(4, entidad.getTelefono());
			sentenciaPreparada.setString(5, entidad.getCorreo());
			sentenciaPreparada.setObject(6, entidad.getDireccion().getId());

			sentenciaPreparada.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_REGISTRANDO_CLIENTE;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_REGISTRANDO_CLIENTE;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public ClienteEntidad consultarPorId(UUID id) {
		var sentencia = SELECT_BASE + " WHERE id_cliente = ?";

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			sentenciaPreparada.setObject(1, id);

			try (var resultado = sentenciaPreparada.executeQuery()) {
				return resultado.next() ? mapearCliente(resultado) : new ClienteEntidad();
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTE_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTE_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<ClienteEntidad> consultarPorFiltro(ClienteEntidad filtro) {
		var filtroTmp = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(filtro, new ClienteEntidad());
		var sentencia = new StringBuilder(SELECT_BASE);
		var parametros = new ArrayList<Object>();

		// Solo se filtra por los datos que vienen diligenciados
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getId())) {
			agregarCondicion(sentencia, parametros, "id_cliente", filtroTmp.getId());
		}
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getTipoIdentificacion().getId())) {
			agregarCondicion(sentencia, parametros, "id_tipo_identificacion", filtroTmp.getTipoIdentificacion().getId());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getNumeroDocumento())) {
			agregarCondicion(sentencia, parametros, "numero_documento", filtroTmp.getNumeroDocumento());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getTelefono())) {
			agregarCondicion(sentencia, parametros, "telefono", filtroTmp.getTelefono());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroTmp.getCorreo())) {
			agregarCondicion(sentencia, parametros, "correo", filtroTmp.getCorreo());
		}
		if (!UtilUUID.obtenerUUIDDefecto().equals(filtroTmp.getDireccion().getId())) {
			agregarCondicion(sentencia, parametros, "id_direccion", filtroTmp.getDireccion().getId());
		}

		var resultados = new ArrayList<ClienteEntidad>();

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia.toString())) {
			for (int posicion = 0; posicion < parametros.size(); posicion++) {
				sentenciaPreparada.setObject(posicion + 1, parametros.get(posicion));
			}

			try (var resultado = sentenciaPreparada.executeQuery()) {
				while (resultado.next()) {
					resultados.add(mapearCliente(resultado));
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CLIENTES_POR_FILTRO;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.ClientePostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CLIENTES_POR_FILTRO;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

		return resultados;
	}

	@Override
	public List<ClienteEntidad> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void actualizar(UUID id, ClienteEntidad entidad) {
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

	private ClienteEntidad mapearCliente(ResultSet resultado) throws SQLException {
		var tipoIdentificacion = new TipoIdentificacionEntidad();
		tipoIdentificacion.setId(resultado.getObject("id_tipo_identificacion", UUID.class));

		var direccion = new DireccionEntidad();
		direccion.setId(resultado.getObject("id_direccion", UUID.class));

		return new ClienteEntidad(resultado.getObject("id_cliente", UUID.class), tipoIdentificacion,
				resultado.getString("numero_documento"), resultado.getString("telefono"),
				resultado.getString("correo"), direccion);
	}

}
