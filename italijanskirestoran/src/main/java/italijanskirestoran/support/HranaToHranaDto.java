package italijanskirestoran.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.HranaDTO;
import italijanskirestoran.model.Hrana;

@Component
public class HranaToHranaDto implements Converter<Hrana, HranaDTO> {

	@Override
	public HranaDTO convert(Hrana source) {
		HranaDTO dto = new HranaDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		dto.setCena(source.getCena());
		
		return dto;
	}
	
	public List<HranaDTO> convert(List<Hrana> hrane){
		List<HranaDTO> hraneDTO = new ArrayList<>();
		
		for(Hrana h:hrane) {
			hraneDTO.add(convert(h));
		}
		
		return hraneDTO;
	}

}
