package com.indumatch.entidad;

import java.time.LocalDate;
import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class EnvioEntidad {
	
	private UUID id;
	private PedidoEntidad pedido;
	private TransportadoraEntidad transportadora;
	private String numeroGuia;
	private LocalDate fechaDespacho;
	
	public EnvioEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setPedido(new PedidoEntidad());
		setTransportadora(new TransportadoraEntidad());
		setNumeroGuia(UtilTexto.VACIO);
		setFechaDespacho(LocalDate.of(1900, 1, 1));
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
	
	public TransportadoraEntidad getTransportadora() {
		return transportadora;
	}
	
	public void setTransportadora(TransportadoraEntidad transportadora) {
		this.transportadora = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(transportadora, new TransportadoraEntidad());
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
