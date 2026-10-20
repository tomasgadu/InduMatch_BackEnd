package com.indumatch.dto;

import java.time.LocalDate;
import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class PedidoDTO {
	
	private UUID id;
	private String numeroPedido;
	private LocalDate fechaPedido;
	private ClienteDTO cliente;
	private EstadoPedidoDTO estadoPedido;
	
	public PedidoDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNumeroPedido(UtilTexto.VACIO);
		setFechaPedido(LocalDate.of(1900, 1, 1));
		setCliente(new ClienteDTO());
		setEstadoPedido(new EstadoPedidoDTO());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public String getNumeroPedido() {
		return numeroPedido;
	}
	
	public void setNumeroPedido(String numeroPedido) {
		this.numeroPedido = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroPedido);
	}
	
	public LocalDate getFechaPedido() {
		return fechaPedido;
	}
	
	public void setFechaPedido(LocalDate fechaPedido) {
		this.fechaPedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(fechaPedido, LocalDate.of(1900, 1, 1));
	}
	
	public ClienteDTO getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteDTO cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteDTO());
	}
	
	public EstadoPedidoDTO getEstadoPedido() {
		return estadoPedido;
	}
	
	public void setEstadoPedido(EstadoPedidoDTO estadoPedido) {
		this.estadoPedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoPedido, new EstadoPedidoDTO());
	}
	
}
