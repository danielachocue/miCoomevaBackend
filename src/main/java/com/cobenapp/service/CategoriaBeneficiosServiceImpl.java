package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.CategoriaBeneficios;
import com.cobenapp.repository.CategoriaBeneficiosRepository;

@Service
@Scope("singleton")
public class CategoriaBeneficiosServiceImpl implements CategoriaBeneficiosService{

	CategoriaBeneficiosRepository categoriaBeneficiosRepository;

	@Transactional(readOnly = true)
	@Override
	public List<CategoriaBeneficios> findAll() {
	
		return categoriaBeneficiosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public CategoriaBeneficios save(CategoriaBeneficios entity) throws Exception {
		
		validate(entity);
		
		
		return categoriaBeneficiosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public CategoriaBeneficios update(CategoriaBeneficios entity) throws Exception {
		
		if(categoriaBeneficiosRepository.existsById(entity.getIdCat())==false) {
			throw new Exception("Esa categoria no existe");
		}
		
		
		return categoriaBeneficiosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delete(CategoriaBeneficios entity) throws Exception {
		if(categoriaBeneficiosRepository.existsById(entity.getIdCat())==false) {
			throw new Exception("Esa categoria no existe");
		}
		categoriaBeneficiosRepository.findById(entity.getIdCat()).ifPresent(categoria ->{
			if(categoria.getBeneficios()!=null && categoria.getBeneficios().isEmpty()==false) {
				throw new RuntimeException("La categoria con id:"+entity.getIdCat()+"tiene beneficios asociados");
			}
		});
		
		categoriaBeneficiosRepository.deleteById(entity.getIdCat());
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		
		if(id==null ) {
			throw new Exception("El id es obligatorio");
		}
		
		if(categoriaBeneficiosRepository.existsById(id)) {
			delete(categoriaBeneficiosRepository.findById(id).get());
		}else {
			throw new Exception("La categoria con id "+id+ " No existe");
		}
		
		
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<CategoriaBeneficios> findById(Integer id) throws Exception {
	
		return categoriaBeneficiosRepository.findById(id);
	}

	
	@Override
	public void validate(CategoriaBeneficios entity) throws Exception {
		
		if(entity == null) {
			throw new Exception("El entity es nulo");
		}
		
		if(entity.getCategoria().isEmpty() == true || entity.getCategoria().isBlank() == true) {
			throw new Exception("El beneficio está vacio o nulo");
		}
		
		
	}

	@Transactional(readOnly = true)
	@Override
	public Long count() {
		
		return categoriaBeneficiosRepository.count();
	}
	
}
