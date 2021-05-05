package italijanskirestoran.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.PorudzbinaDTO;
import italijanskirestoran.model.Porudzbina;

@Component
public class PorudzbinaToPorudzbinaDto implements Converter<Porudzbina, PorudzbinaDTO> {

	@Autowired
	private StoToStoDto stoToStoDto;
	
	@Override
	public PorudzbinaDTO convert(Porudzbina source) {
		PorudzbinaDTO dto = new PorudzbinaDTO();
		
		dto.setId(source.getId());
		dto.setPlaceno(source.getPlaceno());
		dto.setStoDTO(stoToStoDto.convert(source.getSto()));
		dto.setUkupnacena(source.getUkupnacena());
		
		return dto;
	}
	
	public List<PorudzbinaDTO> convert(List<Porudzbina> porudzbine){
		List<PorudzbinaDTO> porudzbineDTO = new ArrayList<>();
		
		for(Porudzbina p:porudzbine) {
			porudzbineDTO.add(convert(p));
		}
		return porudzbineDTO;
	}

}
