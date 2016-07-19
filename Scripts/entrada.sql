INSERT INTO p.empresa VALUES ('abcd', 'Procesadora', 'Cacao Oderi', 'Av. Bolivar', 'Valencia', 'Carabobo');
INSERT INTO p.empresa VALUES ('acdb', 'Chocolatera', 'El Cimarron', 'Av. Universidad', 'Maracay', 'Aragua');
INSERT INTO p.empresa VALUES ('bdgs', 'Tienda', 'Cacao Venezolano', 'Isabelica', 'Valencia', 'Carabobo');
INSERT INTO p.empresa VALUES ('bhgh', 'Tienda', 'Cacao Venezolano', 'Calle Miranda', 'Pto Cabello', 'Carabobo');
INSERT INTO p.empresa VALUES ('xyqw', 'Tienda', 'Cacao Venezolano', 'Calle San Jose', 'Cumana', 'Sucre');
INSERT INTO p.empresa VALUES ('swdr', 'Tienda', 'Cacao Venezolano', 'Av Andres Eloy', 'Los Teques', 'Miranda');
INSERT INTO p.empresa VALUES ('juyr', 'Tienda', 'Cacao Venezolano', 'CC El Templo IV', 'Cabimas', 'Zulia');
INSERT INTO p.empresa VALUES ('cgui', 'Tienda', 'Cacao Venezolano', 'CC Cielo Azul', 'Margarita', 'Nueva Esparta');
INSERT INTO p.empresa VALUES ('acbj', 'Tienda', 'Cacao Venezolano', 'Las Delicias', 'Maracay', 'Aragua');
INSERT INTO p.empresa VALUES ('plrt', 'Tienda', 'Cacao Venezolano', 'Cabudare', 'Barquisimeto', 'Lara');
INSERT INTO p.empresa VALUES ('vkrw', 'Tienda', 'Cacao Venezolano', 'Av Valencia', 'Naguanagua', 'Caracas');
INSERT INTO p.empresa VALUES ('plqn', 'Tienda', 'Cacao Venezolano', 'CC Trinitarias', 'Barquisimeto', 'Lara');

INSERT INTO p.maquinaria VALUES ('1234', 20000.53, 'Japon');
INSERT INTO p.maquinaria VALUES ('4321', 15000.47, 'China');
INSERT INTO p.maquinaria VALUES ('3452', 1000.77, 'Venezuela');
INSERT INTO p.maquinaria VALUES ('3450', 8000.53, 'Japon');
INSERT INTO p.maquinaria VALUES ('0285', 915.47, 'China');
INSERT INTO p.maquinaria VALUES ('8265', 700.77, 'USA');
INSERT INTO p.maquinaria VALUES ('0043', 9874.53, 'Taiwan');
INSERT INTO p.maquinaria VALUES ('0923', 14800.00, 'Turquia');
INSERT INTO p.maquinaria VALUES ('3334', 9870.00, 'Chile');
INSERT INTO p.maquinaria VALUES ('0992', 2985.448, 'China');
INSERT INTO p.maquinaria VALUES ('0911', 5874.698, 'China');
INSERT INTO p.maquinaria VALUES ('1134', 745.33, 'Rusia');

/*Estoy colocando como ingrediente todos los tipo de cacao, y como productos los que ya son chocolate en alguna de sus presentaciones*/
INSERT INTO p.producto VALUES ('1a', 'licor de cacao', 100, 1200, 'Ingrediente');
INSERT INTO p.producto VALUES ('1b', 'manteca de cacao', 300, 1500, 'Ingrediente');
INSERT INTO p.producto VALUES ('1c', 'polvo de cacao', 700, 15000, 'Ingrediente');
INSERT INTO p.producto VALUES ('1d', 'chocolate en taza', 800, 17000, 'Producto');
INSERT INTO p.producto VALUES ('1e', 'monedas de chocolate', 1, 5000, 'Producto');
INSERT INTO p.producto VALUES ('1f', 'bombones', 6, 500, 'Producto');
INSERT INTO p.producto VALUES ('1j', 'pasta de chocolate', 200, 3000, 'Producto');
INSERT INTO p.producto VALUES ('1g', 'cacao en polvo', 750, 6000, 'Ingrediente');
INSERT INTO p.producto VALUES ('1h', 'barra de chocolate con leche', 1500, 98000, 'Producto');
INSERT INTO p.producto VALUES ('1i', 'barra de chocolate amargo', 900, 15000, 'Producto');

