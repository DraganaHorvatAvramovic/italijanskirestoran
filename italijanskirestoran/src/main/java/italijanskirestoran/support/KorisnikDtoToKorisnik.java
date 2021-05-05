package italijanskirestoran.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import italijanskirestoran.dto.KorisnikDto;
import italijanskirestoran.model.Korisnik;
import italijanskirestoran.service.KorisnikService;

@Component
public class KorisnikDtoToKorisnik implements Converter<KorisnikDto, Korisnik>{

	@Autowired
	private KorisnikService korisnikService;

	@Override
	public Korisnik convert(KorisnikDto source) {
		Korisnik korisnik = null;
		
		if(source.getId() != null) {
            korisnik = korisnikService.findOne(source.getId()).get();
        }

        if(korisnik == null) {
            korisnik = new Korisnik();
        }
        
        korisnik.setKorisnickoIme(source.getKorisnickoIme());
        korisnik.seteMail(source.geteMail());
        korisnik.setIme(source.getIme());
        korisnik.setPrezime(source.getPrezime());

		
		return korisnik;
	}
	
}
