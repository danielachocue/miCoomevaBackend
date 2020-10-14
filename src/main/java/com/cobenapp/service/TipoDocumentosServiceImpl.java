package com.cobenapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.cobenapp.domain.TipoDocumentos;
import com.cobenapp.repository.TipoDocumentosRepository;

public class TipoDocumentosServiceImpl implements TipoDocumentosService {

	TipoDocumentosRepository tipoDocumentosRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoDocumentos> findAll() {

		return null;
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)
	public TipoDocumentos save(TipoDocumentos entity) throws Exception {

		validate(entity);
		
		return null;
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public TipoDocumentos update(TipoDocumentos entity) throws Exception {

	
		
		if(tipoDocumentosRepository.existsById(entity.getIdTipo())==false) {
			throw new Exception("Ese proveedor no existe");
		}
		
		
		return tipoDocumentosRepository.save(entity);	

	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public void delete(TipoDocumentos entity) throws Exception {
		if(tipoDocumentosRepository.existsById(entity.getIdTipo())==false) {
			throw new Exception("Ese proveedor no existe");
		}
		tipoDocumentosRepository.findById(entity.getIdTipo()).ifPresent(tipoDocumentos ->{
			if(tipoDocumentos.getAsociados()!=null && tipoDocumentos.getAsociados().isEmpty()==false) {
				throw new RuntimeException("El proveedor con id:"+entity.getIdTipo()+"tiene asociados");
			}
		});
		
		tipoDocumentosRepository.deleteById(entity.getIdTipo());
		
	}

	@Override
	@Transactional(readOnly = false,propagation=Propagation.REQUIRED,rollbackFor = Exception.class)

	public void deleteById(Integer id) throws Exception {

		if(id==null ) {
			throw new Exception("El id es obligatorio");
		}
		
		if(tipoDocumentosRepository.existsById(id)) {
			delete(tipoDocumentosRepository.findById(id).get());
		}else {
			throw new Exception("El tipo documento con id "+id+ " No existe");
		}
	}

	@Override
	@Transactional(readOnly = true)

	public Optional<TipoDocumentos> findById(Integer id) throws Exception {

		return tipoDocumentosRepository.findById(id);
	}

	@Override
	public void validate(TipoDocumentos entity) throws Exception {

		if(entity == null) {
			throw new Exception("El entity es null");
		}
		if(entity.getTipo().isBlank() == true || entity.getTipo().isEmpty() == true) {
			throw new Exception("El tipo es null");
		}
		
	}

	@Override
	public Long count() {

		return tipoDocumentosRepository.count();
	}

}
