package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class MarcaComercialDominio {
	
	private UUID id;
	private String nombre;
	private String descripcion;
	private ClienteDistribuidorDominio clienteDistribuidor;
	private MarcaComercialDominio marcaMadre;
	
	
	private MarcaComercialDominio(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
		this.descripcion = builder.descripcion;
		this.clienteDistribuidor = builder.clienteDistribuidor;
		this.marcaMadre = builder.marcaMadre;
	}
	

	public UUID getId() {
		return id;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public ClienteDistribuidorDominio getClienteDistribuidor() {
		return clienteDistribuidor;
	}
	
	public MarcaComercialDominio getMarcaMadre() {
		return marcaMadre;
	}
	
	public static class Builder {
		private UUID id;
		private String nombre;
		private String descripcion;
		private ClienteDistribuidorDominio clienteDistribuidor;
		private MarcaComercialDominio marcaMadre;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			nombre = UtilTexto.VACIO;
			descripcion = UtilTexto.VACIO;
			clienteDistribuidor = new ClienteDistribuidorDominio.Builder().build();
			// marcaMadre no se inicializa por defecto para evitar una recursión infinita (autorreferencia)
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(nombre);
			return this;
		}
		
		public Builder descripcion(String descripcion) {
			this.descripcion = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(descripcion);
			return this;
		}
		
		public Builder clienteDistribuidor(ClienteDistribuidorDominio clienteDistribuidor) {
			this.clienteDistribuidor = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(clienteDistribuidor, new ClienteDistribuidorDominio.Builder().build());
			return this;
		}
		
		public Builder marcaMadre(MarcaComercialDominio marcaMadre) {
			this.marcaMadre = marcaMadre;
			return this;
		}
		
		public MarcaComercialDominio build() {
			return new MarcaComercialDominio(this);
		}
		
	}
}
