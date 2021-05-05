package italijanskirestoran.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.PrilogDTO;
import italijanskirestoran.model.Prilog;
import italijanskirestoran.service.PrilogService;

@Component
public class PrilogDtoToPrilog implements Converter<PrilogDTO, Prilog> {

	@Autowired
	private PrilogService prilogService;
	
	@Override
	public Prilog convert(PrilogDTO source) {
		Prilog prilog;
		
		if(source.getId() == null) {
			prilog = new Prilog();
		} else {
			prilog = prilogService.findOne(source.getId());
		}
		
		if(prilog != null) {
			prilog.setNaziv(source.getNaziv());
			prilog.setCena(source.getCena());
		}
		
		return prilog;
	}

}
