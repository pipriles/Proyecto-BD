INSERT INTO p.empresa VALUES ('abcd', 'Procesadora', 'Cacao Oderi', 'Av. Bolivar', 'Valencia', 'Carabobo');
INSERT INTO p.empresa VALUES ('acdb', 'Chocolatera', 'El Cimarron', 'Av. Universidad', 'Maracay', 'Aragua');
INSERT INTO p.empresa VALUES ('bdgs', 'Tienda', 'Panaderia', 'Calle morrocoy', 'Valencia', 'Carabobo');
INSERT INTO p.empresa VALUES ('bhgh', 'Tienda', 'Panaderia', 'Calle Marina', 'Pto Cabello', 'Barinas');

INSERT INTO p.maquinaria VALUES (1234, 20000.53, 'Japon');
INSERT INTO p.maquinaria VALUES (4321, 15000.47, 'China');
INSERT INTO p.maquinaria VALUES (3452, 1000.77, 'Venezuela');

INSERT INTO p.producto VALUES ('1a', 'licor de cacao', 100, 1200, 'Ingrediente');
INSERT INTO p.producto VALUES ('1b', 'manteca de cacao', 300, 1500, 'Ingrediente');
INSERT INTO p.producto VALUES ('2a', 'chocolate liquido', 700, 15000, 'Producto');
INSERT INTO p.producto VALUES ('2b', 'chocolate en barra', 800, 17000, 'Producto');
INSERT INTO p.producto VALUES ('2c', 'Torta', 1, 5000, 'Producto');
INSERT INTO p.producto VALUES ('2d', 'Bienmesabe', 6, 8000, 'Producto');
INSERT INTO p.producto VALUES ('2e', 'Bombones', 200, 3000, 'Producto');

INSERT INTO p.evento VALUES ('Hiperevento', 'El mejor chocolate', 2015, 'a', 'Jose');
INSERT INTO p.evento VALUES ('Eventos', 'El mejor chocolate blanco', 2014, 'b', 'Josefina');

INSERT INTO p.etapa VALUES ('2b', 'Prensado', '2016-05-24', '03:24:00', 'Todo perfecto', 'CC', 45000);
INSERT INTO p.etapa VALUES ('2c', 'Congelado', '2016-04-24', '03:24:00', 'Todo perfecto', 'CC', 45000);
INSERT INTO p.etapa VALUES ('2a', 'Pulverizado', '2016-06-24', '01:35:00', 'Todo perfecto', 'CC', 4000);

INSERT INTO p.persona VALUES ('11356004', 'Juan Ramirez', '1995-06-24');
INSERT INTO p.persona VALUES ('22410354', 'Julian Orozco', '1994-08-26');
INSERT INTO p.persona VALUES ('24150354', 'Anais Hernandez', '1990-01-15');

/*inserciones en las tablas secundarias*/
INSERT INTO p.encargo VALUES ('e1', 'abcd', 50000.443, '2016-04-12', 'nada', 'Valencia-Maracay');
INSERT INTO p.encargo VALUES ('e2', 'acdb', 4000.445, '2012-04-10', 'retraso', 'Valencia-Maracay');
INSERT INTO p.encargo VALUES ('e3', 'bdgs', 66000.415, '2015-06-22', 'no hay material', 'Barcelona-Maracay');
INSERT INTO p.encargo VALUES ('e4', 'acdb', 9320.495, '2014-12-24', 'huelga', 'Maracay-Caracas');

INSERT INTO p.trabajador VALUES ('20981655', 'Geraldine Herrera G', '1993-06-24', 'CEO', 50000.443, '2012-04-10', '2016-04-10', 'bdgs');
INSERT INTO p.trabajador VALUES ('20256987', 'Wilkel Giovanni', '1995-05-24', 'Gerente', 50000.447, '2009-04-10', '2016-04-10', 'bdgs');
INSERT INTO p.trabajador VALUES ('22658947', 'Oswaldo Capriles', '1995-12-12', 'Programador', 50000.453, '2014-04-10', '2016-04-10', 'abcd');
INSERT INTO p.trabajador VALUES ('24596314', 'Jose Abreu', '1994-06-03', 'Conserje', 50000.943, '2005-04-10', '2016-04-10', 'acdb');

INSERT INTO p.estudiante VALUES ('20981655', 'Gericyber HG', '1980-06-24');
INSERT INTO p.estudiante VALUES ('20256987', 'Wilki Gio', '1970-05-24');

