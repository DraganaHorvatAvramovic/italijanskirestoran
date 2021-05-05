package italijanskirestoran.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.StavkaDTO;
import italijanskirestoran.model.Stavka;

@Component
public class StavkaToStavkaDto implements Converter<Stavka, StavkaDTO> {

	@Autowired
	private PorudzbinaToPorudzbinaDto porudzbinaToPorudzbinaDto;
	
	@Autowired
	private HranaToHranaDto hranaToHranaDto;
	
	@Autowired
	private PrilogToPrilogDto prilogToPrilogDto;
	
	@Autowired
	private PiceToPiceDto piceToPiceDto;
	
	@Override
	public StavkaDTO convert(Stavka source) {
		StavkaDTO dto = new StavkaDTO();
		
		dto.setId(source.getId());
		dto.setPorudzbinaDTO(porudzbinaToPorudzbinaDto.convert(source.getPorudzbina()));
		dto.setHranaDTO(hranaToHranaDto.convert(source.getHrana()));
		dto.setPrilogDTO(prilogToPrilogDto.convert(source.getPrilog()));
		dto.setPiceDTO(piceToPiceDto.convert(source.getPice()));
		
		return dto;
	}
	
	public List<StavkaDTO> convert(List<Stavka> stavke){
		List<StavkaDTO> stavkeDTO = new ArrayList<>();
		
		for(Stavka s:stavke) {
			stavkeDTO.add(convert(s));
		}
		return stavkeDTO;
	}

}
