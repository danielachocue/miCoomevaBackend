package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.UbicacionBeneficios;
import com.cobenapp.repository.UbicacionBeneficiosRepository;

@Service
@Scope("singleton")
public class UbicacionBeneficiosServiceImpl implements UbicacionBeneficiosService{

	UbicacionBeneficiosRepository ubicacionBeneficiosRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<UbicacionBeneficios> findAll() {

		return ubicacionBeneficiosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public UbicacionBeneficios save(UbicacionBeneficios entity) throws Exception {
		validate(entity);
		
		
		
		return ubicacionBeneficiosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public UbicacionBeneficios update(UbicacionBeneficios entity) throws Exception {
		
		validate(entity);
		
		if(ubicacionBeneficiosRepository.existsById(entity.getIdUb())== false) {
			throw new Exception("El id no existe");
		}
		
		
		
		
		return ubicacionBeneficiosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delete(UbicacionBeneficios entity) throws Exception {

		if(ubicacionBeneficiosRepository.existsById(entity.getIdUb())== false) {
			throw new Exception("El id no existe");
		}
		
		
		ubicacionBeneficiosRepository.deleteById(entity.getIdUb());
		
		
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {

		if (id == null) {
			throw new Exception("El id es nulo");
		}
		
		if(ubicacionBeneficiosRepository.existsById(id)) {
			delete(ubicacionBeneficiosRepository.findById(id).get());
		}else {
			throw new Exception("La ubicacion con id "+id+ " No existe");
		}	
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UbicacionBeneficios> findById(Integer id) throws Exception {
		return ubicacionBeneficiosRepository.findById(id);
	}

	@Override
	public void validate(UbicacionBeneficios entity) throws Exception {
		
		if(entity== null) {
			throw new Exception("El entity es nulo");
		}
		
		if(entity.getLatitud().isBlank()==true || entity.getLatitud().isEmpty()==true) {
			throw new Exception("El campo latitud es nulo");
		}
		
		if(entity.getLongitud().isBlank()==true || entity.getLongitud().isEmpty()==true) {
			throw new Exception("El campo longitud es nulo");
		}
		
		
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
		return ubicacionBeneficiosRepository.count();
	}

}
