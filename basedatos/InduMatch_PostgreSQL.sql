DROP TABLE IF EXISTS envio                 CASCADE;
DROP TABLE IF EXISTS detalle_pedido        CASCADE;
DROP TABLE IF EXISTS pedido                CASCADE;
DROP TABLE IF EXISTS homologacion          CASCADE;
DROP TABLE IF EXISTS producto              CASCADE;
DROP TABLE IF EXISTS marca_comercial       CASCADE;
DROP TABLE IF EXISTS cliente_distribuidor  CASCADE;
DROP TABLE IF EXISTS cliente_natural       CASCADE;
DROP TABLE IF EXISTS cliente               CASCADE;
DROP TABLE IF EXISTS modelo_moto           CASCADE;
DROP TABLE IF EXISTS cilindraje            CASCADE;
DROP TABLE IF EXISTS linea_modelo          CASCADE;
DROP TABLE IF EXISTS direccion             CASCADE;
DROP TABLE IF EXISTS ciudad                CASCADE;
DROP TABLE IF EXISTS departamento          CASCADE;
DROP TABLE IF EXISTS transportadora        CASCADE;
DROP TABLE IF EXISTS estado_pedido         CASCADE;
DROP TABLE IF EXISTS categoria_producto    CASCADE;
DROP TABLE IF EXISTS marca_fabricante      CASCADE;
DROP TABLE IF EXISTS tipo_identificacion   CASCADE;
DROP TABLE IF EXISTS pais                  CASCADE;

CREATE TABLE pais (
    id_pais     UUID         NOT NULL,
    nombre      VARCHAR(50)  NOT NULL,
    codigo      VARCHAR(3)   NOT NULL,
    CONSTRAINT pk_pais PRIMARY KEY (id_pais),
    CONSTRAINT uk_pais_nombre UNIQUE (nombre),
    CONSTRAINT uk_pais_codigo UNIQUE (codigo),
    CONSTRAINT ck_pais_nombre_len CHECK (char_length(nombre) >= 4),
    CONSTRAINT ck_pais_codigo_len CHECK (char_length(codigo) = 3)
);

CREATE TABLE tipo_identificacion (
    id_tipo_identificacion  UUID         NOT NULL,
    nombre                  VARCHAR(30)  NOT NULL,
    CONSTRAINT pk_tipo_identificacion PRIMARY KEY (id_tipo_identificacion),
    CONSTRAINT uk_tipoident_nombre UNIQUE (nombre),
    CONSTRAINT ck_tipoident_nombre_len CHECK (char_length(nombre) >= 3)
);

CREATE TABLE marca_fabricante (
    id_marca_fabricante  UUID         NOT NULL,
    nombre               VARCHAR(50)  NOT NULL,
    CONSTRAINT pk_marca_fabricante PRIMARY KEY (id_marca_fabricante),
    CONSTRAINT uk_marcafabr_nombre UNIQUE (nombre),
    CONSTRAINT ck_marcafabr_nombre_len CHECK (char_length(nombre) >= 2)
);

CREATE TABLE categoria_producto (
    id_categoria_producto  UUID         NOT NULL,
    nombre                 VARCHAR(30)  NOT NULL,
    CONSTRAINT pk_categoria_producto PRIMARY KEY (id_categoria_producto),
    CONSTRAINT uk_categoriaprod_nombre UNIQUE (nombre),
    CONSTRAINT ck_categoriaprod_nombre_len CHECK (char_length(nombre) >= 4)
);

CREATE TABLE estado_pedido (
    id_estado_pedido  UUID         NOT NULL,
    nombre            VARCHAR(20)  NOT NULL,
    CONSTRAINT pk_estado_pedido PRIMARY KEY (id_estado_pedido),
    CONSTRAINT uk_estadopedido_nombre UNIQUE (nombre),
    CONSTRAINT ck_estadopedido_nombre_len CHECK (char_length(nombre) >= 5)
);

CREATE TABLE transportadora (
    id_transportadora  UUID         NOT NULL,
    nombre             VARCHAR(40)  NOT NULL,
    CONSTRAINT pk_transportadora PRIMARY KEY (id_transportadora),
    CONSTRAINT uk_transportadora_nombre UNIQUE (nombre),
    CONSTRAINT ck_transportadora_nombre_len CHECK (char_length(nombre) >= 4)
);

CREATE TABLE departamento (
    id_departamento  UUID         NOT NULL,
    id_pais          UUID         NOT NULL,
    nombre           VARCHAR(40)  NOT NULL,
    CONSTRAINT pk_departamento PRIMARY KEY (id_departamento),
    CONSTRAINT fk_departamento_pais FOREIGN KEY (id_pais)
        REFERENCES pais (id_pais),
    CONSTRAINT uk_departamento_pais_nombre UNIQUE (id_pais, nombre),
    CONSTRAINT ck_departamento_nombre_len CHECK (char_length(nombre) >= 3)
);

