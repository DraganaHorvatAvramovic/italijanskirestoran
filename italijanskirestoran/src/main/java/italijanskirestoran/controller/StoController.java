package italijanskirestoran.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import italijanskirestoran.dto.StoDTO;
import italijanskirestoran.model.Sto;
import italijanskirestoran.service.StoService;
import italijanskirestoran.support.StoDtoToSto;
import italijanskirestoran.support.StoToStoDto;

@RestController
@RequestMapping(value = "/api/stolovi",produces = MediaType.APPLICATION_JSON_VALUE)
public class StoController {
	
	@Autowired
	private StoService stoService;
	
	@Autowired
	private StoToStoDto toStoDto;
	
	@Autowired
	private StoDtoToSto toSto;
	
	@GetMapping
	public ResponseEntity<List<StoDTO>> getAll(){
		List<Sto> stolovi = stoService.findAll();
		
		return new ResponseEntity<>(toStoDto.convert(stolovi),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<StoDTO> getOne(@PathVariable Long id){
		
		Sto sto = stoService.findOne(id);
		
		if(sto != null) {
			return new ResponseEntity<>(toStoDto.convert(sto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoDTO> update(@PathVariable Long id, @Valid @RequestBody StoDTO stoDTO){
		if(!id.equals(stoDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Sto sto = toSto.convert(stoDTO);
		Sto sacuvanSto = stoService.update(sto);
		
		return new ResponseEntity<>(toStoDto.convert(sacuvanSto), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StoDTO> create(@Valid @RequestBody StoDTO stoDTO){
		Sto sto = toSto.convert(stoDTO);
		Sto sacuvanSto = stoService.save(sto);
		
		return new ResponseEntity<>(toStoDto.convert(sacuvanSto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Sto> delete (@PathVariable Long id) {
		Sto obrisanSto = stoService.delete(id);
		
		if(obrisanSto != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
