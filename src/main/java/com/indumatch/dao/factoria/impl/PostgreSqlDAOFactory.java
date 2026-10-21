package com.indumatch.dao.factoria.impl;
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
import com.indumatch.dao.datos.entidad.postgresql.CategoriaProductoPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.CilindrajePostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.CiudadPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.ClientePostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.ClienteDistribuidorPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.ClienteNaturalPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.DepartamentoPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.DetallePedidoPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.DireccionPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.EnvioPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.EstadoPedidoPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.HomologacionPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.LineaModeloPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.MarcaComercialPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.MarcaFabricantePostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.ModeloMotoPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.PaisPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.PedidoPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.ProductoPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.TipoIdentificacionPostgreSqlDAO;
import com.indumatch.dao.datos.entidad.postgresql.TransportadoraPostgreSqlDAO;
import com.indumatch.dao.factoria.DAOFactory;

public class PostgreSqlDAOFactory extends DAOFactory{

	@Override
	protected void abrirConexion() {
		//TAREA: ¿Como abrir una conexion con PostgreSQL desde java?	
		Connection conexion = null;
		setConexion(conexion);	
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisPostgreSqlDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoPostgreSqlDAO(getConexion());
	}

	@Override
	public CiudadDAO obtenerCiudadDAO() {
		return new CiudadPostgreSqlDAO(getConexion());
	}

	@Override
	public DireccionDAO obtenerDireccionDAO() {
		return new DireccionPostgreSqlDAO(getConexion());
	}

	@Override
	public TipoIdentificacionDAO obtenerTipoIdentificacionDAO() {
		return new TipoIdentificacionPostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteDAO obtenerClienteDAO() {
		return new ClientePostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteNaturalDAO obtenerClienteNaturalDAO() {
		return new ClienteNaturalPostgreSqlDAO(getConexion());
	}

	@Override
	public ClienteDistribuidorDAO obtenerClienteDistribuidorDAO() {
		return new ClienteDistribuidorPostgreSqlDAO(getConexion());
	}

	@Override
	public MarcaComercialDAO obtenerMarcaComercialDAO() {
		return new MarcaComercialPostgreSqlDAO(getConexion());
	}

	@Override
	public MarcaFabricanteDAO obtenerMarcaFabricanteDAO() {
		return new MarcaFabricantePostgreSqlDAO(getConexion());
	}

	@Override
	public LineaModeloDAO obtenerLineaModeloDAO() {
		return new LineaModeloPostgreSqlDAO(getConexion());
	}

	@Override
	public CilindrajeDAO obtenerCilindrajeDAO() {
		return new CilindrajePostgreSqlDAO(getConexion());
	}

	@Override
	public ModeloMotoDAO obtenerModeloMotoDAO() {
		return new ModeloMotoPostgreSqlDAO(getConexion());
	}

	@Override
	public CategoriaProductoDAO obtenerCategoriaProductoDAO() {
		return new CategoriaProductoPostgreSqlDAO(getConexion());
	}

	@Override
	public ProductoDAO obtenerProductoDAO() {
		return new ProductoPostgreSqlDAO(getConexion());
	}

	@Override
	public HomologacionDAO obtenerHomologacionDAO() {
		return new HomologacionPostgreSqlDAO(getConexion());
	}

	@Override
	public EstadoPedidoDAO obtenerEstadoPedidoDAO() {
		return new EstadoPedidoPostgreSqlDAO(getConexion());
	}

	@Override
	public PedidoDAO obtenerPedidoDAO() {
		return new PedidoPostgreSqlDAO(getConexion());
	}

	@Override
	public DetallePedidoDAO obtenerDetallePedidoDAO() {
		return new DetallePedidoPostgreSqlDAO(getConexion());
	}

	@Override
	public TransportadoraDAO obtenerTransportadoraDAO() {
		return new TransportadoraPostgreSqlDAO(getConexion());
	}

	@Override
	public EnvioDAO obtenerEnvioDAO() {
		return new EnvioPostgreSqlDAO(getConexion());
	}

}