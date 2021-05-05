package italijanskirestoran.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.StavkaDTO;
import italijanskirestoran.model.Stavka;
import italijanskirestoran.service.HranaService;
import italijanskirestoran.service.PiceService;
import italijanskirestoran.service.PorudzbinaService;
import italijanskirestoran.service.PrilogService;
import italijanskirestoran.service.StavkaService;

@Component
public class StavkaDtoToStavka implements Converter<StavkaDTO, Stavka> {

	@Autowired
	private StavkaService stavkaService;
	
	@Autowired
	private PorudzbinaService porudzbinaService;
	
	@Autowired
	private HranaService hranaService;
	
	@Autowired
	private PrilogService prilogService;
	
	@Autowired
	private PiceService piceService;
	
	@Override
	public Stavka convert(StavkaDTO source) {
		Stavka stavka;
		
		if(source.getId() == null) {
			stavka = new Stavka();
		} else {
			stavka = stavkaService.findOne(source.getId());
		}
		
		if(stavka != null) {
			if(source.getPorudzbinaDTO() != null) {
				stavka.setPorudzbina(porudzbinaService.findOne(source.getPorudzbinaDTO().getId()));
			}
			if(source.getHranaDTO() != null) {
				stavka.setHrana(hranaService.findOne(source.getHranaDTO().getId()));
			}
			if(source.getPrilogDTO() != null) {
				stavka.setPrilog(prilogService.findOne(source.getPrilogDTO().getId()));
			}
			if(source.getPiceDTO() != null) {
				stavka.setPice(piceService.findOne(source.getPiceDTO().getId()));
			}
		}
		return stavka;
	}

}
