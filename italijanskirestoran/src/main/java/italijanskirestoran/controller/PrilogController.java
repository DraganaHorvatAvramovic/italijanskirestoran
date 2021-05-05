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

import italijanskirestoran.dto.PrilogDTO;
import italijanskirestoran.model.Prilog;
import italijanskirestoran.service.PrilogService;
import italijanskirestoran.support.PrilogDtoToPrilog;
import italijanskirestoran.support.PrilogToPrilogDto;

@RestController
@RequestMapping(value = "/api/prilozi",produces = MediaType.APPLICATION_JSON_VALUE)
public class PrilogController {
	
	@Autowired
	private PrilogService prilogService;
	
	@Autowired
	private PrilogToPrilogDto toPrilogDto;
	
	@Autowired
	private PrilogDtoToPrilog toPrilog;
	
	@GetMapping
	public ResponseEntity<List<PrilogDTO>> getAll(){
		List<Prilog> prilozi = prilogService.findAll();
		
		return new ResponseEntity<>(toPrilogDto.convert(prilozi), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PrilogDTO> getOne(@PathVariable Long id){
		
		Prilog prilog = prilogService.findOne(id);
		
		if(prilog != null) {
			return new ResponseEntity<>(toPrilogDto.convert(prilog), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrilogDTO> update(@PathVariable Long id, @Valid @RequestBody PrilogDTO prilogDTO){
		if(!id.equals(prilogDTO.getId())) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Prilog prilog = toPrilog.convert(prilogDTO);
		Prilog sacuvanPrilog = prilogService.update(prilog);
		
		return new ResponseEntity<>(toPrilogDto.convert(sacuvanPrilog), HttpStatus.OK);
			
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PrilogDTO> create(@Valid @RequestBody PrilogDTO prilogDTO){
		
		Prilog prilog = toPrilog.convert(prilogDTO);
		Prilog sacuvanPrilog = prilogService.save(prilog);
		
		return new ResponseEntity<>(toPrilogDto.convert(sacuvanPrilog), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Prilog> delete(@PathVariable Long id){
		Prilog obrisanPrilog = prilogService.delete(id);
		
		if(obrisanPrilog != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
