package italijanskirestoran.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.HranaDTO;
import italijanskirestoran.model.Hrana;
import italijanskirestoran.service.HranaService;

@Component
public class HranaDtoToHrana implements Converter<HranaDTO, Hrana> {

	@Autowired
	private HranaService hranaService;
	
	@Override
	public Hrana convert(HranaDTO source) {
		Hrana hrana;
		
		if(source.getId() == null) {
			hrana = new Hrana();
		} else {
			hrana = hranaService.findOne(source.getId());
		}
		
		if(hrana != null) {
			hrana.setNaziv(source.getNaziv());
			hrana.setCena(source.getCena());
		}
		
		return hrana;
	}

}
