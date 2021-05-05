package italijanskirestoran.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.PiceDTO;
import italijanskirestoran.model.Pice;
import italijanskirestoran.service.PiceService;

@Component
public class PiceDtoToPice implements Converter<PiceDTO, Pice> {

	@Autowired
	private PiceService piceService;
	
	@Override
	public Pice convert(PiceDTO source) {
		Pice pice;
		
		if(source.getId() == null) {
			pice = new Pice();
		} else {
			pice = piceService.findOne(source.getId());
		}
		
		if(pice != null) {
			pice.setNaziv(source.getNaziv());
			pice.setCena(source.getCena());
			pice.setZapremina(source.getZapremina());
		}
		return pice;
	}

}
