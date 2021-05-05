package italijanskirestoran.dto;

public class PorudzbinaDTO {
	
	private Long id;
	
	private StoDTO stoDTO;
	
	private String placeno;
	
	private double ukupnacena;
	
	public PorudzbinaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StoDTO getStoDTO() {
		return stoDTO;
	}

	public void setStoDTO(StoDTO stoDTO) {
		this.stoDTO = stoDTO;
	}

	public String getPlaceno() {
		return placeno;
	}

	public void setPlaceno(String placeno) {
		this.placeno = placeno;
	}

	public double getUkupnacena() {
		return ukupnacena;
	}

	public void setUkupnacena(double ukupnacena) {
		this.ukupnacena = ukupnacena;
	}
	
	
	
}
