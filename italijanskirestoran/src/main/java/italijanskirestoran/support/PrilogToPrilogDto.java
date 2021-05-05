package italijanskirestoran.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.PrilogDTO;
import italijanskirestoran.model.Prilog;

@Component
public class PrilogToPrilogDto implements Converter<Prilog, PrilogDTO> {

	@Override
	public PrilogDTO convert(Prilog source) {
		PrilogDTO dto = new PrilogDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setCena(source.getCena());
		
		return dto;
	}
	
	public List<PrilogDTO> convert(List<Prilog> prilozi){
		List<PrilogDTO> priloziDTO = new ArrayList<>();
		
		for(Prilog p:prilozi) {
			priloziDTO.add(convert(p));
		}
		return priloziDTO;
	}

}
