package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.ModeloMotoEntidad;

public interface ModeloMotoDAO extends CrearDAO<ModeloMotoEntidad>, ConsultarDAO<ModeloMotoEntidad, UUID>, 
		ActualizarDAO<ModeloMotoEntidad, UUID>, EliminarDAO<UUID> {

}
