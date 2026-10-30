package com.indumatch.negocio.negocio.reglas;

public interface Rule<O> {
	
	void ejecutar(O... datos);

}
