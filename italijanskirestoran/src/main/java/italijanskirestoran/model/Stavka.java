package italijanskirestoran.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Stavka {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Porudzbina porudzbina;
	
	@ManyToOne
	private Hrana hrana;
	
	@ManyToOne
	private Prilog prilog;
	
	@ManyToOne
	private Pice pice;

	public Stavka() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Porudzbina getPorudzbina() {
		return porudzbina;
	}

	public void setPorudzbina(Porudzbina porudzbina) {
		this.porudzbina = porudzbina;
	}

	public Hrana getHrana() {
		return hrana;
	}

	public void setHrana(Hrana hrana) {
		this.hrana = hrana;
	}

	public Prilog getPrilog() {
		return prilog;
	}

	public void setPrilog(Prilog prilog) {
		this.prilog = prilog;
	}

	public Pice getPice() {
		return pice;
	}

	public void setPice(Pice pice) {
		this.pice = pice;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stavka other = (Stavka) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Stavka [id=" + id + ", porudzbina=" + porudzbina + ", hrana=" + hrana + ", prilog=" + prilog + ", pice="
				+ pice + "]";
	}
	
	
	
	

}
