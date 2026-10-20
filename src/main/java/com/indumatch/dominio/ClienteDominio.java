package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteDominio {
	
	private UUID id;
	private TipoIdentificacionDominio tipoIdentificacion;
	private String numeroDocumento;
	private String telefono;
	private String correo;
	private DireccionDominio direccion;
	
	
	private ClienteDominio(Builder builder) {
		this.id = builder.id;
		this.tipoIdentificacion = builder.tipoIdentificacion;
		this.numeroDocumento = builder.numeroDocumento;
		this.telefono = builder.telefono;
		this.correo = builder.correo;
		this.direccion = builder.direccion;
	}
	

	public UUID getId() {
		return id;
	}
	
	public TipoIdentificacionDominio getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public DireccionDominio getDireccion() {
		return direccion;
	}
	
	public static class Builder {
		private UUID id;
		private TipoIdentificacionDominio tipoIdentificacion;
		private String numeroDocumento;
		private String telefono;
		private String correo;
		private DireccionDominio direccion;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			tipoIdentificacion = new TipoIdentificacionDominio.Builder().build();
			numeroDocumento = UtilTexto.VACIO;
			telefono = UtilTexto.VACIO;
			correo = UtilTexto.VACIO;
			direccion = new DireccionDominio.Builder().build();
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder tipoIdentificacion(TipoIdentificacionDominio tipoIdentificacion) {
			this.tipoIdentificacion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoIdentificacion, new TipoIdentificacionDominio.Builder().build());
			return this;
		}
		
		public Builder numeroDocumento(String numeroDocumento) {
			this.numeroDocumento = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroDocumento);
			return this;
		}
		
		public Builder telefono(String telefono) {
			this.telefono = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(telefono);
			return this;
		}
		
		public Builder correo(String correo) {
			this.correo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(correo);
			return this;
		}
		
		public Builder direccion(DireccionDominio direccion) {
			this.direccion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(direccion, new DireccionDominio.Builder().build());
			return this;
		}
		
		public ClienteDominio build() {
			return new ClienteDominio(this);
		}
		
	}
}
