/* Consultas */
				
/* Indique toda la información del producto más costoso que se produce en la “Chocolatera Cimarrón” y muestre las distintas 
etapas de producción y qué trabajadores están vinculados en cada etapa. */

SELECT 
	pr.codigo, 
	pr.nombre AS "producto", 
	pr.peso, 
	pr.precio, 
	pr.tipo, 
	et.nombre AS "etapa", 
	t.nombre AS "trabajador de la etapa"
FROM 
	p.producto pr, 
	p.procesa pc, 
	p.empresa e, 
	p.etapa et, 
	p.trabajador t, 
	p.labora l 
WHERE pr.codigo = pc.codigo 
	AND pc.rif = e.rif 
	AND e.tipo = 'Chocolatera' 
	AND e.nombre = 'El Cimarron' 
	AND pc.id = et.id 
	AND t.rif = e.rif 
	AND t.ci = l.ci 
	AND precio = (
				SELECT max(precio) 
				FROM 
					p.producto pr, 
					p.procesa pc, 
					p.empresa e, 
					p.etapa et, 
					p.trabajador t, 
					p.labora l 
				WHERE pr.codigo = pc.codigo 
					AND pc.rif = e.rif 
					AND e.tipo = 'Chocolatera' 
					AND e.nombre = 'El Cimarron' 
					AND pc.id = et.id 
					AND t.rif = e.rif 
					AND t.ci = l.ci
				);

/* Liste los productos vendidos en el mes de mayo de 2016 y las ganancias de cada Tienda “Cacao Venezolano” clasificadas 
por estado. En cada caso, los listados deben estar ordenados por la clave del producto en forma ascendente y por la ganancia
de forma descendente.*/

SELECT v.codigo, v.costo, w.estado 
FROM 
	p.vende v, 
	p.empresa em, 
	(
		SELECT e.estado FROM p.empresa e 
		WHERE e.tipo = 'Tienda' 
			AND e.nombre = 'Panaderia' 
		GROUP BY e.estado
	) w
WHERE v.fecha >= '2016-05-01' 
	AND v.fecha <= '2016-05-31' 
	AND w.estado = em.estado 
	AND v.rif = em.rif 
	ORDER BY v.codigo ASC, costo DESC;

/*Diga cuál es el producto que ha ganado mayor cantidad de
premios e indique toda la información del evento y de los premios
otorgados.*/

SELECT 
	pre.codigo, 
	pre.organizador, 
	pre.nombre, 
	pre.anho AS año, 
	pre.premio, 
	c.participante, 
	e.delegado
FROM 
	p.premio_conc pre, 
	p.concursa c, 
	p.evento e
WHERE c.codigo = pre.codigo 
	AND e.participante = c.participante 
	AND e.nombre = c.nombre 
	AND e.organizador = c.organizador 
	AND e.anho = c.anho
	AND pre.codigo = (
				SELECT codigo
				FROM p.premio_conc
				GROUP BY codigo 
				HAVING COUNT(*) = (
					SELECT MAX(COUNT(codigo)) OVER()
					FROM p.premio_conc
					GROUP BY codigo
					LIMIT 1)
				);
