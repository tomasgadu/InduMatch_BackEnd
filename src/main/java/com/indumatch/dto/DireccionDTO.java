package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class DireccionDTO {
	
	private UUID id;
	private CiudadDTO ciudad;
	private String viaPrincipal;
	private String numeroCruce;
	private String numeroCasa;
	private String complemento;
	
	public DireccionDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setCiudad(new CiudadDTO());
		setViaPrincipal(UtilTexto.VACIO);
		setNumeroCruce(UtilTexto.VACIO);
		setNumeroCasa(UtilTexto.VACIO);
		setComplemento(UtilTexto.VACIO);
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public CiudadDTO getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(CiudadDTO ciudad) {
		this.ciudad = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(ciudad, new CiudadDTO());
	}
	
	public String getViaPrincipal() {
		return viaPrincipal;
	}
	
	public void setViaPrincipal(String viaPrincipal) {
		this.viaPrincipal = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(viaPrincipal);
	}
	
	public String getNumeroCruce() {
		return numeroCruce;
	}
	
	public void setNumeroCruce(String numeroCruce) {
		this.numeroCruce = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroCruce);
	}
	
	public String getNumeroCasa() {
		return numeroCasa;
	}
	
	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroCasa);
	}
	
	public String getComplemento() {
		return complemento;
	}
	
	public void setComplemento(String complemento) {
		this.complemento = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(complemento);
	}
	
}
