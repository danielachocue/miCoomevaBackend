package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.Beneficios;
import com.cobenapp.repository.BeneficiosRepository;

@Service
@Scope("singleton")
public class BeneficiosServiceImpl implements BeneficiosService {

	@Autowired
	BeneficiosRepository beneficiosRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Beneficios> findAll() {

		
		return beneficiosRepository.findAll() ;
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public Beneficios save(Beneficios entity) throws Exception {
		validate(entity);
		

		return beneficiosRepository.save(entity);
		
	
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public Beneficios update(Beneficios entity) throws Exception {
		validate(entity);
		

		if(beneficiosRepository.existsById(entity.getidBeneficio()) == false) {
			throw new Exception("El beneficio con id: "+entity.getidBeneficio()+" no existe");
		}
		
		return beneficiosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delete(Beneficios entity) throws Exception {
		validate(entity);
	
		
		beneficiosRepository.findById(entity.getidBeneficio()).ifPresent(beneficio ->{
			if(beneficio.getPreferencias()!=null && beneficio.getPreferencias().isEmpty()==false) {
				throw new RuntimeException("El asociado con id:"+entity.getidBeneficio()+"tiene preferencias");
			}
			
			if(beneficio.getProveedores()!=null) {
				throw new RuntimeException("El asociado con id:"+entity.getidBeneficio()+"tiene usos de beneficios");
			}
		});
		
		beneficiosRepository.deleteById(entity.getidBeneficio());
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
	
		
		if(id==null ) {
			throw new Exception("El id es obligatoria");
		}
		
		if(beneficiosRepository.existsById(id)) {
			delete(beneficiosRepository.findById(id).get());
		}else {
			throw new Exception("El beneficio con id "+id+ " No existe");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Beneficios> findById(Integer id) throws Exception {

		
		return beneficiosRepository.findById(id);
	}

	@Override
	public void validate(Beneficios entity) throws Exception {

		if(entity==null) {
			throw new Exception("El entity es nulo");
		}
		
		if(entity.getBeneficio().isBlank() == true || entity.getBeneficio().isEmpty() ==true) {
			throw new Exception("El beneficio es nulo");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {

		
		return beneficiosRepository.count();
	}

}
