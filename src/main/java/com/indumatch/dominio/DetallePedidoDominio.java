package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilNumero;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DetallePedidoDominio {
	
	private UUID id;
	private PedidoDominio pedido;
	private ProductoDominio producto;
	private int cantidad;
	
	
	private DetallePedidoDominio(Builder builder) {
		this.id = builder.id;
		this.pedido = builder.pedido;
		this.producto = builder.producto;
		this.cantidad = builder.cantidad;
	}
	

	public UUID getId() {
		return id;
	}
	
	public PedidoDominio getPedido() {
		return pedido;
	}
	
	public ProductoDominio getProducto() {
		return producto;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public static class Builder {
		private UUID id;
		private PedidoDominio pedido;
		private ProductoDominio producto;
		private int cantidad;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			pedido = new PedidoDominio.Builder().build();
			producto = new ProductoDominio.Builder().build();
			cantidad = UtilNumero.CERO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder pedido(PedidoDominio pedido) {
			this.pedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pedido, new PedidoDominio.Builder().build());
			return this;
		}
		
		public Builder producto(ProductoDominio producto) {
			this.producto = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(producto, new ProductoDominio.Builder().build());
			return this;
		}
		
		public Builder cantidad(int cantidad) {
			this.cantidad = cantidad;
			return this;
		}
		
		public DetallePedidoDominio build() {
			return new DetallePedidoDominio(this);
		}
		
	}
}
