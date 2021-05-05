package italijanskirestoran.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.StoDTO;
import italijanskirestoran.model.Sto;
import italijanskirestoran.service.StoService;

@Component
public class StoDtoToSto implements Converter<StoDTO, Sto> {

	@Autowired
	private StoService stoService;
	
	@Override
	public Sto convert(StoDTO source) {
		Sto sto;
		
		if(source.getId() == null) {
			sto = new Sto();
		} else {
			sto = stoService.findOne(source.getId());
		}
		
		if(sto != null) {
			sto.setNaziv(source.getNaziv());
		}
		return sto;
	}

}
