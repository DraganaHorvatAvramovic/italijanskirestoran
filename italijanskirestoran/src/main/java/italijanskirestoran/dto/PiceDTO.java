package italijanskirestoran.dto;

public class PiceDTO {
	
	private Long id;
	
	private String naziv;
	
	private double cena;
	
	private double zapremina;

	public PiceDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public double getZapremina() {
		return zapremina;
	}

	public void setZapremina(double zapremina) {
		this.zapremina = zapremina;
	}
	
	


}