CREATE TABLE ciudad (
    id_ciudad        UUID         NOT NULL,
    id_departamento  UUID         NOT NULL,
    nombre           VARCHAR(40)  NOT NULL,
    CONSTRAINT pk_ciudad PRIMARY KEY (id_ciudad),
    CONSTRAINT fk_ciudad_departamento FOREIGN KEY (id_departamento)
        REFERENCES departamento (id_departamento),
    CONSTRAINT uk_ciudad_depto_nombre UNIQUE (id_departamento, nombre),
    CONSTRAINT ck_ciudad_nombre_len CHECK (char_length(nombre) >= 3)
);

CREATE TABLE direccion (
    id_direccion   UUID         NOT NULL,
    id_ciudad      UUID         NOT NULL,
    via_principal  VARCHAR(20)  NOT NULL,
    numero_cruce   VARCHAR(6)   NOT NULL,
    numero_casa    VARCHAR(6)   NOT NULL,
    complemento    VARCHAR(30),
    CONSTRAINT pk_direccion PRIMARY KEY (id_direccion),
    CONSTRAINT fk_direccion_ciudad FOREIGN KEY (id_ciudad)
        REFERENCES ciudad (id_ciudad),
    CONSTRAINT uk_direccion_completa UNIQUE
        (id_ciudad, via_principal, numero_cruce, numero_casa, complemento),
    CONSTRAINT ck_direccion_via_len CHECK (char_length(via_principal) >= 4),
    CONSTRAINT ck_direccion_cruce_len CHECK (char_length(numero_cruce) >= 1),
    CONSTRAINT ck_direccion_casa_len CHECK (char_length(numero_casa) >= 1)
);

CREATE TABLE linea_modelo (
    id_linea_modelo      UUID         NOT NULL,
    id_marca_fabricante  UUID         NOT NULL,
    nombre               VARCHAR(30)  NOT NULL,
    CONSTRAINT pk_linea_modelo PRIMARY KEY (id_linea_modelo),
    CONSTRAINT fk_lineamodelo_marcafabr FOREIGN KEY (id_marca_fabricante)
        REFERENCES marca_fabricante (id_marca_fabricante),
    CONSTRAINT uk_lineamodelo_marca_nombre UNIQUE (id_marca_fabricante, nombre),
    CONSTRAINT ck_lineamodelo_nombre_len CHECK (char_length(nombre) >= 2)
);

CREATE TABLE cilindraje (
    id_cilindraje    UUID     NOT NULL,
    id_linea_modelo  UUID     NOT NULL,
    valor            INTEGER  NOT NULL,
    CONSTRAINT pk_cilindraje PRIMARY KEY (id_cilindraje),
    CONSTRAINT fk_cilindraje_lineamodelo FOREIGN KEY (id_linea_modelo)
        REFERENCES linea_modelo (id_linea_modelo),
    CONSTRAINT uk_cilindraje_linea_valor UNIQUE (id_linea_modelo, valor),
    CONSTRAINT ck_cilindraje_valor_rango CHECK (valor BETWEEN 50 AND 1500)
);

CREATE TABLE modelo_moto (
    id_modelo_moto  UUID  NOT NULL,
    id_cilindraje   UUID  NOT NULL,
    CONSTRAINT pk_modelo_moto PRIMARY KEY (id_modelo_moto),
    CONSTRAINT fk_modelomoto_cilindraje FOREIGN KEY (id_cilindraje)
        REFERENCES cilindraje (id_cilindraje),
    CONSTRAINT uk_modelomoto_cilindraje UNIQUE (id_cilindraje)
);

CREATE TABLE cliente (
    id_cliente              UUID         NOT NULL,
    id_tipo_identificacion  UUID         NOT NULL,
    numero_documento        VARCHAR(15)  NOT NULL,
    telefono                VARCHAR(15)  NOT NULL,
    correo                  VARCHAR(60)  NOT NULL,
    id_direccion            UUID         NOT NULL,
    CONSTRAINT pk_cliente PRIMARY KEY (id_cliente),
    CONSTRAINT fk_cliente_tipoident FOREIGN KEY (id_tipo_identificacion)
        REFERENCES tipo_identificacion (id_tipo_identificacion),
    CONSTRAINT fk_cliente_direccion FOREIGN KEY (id_direccion)
        REFERENCES direccion (id_direccion),
    CONSTRAINT uk_cliente_direccion UNIQUE (id_direccion),
    CONSTRAINT uk_cliente_tipoident_doc UNIQUE (id_tipo_identificacion, numero_documento),
    CONSTRAINT uk_cliente_correo UNIQUE (correo),
    CONSTRAINT uk_cliente_telefono UNIQUE (telefono),
    CONSTRAINT ck_cliente_doc_len CHECK (char_length(numero_documento) >= 5),
    CONSTRAINT ck_cliente_tel_len CHECK (char_length(telefono) >= 7),
    CONSTRAINT ck_cliente_correo_len CHECK (char_length(correo) >= 6),
    CONSTRAINT ck_cliente_correo_formato CHECK (
        correo ~ '^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$'
    )
);

