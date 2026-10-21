package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.CilindrajeEntidad;

public interface CilindrajeDAO extends CrearDAO<CilindrajeEntidad>, ConsultarDAO<CilindrajeEntidad, UUID>, 
		ActualizarDAO<CilindrajeEntidad, UUID>, EliminarDAO<UUID> {

}
