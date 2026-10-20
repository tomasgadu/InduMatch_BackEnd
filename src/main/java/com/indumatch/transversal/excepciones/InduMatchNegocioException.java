package com.indumatch.transversal.excepciones;

import com.indumatch.transversal.excepciones.enums.Capa;

public class InduMatchNegocioException extends InduMatchExcepcion {

	private static final long serialVersionUID = 2781462033546993220L;

	private InduMatchNegocioException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario) {
		return new InduMatchNegocioException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico) {
		return new InduMatchNegocioException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico, Exception excepcionRaiz) {
		return new InduMatchNegocioException(mensajeUsuario, mensajeTecnico, new Exception(excepcionRaiz));	
	}
	
}
