package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.UsoBeneficio;
import com.cobenapp.repository.UsoBeneficioRepository;

@Service
@Scope("singleton")
public class UsoBeneficioServiceImpl implements UsoBeneficioService {

	UsoBeneficioRepository usoBeneficioRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<UsoBeneficio> findAll() {

		return usoBeneficioRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public UsoBeneficio save(UsoBeneficio entity) throws Exception {

		validate(entity);
		
		if(usoBeneficioRepository.existsById(entity.getIdUso()) == true) {
			throw new Exception("El Uso de beneficio ya existe");
		}
		
		
		return usoBeneficioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public UsoBeneficio update(UsoBeneficio entity) throws Exception {

		validate(entity);
		

		if(usoBeneficioRepository.existsById(entity.getIdUso()) == false) {
			throw new Exception("El uso de beneficio con id: "+entity.getIdUso()+" no existe");
		}
		
		return usoBeneficioRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delete(UsoBeneficio entity) throws Exception {

		if(usoBeneficioRepository.existsById(entity.getIdUso())== false) {
			throw new Exception("El id no existe");
		}
		
		
		usoBeneficioRepository.deleteById(entity.getIdUso());
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null) {
			throw new Exception("El id es nulo");
		}
		
		if(usoBeneficioRepository.existsById(id)) {
			delete(usoBeneficioRepository.findById(id).get());
		}else {
			throw new Exception("El uso de beneficio con id "+id+ " No existe");
		}	
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<UsoBeneficio> findById(Integer id) throws Exception {

		return null;
	}

	@Override
	public void validate(UsoBeneficio entity) throws Exception {
		
		if(entity == null) {
			throw new Exception("El entity es nulo");
		}
		
		if(entity.getFechaUso() == null) {
			throw new Exception("La fecha es nula");
		}
		
		
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {

		return usoBeneficioRepository.count();
	}

}
