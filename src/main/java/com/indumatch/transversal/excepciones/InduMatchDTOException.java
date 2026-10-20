package com.indumatch.transversal.excepciones;

import com.indumatch.transversal.excepciones.enums.Capa;

public class InduMatchDTOException extends InduMatchExcepcion {

	private static final long serialVersionUID = 2781462033546993220L;

	private InduMatchDTOException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario) {
		return new InduMatchDTOException(mensajeUsuario, mensajeUsuario, new Exception(mensajeUsuario));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico) {
		return new InduMatchDTOException(mensajeUsuario, mensajeTecnico, new Exception(mensajeTecnico));	
	}
	
	public static InduMatchExcepcion crear(String mensajeUsuario,String mensajeTecnico, Exception excepcionRaiz) {
		return new InduMatchDTOException(mensajeUsuario, mensajeTecnico, new Exception(excepcionRaiz));	
	}
	
}
