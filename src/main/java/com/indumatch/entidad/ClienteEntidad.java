package com.indumatch.entidad;

import java.util.UUID;

import com.indumatch.transversal.utilitarios.UtilObjeto;
import com.indumatch.transversal.utilitarios.UtilTexto;
import com.indumatch.transversal.utilitarios.UtilUUID;

public class ClienteEntidad {
	
	private UUID id;
	private TipoIdentificacionEntidad tipoIdentificacion;
	private String numeroDocumento;
	private String telefono;
	private String correo;
	private DireccionEntidad direccion;
	
	public ClienteEntidad() {
		setId(UtilUUID.obtenerUUIDDefecto());
		setTipoIdentificacion(new TipoIdentificacionEntidad());
		setNumeroDocumento(UtilTexto.VACIO);
		setTelefono(UtilTexto.VACIO);
		setCorreo(UtilTexto.VACIO);
		setDireccion(new DireccionEntidad());
	}
	
	public UUID getId() {
		return id;
	}
	
	public void setId(UUID id) {
		this.id = UtilUUID.obtenerValorDefecto(id);
	}
	
	public TipoIdentificacionEntidad getTipoIdentificacion() {
		return tipoIdentificacion;
	}
	
	public void setTipoIdentificacion(TipoIdentificacionEntidad tipoIdentificacion) {
		this.tipoIdentificacion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(tipoIdentificacion, new TipoIdentificacionEntidad());
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
	
	public DireccionEntidad getDireccion() {
		return direccion;
	}
	
	public void setDireccion(DireccionEntidad direccion) {
		this.direccion = UtilObjeto.obtenerValorDefectoSiValorOriginalEsNulo(direccion, new DireccionEntidad());
	}
	
}
