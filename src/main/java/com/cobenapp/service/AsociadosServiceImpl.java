package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.Asociados;
import com.cobenapp.repository.AsociadosRepository;

@Service
@Scope("singleton")
public class AsociadosServiceImpl implements AsociadosService{

	@Autowired
	AsociadosRepository asociadosRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<Asociados> findAll() {
	
		return asociadosRepository.findAll();
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public Asociados save(Asociados entity) throws Exception {
		
		validate(entity);
		
		if(asociadosRepository.existsById(entity.getDocumento()) == true) {
			throw new Exception("El asociado ya existe");
		}
		
		
		return asociadosRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public Asociados update(Asociados entity) throws Exception {
		
		validate(entity);
		

		if(asociadosRepository.existsById(entity.getDocumento()) == false) {
			throw new Exception("El customer con id: "+entity.getDocumento()+" no existe");
		}
		
		return asociadosRepository.save(entity);
		
		
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void delete(Asociados entity) throws Exception {
		
		validate(entity);
		
		asociadosRepository.findById(entity.getDocumento()).ifPresent(asociado ->{
			if(asociado.getPreferencias()!=null && asociado.getPreferencias().isEmpty()==false) {
				throw new RuntimeException("El asociado con id:"+entity.getDocumento()+"tiene preferencias");
			}
			
			if(asociado.getUsobeneficios()!=null && asociado.getUsobeneficios().isEmpty()==false) {
				throw new RuntimeException("El asociado con id:"+entity.getDocumento()+"tiene usos de beneficios");
			}
		});
		
		asociadosRepository.deleteById(entity.getDocumento());
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public void deleteById(String id) throws Exception {
		if(id==null || id.isBlank() ==true) {
			throw new Exception("La dirección es obligatoria");
		}
		
		if(asociadosRepository.existsById(id)) {
			delete(asociadosRepository.findById(id).get());
		}else {
			throw new Exception("El asociado con id "+id+ " No existe");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Asociados> findById(String id) throws Exception {
	
		return asociadosRepository.findById(id);
	}

	@Override
	public void validate(Asociados entity) throws Exception {
		if(entity==null) {
			throw new Exception("El asociado es nulo");
		}
		
		if(entity.getNickname().isBlank() ==true || entity.getNickname().isEmpty()==true) {
			throw new Exception("El nickname es nulo");
		}
		
		if(entity.getNombre().isBlank() ==true || entity.getNombre().isEmpty()==true) {
			throw new Exception("El nombre es nulo");
		}
		
		if(entity.getApellido().isBlank() ==true || entity.getApellido().isEmpty()==true) {
			throw new Exception("El apellido es nulo");
		}
		
		if(entity.getDocumento().isBlank() ==true || entity.getDocumento().isEmpty()==true) {
			throw new Exception("El documento es nulo");
		}
		
		if(entity.getContrasena().isBlank() ==true || entity.getContrasena().isEmpty()==true) {
			throw new Exception("La Contrasena es nulo");
		}
		
		if(entity.getTelefono().isBlank() ==true || entity.getTelefono().isEmpty()==true) {
			throw new Exception("El telefono es nulo");
		}
		
		if(entity.getPuntos().isBlank() ==true || entity.getPuntos().isEmpty()==true) {
			throw new Exception("El puntos es nulo");
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public Long count() {
	
		return asociadosRepository.count();
	}

	

	
}
