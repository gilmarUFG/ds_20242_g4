SELECT 
    
    calendario.id,
    categoria.nome as Categoria,
    faixa_etaria.meses_inicial ,
    faixa_etaria.meses_final,
    vacinas.nome_vacina as Vacina,
    doses.quantidade_dose as Doses

FROM
    calendario
        INNER JOIN
    categoria ON calendario.categoria_id = categoria.id
        INNER JOIN
    doses ON calendario.dose_id = doses.id
        INNER JOIN
    faixa_etaria ON calendario.faixaetaria_id = faixa_etaria.id
		INNER JOIN
    vacinas on calendario.vacina_id = vacinas.id
    
    order by  vacinas.nome_vacina, 
    doses.quantidade_dose;



