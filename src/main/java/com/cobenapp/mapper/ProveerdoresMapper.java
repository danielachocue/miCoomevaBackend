package com.cobenapp.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.cobenapp.domain.Proveedores;
import com.cobenapp.dto.ProveedoresDTO;

@Mapper
public interface ProveerdoresMapper {
	
	public ProveedoresDTO toPorveedorDTO(Proveedores proveedor);
	
	public Proveedores toProveedro(ProveedoresDTO proveedorDTO);
	
	List<ProveedoresDTO> toProveedoresDTO(List<Proveedores> proveedores);
	
	List<Proveedores> toProveedores(List<ProveedoresDTO> proveedoresDTO);

}
