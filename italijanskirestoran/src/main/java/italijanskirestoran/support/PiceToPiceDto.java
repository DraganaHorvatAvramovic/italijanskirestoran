package italijanskirestoran.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.PiceDTO;
import italijanskirestoran.model.Pice;

@Component
public class PiceToPiceDto implements Converter<Pice, PiceDTO>{

	@Override
	public PiceDTO convert(Pice source) {
		PiceDTO dto = new PiceDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setCena(source.getCena());
		dto.setZapremina(source.getZapremina());
		
		return dto;
	}
	
	public List<PiceDTO> convert(List<Pice> pica){
		List<PiceDTO> picaDTO = new ArrayList<>();
		
		for(Pice p:pica) {
			picaDTO.add(convert(p));
		}
		return picaDTO;
	}

}
