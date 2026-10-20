package com.indumatch.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class EnvioDTO {
	
	private UUID id;
	private PedidoDTO pedido;
	private TransportadoraDTO transportadora;
	private String numeroGuia;
	private LocalDate fechaDespacho;
	
	public EnvioDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setPedido(new PedidoDTO());
		setTransportadora(new TransportadoraDTO());
		setNumeroGuia(UtilTexto.VACIO);
		setFechaDespacho(LocalDate.of(1900, 1, 1));
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
	
	public TransportadoraDTO getTransportadora() {
		return transportadora;
	}
	
	public void setTransportadora(TransportadoraDTO transportadora) {
		this.transportadora = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(transportadora, new TransportadoraDTO());
	}
	
	public String getNumeroGuia() {
		return numeroGuia;
	}
	
	public void setNumeroGuia(String numeroGuia) {
		this.numeroGuia = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroGuia);
	}
	
	public LocalDate getFechaDespacho() {
		return fechaDespacho;
	}
	
	public void setFechaDespacho(LocalDate fechaDespacho) {
		this.fechaDespacho = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fechaDespacho, LocalDate.of(1900, 1, 1));
	}
	
}
