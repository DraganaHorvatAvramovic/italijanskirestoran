package italijanskirestoran.dto;

public class StavkaDTO {
	
	private Long id;
	
	private PorudzbinaDTO porudzbinaDTO;
	
	private HranaDTO hranaDTO;
	
	private PrilogDTO prilogDTO;
	
	private PiceDTO piceDTO;

	public StavkaDTO() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PorudzbinaDTO getPorudzbinaDTO() {
		return porudzbinaDTO;
	}

	public void setPorudzbinaDTO(PorudzbinaDTO porudzbinaDTO) {
		this.porudzbinaDTO = porudzbinaDTO;
	}

	public HranaDTO getHranaDTO() {
		return hranaDTO;
	}

	public void setHranaDTO(HranaDTO hranaDTO) {
		this.hranaDTO = hranaDTO;
	}

	public PrilogDTO getPrilogDTO() {
		return prilogDTO;
	}

	public void setPrilogDTO(PrilogDTO prilogDTO) {
		this.prilogDTO = prilogDTO;
	}

	public PiceDTO getPiceDTO() {
		return piceDTO;
	}

	public void setPiceDTO(PiceDTO piceDTO) {
		this.piceDTO = piceDTO;
	}
	
	
	

}
