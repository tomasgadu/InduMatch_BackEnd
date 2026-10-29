package com.indumatch.transversal.catalogo;

public class CatalogoMensajes {
	
	private CatalogoMensajes() {
		
	}
	

	public static class UtilSQL{
		
		private UtilSQL() {
			
		}
		
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información en la cual se iba a tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_TRANSACCION_SQL_ESTA_INICIADA = "Se ha presentado un problema NO CONTROLADO tratando de validar si la conexión contra la fuente de información estaba en un estado consistente al tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción ya fue iniciada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		
		// Mensajes que faltaban:
		
		public static final String USUARIO_ERROR_CONEXION_SQL_NO_ESTA_ABIERTA = "No es posible continuar con la operación deseada, debido a que la conexión contra la fuente de información no se encuentra abierta, ya sea porque está cerrada o porque está vacía. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "No es posible confirmar los cambios de la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "No es posible deshacer los cambios de la operación deseada, debido a que la conexión contra la fuente de información se encuentra en un estado inconsistente porque está cerrada, está vacía o porque la transacción no fue iniciada previamente. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "No es posible finalizar de manera adecuada la operación deseada, debido a que la conexión contra la fuente de información que se intentó cerrar ya se encuentra cerrada o está vacía. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		
		// Mensajes de la conexión:
		
		public static final String USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de iniciar la transacción contra la fuente de información en la cual se iba a llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_INICIANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de iniciar la transacción contra la fuente de información en la cual se iba a llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de confirmar los cambios de la operación deseada en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONFIRMANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de confirmar los cambios de la operación deseada en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL = "Se ha presentado un problema tratando de deshacer los cambios de la operación deseada en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CANCELANDO_TRANSACCION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de deshacer los cambios de la operación deseada en la fuente de información. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL = "Se ha presentado un problema tratando de cerrar la conexión contra la fuente de información luego de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CERRANDO_CONEXION_SQL = "Se ha presentado un problema NO CONTROLADO tratando de cerrar la conexión contra la fuente de información luego de llevar a cabo la operación deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicación y reporte la novedad...";
	
	}
	
	public static class ClienteNegocioImpl {
		
		private ClienteNegocioImpl() {
			
		}
		
		// CLI-P-0001: datos válidos
		public static final String TIPO_IDENTIFICACION_CLIENTE_OBLIGATORIO = "El tipo de identificación del cliente es obligatorio para llevar a cabo la operación deseada.";
		public static final String NUMERO_DOCUMENTO_CLIENTE_OBLIGATORIO = "El número de documento del cliente es obligatorio para llevar a cabo la operación deseada.";
		public static final String FORMATO_NUMERO_DOCUMENTO_CLIENTE_NO_VALIDO = "El formato del número de documento no es válido. Asegúrese de que solamente tenga letras y números, sin espacios ni caracteres especiales.";
		public static final String LONGITUD_NUMERO_DOCUMENTO_CLIENTE_NO_VALIDA = "La longitud del número de documento no es válida. Asegúrese que esté entre 5 y 15 caracteres.";
		public static final String TELEFONO_CLIENTE_OBLIGATORIO = "El teléfono del cliente es obligatorio para llevar a cabo la operación deseada.";
		public static final String FORMATO_TELEFONO_CLIENTE_NO_VALIDO = "El formato del teléfono no es válido. Asegúrese de que solamente tenga letras y números, sin espacios ni caracteres especiales.";
		public static final String LONGITUD_TELEFONO_CLIENTE_NO_VALIDA = "La longitud del teléfono no es válida. Asegúrese que esté entre 7 y 15 caracteres.";
		public static final String CORREO_CLIENTE_OBLIGATORIO = "El correo electrónico del cliente es obligatorio para llevar a cabo la operación deseada.";
		public static final String FORMATO_CORREO_CLIENTE_NO_VALIDO = "El correo electrónico no tiene un formato válido. Asegúrese de que tenga la forma usuario@dominio.com";
		public static final String LONGITUD_CORREO_CLIENTE_NO_VALIDA = "La longitud del correo electrónico no es válida. Asegúrese que esté entre 6 y 60 caracteres.";
		
