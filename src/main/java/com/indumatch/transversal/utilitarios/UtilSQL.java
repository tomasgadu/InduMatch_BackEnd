package com.indumatch.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchTransversalException;

public class UtilSQL {

	private UtilSQL() {

	}

	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return (!conexionEstaVacia(conexion) && !conexion.isClosed());
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}
	}
	
	public static void asegurarConexionAbierta(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA;
			throw InduMatchTransversalException.crear(mensajeUsuario);
		}
	}


	public static void iniciarTransaccion(Connection conexion) {
		
		asegurarConexionAbierta(conexion);

		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO INICIAR LA TRANSACCION
		
		try {
			conexion.setAutoCommit(false);
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_INICIANDO_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}

	}

	public static void confirmarTransaccion(Connection conexion) {

		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO CONFIRMAR LA TRANSACCION
		
		try {
			conexion.commit();
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONFIRMANDO_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}

	}

	public static void cancelarTransaccion(Connection conexion) {

		if (!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO CANCELAR LA TRANSACCION
		
		try {
			conexion.rollback();
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CANCELANDO_TRANSACCION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}

	}

	public static void cerrarConexion(Connection conexion) {

		if (!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario);
		}

		// TAREA QUE SE TENIA DE COMO CERRAR LA CONEXION
		
		try {
			conexion.close();
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CERRANDO_CONEXION_SQL;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}

	}

	public static boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		} catch (SQLException exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);

		} catch (Exception exception) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA;
			throw InduMatchTransversalException.crear(mensajeUsuario, exception.getMessage(), exception);
		}

	}

	public static boolean conexionEstaVacia(Connection conexion) {
		return UtilObjeto.esNulo(conexion);
	}

}
