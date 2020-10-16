package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.Preferencias;
import com.cobenapp.dto.PreferenciasDTO;

@Mapper
public interface PreferenciasMapper {
	
	public PreferenciasDTO toPreferenciaDTO(Preferencias preferencia);
	
	public Preferencias toPreferencia(PreferenciasDTO preferenciaDTO);
	
	public List<PreferenciasDTO> toPreferenciasDTO(List<Preferencias> preferencias);
	
	public List<Preferencias> toPreferencias(List<PreferenciasDTO> preferenciasDTO);
	

}
