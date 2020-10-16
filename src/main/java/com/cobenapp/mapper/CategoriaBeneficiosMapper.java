package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.CategoriaBeneficios;
import com.cobenapp.dto.CategoriaBeneficiosDTO;

@Mapper
public interface CategoriaBeneficiosMapper {
	
	public CategoriaBeneficiosDTO toCategoriaBeneficioDTO(CategoriaBeneficios categoriaBeneficio);
	
	public CategoriaBeneficios toCategoriaBeneficio(CategoriaBeneficiosDTO categoriaBeneficioDTO);
	
	public List<CategoriaBeneficiosDTO> toCategoriaBeneficiosDTO(List<CategoriaBeneficios> categoriaBeneficios);
	
	public List<CategoriaBeneficios> toCategoriaBeneficios(List<CategoriaBeneficiosDTO> categoriaBeneficiosDTO);

}
