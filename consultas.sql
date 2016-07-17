/*Consultas*/
				
/*Indique toda la información del producto más costoso que se produce en la “Chocolatera Cimarrón” y muestre las distintas 
etapas de producción y qué trabajadores están vinculados en cada etapa.*/

select pr.codigo, pr.nombre as "producto", pr.peso, pr.precio, pr.tipo, et.nombre as "etapa", t.nombre as "trabajador de la etapa"
from p.producto pr, p.procesa pc, p.empresa e, p.etapa et, p.trabajador t, p.labora l where 
pr.codigo = pc.codigo and pc.rif = e.rif and e.tipo = 'Chocolatera' 
and e.nombre = 'El Cimarron' and pc.id = et.id and t.rif = e.rif and t.ci = l.ci and precio = 
(select max(precio) from p.producto pr, p.procesa pc, p.empresa e, p.etapa et, p.trabajador t, p.labora l 
where pr.codigo = pc.codigo and pc.rif = e.rif and e.tipo = 'Chocolatera' 
and e.nombre = 'El Cimarron' and pc.id = et.id and t.rif = e.rif and t.ci = l.ci);


/*Liste los productos vendidos en el mes de mayo de 2016 y las ganancias de cada Tienda “Cacao Venezolano” clasificadas 
por estado. En cada caso, los listados deben estar ordenados por la clave del producto en forma ascendente y por la ganancia
de forma descendente.*/

select v.codigo, v.costo, w.estado from p.vende v, p.empresa em, (select e.estado from p.empresa e 
											where e.tipo = 'Tienda' and e.nombre = 'Panaderia' GROUP BY e.estado) w
	where v.fecha >= '2016-05-01' AND v.fecha <= '2016-05-31' and w.estado = em.estado and v.rif = em.rif order by v.codigo asc, costo desc;

/*Diga cuál es el producto que ha ganado mayor cantidad de
premios e indique toda la información del evento y de los premios
otorgados.*/


SELECT pre.codigo, pre.organizador, pre.nombre, pre.anho AS año, pre.premio, c.participante, e.delegado
FROM p.premio_conc pre, p.concursa c, p.evento e
WHERE c.codigo = pre.codigo AND e.participante = c.participante AND e.nombre = c.nombre 
		AND e.organizador = c.organizador AND e.anho = c.anho
		AND pre.codigo = (SELECT codigo
					FROM p.premio_conc
					GROUP BY codigo HAVING COUNT(*) = (SELECT MAX(COUNT(codigo)) OVER()
															FROM p.premio_conc
															GROUP BY codigo
															LIMIT 1));
