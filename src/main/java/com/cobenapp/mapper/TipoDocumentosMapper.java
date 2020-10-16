package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.TipoDocumentos;
import com.cobenapp.dto.TipoDocumentosDTO;

@Mapper
public interface TipoDocumentosMapper {
	
	public TipoDocumentosDTO toTipoDocuementoDTO (TipoDocumentos tipoDocumento);
	
	public TipoDocumentos toTipoDocumento(TipoDocumentosDTO tipoDocumentoDTO);
	
	public List<TipoDocumentosDTO> toTipoDocumentosDTO(List<TipoDocumentos> tipoDocuemntos);
	
	public List<TipoDocumentos> toTipoDocumentos(List<TipoDocumentosDTO> tipoDocumentosDTO);

}
