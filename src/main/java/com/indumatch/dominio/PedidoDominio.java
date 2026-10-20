package com.indumatch.dominio;

import java.time.LocalDate;
import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class PedidoDominio {
	
	private UUID id;
	private String numeroPedido;
	private LocalDate fechaPedido;
	private ClienteDominio cliente;
	private EstadoPedidoDominio estadoPedido;
	
	
	private PedidoDominio(Builder builder) {
		this.id = builder.id;
		this.numeroPedido = builder.numeroPedido;
		this.fechaPedido = builder.fechaPedido;
		this.cliente = builder.cliente;
		this.estadoPedido = builder.estadoPedido;
	}
	

	public UUID getId() {
		return id;
	}
	
	public String getNumeroPedido() {
		return numeroPedido;
	}
	
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	
	public ClienteDominio getCliente() {
		return cliente;
	}
	
	public EstadoPedidoDominio getEstadoPedido() {
		return estadoPedido;
	}
	
	public static class Builder {
		private UUID id;
		private String numeroPedido;
		private LocalDate fechaPedido;
		private ClienteDominio cliente;
		private EstadoPedidoDominio estadoPedido;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			numeroPedido = UtilTexto.VACIO;
			fechaPedido = LocalDate.of(1900, 1, 1);
			cliente = new ClienteDominio.Builder().build();
			estadoPedido = new EstadoPedidoDominio.Builder().build();
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder numeroPedido(String numeroPedido) {
			this.numeroPedido = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroPedido);
			return this;
		}
		
		public Builder fechaPedido(LocalDate fechaPedido) {
			this.fechaPedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fechaPedido, LocalDate.of(1900, 1, 1));
			return this;
		}
		
		public Builder cliente(ClienteDominio cliente) {
			this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDominio.Builder().build());
			return this;
		}
		
		public Builder estadoPedido(EstadoPedidoDominio estadoPedido) {
			this.estadoPedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoPedido, new EstadoPedidoDominio.Builder().build());
			return this;
		}
		
		public PedidoDominio build() {
			return new PedidoDominio(this);
		}
		
	}
}
