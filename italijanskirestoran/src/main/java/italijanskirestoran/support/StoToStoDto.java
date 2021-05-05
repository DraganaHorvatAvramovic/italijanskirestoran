package italijanskirestoran.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.StoDTO;
import italijanskirestoran.model.Sto;

@Component
public class StoToStoDto implements Converter<Sto, StoDTO> {

	@Override
	public StoDTO convert(Sto source) {
		StoDTO dto = new StoDTO();
		
		dto.setId(source.getId());
		dto.setNaziv(source.getNaziv());
		
		return dto;
	}
	
	public List<StoDTO> convert(List<Sto> stolovi){
		List<StoDTO> stoloviDTO = new ArrayList<>();
		
		for(Sto s:stolovi) {
			stoloviDTO.add(convert(s));
		}
		
		return stoloviDTO;
	}

}
