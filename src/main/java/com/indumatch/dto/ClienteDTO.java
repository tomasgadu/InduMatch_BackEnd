package com.indumatch.dto;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteDTO {
	
	private UUID id;
	private TipoIdentificacionDTO tipoIdentificacion;
	private String numeroDocumento;
	private String telefono;
	private String correo;
	private DireccionDTO direccion;
	
	public ClienteDTO() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipoIdentificacion(new TipoIdentificacionDTO());
		setNumeroDocumento(UtilTexto.VACIO);
		setTelefono(UtilTexto.VACIO);
		setCorreo(UtilTexto.VACIO);
		setDireccion(new DireccionDTO());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public TipoIdentificacionDTO getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	
	public void setTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoIdentificacion, new TipoIdentificacionDTO());
	}
	
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(numeroDocumento);
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(telefono);
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = UtilTexto.getUtilTexto().quitarEspacioEnBlanco(correo);
	}
	
	public DireccionDTO getDireccion() {
		return direccion;
	}
	
	public void setDireccion(DireccionDTO direccion) {
		this.direccion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(direccion, new DireccionDTO());
	}
	
}
