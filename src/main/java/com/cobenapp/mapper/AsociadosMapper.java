package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.Asociados;
import com.cobenapp.dto.AsociadosDTO;

@Mapper
public interface AsociadosMapper {
	
	public AsociadosDTO toAsociadoDTO(Asociados asociado);
	
	public Asociados toAsociado(AsociadosDTO asociadoDTO);
	
	public List<AsociadosDTO> toAsociadosDTO(List<Asociados> asociados);
	
	public List<Asociados> toAsociados(List<AsociadosDTO> asociadosDTO);

}