INSERT INTO p.premio_conc VALUES ('Hiperevento', 'El mejor chocolate', 2015, 'a', 'chocolatoso', '2b');
INSERT INTO p.premio_conc VALUES ('Eventos', 'El mejor chocolate blanco', 2014, 'b', 'dulcito', '2a');

INSERT INTO p.concursa VALUES ('El mejor chocolate', 2015, 'Hiperevento', 'a', '2b');
INSERT INTO p.concursa VALUES ('El mejor chocolate blanco', 2014, 'Eventos', 'b', '2a');

INSERT INTO p.participante_ev VALUES ('Hiperevento', 'El mejor chocolate', 2015, 'a');
INSERT INTO p.participante_ev VALUES ('Eventos', 'El mejor chocolate blanco', 2014, 'b');

INSERT INTO p.utiliza VALUES ('lxlx', '2a');
INSERT INTO p.utiliza VALUES ('gxgx', '2b');
INSERT INTO p.utiliza VALUES ('dddd', '2c');
INSERT INTO p.utiliza VALUES ('rrrr','2a');

INSERT INTO p.procesa VALUES ('2b', '1a','bdgs', 32.59);
INSERT INTO p.procesa VALUES ('2a', '2c', 'acdb', 56.47);
INSERT INTO p.procesa VALUES ('2c', '2d', 'acdb', 89.00);
INSERT INTO p.procesa VALUES ('2b', '2d', 'acdb', 45.87);

INSERT INTO p.envia VALUES ('e1', '1a', 84.25);
INSERT INTO p.envia VALUES ('e2', '1b', 785.15);
INSERT INTO p.envia VALUES ('e3', '2c', 12.35);
INSERT INTO p.envia VALUES ('e4', '2b', 745.56);

INSERT INTO p.participa VALUES ('e1', '22658947');
INSERT INTO p.participa VALUES ('e2', '24596314');
INSERT INTO p.participa VALUES ('e4', '20981655');

INSERT INTO p.funcion_part VALUES ('e4', '20981655', 'Despacho');
INSERT INTO p.funcion_part VALUES ('e1', '22658947', 'Transporte');
INSERT INTO p.funcion_part VALUES ('e2', '24596314', 'Recepcion');

INSERT INTO p.labora VALUES ('2b', '20981655');
INSERT INTO p.labora VALUES ('2a', '24596314');
INSERT INTO p.labora VALUES ('2c', '22658947');

INSERT INTO p.especialidad_maestro VALUES ('22658947', 'Programacion de maquinaria');
INSERT INTO p.especialidad_maestro VALUES ('20981655', 'Publicidad');
INSERT INTO p.especialidad_maestro VALUES ('24596314', 'Chocolate express');
INSERT INTO p.especialidad_maestro VALUES ('20256987', 'Tecnicas chocolateras');

INSERT INTO p.curso VALUES ('CAO505', 'Chocolate 1', '04:05:06', '20981655');
INSERT INTO p.curso VALUES ('CAO605', 'Chocolate 2', '06:25:12', '22658947');
INSERT INTO p.curso VALUES ('CAO405', 'Chocolate 3', '11:30:54', '24596314');

INSERT INTO p.asiste VALUES ('20981655', 'lmk3');
INSERT INTO p.asiste VALUES ('20256987', 'lxk7');

INSERT INTO p.vende VALUES ('bdgs', '2a', '22410354', 41, '2016-05-03', 50000.447);
INSERT INTO p.vende VALUES ('acdb', '1b', '11356004', 8, '2016-05-24', 895.443);
INSERT INTO p.vende VALUES ('abcd', '2c', '24150354', 72, '2005-05-24', 50021.447);
INSERT INTO p.vende VALUES ('bhgh', '2e', '11356004', 41, '2016-05-10', 95000.447);
INSERT INTO p.vende VALUES ('bdgs', '2b', '22410354', 41, '2016-05-04', 5450.447);


INSERT INTO p.necesita VALUES ('2c', '2b', 565);
INSERT INTO p.necesita VALUES ('1a', '1b', 412);
INSERT INTO p.necesita VALUES ('2b', '2a', 56);
INSERT INTO p.necesita VALUES ('2a', '1b', 10);

/* 
* FALTA PROBAR INSERTAR EN LAS TABLAS SIN COLOCAR NADA EN LOS ATRIBUTOS NO OBLIGATORIOS
*/

-- ~ INSERT INTO p.persona VALUES ('22410354', 'Julian Orozco', '1994-08-26');