CREATE TABLE cliente_natural (
    id_cliente_natural  UUID         NOT NULL,
    id_cliente          UUID         NOT NULL,
    nombre              VARCHAR(60)  NOT NULL,
    CONSTRAINT pk_cliente_natural PRIMARY KEY (id_cliente_natural),
    CONSTRAINT fk_clientenatural_cliente FOREIGN KEY (id_cliente)
        REFERENCES cliente (id_cliente) ON DELETE CASCADE,
    CONSTRAINT uk_clientenatural_cliente UNIQUE (id_cliente),
    CONSTRAINT ck_clientenatural_nombre_len CHECK (char_length(nombre) >= 3)
);

CREATE TABLE cliente_distribuidor (
    id_cliente_distribuidor  UUID         NOT NULL,
    id_cliente               UUID         NOT NULL,
    razon_social             VARCHAR(80)  NOT NULL,
    nombre_comercial         VARCHAR(60),
    CONSTRAINT pk_cliente_distribuidor PRIMARY KEY (id_cliente_distribuidor),
    CONSTRAINT fk_clientedist_cliente FOREIGN KEY (id_cliente)
        REFERENCES cliente (id_cliente) ON DELETE CASCADE,
    CONSTRAINT uk_clientedist_cliente UNIQUE (id_cliente),
    CONSTRAINT ck_clientedist_razon_len CHECK (char_length(razon_social) >= 3),
    CONSTRAINT ck_clientedist_comercial_len CHECK (
        nombre_comercial IS NULL OR nombre_comercial = '' OR char_length(nombre_comercial) >= 3
    )
);

CREATE TABLE marca_comercial (
    id_marca_comercial       UUID          NOT NULL,
    nombre                   VARCHAR(50)   NOT NULL,
    descripcion              VARCHAR(200),
    id_cliente_distribuidor  UUID          NOT NULL,
    id_marca_madre           UUID          NOT NULL,
    CONSTRAINT pk_marca_comercial PRIMARY KEY (id_marca_comercial),
    CONSTRAINT fk_marcacom_clientedist FOREIGN KEY (id_cliente_distribuidor)
        REFERENCES cliente_distribuidor (id_cliente_distribuidor),
    CONSTRAINT fk_marcacom_madre FOREIGN KEY (id_marca_madre)
        REFERENCES marca_comercial (id_marca_comercial)
        DEFERRABLE INITIALLY DEFERRED,
    CONSTRAINT uk_marcacom_nombre UNIQUE (nombre),
    CONSTRAINT ck_marcacom_nombre_len CHECK (char_length(nombre) >= 2)
);

CREATE TABLE producto (
    id_producto            UUID          NOT NULL,
    referencia             VARCHAR(15)   NOT NULL,
    descripcion            VARCHAR(250)  NOT NULL,
    id_categoria_producto  UUID          NOT NULL,
    id_modelo_moto         UUID,
    id_marca_comercial     UUID          NOT NULL,
    CONSTRAINT pk_producto PRIMARY KEY (id_producto),
    CONSTRAINT fk_producto_categoria FOREIGN KEY (id_categoria_producto)
        REFERENCES categoria_producto (id_categoria_producto),
    CONSTRAINT fk_producto_modelomoto FOREIGN KEY (id_modelo_moto)
        REFERENCES modelo_moto (id_modelo_moto),
    CONSTRAINT fk_producto_marcacom FOREIGN KEY (id_marca_comercial)
        REFERENCES marca_comercial (id_marca_comercial),
    CONSTRAINT uk_producto_referencia UNIQUE (referencia),
    CONSTRAINT ck_producto_ref_len CHECK (char_length(referencia) >= 4),
    CONSTRAINT ck_producto_desc_len CHECK (char_length(descripcion) >= 5)
);

