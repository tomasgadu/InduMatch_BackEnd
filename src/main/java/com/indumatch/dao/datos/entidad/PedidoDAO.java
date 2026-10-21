package com.indumatch.dao.datos.entidad;

import java.util.UUID;

import com.indumatch.dao.datos.ActualizarDAO;
import com.indumatch.dao.datos.ConsultarDAO;
import com.indumatch.dao.datos.CrearDAO;
import com.indumatch.dao.datos.EliminarDAO;
import com.indumatch.entidad.PedidoEntidad;

public interface PedidoDAO extends CrearDAO<PedidoEntidad>, ConsultarDAO<PedidoEntidad, UUID>, 
		ActualizarDAO<PedidoEntidad, UUID>, EliminarDAO<UUID> {

}
