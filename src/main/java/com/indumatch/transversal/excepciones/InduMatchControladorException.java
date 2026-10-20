package com.indumatch.transversal.excepciones;

import com.indumatch.transversal.excepciones.enums.Capa;

public class InduMatchControladorException extends InduMatchExcepcion {

	private static final long serialVersionUID = 2781462033546993220L;

	private InduMatchControladorException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario) {
		return new InduMatchControladorException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico) {
		return new InduMatchControladorException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico, Exception excepcionRaiz) {
		return new InduMatchControladorException(mensajeUsuario, mensajeTecnico, new Exception(excepcionRaiz));	
	}
	
}
