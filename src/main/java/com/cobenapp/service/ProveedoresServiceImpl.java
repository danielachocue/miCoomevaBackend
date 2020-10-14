package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.Proveedores;
import com.cobenapp.repository.ProveedoresRepository;

public class ProveedoresServiceImpl implements ProveedoresService{

	ProveedoresRepository proveedoresRepository;
	
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Proveedores> findAll() {
		return proveedoresRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public Proveedores save(Proveedores entity) throws Exception {
		
		validate(entity);
		return proveedoresRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public Proveedores update(Proveedores entity) throws Exception {
		if(proveedoresRepository.existsById(entity.getIdProvd())==false) {
			throw new Exception("Ese proveedor no existe");
		}
		
		
		return proveedoresRepository.save(entity);	
		}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public void delete(Proveedores entity) throws Exception {
		if(proveedoresRepository.existsById(entity.getIdProvd())==false) {
			throw new Exception("Ese proveedor no existe");
		}
		proveedoresRepository.findById(entity.getIdProvd()).ifPresent(proveedores ->{
			if(proveedores.getBeneficios()!=null && proveedores.getBeneficios().isEmpty()==false) {
				throw new RuntimeException("El proveedor con id:"+entity.getIdProvd()+"tiene beneficios asociados");
			}
		});
		
		proveedoresRepository.deleteById(entity.getIdProvd());
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public void deleteById(Integer id) throws Exception {
		if(id==null ) {
			throw new Exception("El id es obligatorio");
		}
		
		if(proveedoresRepository.existsById(id)) {
			delete(proveedoresRepository.findById(id).get());
		}else {
			throw new Exception("El proveedor con id "+id+ " No existe");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Proveedores> findById(Integer id) throws Exception {
		return proveedoresRepository.findById(id);
	}

	@Override
	public void validate(Proveedores entity) throws Exception {
		
		if(entity == null) {
			throw new Exception("El entity es nulo");
		}
		
		if(entity.getProveedor().isBlank()==true || entity.getProveedor().isEmpty()==true) {
			throw new Exception("El proveedor es nulo");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return proveedoresRepository.count();
	}

	
	
	
	
}
