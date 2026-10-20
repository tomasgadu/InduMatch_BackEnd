package com.indumatch.transversal.excepciones;

import com.indumatch.transversal.excepciones.enums.Capa;

public class InduMatchDatosException extends InduMatchExcepcion {

	private static final long serialVersionUID = 2781462033546993220L;

	private InduMatchDatosException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DATOS, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario) {
		return new InduMatchDatosException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico) {
		return new InduMatchDatosException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico, Exception excepcionRaiz) {
		return new InduMatchDatosException(mensajeUsuario, mensajeTecnico, new Exception(excepcionRaiz));	
	}
	
}
