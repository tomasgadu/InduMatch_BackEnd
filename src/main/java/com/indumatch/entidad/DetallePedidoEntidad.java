package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilNumero;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DetallePedidoEntidad {
	
	private UUID id;
	private PedidoEntidad pedido;
	private ProductoEntidad producto;
	private int cantidad;
	
	public DetallePedidoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setPedido(new PedidoEntidad());
		setProducto(new ProductoEntidad());
		setCantidad(UtilNumero.CERO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public PedidoEntidad getPedido() {
		return pedido;
	}
	
	public void setPedido(PedidoEntidad pedido) {
		this.pedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pedido, new PedidoEntidad());
	}
	
	public ProductoEntidad getProducto() {
		return producto;
	}
	
	public void setProducto(ProductoEntidad producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoEntidad());
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
