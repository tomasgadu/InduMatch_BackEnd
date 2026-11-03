package com.indumatch.dao.datos.entidad.postgresql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.indumatch.dao.datos.entidad.CiudadDAO;
import com.indumatch.dao.datos.entidad.SqlDAO;
import com.indumatch.entidad.DepartamentoEntidad;
import com.indumatch.entidad.CiudadEntidad;
import com.indumatch.entidad.PaisEntidad;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchDatosException;

public class CiudadPostgreSqlDAO extends SqlDAO implements CiudadDAO {

	public CiudadPostgreSqlDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public void crear(CiudadEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CiudadEntidad consultarPorId(UUID id) {
		var sentencia = "SELECT id_ciudad, id_departamento, nombre FROM ciudad WHERE id_ciudad = ?";

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia)) {
			sentenciaPreparada.setObject(1, id);

			try (var resultado = sentenciaPreparada.executeQuery()) {
				return resultado.next() ? mapearCiudad(resultado) : new CiudadEntidad();
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDAD_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDAD_POR_ID;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<CiudadEntidad> consultarPorFiltro(CiudadEntidad filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadEntidad> consultarTodos() {
		var sentencia = "SELECT c.id_ciudad, c.nombre AS nombre_ciudad, d.id_departamento, d.nombre AS nombre_departamento, "
				+ "p.id_pais, p.nombre AS nombre_pais, p.codigo AS codigo_pais "
				+ "FROM ciudad c "
				+ "INNER JOIN departamento d ON d.id_departamento = c.id_departamento "
				+ "INNER JOIN pais p ON p.id_pais = d.id_pais "
				+ "ORDER BY c.nombre";
		var ciudades = new ArrayList<CiudadEntidad>();

		try (var sentenciaPreparada = getConexion().prepareStatement(sentencia);
				var resultado = sentenciaPreparada.executeQuery()) {

			while (resultado.next()) {
				ciudades.add(mapearCiudadCompleta(resultado));
			}
			return ciudades;
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODAS_CIUDADES;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadPostgreSqlDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TODAS_CIUDADES;
			throw InduMatchDatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public void actualizar(UUID id, CiudadEntidad entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(UUID id) {
		// TODO Auto-generated method stub
		
	}


	private CiudadEntidad mapearCiudad(ResultSet resultado) throws SQLException {
		var departamento = new DepartamentoEntidad();
		departamento.setId(resultado.getObject("id_departamento", UUID.class));

		return new CiudadEntidad(resultado.getObject("id_ciudad", UUID.class), resultado.getString("nombre"),
				departamento);
	}

	private CiudadEntidad mapearCiudadCompleta(ResultSet resultado) throws SQLException {
		var pais = new PaisEntidad(resultado.getObject("id_pais", UUID.class), resultado.getString("nombre_pais"),
				resultado.getString("codigo_pais"));
		var departamento = new DepartamentoEntidad(resultado.getObject("id_departamento", UUID.class),
				resultado.getString("nombre_departamento"), pais);

		return new CiudadEntidad(resultado.getObject("id_ciudad", UUID.class), resultado.getString("nombre_ciudad"),
				departamento);
	}

}