INSERT INTO p.evento VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015);
INSERT INTO p.evento VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012);

INSERT INTO p.etapa VALUES ('2a', 'Prensado', '2016-05-24', '03:24:00', 'Sin Inconvenientes', 'CC', 98000);
INSERT INTO p.etapa VALUES ('2b', 'Fermentacion', '2016-04-24', '03:30:00', 'Retraso', 'CC', 4650);
INSERT INTO p.etapa VALUES ('2c', 'Secado', '2016-06-24', '11:35:00', 'Sin Inconvenientes', 'CC', 12500);
INSERT INTO p.etapa VALUES ('2d', 'Seleccionado', '2016-08-24', '09:10:00', 'Sin Inconvenientes', 'CC', 4000);
INSERT INTO p.etapa VALUES ('2e', 'Torrefaccion', '2016-04-12', '12:35:00', 'Sin Inconvenientes', 'CC', 6900);
INSERT INTO p.etapa VALUES ('2f', 'Descascarillado', '2016-05-2', '07:35:00', 'Falla Electrica', 'CC', 1400);
INSERT INTO p.etapa VALUES ('2g', 'Produccion de licor de cacao', '2016-06-10', '11:10:00', 'Falla de Combustible', 'CC', 3500);
INSERT INTO p.etapa VALUES ('2h', 'Neutralizado', '2016-07-24', '08:55:00', 'Sin Inconvenientes', 'CC', 46940);
INSERT INTO p.etapa VALUES ('2i', 'Filtracion', '2016-06-30', '04:15:00', 'Falla Electrica', 'CC', 78000);
INSERT INTO p.etapa VALUES ('2j', 'Pulverizado', '2016-05-31', '02:35:00', 'Sin Inconvenientes', 'CC', 43600);

INSERT INTO p.persona VALUES ('11356004', 'Juan Ramirez', '1995-06-24');
INSERT INTO p.persona VALUES ('22469870', 'Julian Orozco', '1994-08-26');
INSERT INTO p.persona VALUES ('15697203', 'Anais Hernandez', '1990-01-15');
INSERT INTO p.persona VALUES ('3657422', 'Freddy Rodriguez', '1985-03-15');
INSERT INTO p.persona VALUES ('14055426', 'Luis Perez', '1975-10-14');
INSERT INTO p.persona VALUES ('7169845', 'Alonso Jimenez', '1962-06-30');
INSERT INTO p.persona VALUES ('26687454', 'Elena Flores', '1992-02-19');

/*inserciones en las tablas secundarias*/
INSERT INTO p.encargo VALUES ('e1', 'plqn', 50000.443, '2016-04-12', 'Nada', 'Valencia-Barquisimeto');
INSERT INTO p.encargo VALUES ('e2', 'plrt', 4000.445, '2016-04-10', 'Retraso', 'Valencia-Barquisimeto');
INSERT INTO p.encargo VALUES ('e3', 'bdgs', 66000.415, '2016-06-22', 'No hay material', 'Barcelona-Carabobo');
INSERT INTO p.encargo VALUES ('e4', 'swdr', 9320.752, '2016-12-15', 'Nada', 'Maracay-Miranda');
INSERT INTO p.encargo VALUES ('e5', 'bhgh', 6540.495, '2016-01-24', 'Nada', 'Maracay-Carabobo');

