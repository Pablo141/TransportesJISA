PGDMP                         y           TransportesJISA    13.2    13.2 ?    u           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            v           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            w           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            x           1262    16470    TransportesJISA    DATABASE     m   CREATE DATABASE "TransportesJISA" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Spain.1252';
 !   DROP DATABASE "TransportesJISA";
                postgres    false            ?            1259    16684    alumnos    TABLE     ?   CREATE TABLE public.alumnos (
    id_alumno integer NOT NULL,
    nombre character varying(30) NOT NULL,
    edad integer NOT NULL,
    cumpleanos date,
    id_salon integer NOT NULL,
    id_escuela integer
);
    DROP TABLE public.alumnos;
       public         heap    postgres    false            ?            1259    16682    alumnos_id_alumno_seq    SEQUENCE     ?   CREATE SEQUENCE public.alumnos_id_alumno_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.alumnos_id_alumno_seq;
       public          postgres    false    219            y           0    0    alumnos_id_alumno_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.alumnos_id_alumno_seq OWNED BY public.alumnos.id_alumno;
          public          postgres    false    218            ?            1259    16515    capacidades    TABLE     _   CREATE TABLE public.capacidades (
    id_c integer NOT NULL,
    capacidad integer NOT NULL
);
    DROP TABLE public.capacidades;
       public         heap    postgres    false            ?            1259    16513    capacidades_id_c_seq    SEQUENCE     ?   CREATE SEQUENCE public.capacidades_id_c_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.capacidades_id_c_seq;
       public          postgres    false    207            z           0    0    capacidades_id_c_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.capacidades_id_c_seq OWNED BY public.capacidades.id_c;
          public          postgres    false    206            ?            1259    16721    e_gastos    TABLE     ?   CREATE TABLE public.e_gastos (
    id_gasto integer NOT NULL,
    fecha date,
    gasto_total numeric NOT NULL,
    facturado boolean,
    id_tipog integer,
    id_proveedor integer
);
    DROP TABLE public.e_gastos;
       public         heap    postgres    false            ?            1259    16719    e_gastos_id_gasto_seq    SEQUENCE     ?   CREATE SEQUENCE public.e_gastos_id_gasto_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.e_gastos_id_gasto_seq;
       public          postgres    false    223            {           0    0    e_gastos_id_gasto_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.e_gastos_id_gasto_seq OWNED BY public.e_gastos.id_gasto;
          public          postgres    false    222            ?            1259    16783    empresas    TABLE     ?   CREATE TABLE public.empresas (
    ide character(4) NOT NULL,
    nombre character varying(30),
    dom character varying(30),
    giro character varying(20)
);
    DROP TABLE public.empresas;
       public         heap    postgres    false            ?            1259    16697    escuelas    TABLE     n   CREATE TABLE public.escuelas (
    id_escuela integer NOT NULL,
    escuela character varying(50) NOT NULL
);
    DROP TABLE public.escuelas;
       public         heap    postgres    false            ?            1259    16695    escuelas_id_escuela_seq    SEQUENCE     ?   CREATE SEQUENCE public.escuelas_id_escuela_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.escuelas_id_escuela_seq;
       public          postgres    false    221            |           0    0    escuelas_id_escuela_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.escuelas_id_escuela_seq OWNED BY public.escuelas.id_escuela;
          public          postgres    false    220            ?            1259    16755    mantenimientosyreparaciones    TABLE     ?   CREATE TABLE public.mantenimientosyreparaciones (
    id_myr integer NOT NULL,
    id_vehiculo integer,
    mor character varying(50) NOT NULL,
    id_proveedor integer,
    reporte character varying(150),
    costo numeric,
    fecha date
);
 /   DROP TABLE public.mantenimientosyreparaciones;
       public         heap    postgres    false            ?            1259    16753 &   mantenimientosyreparaciones_id_myr_seq    SEQUENCE     ?   CREATE SEQUENCE public.mantenimientosyreparaciones_id_myr_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.mantenimientosyreparaciones_id_myr_seq;
       public          postgres    false    227            }           0    0 &   mantenimientosyreparaciones_id_myr_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.mantenimientosyreparaciones_id_myr_seq OWNED BY public.mantenimientosyreparaciones.id_myr;
          public          postgres    false    226            ?            1259    16505    marcas    TABLE     h   CREATE TABLE public.marcas (
    id_marca integer NOT NULL,
    marca character varying(15) NOT NULL
);
    DROP TABLE public.marcas;
       public         heap    postgres    false            ?            1259    16503    marcas_id_marca_seq    SEQUENCE     ?   CREATE SEQUENCE public.marcas_id_marca_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.marcas_id_marca_seq;
       public          postgres    false    205            ~           0    0    marcas_id_marca_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.marcas_id_marca_seq OWNED BY public.marcas.id_marca;
          public          postgres    false    204            ?            1259    16485    modelos    TABLE     e   CREATE TABLE public.modelos (
    id_m integer NOT NULL,
    modelo character varying(4) NOT NULL
);
    DROP TABLE public.modelos;
       public         heap    postgres    false            ?            1259    16483    modelos_id_m_seq    SEQUENCE     ?   CREATE SEQUENCE public.modelos_id_m_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 '   DROP SEQUENCE public.modelos_id_m_seq;
       public          postgres    false    201                       0    0    modelos_id_m_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE public.modelos_id_m_seq OWNED BY public.modelos.id_m;
          public          postgres    false    200            ?            1259    16614    proveedores    TABLE     ?   CREATE TABLE public.proveedores (
    id_p integer NOT NULL,
    nombre character varying(30) NOT NULL,
    numerotel character varying(12) NOT NULL,
    id_tipo integer NOT NULL
);
    DROP TABLE public.proveedores;
       public         heap    postgres    false            ?            1259    16742    proveedores_agentes    TABLE        CREATE TABLE public.proveedores_agentes (
    id_agente integer NOT NULL,
    id_proveedor integer NOT NULL,
    nombre_agente character varying(25),
    telefono_a character varying(12),
    email character varying(50),
    cargo character varying(50)
);
 '   DROP TABLE public.proveedores_agentes;
       public         heap    postgres    false            ?            1259    16740 !   proveedores_agentes_id_agente_seq    SEQUENCE     ?   CREATE SEQUENCE public.proveedores_agentes_id_agente_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.proveedores_agentes_id_agente_seq;
       public          postgres    false    225            ?           0    0 !   proveedores_agentes_id_agente_seq    SEQUENCE OWNED BY     g   ALTER SEQUENCE public.proveedores_agentes_id_agente_seq OWNED BY public.proveedores_agentes.id_agente;
          public          postgres    false    224            ?            1259    16612    proveedores_id_p_seq    SEQUENCE     ?   CREATE SEQUENCE public.proveedores_id_p_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.proveedores_id_p_seq;
       public          postgres    false    213            ?           0    0    proveedores_id_p_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.proveedores_id_p_seq OWNED BY public.proveedores.id_p;
          public          postgres    false    212            ?            1259    16788    registro    TABLE     ?   CREATE TABLE public.registro (
    idr character(4) NOT NULL,
    ide character(4) NOT NULL,
    fechareg date,
    periodo integer,
    capital integer
);
    DROP TABLE public.registro;
       public         heap    postgres    false            ?            1259    16776 	   registros    TABLE     v   CREATE TABLE public.registros (
    id_registro integer NOT NULL,
    nombre character varying(30),
    fecha date
);
    DROP TABLE public.registros;
       public         heap    postgres    false            ?            1259    16774    registros_id_registro_seq    SEQUENCE     ?   CREATE SEQUENCE public.registros_id_registro_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.registros_id_registro_seq;
       public          postgres    false    229            ?           0    0    registros_id_registro_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.registros_id_registro_seq OWNED BY public.registros.id_registro;
          public          postgres    false    228            ?            1259    16660    salones    TABLE     h   CREATE TABLE public.salones (
    id_salon integer NOT NULL,
    salon character varying(1) NOT NULL
);
    DROP TABLE public.salones;
       public         heap    postgres    false            ?            1259    16658    salones_id_salon_seq    SEQUENCE     ?   CREATE SEQUENCE public.salones_id_salon_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.salones_id_salon_seq;
       public          postgres    false    217            ?           0    0    salones_id_salon_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.salones_id_salon_seq OWNED BY public.salones.id_salon;
          public          postgres    false    216            ?            1259    16495    t_cilindros    TABLE     l   CREATE TABLE public.t_cilindros (
    id_c integer NOT NULL,
    cilindros character varying(2) NOT NULL
);
    DROP TABLE public.t_cilindros;
       public         heap    postgres    false            ?            1259    16493    t_cilindros_id_c_seq    SEQUENCE     ?   CREATE SEQUENCE public.t_cilindros_id_c_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 +   DROP SEQUENCE public.t_cilindros_id_c_seq;
       public          postgres    false    203            ?           0    0    t_cilindros_id_c_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE public.t_cilindros_id_c_seq OWNED BY public.t_cilindros.id_c;
          public          postgres    false    202            ?            1259    16631    tipo_gastos    TABLE     o   CREATE TABLE public.tipo_gastos (
    id_tg integer NOT NULL,
    tipo_gasto character varying(30) NOT NULL
);
    DROP TABLE public.tipo_gastos;
       public         heap    postgres    false            ?            1259    16629    tipo_gastos_id_tg_seq    SEQUENCE     ?   CREATE SEQUENCE public.tipo_gastos_id_tg_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.tipo_gastos_id_tg_seq;
       public          postgres    false    215            ?           0    0    tipo_gastos_id_tg_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.tipo_gastos_id_tg_seq OWNED BY public.tipo_gastos.id_tg;
          public          postgres    false    214            ?            1259    16604    tipo_soc    TABLE     e   CREATE TABLE public.tipo_soc (
    id_t integer NOT NULL,
    tipo character varying(25) NOT NULL
);
    DROP TABLE public.tipo_soc;
       public         heap    postgres    false            ?            1259    16602    tipo_soc_id_t_seq    SEQUENCE     ?   CREATE SEQUENCE public.tipo_soc_id_t_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.tipo_soc_id_t_seq;
       public          postgres    false    211            ?           0    0    tipo_soc_id_t_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.tipo_soc_id_t_seq OWNED BY public.tipo_soc.id_t;
          public          postgres    false    210            ?            1259    16572 	   vehiculos    TABLE     H  CREATE TABLE public.vehiculos (
    id_vehiculo integer NOT NULL,
    nombre_vehiculo character varying(50) NOT NULL,
    placas character varying(10),
    num_serie character varying(18) NOT NULL,
    kmxl character varying(2),
    id_modelo integer,
    id_cilindros integer,
    id_marca integer,
    id_capacidad integer
);
    DROP TABLE public.vehiculos;
       public         heap    postgres    false            ?            1259    16570    vehiculos_id_vehiculo_seq    SEQUENCE     ?   CREATE SEQUENCE public.vehiculos_id_vehiculo_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.vehiculos_id_vehiculo_seq;
       public          postgres    false    209            ?           0    0    vehiculos_id_vehiculo_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.vehiculos_id_vehiculo_seq OWNED BY public.vehiculos.id_vehiculo;
          public          postgres    false    208            ?           2604    16687    alumnos id_alumno    DEFAULT     v   ALTER TABLE ONLY public.alumnos ALTER COLUMN id_alumno SET DEFAULT nextval('public.alumnos_id_alumno_seq'::regclass);
 @   ALTER TABLE public.alumnos ALTER COLUMN id_alumno DROP DEFAULT;
       public          postgres    false    218    219    219            ?           2604    16518    capacidades id_c    DEFAULT     t   ALTER TABLE ONLY public.capacidades ALTER COLUMN id_c SET DEFAULT nextval('public.capacidades_id_c_seq'::regclass);
 ?   ALTER TABLE public.capacidades ALTER COLUMN id_c DROP DEFAULT;
       public          postgres    false    207    206    207            ?           2604    16724    e_gastos id_gasto    DEFAULT     v   ALTER TABLE ONLY public.e_gastos ALTER COLUMN id_gasto SET DEFAULT nextval('public.e_gastos_id_gasto_seq'::regclass);
 @   ALTER TABLE public.e_gastos ALTER COLUMN id_gasto DROP DEFAULT;
       public          postgres    false    222    223    223            ?           2604    16700    escuelas id_escuela    DEFAULT     z   ALTER TABLE ONLY public.escuelas ALTER COLUMN id_escuela SET DEFAULT nextval('public.escuelas_id_escuela_seq'::regclass);
 B   ALTER TABLE public.escuelas ALTER COLUMN id_escuela DROP DEFAULT;
       public          postgres    false    220    221    221            ?           2604    16758 "   mantenimientosyreparaciones id_myr    DEFAULT     ?   ALTER TABLE ONLY public.mantenimientosyreparaciones ALTER COLUMN id_myr SET DEFAULT nextval('public.mantenimientosyreparaciones_id_myr_seq'::regclass);
 Q   ALTER TABLE public.mantenimientosyreparaciones ALTER COLUMN id_myr DROP DEFAULT;
       public          postgres    false    227    226    227            ?           2604    16508    marcas id_marca    DEFAULT     r   ALTER TABLE ONLY public.marcas ALTER COLUMN id_marca SET DEFAULT nextval('public.marcas_id_marca_seq'::regclass);
 >   ALTER TABLE public.marcas ALTER COLUMN id_marca DROP DEFAULT;
       public          postgres    false    204    205    205            ?           2604    16488    modelos id_m    DEFAULT     l   ALTER TABLE ONLY public.modelos ALTER COLUMN id_m SET DEFAULT nextval('public.modelos_id_m_seq'::regclass);
 ;   ALTER TABLE public.modelos ALTER COLUMN id_m DROP DEFAULT;
       public          postgres    false    200    201    201            ?           2604    16617    proveedores id_p    DEFAULT     t   ALTER TABLE ONLY public.proveedores ALTER COLUMN id_p SET DEFAULT nextval('public.proveedores_id_p_seq'::regclass);
 ?   ALTER TABLE public.proveedores ALTER COLUMN id_p DROP DEFAULT;
       public          postgres    false    212    213    213            ?           2604    16745    proveedores_agentes id_agente    DEFAULT     ?   ALTER TABLE ONLY public.proveedores_agentes ALTER COLUMN id_agente SET DEFAULT nextval('public.proveedores_agentes_id_agente_seq'::regclass);
 L   ALTER TABLE public.proveedores_agentes ALTER COLUMN id_agente DROP DEFAULT;
       public          postgres    false    225    224    225            ?           2604    16779    registros id_registro    DEFAULT     ~   ALTER TABLE ONLY public.registros ALTER COLUMN id_registro SET DEFAULT nextval('public.registros_id_registro_seq'::regclass);
 D   ALTER TABLE public.registros ALTER COLUMN id_registro DROP DEFAULT;
       public          postgres    false    229    228    229            ?           2604    16663    salones id_salon    DEFAULT     t   ALTER TABLE ONLY public.salones ALTER COLUMN id_salon SET DEFAULT nextval('public.salones_id_salon_seq'::regclass);
 ?   ALTER TABLE public.salones ALTER COLUMN id_salon DROP DEFAULT;
       public          postgres    false    216    217    217            ?           2604    16498    t_cilindros id_c    DEFAULT     t   ALTER TABLE ONLY public.t_cilindros ALTER COLUMN id_c SET DEFAULT nextval('public.t_cilindros_id_c_seq'::regclass);
 ?   ALTER TABLE public.t_cilindros ALTER COLUMN id_c DROP DEFAULT;
       public          postgres    false    202    203    203            ?           2604    16634    tipo_gastos id_tg    DEFAULT     v   ALTER TABLE ONLY public.tipo_gastos ALTER COLUMN id_tg SET DEFAULT nextval('public.tipo_gastos_id_tg_seq'::regclass);
 @   ALTER TABLE public.tipo_gastos ALTER COLUMN id_tg DROP DEFAULT;
       public          postgres    false    215    214    215            ?           2604    16607    tipo_soc id_t    DEFAULT     n   ALTER TABLE ONLY public.tipo_soc ALTER COLUMN id_t SET DEFAULT nextval('public.tipo_soc_id_t_seq'::regclass);
 <   ALTER TABLE public.tipo_soc ALTER COLUMN id_t DROP DEFAULT;
       public          postgres    false    211    210    211            ?           2604    16575    vehiculos id_vehiculo    DEFAULT     ~   ALTER TABLE ONLY public.vehiculos ALTER COLUMN id_vehiculo SET DEFAULT nextval('public.vehiculos_id_vehiculo_seq'::regclass);
 D   ALTER TABLE public.vehiculos ALTER COLUMN id_vehiculo DROP DEFAULT;
       public          postgres    false    209    208    209            f          0    16684    alumnos 
   TABLE DATA           \   COPY public.alumnos (id_alumno, nombre, edad, cumpleanos, id_salon, id_escuela) FROM stdin;
    public          postgres    false    219   ??       Z          0    16515    capacidades 
   TABLE DATA           6   COPY public.capacidades (id_c, capacidad) FROM stdin;
    public          postgres    false    207   ?       j          0    16721    e_gastos 
   TABLE DATA           c   COPY public.e_gastos (id_gasto, fecha, gasto_total, facturado, id_tipog, id_proveedor) FROM stdin;
    public          postgres    false    223   E?       q          0    16783    empresas 
   TABLE DATA           :   COPY public.empresas (ide, nombre, dom, giro) FROM stdin;
    public          postgres    false    230   ??       h          0    16697    escuelas 
   TABLE DATA           7   COPY public.escuelas (id_escuela, escuela) FROM stdin;
    public          postgres    false    221   ?       n          0    16755    mantenimientosyreparaciones 
   TABLE DATA           t   COPY public.mantenimientosyreparaciones (id_myr, id_vehiculo, mor, id_proveedor, reporte, costo, fecha) FROM stdin;
    public          postgres    false    227   e?       X          0    16505    marcas 
   TABLE DATA           1   COPY public.marcas (id_marca, marca) FROM stdin;
    public          postgres    false    205   ɣ       T          0    16485    modelos 
   TABLE DATA           /   COPY public.modelos (id_m, modelo) FROM stdin;
    public          postgres    false    201   ?       `          0    16614    proveedores 
   TABLE DATA           G   COPY public.proveedores (id_p, nombre, numerotel, id_tipo) FROM stdin;
    public          postgres    false    213   ;?       l          0    16742    proveedores_agentes 
   TABLE DATA           o   COPY public.proveedores_agentes (id_agente, id_proveedor, nombre_agente, telefono_a, email, cargo) FROM stdin;
    public          postgres    false    225   ??       r          0    16788    registro 
   TABLE DATA           H   COPY public.registro (idr, ide, fechareg, periodo, capital) FROM stdin;
    public          postgres    false    231   6?       p          0    16776 	   registros 
   TABLE DATA           ?   COPY public.registros (id_registro, nombre, fecha) FROM stdin;
    public          postgres    false    229   ??       d          0    16660    salones 
   TABLE DATA           2   COPY public.salones (id_salon, salon) FROM stdin;
    public          postgres    false    217   ͥ       V          0    16495    t_cilindros 
   TABLE DATA           6   COPY public.t_cilindros (id_c, cilindros) FROM stdin;
    public          postgres    false    203   ??       b          0    16631    tipo_gastos 
   TABLE DATA           8   COPY public.tipo_gastos (id_tg, tipo_gasto) FROM stdin;
    public          postgres    false    215   ?       ^          0    16604    tipo_soc 
   TABLE DATA           .   COPY public.tipo_soc (id_t, tipo) FROM stdin;
    public          postgres    false    211   S?       \          0    16572 	   vehiculos 
   TABLE DATA           ?   COPY public.vehiculos (id_vehiculo, nombre_vehiculo, placas, num_serie, kmxl, id_modelo, id_cilindros, id_marca, id_capacidad) FROM stdin;
    public          postgres    false    209   ??       ?           0    0    alumnos_id_alumno_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.alumnos_id_alumno_seq', 4, true);
          public          postgres    false    218            ?           0    0    capacidades_id_c_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.capacidades_id_c_seq', 1, false);
          public          postgres    false    206            ?           0    0    e_gastos_id_gasto_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.e_gastos_id_gasto_seq', 8, true);
          public          postgres    false    222            ?           0    0    escuelas_id_escuela_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.escuelas_id_escuela_seq', 3, true);
          public          postgres    false    220            ?           0    0 &   mantenimientosyreparaciones_id_myr_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.mantenimientosyreparaciones_id_myr_seq', 18, true);
          public          postgres    false    226            ?           0    0    marcas_id_marca_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.marcas_id_marca_seq', 1, false);
          public          postgres    false    204            ?           0    0    modelos_id_m_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.modelos_id_m_seq', 1, false);
          public          postgres    false    200            ?           0    0 !   proveedores_agentes_id_agente_seq    SEQUENCE SET     O   SELECT pg_catalog.setval('public.proveedores_agentes_id_agente_seq', 5, true);
          public          postgres    false    224            ?           0    0    proveedores_id_p_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.proveedores_id_p_seq', 18, true);
          public          postgres    false    212            ?           0    0    registros_id_registro_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.registros_id_registro_seq', 3, true);
          public          postgres    false    228            ?           0    0    salones_id_salon_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('public.salones_id_salon_seq', 2, true);
          public          postgres    false    216            ?           0    0    t_cilindros_id_c_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.t_cilindros_id_c_seq', 1, false);
          public          postgres    false    202            ?           0    0    tipo_gastos_id_tg_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.tipo_gastos_id_tg_seq', 5, true);
          public          postgres    false    214            ?           0    0    tipo_soc_id_t_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.tipo_soc_id_t_seq', 10, true);
          public          postgres    false    210            ?           0    0    vehiculos_id_vehiculo_seq    SEQUENCE SET     H   SELECT pg_catalog.setval('public.vehiculos_id_vehiculo_seq', 1, false);
          public          postgres    false    208            ?           2606    16689    alumnos alumnos_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_pkey PRIMARY KEY (id_alumno);
 >   ALTER TABLE ONLY public.alumnos DROP CONSTRAINT alumnos_pkey;
       public            postgres    false    219            ?           2606    16522 %   capacidades capacidades_capacidad_key 
   CONSTRAINT     e   ALTER TABLE ONLY public.capacidades
    ADD CONSTRAINT capacidades_capacidad_key UNIQUE (capacidad);
 O   ALTER TABLE ONLY public.capacidades DROP CONSTRAINT capacidades_capacidad_key;
       public            postgres    false    207            ?           2606    16520    capacidades capacidades_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.capacidades
    ADD CONSTRAINT capacidades_pkey PRIMARY KEY (id_c);
 F   ALTER TABLE ONLY public.capacidades DROP CONSTRAINT capacidades_pkey;
       public            postgres    false    207            ?           2606    16729    e_gastos e_gastos_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.e_gastos
    ADD CONSTRAINT e_gastos_pkey PRIMARY KEY (id_gasto);
 @   ALTER TABLE ONLY public.e_gastos DROP CONSTRAINT e_gastos_pkey;
       public            postgres    false    223            ?           2606    16787    empresas empresas_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.empresas
    ADD CONSTRAINT empresas_pkey PRIMARY KEY (ide);
 @   ALTER TABLE ONLY public.empresas DROP CONSTRAINT empresas_pkey;
       public            postgres    false    230            ?           2606    16702    escuelas escuelas_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.escuelas
    ADD CONSTRAINT escuelas_pkey PRIMARY KEY (id_escuela);
 @   ALTER TABLE ONLY public.escuelas DROP CONSTRAINT escuelas_pkey;
       public            postgres    false    221            ?           2606    16763 <   mantenimientosyreparaciones mantenimientosyreparaciones_pkey 
   CONSTRAINT     ~   ALTER TABLE ONLY public.mantenimientosyreparaciones
    ADD CONSTRAINT mantenimientosyreparaciones_pkey PRIMARY KEY (id_myr);
 f   ALTER TABLE ONLY public.mantenimientosyreparaciones DROP CONSTRAINT mantenimientosyreparaciones_pkey;
       public            postgres    false    227            ?           2606    16512    marcas marcas_marca_key 
   CONSTRAINT     S   ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT marcas_marca_key UNIQUE (marca);
 A   ALTER TABLE ONLY public.marcas DROP CONSTRAINT marcas_marca_key;
       public            postgres    false    205            ?           2606    16510    marcas marcas_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.marcas
    ADD CONSTRAINT marcas_pkey PRIMARY KEY (id_marca);
 <   ALTER TABLE ONLY public.marcas DROP CONSTRAINT marcas_pkey;
       public            postgres    false    205            ?           2606    16492    modelos modelos_modelo_key 
   CONSTRAINT     W   ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT modelos_modelo_key UNIQUE (modelo);
 D   ALTER TABLE ONLY public.modelos DROP CONSTRAINT modelos_modelo_key;
       public            postgres    false    201            ?           2606    16490    modelos modelos_pkey 
   CONSTRAINT     T   ALTER TABLE ONLY public.modelos
    ADD CONSTRAINT modelos_pkey PRIMARY KEY (id_m);
 >   ALTER TABLE ONLY public.modelos DROP CONSTRAINT modelos_pkey;
       public            postgres    false    201            ?           2606    16747 ,   proveedores_agentes proveedores_agentes_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY public.proveedores_agentes
    ADD CONSTRAINT proveedores_agentes_pkey PRIMARY KEY (id_agente);
 V   ALTER TABLE ONLY public.proveedores_agentes DROP CONSTRAINT proveedores_agentes_pkey;
       public            postgres    false    225            ?           2606    16621 "   proveedores proveedores_nombre_key 
   CONSTRAINT     _   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_nombre_key UNIQUE (nombre);
 L   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_nombre_key;
       public            postgres    false    213            ?           2606    16623 %   proveedores proveedores_numerotel_key 
   CONSTRAINT     e   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_numerotel_key UNIQUE (numerotel);
 O   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_numerotel_key;
       public            postgres    false    213            ?           2606    16619    proveedores proveedores_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_pkey PRIMARY KEY (id_p);
 F   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_pkey;
       public            postgres    false    213            ?           2606    16792    registro registro_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.registro
    ADD CONSTRAINT registro_pkey PRIMARY KEY (idr);
 @   ALTER TABLE ONLY public.registro DROP CONSTRAINT registro_pkey;
       public            postgres    false    231            ?           2606    16781    registros registros_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.registros
    ADD CONSTRAINT registros_pkey PRIMARY KEY (id_registro);
 B   ALTER TABLE ONLY public.registros DROP CONSTRAINT registros_pkey;
       public            postgres    false    229            ?           2606    16665    salones salones_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.salones
    ADD CONSTRAINT salones_pkey PRIMARY KEY (id_salon);
 >   ALTER TABLE ONLY public.salones DROP CONSTRAINT salones_pkey;
       public            postgres    false    217            ?           2606    16502 %   t_cilindros t_cilindros_cilindros_key 
   CONSTRAINT     e   ALTER TABLE ONLY public.t_cilindros
    ADD CONSTRAINT t_cilindros_cilindros_key UNIQUE (cilindros);
 O   ALTER TABLE ONLY public.t_cilindros DROP CONSTRAINT t_cilindros_cilindros_key;
       public            postgres    false    203            ?           2606    16500    t_cilindros t_cilindros_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.t_cilindros
    ADD CONSTRAINT t_cilindros_pkey PRIMARY KEY (id_c);
 F   ALTER TABLE ONLY public.t_cilindros DROP CONSTRAINT t_cilindros_pkey;
       public            postgres    false    203            ?           2606    16636    tipo_gastos tipo_gastos_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.tipo_gastos
    ADD CONSTRAINT tipo_gastos_pkey PRIMARY KEY (id_tg);
 F   ALTER TABLE ONLY public.tipo_gastos DROP CONSTRAINT tipo_gastos_pkey;
       public            postgres    false    215            ?           2606    16638 &   tipo_gastos tipo_gastos_tipo_gasto_key 
   CONSTRAINT     g   ALTER TABLE ONLY public.tipo_gastos
    ADD CONSTRAINT tipo_gastos_tipo_gasto_key UNIQUE (tipo_gasto);
 P   ALTER TABLE ONLY public.tipo_gastos DROP CONSTRAINT tipo_gastos_tipo_gasto_key;
       public            postgres    false    215            ?           2606    16609    tipo_soc tipo_soc_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.tipo_soc
    ADD CONSTRAINT tipo_soc_pkey PRIMARY KEY (id_t);
 @   ALTER TABLE ONLY public.tipo_soc DROP CONSTRAINT tipo_soc_pkey;
       public            postgres    false    211            ?           2606    16611    tipo_soc tipo_soc_tipo_key 
   CONSTRAINT     U   ALTER TABLE ONLY public.tipo_soc
    ADD CONSTRAINT tipo_soc_tipo_key UNIQUE (tipo);
 D   ALTER TABLE ONLY public.tipo_soc DROP CONSTRAINT tipo_soc_tipo_key;
       public            postgres    false    211            ?           2606    16579 '   vehiculos vehiculos_nombre_vehiculo_key 
   CONSTRAINT     m   ALTER TABLE ONLY public.vehiculos
    ADD CONSTRAINT vehiculos_nombre_vehiculo_key UNIQUE (nombre_vehiculo);
 Q   ALTER TABLE ONLY public.vehiculos DROP CONSTRAINT vehiculos_nombre_vehiculo_key;
       public            postgres    false    209            ?           2606    16581 !   vehiculos vehiculos_num_serie_key 
   CONSTRAINT     a   ALTER TABLE ONLY public.vehiculos
    ADD CONSTRAINT vehiculos_num_serie_key UNIQUE (num_serie);
 K   ALTER TABLE ONLY public.vehiculos DROP CONSTRAINT vehiculos_num_serie_key;
       public            postgres    false    209            ?           2606    16577    vehiculos vehiculos_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.vehiculos
    ADD CONSTRAINT vehiculos_pkey PRIMARY KEY (id_vehiculo);
 B   ALTER TABLE ONLY public.vehiculos DROP CONSTRAINT vehiculos_pkey;
       public            postgres    false    209            ?           2606    16690    alumnos alumnos_id_salon_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.alumnos
    ADD CONSTRAINT alumnos_id_salon_fkey FOREIGN KEY (id_salon) REFERENCES public.salones(id_salon);
 G   ALTER TABLE ONLY public.alumnos DROP CONSTRAINT alumnos_id_salon_fkey;
       public          postgres    false    219    2996    217            ?           2606    16735 #   e_gastos e_gastos_id_proveedor_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.e_gastos
    ADD CONSTRAINT e_gastos_id_proveedor_fkey FOREIGN KEY (id_proveedor) REFERENCES public.proveedores(id_p);
 M   ALTER TABLE ONLY public.e_gastos DROP CONSTRAINT e_gastos_id_proveedor_fkey;
       public          postgres    false    2990    213    223            ?           2606    16730    e_gastos e_gastos_id_tipog_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.e_gastos
    ADD CONSTRAINT e_gastos_id_tipog_fkey FOREIGN KEY (id_tipog) REFERENCES public.tipo_gastos(id_tg);
 I   ALTER TABLE ONLY public.e_gastos DROP CONSTRAINT e_gastos_id_tipog_fkey;
       public          postgres    false    223    2992    215            ?           2606    16769 I   mantenimientosyreparaciones mantenimientosyreparaciones_id_proveedor_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mantenimientosyreparaciones
    ADD CONSTRAINT mantenimientosyreparaciones_id_proveedor_fkey FOREIGN KEY (id_proveedor) REFERENCES public.proveedores(id_p);
 s   ALTER TABLE ONLY public.mantenimientosyreparaciones DROP CONSTRAINT mantenimientosyreparaciones_id_proveedor_fkey;
       public          postgres    false    2990    213    227            ?           2606    16764 H   mantenimientosyreparaciones mantenimientosyreparaciones_id_vehiculo_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mantenimientosyreparaciones
    ADD CONSTRAINT mantenimientosyreparaciones_id_vehiculo_fkey FOREIGN KEY (id_vehiculo) REFERENCES public.vehiculos(id_vehiculo);
 r   ALTER TABLE ONLY public.mantenimientosyreparaciones DROP CONSTRAINT mantenimientosyreparaciones_id_vehiculo_fkey;
       public          postgres    false    227    2980    209            ?           2606    16748 9   proveedores_agentes proveedores_agentes_id_proveedor_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.proveedores_agentes
    ADD CONSTRAINT proveedores_agentes_id_proveedor_fkey FOREIGN KEY (id_proveedor) REFERENCES public.proveedores(id_p);
 c   ALTER TABLE ONLY public.proveedores_agentes DROP CONSTRAINT proveedores_agentes_id_proveedor_fkey;
       public          postgres    false    225    213    2990            ?           2606    16624 $   proveedores proveedores_id_tipo_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.proveedores
    ADD CONSTRAINT proveedores_id_tipo_fkey FOREIGN KEY (id_tipo) REFERENCES public.tipo_soc(id_t);
 N   ALTER TABLE ONLY public.proveedores DROP CONSTRAINT proveedores_id_tipo_fkey;
       public          postgres    false    2982    213    211            ?           2606    16793    registro registro_ide_fkey    FK CONSTRAINT     y   ALTER TABLE ONLY public.registro
    ADD CONSTRAINT registro_ide_fkey FOREIGN KEY (ide) REFERENCES public.empresas(ide);
 D   ALTER TABLE ONLY public.registro DROP CONSTRAINT registro_ide_fkey;
       public          postgres    false    230    3010    231            ?           2606    16597 %   vehiculos vehiculos_id_capacidad_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vehiculos
    ADD CONSTRAINT vehiculos_id_capacidad_fkey FOREIGN KEY (id_capacidad) REFERENCES public.capacidades(id_c);
 O   ALTER TABLE ONLY public.vehiculos DROP CONSTRAINT vehiculos_id_capacidad_fkey;
       public          postgres    false    207    209    2974            ?           2606    16587 %   vehiculos vehiculos_id_cilindros_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vehiculos
    ADD CONSTRAINT vehiculos_id_cilindros_fkey FOREIGN KEY (id_cilindros) REFERENCES public.t_cilindros(id_c);
 O   ALTER TABLE ONLY public.vehiculos DROP CONSTRAINT vehiculos_id_cilindros_fkey;
       public          postgres    false    2966    209    203            ?           2606    16592 !   vehiculos vehiculos_id_marca_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vehiculos
    ADD CONSTRAINT vehiculos_id_marca_fkey FOREIGN KEY (id_marca) REFERENCES public.marcas(id_marca);
 K   ALTER TABLE ONLY public.vehiculos DROP CONSTRAINT vehiculos_id_marca_fkey;
       public          postgres    false    2970    205    209            ?           2606    16582 "   vehiculos vehiculos_id_modelo_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vehiculos
    ADD CONSTRAINT vehiculos_id_modelo_fkey FOREIGN KEY (id_modelo) REFERENCES public.modelos(id_m);
 L   ALTER TABLE ONLY public.vehiculos DROP CONSTRAINT vehiculos_id_modelo_fkey;
       public          postgres    false    2962    209    201            f   W   x?3?HL??WKMO?4??4200?5??50?4?4?2???L/M????tA,e???S?X??id
?hi??hh?i?i????? ?G^      Z   !   x?3?44?2?44?2?42?2?41?????? ,?U      j   L   x?E??	?0??.	???.}g??OC](??;?F??hTd&?b??1cv???t?pnq?&???_>?)W???C      q   m   x?s?50??t??t????S622rJK?3???\u?8?K??+9srR?RR?MAJ2SA?Ɯ????P?f??a?E??? N??⒢DN??Ģ?*ess??=... J?"?      h   7   x?3?tJ,????WKL?????2?NM.?KI,?LT0?2??IT040?????? \??      n   T   x?34?4??M?+I????L?+??44?J-?/*I?4?3?4202?50".C3?b?\bQbrf~??	g? U ?5?????? ?W?      X   .   x?3?t?r?2????q?2?t?wqw?2???v??????? ?=?      T   $   x?3?4????2Q?\ƜF\& ʌ+F??? X?       `   \   x?34?tO,?LJ?I??4614466447???24?t??S??/NK?Y?Y?s?q?s??$'?E??f ???I9?As3SNs?=... ?|?      l      x?3?44?t?H?I?S?)?,?46144?0371?,H-HuH?M???K???L??2?44??/?,I?4?A?
$e~?ũ\&??朎9e?E?M???9sJ3?*,??'???R??4;F??? ?*?      r   @   x??50?tFF??????`\A?F i#??!????)T?$k??Iy`?1z\\\ 9!g      p   7   x?3??N-???4202?50?50?2???L/Ḿ?ps??#???b???? ?'?      d      x?3?t?2?t?????? ??      V      x?3?4?2???????? :?      b   ,   x?3??M?+I????L?+??2?J-H,JL???K-?????? ??l      ^   H   x?3??M?+I????L?+??2?J-H,JL???K-?2??MMN??L??2?t?IM.)?-??????b???? ??e      \   7   x?3?tM??????KU0?ttr?52??4426153	224???4C#?=... E?
?     