package com.indumatch.controlador.vista;

import java.util.UUID;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.indumatch.dto.CiudadDTO;
import com.indumatch.dto.ClienteDTO;
import com.indumatch.dto.TipoIdentificacionDTO;
import com.indumatch.negocio.fachada.ClienteFachada;
import com.indumatch.negocio.fachada.impl.CiudadFachadaImpl;
import com.indumatch.negocio.fachada.impl.ClienteFachadaImpl;
import com.indumatch.negocio.fachada.impl.TipoIdentificacionFachadaImpl;
import com.indumatch.transversal.catalogo.CatalogoMensajes;
import com.indumatch.transversal.excepciones.InduMatchExcepcion;

// @Controller (no @RestController): sus métodos devuelven el NOMBRE de una
// página de la carpeta templates, no un JSON.
@Controller
public class ClienteVistaControlador {

	private static final String VISTA_FORMULARIO = "registrar-cliente";
	private static final String VISTA_CONFIRMACION = "cliente-registrado";

	// Muestra el formulario vacío
	@GetMapping({ "/", "/clientes/registrar" })
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("cliente", new ClienteDTO());
		cargarListas(modelo);
		return VISTA_FORMULARIO;
	}

	// Recibe el formulario. Spring llena el ClienteDTO con los campos que se enviaron.
	@PostMapping("/clientes/registrar")
	public String registrarCliente(@ModelAttribute("cliente") ClienteDTO cliente, Model modelo) {
		try {
			ClienteFachada fachada = new ClienteFachadaImpl();
			fachada.registrarInformacionNuevoCliente(cliente);

			modelo.addAttribute("mensaje", CatalogoMensajes.ClienteVistaControlador.CLIENTE_REGISTRADO_EXITOSAMENTE);
			modelo.addAttribute("tipoIdentificacion", buscarTipoIdentificacion(cliente.getTipoIdentificacion().getId()));
			modelo.addAttribute("ciudad", buscarCiudad(cliente.getDireccion().getCiudad().getId()));
			return VISTA_CONFIRMACION;
		} catch (InduMatchExcepcion excepcion) {
			// Una regla no se cumplió: se muestra su mensaje en el formulario
			modelo.addAttribute("error", excepcion.getMensajeUsuario());
		} catch (Exception excepcion) {
			modelo.addAttribute("error", CatalogoMensajes.ClienteVistaControlador.PROBLEMA_INESPERADO_REGISTRANDO_CLIENTE);
		}

		// Se vuelve al formulario con los datos que el usuario ya había escrito
		cargarListas(modelo);
		return VISTA_FORMULARIO;
	}

	// Datos para los desplegables
	private void cargarListas(Model modelo) {
		modelo.addAttribute("tiposIdentificacion", new TipoIdentificacionFachadaImpl().consultarTodos());
		modelo.addAttribute("ciudades", new CiudadFachadaImpl().consultarTodos());
	}

	// Para mostrar el nombre (ej: "Cédula") en la confirmación
	private TipoIdentificacionDTO buscarTipoIdentificacion(UUID id) {
		for (var tipo : new TipoIdentificacionFachadaImpl().consultarTodos()) {
			if (tipo.getId().equals(id)) {
				return tipo;
			}
		}
		return new TipoIdentificacionDTO();
	}

	// Para mostrar ciudad, departamento y país en la confirmación
	private CiudadDTO buscarCiudad(UUID id) {
		for (var ciudad : new CiudadFachadaImpl().consultarTodos()) {
			if (ciudad.getId().equals(id)) {
				return ciudad;
			}
		}
		return new CiudadDTO();
	}

}