/*Son 250 trabajadores porque hay 250 que participan en una etapa segun en el enunciado U__U*/
INSERT INTO p.trabajador VALUES ('20981655', 'Geraldine Herrera G', '1993-06-24', 'CEO', 50000.443, '2012-05-10', '2016-04-10', 'abcd');
INSERT INTO p.trabajador VALUES ('20256987', 'Wilkel Giovanni', '1995-05-24', 'Gerente', 45000.447, '2009-03-10', '2016-06-10', 'acdb');
INSERT INTO p.trabajador VALUES ('22658947', 'Oswaldo Capriles', '1995-12-12', 'Programador', 50000.453, '2014-04-10', '2016-04-10', 'acdb');
INSERT INTO p.trabajador VALUES ('24596314', 'Jose Abreu', '1994-06-03', 'Conserje', 56000.943, '2005-04-10', '2016-04-10', 'abcd');
INSERT INTO p.trabajador VALUES ('25572685', 'Jose Mendez', '1985-06-03', 'Empaquetador', 1000.943, '2002-04-20', '2016-10-10', 'abcd');
INSERT INTO p.trabajador VALUES ('21447866', 'Felipe Rojas', '1990-04-12', 'Mensajero', 2000.943, '2015-11-10', '2016-04-10', 'abcd');
INSERT INTO p.trabajador VALUES ('14569870', 'Ignacio Loreto', '1984-12-03', 'Director de planta', 9650.943, '2015-01-29', '2016-04-10', 'abcd');
INSERT INTO p.trabajador VALUES ('4227895', 'Pedro Avila', '1972-06-30', 'Corredor de envios', 14000.943, '2010-05-10', '2016-12-10', 'acdb');
INSERT INTO p.trabajador VALUES ('1214789', 'Mariana Gamboa', '1982-09-15', 'Directora de personal', 25000.943, '2014-03-20', '2016-04-10', 'abcd');
INSERT INTO p.trabajador VALUES ('9874520', 'Mirella Gonzalez', '1955-11-28', 'Secretaria', 8400.943, '2016-02-17', '2016-04-10', 'acdb');
INSERT INTO p.trabajador VALUES ('18214577', 'Rosa Gomez', '1980-03-20', 'Directora de riesgos', 6900.943, '209-07-20', '2016-09-10', 'acdb');
INSERT INTO p.trabajador VALUES ('8221456', 'Fabian Diaz', '1976-08-12', 'Director de seguridad', 36000.943, '2028-12-10', '2016-04-10', 'abcd');
INSERT INTO p.trabajador VALUES ('5124556', 'Lorenzo Mendoza', '1954-10-04', 'Operador de maquinaria', 2000.943, '2005-07-10', '2016-11-10', 'acdb');
INSERT INTO p.trabajador VALUES ('16547832', 'Maria Aponte', '1988-02-13', 'Soporte tecnico', 36000.943, '2006-04-30', '2016-04-10', 'acdb');

INSERT INTO p.estudiante VALUES ('25479964', 'Agustin Fernandez', '1990-06-24');
INSERT INTO p.estudiante VALUES ('24120987', 'Ana Figueroa', '19792-05-24');
INSERT INTO p.estudiante VALUES ('14589620', 'Enrique Perez', '1982-10-24');
INSERT INTO p.estudiante VALUES ('20369871', 'Leonardo Aranguren', '1994-08-02');

INSERT INTO p.premio_conc VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015,'Mejor Chocolate 2', '1i');
INSERT INTO p.premio_conc VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015,'Mejor Chocolate 3', '1i');
INSERT INTO p.premio_conc VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015,'Mejor Chocolate 4', '1i');
INSERT INTO p.premio_conc VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015,'Mejor Chocolate 5', '1i');
INSERT INTO p.premio_conc VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Mejor Chocolate dulce', '1i');
INSERT INTO p.premio_conc VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Mejor Chocolate dulce 1', '1g');
INSERT INTO p.premio_conc VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Mejor Chocolate dulce 2', '1g');
INSERT INTO p.premio_conc VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Mejor Chocolate dulce 3', '1g');

