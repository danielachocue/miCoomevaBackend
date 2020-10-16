package com.cobenapp.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cobenapp.domain.TipoDocumentos;
import com.cobenapp.dto.TipoDocumentosDTO;
import com.cobenapp.mapper.TipoDocumentosMapper;
import com.cobenapp.service.TipoDocumentosService;

@RestController
@RequestMapping("/api/tipoDocumentos")
@CrossOrigin("*")
public class TipoDocumentosController {
	
	public static Logger log=LoggerFactory.getLogger(TipoDocumentosController.class);
	
	//Iyeccion de dependencia
	@Autowired
	TipoDocumentosService tipoDocumentoService;
	
	@Autowired
	TipoDocumentosMapper tipoDocumentoMapper;
	
	//crea y guarda un nuevo asocicado
	@PostMapping("/save")
	public ResponseEntity<?> save(@Valid @RequestBody TipoDocumentosDTO tipoDocumentosDTO) throws Exception{
		
		TipoDocumentos tipoDocumentos=tipoDocumentoMapper.toTipoDocumento(tipoDocumentosDTO);
		tipoDocumentos=tipoDocumentoService.update(tipoDocumentos);
		
		return ResponseEntity.ok().body(tipoDocumentosDTO);
	}
	
	//modifica un asociado
	@PutMapping("/update")
	public ResponseEntity<?> update(@Valid @RequestBody TipoDocumentosDTO tipoDocumentosDTO) throws Exception{
		
		TipoDocumentos tipoDocumentos=tipoDocumentoMapper.toTipoDocumento(tipoDocumentosDTO);
		tipoDocumentos=tipoDocumentoService.update(tipoDocumentos);
		
		return ResponseEntity.ok().body(tipoDocumentosDTO);
	}
	
	//Se crea el metodo de tipo DTO verificando que exista el asociado
	@DeleteMapping("/delete/{idTipo}")
	public ResponseEntity<?> delete(@PathVariable("idTipo") Integer idTipo) throws Exception{
		
		tipoDocumentoService.deleteById(idTipo);
		
		return ResponseEntity.ok().build();
	}
	
	//busca todos los asociados
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() throws Exception{
		
		//se crea una lista de asociados con todos los asociados
		List<TipoDocumentos> tipoDocumentos=tipoDocumentoService.findAll();
		///se crea una lista de asociadosDTO
		List<TipoDocumentosDTO> tipoDocumentosDTOS=tipoDocumentoMapper.toTipoDocumentosDTO(tipoDocumentos);
		
		return ResponseEntity.ok().body(tipoDocumentosDTOS);
	}
	
	//se crea el metodo de tipo DTO verificando que exista el asociado
	@GetMapping("/findById/{idTipo}")
	public ResponseEntity<?> findById(@PathVariable("idTipo") Integer idTipo) throws Exception{
		
		Optional<TipoDocumentos> tipoDocumentosOptional=tipoDocumentoService.findById(idTipo);
		if(tipoDocumentosOptional.isPresent()==false) {
			
			return ResponseEntity.ok().body("Tipo de documento Not Found");	
		}
		
		TipoDocumentos tipoDocumentos=tipoDocumentosOptional.get();
		
		TipoDocumentosDTO tipoDocumentosDTO=tipoDocumentoMapper.toTipoDocuementoDTO(tipoDocumentos);
		
		return ResponseEntity.ok().body(tipoDocumentosDTO);
	}

}
