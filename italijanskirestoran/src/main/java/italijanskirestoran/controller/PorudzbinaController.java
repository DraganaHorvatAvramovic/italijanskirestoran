package italijanskirestoran.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
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

import italijanskirestoran.dto.PorudzbinaDTO;
import italijanskirestoran.model.Porudzbina;
import italijanskirestoran.model.Stavka;
import italijanskirestoran.service.PorudzbinaService;
import italijanskirestoran.support.PorudzbinaDtoToPorudzbina;
import italijanskirestoran.support.PorudzbinaToPorudzbinaDto;

@RestController
@RequestMapping(value = "/api/porudzbine",produces = MediaType.APPLICATION_JSON_VALUE)
public class PorudzbinaController {
	
	@Autowired
	private PorudzbinaService porudzbinaService;
	
	@Autowired
	private PorudzbinaToPorudzbinaDto toPorudzbinaDto;
	
	@Autowired
	private PorudzbinaDtoToPorudzbina toPorudzbina;
	
	@GetMapping
	public ResponseEntity<List<PorudzbinaDTO>> getAll(
			@RequestParam(required=false) Long stoId,
			@RequestParam(defaultValue = "0") int pageNo){
		
		Page<Porudzbina> porudzbinaPage = porudzbinaService.pretraga(stoId, pageNo);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("Total-Pages", porudzbinaPage.getTotalPages() + "");
		
		return new ResponseEntity<>(toPorudzbinaDto.convert(porudzbinaPage.getContent()), responseHeaders, HttpStatus.OK);
	}
	@GetMapping("/sve")
	public ResponseEntity<List<PorudzbinaDTO>> getSve(){
		List<Porudzbina> porudzbine = porudzbinaService.findAll();
		
		return new ResponseEntity<>(toPorudzbinaDto.convert(porudzbine), HttpStatus.OK);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<PorudzbinaDTO> getOne(@PathVariable Long id){
		
		Porudzbina porudzbina = porudzbinaService.findOne(id);
		
		if(porudzbina != null) {
			return new ResponseEntity<>(toPorudzbinaDto.convert(porudzbina), HttpStatus.OK);
		} else {
			 return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PorudzbinaDTO> naplata (@PathVariable Long id) {
		Porudzbina porudzbina = porudzbinaService.findOne(id);
		
		if(porudzbina.getPlaceno().equals("placeno")) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			porudzbina.setPlaceno("placeno");
			double ukupnacena = 0.0;
			List<Stavka> stavke = porudzbina.getStavke();
			for(int i=0; i<stavke.size(); i++) {
				Stavka sacuvanaStavka = stavke.get(i);
				ukupnacena += sacuvanaStavka.getHrana().getCena() + sacuvanaStavka.getPrilog().getCena() + sacuvanaStavka.getPice().getCena();
			}
			porudzbina.setUkupnacena(ukupnacena);
			Porudzbina sacuvnaPorudzbina = porudzbinaService.update(porudzbina);
			
			return new ResponseEntity<>(toPorudzbinaDto.convert(sacuvnaPorudzbina), HttpStatus.OK);
		}
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PorudzbinaDTO> create(@Valid @RequestBody PorudzbinaDTO porudzbinaDTO){
		
		Porudzbina porudzbina = toPorudzbina.convert(porudzbinaDTO);
		List<Porudzbina> porudzbine = porudzbinaService.findAll();
		for(int i =  0; i < porudzbine.size(); i++) {
			Porudzbina porudbzinaIzListe = porudzbine.get(i);
			if(porudbzinaIzListe.getSto().getId() == porudzbina.getSto().getId()) {
				if (porudbzinaIzListe.getPlaceno().equals("nije placeno")) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
				
				
					
				
			} 
		}
		Porudzbina sacuvanaPorudzbina = porudzbinaService.save(porudzbina);
		
		return new ResponseEntity<>(toPorudzbinaDto.convert(sacuvanaPorudzbina), HttpStatus.CREATED);
		
			
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Porudzbina> delete(@PathVariable Long id){
		Porudzbina obrisanaPorudzbina = porudzbinaService.delete(id);
		
		if(obrisanaPorudzbina != null) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