INSERT INTO p.concursa VALUES ('Expoferia Internacional del Chocolate', 2015, 'Colombia', '1i');
INSERT INTO p.concursa VALUES ('Exhibicion Internacional EuroChoc', 2012, 'Francia', '1g');
INSERT INTO p.concursa VALUES ('Exhibicion Internacional EuroChoc', 2012, 'Francia', '1i');

INSERT INTO p.participante_ev VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015, 'Venezuela','Jose Camejo');
INSERT INTO p.participante_ev VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015, 'Colombia','Pedro Abreu');
INSERT INTO p.participante_ev VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015, 'Ecuador','Alejandro Uzcategui');
INSERT INTO p.participante_ev VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015, 'Bolivia','Marisela Suarez');
INSERT INTO p.participante_ev VALUES ('Colombia', 'Expoferia Internacional del Chocolate', 2015, 'Panama','Alexander Cruz');
INSERT INTO p.participante_ev VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Venezuela','Andres Tovar');
INSERT INTO p.participante_ev VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Espana','Angelica Hurtado');
INSERT INTO p.participante_ev VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Portugal','Aracelys Salas');
INSERT INTO p.participante_ev VALUES ('Francia', 'Exhibicion Internacional EuroChoc', 2012, 'Puerto Rico','Rocky Balboa');

INSERT INTO p.utiliza VALUES ('u1', '2a');
INSERT INTO p.utiliza VALUES ('u2', '2b');
INSERT INTO p.utiliza VALUES ('u3', '2c');
INSERT INTO p.utiliza VALUES ('u4','2d');
INSERT INTO p.utiliza VALUES ('u5','2e');
INSERT INTO p.utiliza VALUES ('u6','2f');
INSERT INTO p.utiliza VALUES ('u7','2g');
INSERT INTO p.utiliza VALUES ('u8','2h');
INSERT INTO p.utiliza VALUES ('u9','2i');
INSERT INTO p.utiliza VALUES ('u10','2j');

INSERT INTO p.procesa VALUES ('2a', '1f','acdb', 32.59);
INSERT INTO p.procesa VALUES ('2b', '1j', 'acdb', 56.47);
INSERT INTO p.procesa VALUES ('2c', '1i', 'acdb', 89.00);
INSERT INTO p.procesa VALUES ('2d', '1g', 'abcd', 45.87);
INSERT INTO p.procesa VALUES ('2e', '1h', 'acdb', 12.36);
INSERT INTO p.procesa VALUES ('2f', '1e', 'acdb', 125.87);
INSERT INTO p.procesa VALUES ('2g', '1d', 'acdb', 196.487);
INSERT INTO p.procesa VALUES ('2h', '1b', 'acdb', 12.02);
INSERT INTO p.procesa VALUES ('2j', '1c', 'acdb', 100.00);
INSERT INTO p.procesa VALUES ('2i', '1a', 'acdb', 87.36);

INSERT INTO p.envia VALUES ('e1', '1a', 84.25);
INSERT INTO p.envia VALUES ('e2', '1b', 785.15);
INSERT INTO p.envia VALUES ('e3', '1g', 12.35);
INSERT INTO p.envia VALUES ('e4', '1i', 745.56);
INSERT INTO p.envia VALUES ('e5', '1j', 98.14);

INSERT INTO p.participa VALUES ('e1', '5124556');
INSERT INTO p.participa VALUES ('e2', '16547832');
INSERT INTO p.participa VALUES ('e4', '22658947');
INSERT INTO p.participa VALUES ('e3', '20981655');
INSERT INTO p.participa VALUES ('e5', '21447866');

INSERT INTO p.funcion_part VALUES ('e4', '22658947', 'Despacho');
INSERT INTO p.funcion_part VALUES ('e1', '5124556', 'Transporte');
INSERT INTO p.funcion_part VALUES ('e3', '20981655', 'Recepcion');
INSERT INTO p.funcion_part VALUES ('e2', '16547832', 'Recepcion');
INSERT INTO p.funcion_part VALUES ('e5', '21447866', 'Recepcion');

