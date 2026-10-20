package com.indumatch.entidad;

import java.time.LocalDate;
import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class PedidoEntidad {
	
	private UUID id;
	private String numeroPedido;
	private LocalDate fechaPedido;
	private ClienteEntidad cliente;
	private EstadoPedidoEntidad estadoPedido;
	
	public PedidoEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setNumeroPedido(UtilTexto.VACIO);
		setFechaPedido(LocalDate.of(1900, 1, 1));
		setCliente(new ClienteEntidad());
		setEstadoPedido(new EstadoPedidoEntidad());
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
	
	public ClienteEntidad getCliente() {
		return cliente;
	}
	
	public void setCliente(ClienteEntidad cliente) {
		this.cliente = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(cliente, new ClienteEntidad());
	}
	
	public EstadoPedidoEntidad getEstadoPedido() {
		return estadoPedido;
	}
	
	public void setEstadoPedido(EstadoPedidoEntidad estadoPedido) {
		this.estadoPedido = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(estadoPedido, new EstadoPedidoEntidad());
	}
	
}
