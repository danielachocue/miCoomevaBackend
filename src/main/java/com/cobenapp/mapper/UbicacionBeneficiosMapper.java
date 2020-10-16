package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.UbicacionBeneficios;
import com.cobenapp.dto.UbicacionBeneficiosDTO;

@Mapper
public interface UbicacionBeneficiosMapper {
	
	public UbicacionBeneficiosDTO toUbicacionBeneficioDTO(UbicacionBeneficios ubicacionBeneficio);
	
	public UbicacionBeneficios toUbicacionBeneficio(UbicacionBeneficiosDTO ubicacionBeneficioDTO);
	
	public List<UbicacionBeneficiosDTO> toUbicacionBeneficiosDTO(List<UbicacionBeneficios> ubicacionBeneficos);
	
	public List<UbicacionBeneficios> toUbicacionsBeneficios(List<UbicacionBeneficiosDTO> ubicacionsBeneficiosDTO);
	

}