/*250 labora como trabajadores hay U_U*/
INSERT INTO p.labora VALUES ('2b', '20981655');
INSERT INTO p.labora VALUES ('2a', '5124556');
INSERT INTO p.labora VALUES ('2c', '24596314');
INSERT INTO p.labora VALUES ('2a', '25572685');
INSERT INTO p.labora VALUES ('2j', '14569870');
INSERT INTO p.labora VALUES ('2j', '8221456');
INSERT INTO p.labora VALUES ('2j', '16547832');
INSERT INTO p.labora VALUES ('2h', '8221456');
INSERT INTO p.labora VALUES ('2i', '18214577');
INSERT INTO p.labora VALUES ('2d', '9874520');
INSERT INTO p.labora VALUES ('2e', '1214789');
INSERT INTO p.labora VALUES ('2b', '4227895');
INSERT INTO p.labora VALUES ('2c', '20256987');
INSERT INTO p.labora VALUES ('2a', '22658947');

INSERT INTO p.especialidad_maestro VALUES ('22658947', 'Programacion de maquinaria');
INSERT INTO p.especialidad_maestro VALUES ('20256987', 'Publicidad');
INSERT INTO p.especialidad_maestro VALUES ('22658947', 'Chocolate express');
INSERT INTO p.especialidad_maestro VALUES ('14569870', 'Seguridad de Chocolatera');

INSERT INTO p.curso VALUES ('CAO505', 'Sweet Chocolate', '04:05:06', '14569870');
INSERT INTO p.curso VALUES ('CAO605', 'Amazing White Chocolate', '06:25:12', '18214577');
INSERT INTO p.curso VALUES ('CAO405', 'Pasteleria Chocolatera', '11:30:54', '20981655');

INSERT INTO p.asiste VALUES ('25479964', 'CAO405');
INSERT INTO p.asiste VALUES ('24120987', 'CAO605');
INSERT INTO p.asiste VALUES ('14589620', 'CAO505');
INSERT INTO p.asiste VALUES ('20369871', 'CAO505');

INSERT INTO p.vende VALUES ('plqn', '1e', '7169845', 41, '2016-05-03', 564500.447);
INSERT INTO p.vende VALUES ('vkrw', '1d', '7169845', 8, '2016-05-24', 36006.00);
INSERT INTO p.vende VALUES ('vkrw', '1e', '22469870', 72, '2016-05-14', 641321.37);
INSERT INTO p.vende VALUES ('juyr', '1e', '22469870', 2, '2016-05-10', 18000.487);
INSERT INTO p.vende VALUES ('acbj', '1e', '3657422', 36, '2016-06-04', 280450.647);
INSERT INTO p.vende VALUES ('xyqw', '1f', '3657422', 58, '2016-02-23', 59640.17);
INSERT INTO p.vende VALUES ('bdgs', '1j', '14055426', 13, '2016-01-15', 70050.447);
INSERT INTO p.vende VALUES ('xyqw', '1f', '14055426', 52, '2016-03-29', 40650.547);
INSERT INTO p.vende VALUES ('bdgs', '1i', '15697203', 102, '2016-04-10', 2677550.77);
INSERT INTO p.vende VALUES ('bhgh', '1i', '15697203', 652, '2016-05-30', 19542350.617);
INSERT INTO p.vende VALUES ('bdgs', '1h', '26687454', 47, '2016-05-22', 9124562.447);
INSERT INTO p.vende VALUES ('bhgh', '1f', '26687454', 63, '2016-05-03', 64550.436);

INSERT INTO p.necesita VALUES ('1h', '1c', 565);
INSERT INTO p.necesita VALUES ('1i', '1g', 412);
INSERT INTO p.necesita VALUES ('1f', '1j', 56);
INSERT INTO p.necesita VALUES ('1d', '1c', 10);

/* 
* FALTA PROBAR INSERTAR EN LAS TABLAS SIN COLOCAR NADA EN LOS ATRIBUTOS NO OBLIGATORIOS
*/

-- ~ INSERT INTO p.persona VALUES ('22410354', 'Julian Orozco', '1994-08-26');
