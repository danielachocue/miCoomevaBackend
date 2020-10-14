package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.Preferencias;
import com.cobenapp.repository.PreferenciasRepository;

@Service
@Scope("singleton")

public class PreferenciasServiceImpl implements PreferenciasService {


	PreferenciasRepository preferenciasRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Preferencias> findAll() {
		
		return preferenciasRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public Preferencias save(Preferencias entity) throws Exception {


		return preferenciasRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public Preferencias update(Preferencias entity) throws Exception {

		if(preferenciasRepository.existsById(entity.getIdprdfcs())==false) {
			throw new Exception("La preferencia no existe");
		}
		return preferenciasRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public void delete(Preferencias entity) throws Exception {

		if(preferenciasRepository.existsById(entity.getIdprdfcs())==false) {
			throw new Exception("La preferencia no existe");
		}
		
		
		preferenciasRepository.deleteById(entity.getIdprdfcs());
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public void deleteById(Integer id) throws Exception {

		if(id==null ) {
			throw new Exception("El id es obligatorio");
		}
		
		if(preferenciasRepository.existsById(id)) {
			delete(preferenciasRepository.findById(id).get());
		}else {
			throw new Exception("La preferencia con id "+id+ " No existe");
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Preferencias> findById(Integer id) throws Exception {

		return preferenciasRepository.findById(id);
	}

	@Override
	public void validate(Preferencias entity) throws Exception {
		
		if(entity== null) {
			throw new Exception("El entity es nulo");

		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {

		return preferenciasRepository.count();
	}

	
	
	
}