		// CLI-P-0003: tipo de identificación exista
		public static final String TIPO_IDENTIFICACION_CLIENTE_NO_EXISTE = "El tipo de identificación indicado para el cliente no existe.";
		
		// CLI-P-0004, CLI-P-0005, CLI-P-0006: datos únicos
		public static final String CLIENTE_EXISTE_CON_MISMO_TIPO_Y_NUMERO_DOCUMENTO = "Ya existe otro cliente registrado con el mismo tipo de identificación y número de documento.";
		public static final String CLIENTE_EXISTE_CON_MISMO_CORREO = "Ya existe otro cliente registrado con el mismo correo electrónico.";
		public static final String CLIENTE_EXISTE_CON_MISMO_TELEFONO = "Ya existe otro cliente registrado con el mismo número de teléfono.";
		
	}
	
	public static class DireccionNegocioImpl {
		
		private DireccionNegocioImpl() {
			
		}
		
		// DIR-P-0001 / DIR-P-0002: datos válidos y sanitizados
		public static final String CIUDAD_DIRECCION_OBLIGATORIA = "La ciudad de la dirección es obligatoria para llevar a cabo la operación deseada.";
		public static final String VIA_PRINCIPAL_DIRECCION_OBLIGATORIA = "La vía principal de la dirección es obligatoria para llevar a cabo la operación deseada.";
		public static final String FORMATO_VIA_PRINCIPAL_DIRECCION_NO_VALIDO = "El formato de la vía principal no es válido. Asegúrese de que solamente tenga letras, números y espacios.";
		public static final String LONGITUD_VIA_PRINCIPAL_DIRECCION_NO_VALIDA = "La longitud de la vía principal no es válida. Asegúrese que esté entre 4 y 20 caracteres.";
		public static final String NUMERO_CRUCE_DIRECCION_OBLIGATORIO = "El número de cruce de la dirección es obligatorio para llevar a cabo la operación deseada.";
		public static final String FORMATO_NUMERO_CRUCE_DIRECCION_NO_VALIDO = "El formato del número de cruce no es válido. Asegúrese de que solamente tenga letras y números.";
		public static final String LONGITUD_NUMERO_CRUCE_DIRECCION_NO_VALIDA = "La longitud del número de cruce no es válida. Asegúrese que esté entre 1 y 6 caracteres.";
		public static final String NUMERO_CASA_DIRECCION_OBLIGATORIO = "El número de casa de la dirección es obligatorio para llevar a cabo la operación deseada.";
		public static final String FORMATO_NUMERO_CASA_DIRECCION_NO_VALIDO = "El formato del número de casa no es válido. Asegúrese de que solamente tenga letras y números.";
		public static final String LONGITUD_NUMERO_CASA_DIRECCION_NO_VALIDA = "La longitud del número de casa no es válida. Asegúrese que esté entre 1 y 6 caracteres.";
		public static final String FORMATO_COMPLEMENTO_DIRECCION_NO_VALIDO = "El formato del complemento no es válido. Asegúrese de que solamente tenga letras, números y espacios.";
		public static final String LONGITUD_COMPLEMENTO_DIRECCION_NO_VALIDA = "La longitud del complemento no es válida. Asegúrese que no supere los 30 caracteres.";
		
		// DIR-P-0004: ciudad exista
		public static final String CIUDAD_DIRECCION_NO_EXISTE = "La ciudad indicada para la dirección no existe.";
		
		// DIR-P-0005: dirección única
		public static final String DIRECCION_EXISTE_CON_MISMOS_DATOS = "Ya existe otra dirección registrada con la misma vía principal, número de cruce, número de casa, complemento y ciudad.";
		
	}
	
}
