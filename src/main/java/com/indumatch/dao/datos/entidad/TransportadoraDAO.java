package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.TransportadoraEntidad;

public interface TransportadoraDAO extends CrearDAO<TransportadoraEntidad>, ConsultarDAO<TransportadoraEntidad, UUID>, 
		ActualizarDAO<TransportadoraEntidad, UUID>, EliminarDAO<UUID> {

}
