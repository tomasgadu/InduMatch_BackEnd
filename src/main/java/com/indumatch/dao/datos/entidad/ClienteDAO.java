package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.ClienteEntidad;

public interface ClienteDAO extends CrearDAO<ClienteEntidad>, ConsultarDAO<ClienteEntidad, UUID>, 
		ActualizarDAO<ClienteEntidad, UUID>, EliminarDAO<UUID> {

}
