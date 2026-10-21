package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.TipoIdentificacionEntidad;

public interface TipoIdentificacionDAO extends CrearDAO<TipoIdentificacionEntidad>, ConsultarDAO<TipoIdentificacionEntidad, UUID>, 
		ActualizarDAO<TipoIdentificacionEntidad, UUID>, EliminarDAO<UUID> {

}
