package com.indumatch.dominio;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DireccionDominio {
	
	private UUID id;
	private CiudadDominio ciudad;
	private String viaPrincipal;
	private String numeroCruce;
	private String numeroCasa;
	private String complemento;
	
	
	private DireccionDominio(Builder builder) {
		this.id = builder.id;
		this.ciudad = builder.ciudad;
		this.viaPrincipal = builder.viaPrincipal;
		this.numeroCruce = builder.numeroCruce;
		this.numeroCasa = builder.numeroCasa;
		this.complemento = builder.complemento;
	}
	

	public UUID getId() {
		return id;
	}
	
	public CiudadDominio getCiudad() {
		return ciudad;
	}
	
	public String getViaPrincipal() {
		return viaPrincipal;
	}
	
	public String getNumeroCruce() {
		return numeroCruce;
	}
	
	public String getNumeroCasa() {
		return numeroCasa;
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public static class Builder {
		private UUID id;
		private CiudadDominio ciudad;
		private String viaPrincipal;
		private String numeroCruce;
		private String numeroCasa;
		private String complemento;
		
		public Builder() {
			id = UtilUUID.obtenerUUIDDefecto();
			ciudad = new CiudadDominio.Builder().build();
			viaPrincipal = UtilTexto.VACIO;
			numeroCruce = UtilTexto.VACIO;
			numeroCasa = UtilTexto.VACIO;
			complemento = UtilTexto.VACIO;
		}
		
		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}
		
		public Builder ciudad(CiudadDominio ciudad) {
			this.ciudad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(ciudad, new CiudadDominio.Builder().build());
			return this;
		}
		
		public Builder viaPrincipal(String viaPrincipal) {
			this.viaPrincipal = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(viaPrincipal);
			return this;
		}
		
		public Builder numeroCruce(String numeroCruce) {
			this.numeroCruce = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroCruce);
			return this;
		}
		
		public Builder numeroCasa(String numeroCasa) {
			this.numeroCasa = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroCasa);
			return this;
		}
		
		public Builder complemento(String complemento) {
			this.complemento = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(complemento);
			return this;
		}
		
		public DireccionDominio build() {
			return new DireccionDominio(this);
		}
		
	}
}
