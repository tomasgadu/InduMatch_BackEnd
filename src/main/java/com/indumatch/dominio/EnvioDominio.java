package com.indumatch.dominio;

import java.time.LocalDate;
import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class EnvioDominio {
	
	private UUID id;
	private PedidoDominio pedido;
	private TransportadoraDominio transportadora;
	private String numeroGuia;
	private LocalDate fechaDespacho;
	
	
	private EnvioDominio(Builder builder) {
		this.id = builder.id;
		this.pedido = builder.pedido;
		this.transportadora = builder.transportadora;
		this.numeroGuia = builder.numeroGuia;
		this.fechaDespacho = builder.fechaDespacho;
	}
	

	public UUID getId() {
		return id;
	}
	
	public PedidoDominio getPedido() {
		return pedido;
	}
	
	public TransportadoraDominio getTransportadora() {
		return transportadora;
	}
	
	public String getNumeroGuia() {
		return numeroGuia;
	}
	
	public LocalDate getFechaDespacho() {
		return fechaDespacho;
	}
	
	public static class Builder {
		private UUID id;
		private PedidoDominio pedido;
		private TransportadoraDominio transportadora;
		private String numeroGuia;
		private LocalDate fechaDespacho;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			pedido = new PedidoDominio.Builder().build();
			transportadora = new TransportadoraDominio.Builder().build();
			numeroGuia = UtilTexto.VACIO;
			fechaDespacho = LocalDate.of(1900, 1, 1);
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder pedido(PedidoDominio pedido) {
			this.pedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(pedido, new PedidoDominio.Builder().build());
			return this;
		}
		
		public Builder transportadora(TransportadoraDominio transportadora) {
			this.transportadora = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(transportadora, new TransportadoraDominio.Builder().build());
			return this;
		}
		
		public Builder numeroGuia(String numeroGuia) {
			this.numeroGuia = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroGuia);
			return this;
		}
		
		public Builder fechaDespacho(LocalDate fechaDespacho) {
			this.fechaDespacho = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fechaDespacho, LocalDate.of(1900, 1, 1));
			return this;
		}
		
		public EnvioDominio build() {
			return new EnvioDominio(this);
		}
		
	}
}
