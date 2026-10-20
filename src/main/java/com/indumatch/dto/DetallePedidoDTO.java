package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilNumero;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DetallePedidoDTO {
	
	private UUID id;
	private PedidoDTO pedido;
	private ProductoDTO producto;
	private int cantidad;
	
	public DetallePedidoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setPedido(new PedidoDTO());
		setProducto(new ProductoDTO());
		setCantidad(UtilNumero.CERO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public PedidoDTO getPedido() {
		return pedido;
	}
	
	public void setPedido(PedidoDTO pedido) {
		this.pedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pedido, new PedidoDTO());
	}
	
	public ProductoDTO getProducto() {
		return producto;
	}
	
	public void setProducto(ProductoDTO producto) {
		this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoDTO());
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
}
