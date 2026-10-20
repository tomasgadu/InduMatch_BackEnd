package com.indumatch.transversal.excepciones;

import com.indumatch.transversal.excepciones.enums.Capa;

public class InduMatchFachadaException extends InduMatchExcepcion {

	private static final long serialVersionUID = 2781462033546993220L;

	private InduMatchFachadaException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.FACHADA, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario) {
		return new InduMatchFachadaException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico) {
		return new InduMatchFachadaException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico, Exception excepcionRaiz) {
		return new InduMatchFachadaException(mensajeUsuario, mensajeTecnico, new Exception(excepcionRaiz));	
	}
	
}
