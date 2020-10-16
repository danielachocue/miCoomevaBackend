package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.Beneficios;
import com.cobenapp.dto.BeneficiosDTO;

@Mapper
public interface BeneficiosMapper {
	
	public BeneficiosDTO toBeneficioDTO(Beneficios beneficio);
	
	public Beneficios toBeneficio(BeneficiosDTO beneficioDTO);
	
	List<BeneficiosDTO> toBeneficiosDTO(List<Beneficios> beneficios);
	
	List<Beneficios> toBeneficios(List<BeneficiosDTO> beneficiosDTO);

}
