package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.UsoBeneficio;
import com.cobenapp.dto.UsoBeneficioDTO;

@Mapper
public interface UsoBeneficiosMapper {
	
	public UsoBeneficioDTO toUsoBeneficioDTO(UsoBeneficio usoBeneficio);
	
	public UsoBeneficio toUsoBeneficio(UsoBeneficioDTO usoBeneficioDTO);
	
	public List<UsoBeneficioDTO> toUsoBeneficiosDTO(List<UsoBeneficio> usoBeneficios);
	
	public List<UsoBeneficio> toUsoBeneficios(List<UsoBeneficioDTO> usoBeneficiosDTO);

}
