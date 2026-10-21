package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.DepartamentoEntidad;

public interface DepartamentoDAO extends CrearDAO<DepartamentoEntidad>, ConsultarDAO<DepartamentoEntidad, UUID>, 
		ActualizarDAO<DepartamentoEntidad, UUID>, EliminarDAO<UUID> {

}
