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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import italijanskirestoran.dto.StavkaDTO;
import italijanskirestoran.model.Stavka;
import italijanskirestoran.service.PorudzbinaService;
import italijanskirestoran.service.StavkaService;
import italijanskirestoran.support.StavkaDtoToStavka;
import italijanskirestoran.support.StavkaToStavkaDto;

@RestController
@RequestMapping(value = "/api/stavke",produces = MediaType.APPLICATION_JSON_VALUE)
public class StavkeController {
	
	@Autowired 
	private StavkaService stavkaService;
	
	@Autowired
	private StavkaToStavkaDto toStavkaDto;
	
	@Autowired
	private StavkaDtoToStavka toStavka;
	
	@Autowired
	private PorudzbinaService porudzbinaService;
	
	@GetMapping
	public ResponseEntity<List<StavkaDTO>> getAll(@RequestParam(required = false) Long id){
		
		List<Stavka> stavke;
		stavke = stavkaService.find(id);
	
		return new ResponseEntity<>(toStavkaDto.convert(stavke), HttpStatus.OK);
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StavkaDTO> create(
			@RequestParam(required = false) Long id,
			@Valid @RequestBody StavkaDTO stavkaDTO){
		
		List<Stavka> stavke = stavkaService.find(id);
		
		Stavka stavka = toStavka.convert(stavkaDTO);
		if(id == stavka.getPorudzbina().getId()) {
			Stavka sacuvanaStavka=stavkaService.save(stavka);
			stavke.add(sacuvanaStavka);
			
			return new ResponseEntity<>(toStavkaDto.convert(sacuvanaStavka), HttpStatus.CREATED);
			
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}	
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<StavkaDTO> update(@PathVariable Long id, @Valid @RequestBody StavkaDTO stavkaDTO){
		if(!id.equals(stavkaDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Stavka stavka = toStavka.convert(stavkaDTO);
		Stavka sacuvanaStavka = stavkaService.save(stavka);
		
		porudzbinaService.update(sacuvanaStavka.getPorudzbina());
		
		return new ResponseEntity<>(toStavkaDto.convert(sacuvanaStavka), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Stavka> delete (@PathVariable Long id) {
		
		Stavka obrisanaStavka = stavkaService.delete(id);
		
		if(obrisanaStavka != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
