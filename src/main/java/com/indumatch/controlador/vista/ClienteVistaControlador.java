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

@Controller
public class ClienteVistaControlador {

	private static final String VISTA_FORMULARIO = "registrar-cliente";
	private static final String VISTA_CONFIRMACION = "cliente-registrado";

	@GetMapping({ "/", "/clientes/registrar" })
	public String mostrarFormulario(Model modelo) {
		modelo.addAttribute("cliente", new ClienteDTO());
		cargarListas(modelo);
		return VISTA_FORMULARIO;
	}

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
			modelo.addAttribute("error", excepcion.getMensajeUsuario());
		} catch (Exception excepcion) {
			modelo.addAttribute("error", CatalogoMensajes.ClienteVistaControlador.PROBLEMA_INESPERADO_REGISTRANDO_CLIENTE);
		}

		cargarListas(modelo);
		return VISTA_FORMULARIO;
	}

	private void cargarListas(Model modelo) {
		modelo.addAttribute("tiposIdentificacion", new TipoIdentificacionFachadaImpl().consultarTodos());
		modelo.addAttribute("ciudades", new CiudadFachadaImpl().consultarTodos());
	}

	private TipoIdentificacionDTO buscarTipoIdentificacion(UUID id) {
		for (var tipo : new TipoIdentificacionFachadaImpl().consultarTodos()) {
			if (tipo.getId().equals(id)) {
				return tipo;
			}
		}
		return new TipoIdentificacionDTO();
	}

	private CiudadDTO buscarCiudad(UUID id) {
		for (var ciudad : new CiudadFachadaImpl().consultarTodos()) {
			if (ciudad.getId().equals(id)) {
				return ciudad;
			}
		}
		return new CiudadDTO();
	}

}
