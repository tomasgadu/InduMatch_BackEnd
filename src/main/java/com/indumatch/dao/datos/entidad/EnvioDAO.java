package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.entidad.EnvioEntidad;

public interface EnvioDAO extends CrearDAO<EnvioEntidad>, ConsultarDAO<EnvioEntidad, UUID>, 
		ActualizarDAO<EnvioEntidad, UUID> {

}
