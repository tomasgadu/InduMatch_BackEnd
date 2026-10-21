package com.indumatch.dao.factoria;

import java.sql.Connection;

import com.indumatch.dao.datos.entidad.CategoriaProductoDAO;
import com.indumatch.dao.datos.entidad.CilindrajeDAO;
import com.indumatch.dao.datos.entidad.CiudadDAO;
import com.indumatch.dao.datos.entidad.ClienteDAO;
import com.indumatch.dao.datos.entidad.ClienteDistribuidorDAO;
import com.indumatch.dao.datos.entidad.ClienteNaturalDAO;
import com.indumatch.dao.datos.entidad.DepartamentoDAO;
import com.indumatch.dao.datos.entidad.DetallePedidoDAO;
import com.indumatch.dao.datos.entidad.DireccionDAO;
import com.indumatch.dao.datos.entidad.EnvioDAO;
import com.indumatch.dao.datos.entidad.EstadoPedidoDAO;
import com.indumatch.dao.datos.entidad.HomologacionDAO;
import com.indumatch.dao.datos.entidad.LineaModeloDAO;
import com.indumatch.dao.datos.entidad.MarcaComercialDAO;
import com.indumatch.dao.datos.entidad.MarcaFabricanteDAO;
import com.indumatch.dao.datos.entidad.ModeloMotoDAO;
import com.indumatch.dao.datos.entidad.PaisDAO;
import com.indumatch.dao.datos.entidad.PedidoDAO;
import com.indumatch.dao.datos.entidad.ProductoDAO;
import com.indumatch.dao.datos.entidad.TipoIdentificacionDAO;
import com.indumatch.dao.datos.entidad.TransportadoraDAO;
import com.indumatch.dao.factoria.enums.FactoriaEnum;
import com.indumatch.dao.factoria.impl.PostgreSqlDAOFactory;
import com.indumatch.transversal.excepciones.InduMatchDatosException;
import com.indumatch.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {

	private Connection conexion;

	private static FactoriaEnum factoria = FactoriaEnum.POSTGRESQL;

	public static DAOFactory obtenerFactoria() {
		switch (factoria) {
		case POSTGRESQL:
			return new PostgreSqlDAOFactory();
		default:
			var mensajeUsuario = "La fuente de información deseada que se solicitó para llevar a cabo la operación no está habilitada. Por favor contacte el administrador de la aplicación";
			throw InduMatchDatosException.crear(mensajeUsuario);
		}
	}

	protected DAOFactory() {
		abrirConexion();

	}

	public Connection getConexion() {
		return conexion;
	}

	public void setConexion(Connection conexion) {
		// TAREA: ASEGURAR QUE LA CONEXIÓN ESTÉ ABIERTA Y SEA VÁLIDA
		this.conexion = conexion;
	}

	protected abstract void abrirConexion();

	public void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}

	public void iniciarTransaccion() {
		UtilSQL.iniciarTransaccion(conexion);
	}

	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}

	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}

	public abstract PaisDAO obtenerPaisDAO();

	public abstract DepartamentoDAO obtenerDepartamentoDAO();

	public abstract CiudadDAO obtenerCiudadDAO();

	public abstract DireccionDAO obtenerDireccionDAO();

	public abstract TipoIdentificacionDAO obtenerTipoIdentificacionDAO();

	public abstract ClienteDAO obtenerClienteDAO();

	public abstract ClienteNaturalDAO obtenerClienteNaturalDAO();

	public abstract ClienteDistribuidorDAO obtenerClienteDistribuidorDAO();

	public abstract MarcaComercialDAO obtenerMarcaComercialDAO();

	public abstract MarcaFabricanteDAO obtenerMarcaFabricanteDAO();

	public abstract LineaModeloDAO obtenerLineaModeloDAO();

	public abstract CilindrajeDAO obtenerCilindrajeDAO();

	public abstract ModeloMotoDAO obtenerModeloMotoDAO();

	public abstract CategoriaProductoDAO obtenerCategoriaProductoDAO();

	public abstract ProductoDAO obtenerProductoDAO();

	public abstract HomologacionDAO obtenerHomologacionDAO();

	public abstract EstadoPedidoDAO obtenerEstadoPedidoDAO();

	public abstract PedidoDAO obtenerPedidoDAO();

	public abstract DetallePedidoDAO obtenerDetallePedidoDAO();

	public abstract TransportadoraDAO obtenerTransportadoraDAO();

	public abstract EnvioDAO obtenerEnvioDAO();

}