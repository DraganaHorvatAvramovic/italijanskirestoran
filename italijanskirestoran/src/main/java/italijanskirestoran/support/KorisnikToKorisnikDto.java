package italijanskirestoran.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.KorisnikDto;
import italijanskirestoran.model.Korisnik;

@Component
public class KorisnikToKorisnikDto implements Converter<Korisnik, KorisnikDto> {

	@Override
	public KorisnikDto convert(Korisnik source) {
		KorisnikDto korisnikDTO = new KorisnikDto();
		
		korisnikDTO.setId(source.getId());
		korisnikDTO.seteMail(source.geteMail());
		korisnikDTO.setIme(source.getIme());
		korisnikDTO.setPrezime(source.getPrezime());
		korisnikDTO.setKorisnickoIme(source.getKorisnickoIme());
		return korisnikDTO;
	}
	
	public List<KorisnikDto> convert(List<Korisnik> korisnici){
		List<KorisnikDto> korisnikDTOS =  new ArrayList<>();
		
		for(Korisnik k: korisnici) {
			KorisnikDto dto = convert(k);
			korisnikDTOS.add(dto);
		}
		
		return korisnikDTOS;
	}

}
