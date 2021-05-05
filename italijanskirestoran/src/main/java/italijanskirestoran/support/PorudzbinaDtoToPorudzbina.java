package italijanskirestoran.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.PorudzbinaDTO;
import italijanskirestoran.model.Porudzbina;
import italijanskirestoran.service.PorudzbinaService;
import italijanskirestoran.service.StoService;

@Component
public class PorudzbinaDtoToPorudzbina implements Converter<PorudzbinaDTO, Porudzbina> {

	@Autowired
	private PorudzbinaService porudzbinaService;
	
	@Autowired
	private StoService stoService;
	
	@Override
	public Porudzbina convert(PorudzbinaDTO source) {
		Porudzbina porudzbina;
		
		if(source.getId() == null) {
			porudzbina = new Porudzbina();
		} else {
			porudzbina = porudzbinaService.findOne(source.getId());
		}
		
		if(porudzbina != null) {
			if(source.getStoDTO() != null) {
				porudzbina.setSto(stoService.findOne(source.getStoDTO().getId()));
			}
			porudzbina.setPlaceno(source.getPlaceno());
			porudzbina.setUkupnacena(source.getUkupnacena());
		}
		return porudzbina;
	}

}