CREATE TABLE homologacion (
    id_homologacion     UUID         NOT NULL,
    id_marca_comercial  UUID         NOT NULL,
    codigo              VARCHAR(20)  NOT NULL,
    id_producto         UUID         NOT NULL,
    CONSTRAINT pk_homologacion PRIMARY KEY (id_homologacion),
    CONSTRAINT fk_homologacion_marcacom FOREIGN KEY (id_marca_comercial)
        REFERENCES marca_comercial (id_marca_comercial),
    CONSTRAINT fk_homologacion_producto FOREIGN KEY (id_producto)
        REFERENCES producto (id_producto),
    CONSTRAINT uk_homologacion_marca_codigo UNIQUE (id_marca_comercial, codigo),
    CONSTRAINT ck_homologacion_codigo_len CHECK (char_length(codigo) >= 3)
);

CREATE TABLE pedido (
    id_pedido         UUID        NOT NULL,
    numero_pedido     VARCHAR(8)  NOT NULL,
    fecha_pedido      DATE        NOT NULL,
    id_cliente        UUID        NOT NULL,
    id_estado_pedido  UUID        NOT NULL,
    CONSTRAINT pk_pedido PRIMARY KEY (id_pedido),
    CONSTRAINT fk_pedido_cliente FOREIGN KEY (id_cliente)
        REFERENCES cliente (id_cliente),
    CONSTRAINT fk_pedido_estadopedido FOREIGN KEY (id_estado_pedido)
        REFERENCES estado_pedido (id_estado_pedido),
    CONSTRAINT uk_pedido_numero UNIQUE (numero_pedido),
    CONSTRAINT ck_pedido_numero_formato CHECK (numero_pedido ~ '^PED-[0-9]{4}$')
);

CREATE TABLE detalle_pedido (
    id_detalle_pedido  UUID     NOT NULL,
    id_pedido          UUID     NOT NULL,
    id_producto        UUID     NOT NULL,
    cantidad           INTEGER  NOT NULL,
    CONSTRAINT pk_detalle_pedido PRIMARY KEY (id_detalle_pedido),
    CONSTRAINT fk_detallepedido_pedido FOREIGN KEY (id_pedido)
        REFERENCES pedido (id_pedido),
    CONSTRAINT fk_detallepedido_producto FOREIGN KEY (id_producto)
        REFERENCES producto (id_producto),
    CONSTRAINT uk_detallepedido_pedido_producto UNIQUE (id_pedido, id_producto),
    CONSTRAINT ck_detallepedido_cantidad_rango CHECK (cantidad BETWEEN 1 AND 100000)
);

CREATE TABLE envio (
    id_envio           UUID         NOT NULL,
    id_pedido          UUID         NOT NULL,
    id_transportadora  UUID         NOT NULL,
    numero_guia        VARCHAR(12)  NOT NULL,
    fecha_despacho     DATE         NOT NULL,
    CONSTRAINT pk_envio PRIMARY KEY (id_envio),
    CONSTRAINT fk_envio_pedido FOREIGN KEY (id_pedido)
        REFERENCES pedido (id_pedido),
    CONSTRAINT fk_envio_transportadora FOREIGN KEY (id_transportadora)
        REFERENCES transportadora (id_transportadora),
    CONSTRAINT uk_envio_transp_guia UNIQUE (id_transportadora, numero_guia),
    CONSTRAINT ck_envio_guia_len CHECK (char_length(numero_guia) >= 10)
);

INSERT INTO tipo_identificacion (id_tipo_identificacion, nombre) VALUES
    (gen_random_uuid(), 'Cédula'),
    (gen_random_uuid(), 'NIT');

INSERT INTO pais (id_pais, nombre, codigo) VALUES
    (gen_random_uuid(), 'Colombia', 'COL');

INSERT INTO departamento (id_departamento, id_pais, nombre)
SELECT gen_random_uuid(), p.id_pais, d.nombre
FROM pais p
CROSS JOIN (VALUES ('Antioquia'), ('Cundinamarca'), ('Atlántico'), ('Caldas'), ('Santander')) AS d (nombre)
WHERE p.nombre = 'Colombia';

INSERT INTO ciudad (id_ciudad, id_departamento, nombre)
SELECT gen_random_uuid(), d.id_departamento, c.ciudad
FROM (VALUES ('Medellín',     'Antioquia'),
             ('Bogotá',       'Cundinamarca'),
             ('Barranquilla', 'Atlántico'),
             ('Manizales',    'Caldas'),
             ('Bucaramanga',  'Santander'),
             ('Marinilla',    'Antioquia')) AS c (ciudad, departamento)
JOIN departamento d ON d.nombre = c.departamento;

SELECT ti.nombre AS tipo_identificacion FROM tipo_identificacion ti ORDER BY ti.nombre;

SELECT c.nombre AS ciudad, d.nombre AS departamento, p.nombre AS pais
FROM ciudad c
JOIN departamento d ON d.id_departamento = c.id_departamento
JOIN pais p ON p.id_pais = d.id_pais
ORDER BY d.nombre, c.nombre;
