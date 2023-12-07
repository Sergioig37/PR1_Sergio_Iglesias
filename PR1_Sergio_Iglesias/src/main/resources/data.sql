insert into inmobiliaria(cif,nombre,numero_Empleados) values('B333903490','VentasTomasín',300);
insert into inmobiliaria(cif,nombre,numero_Empleados) values('B3987555690','PropiedadCity',150);
insert into inmobiliaria(cif,nombre,numero_Empleados) values('B33448998893','Re/Max',200);

insert into agente_inmobiliario(dni,nombre,telefono_Contacto,FK_INMOBILIARIA) values('482493G','Juan Carlos','66734634','B33448998893');
insert into agente_inmobiliario(dni,nombre,telefono_Contacto,FK_INMOBILIARIA) values('478289H','Andrés','6099034','B33448998893');
insert into agente_inmobiliario(dni,nombre,telefono_Contacto,FK_INMOBILIARIA) values('783494J','Mariano','7689305','B3987555690');
insert into agente_inmobiliario(dni,nombre,telefono_Contacto,FK_INMOBILIARIA) values('96906T','David','476475','B333903490');


insert into usuario(dni,nombre)values('54472060X', 'Sergio');
insert into usuario(dni,nombre)values('4738931', 'Dani');
insert into usuario(dni,nombre)values('5893490', 'Diego');
insert into usuario(dni,nombre)values('849038945', 'Andrés');


insert into propiedades (precio, localizacion, tipo, FK_PROPIETARIO) values(200000, 'Oviedo','Chalé','54472060X');
insert into propiedades (precio, localizacion, tipo, FK_PROPIETARIO) values(2000000, 'Oviedo','Piso','4738931');
insert into propiedades (precio, localizacion, tipo, FK_PROPIETARIO) values(200000, 'Oviedo','Chalé','849038945');
insert into propiedades (precio, localizacion, tipo, FK_PROPIETARIO) values(100000, 'Oviedo','Casa','54472060X');



insert into usuario_agente (idagente, idusuario)values('478289H','54472060X');
insert into usuario_agente (idagente, idusuario)values('478289H','5893490');
insert into usuario_agente (idagente, idusuario)values('783494J','4738931');
insert into usuario_agente (idagente, idusuario)values('482493G','849038945');
insert into usuario_agente (idagente, idusuario)values('478289H','4738931');