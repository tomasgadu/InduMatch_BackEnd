package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.MarcaComercialEntidad;

public interface MarcaComercialDAO extends CrearDAO<MarcaComercialEntidad>, ConsultarDAO<MarcaComercialEntidad, UUID>, 
		ActualizarDAO<MarcaComercialEntidad, UUID>, EliminarDAO<UUID> {

}
