package italijanskirestoran.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Porudzbina {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@ManyToOne
	private Sto sto;
	
	@Column
	private String placeno = "nije placeno";
	
	@Column
	private double ukupnacena;
	
	@OneToMany(mappedBy = "porudzbina")
	private List<Stavka> stavke = new ArrayList<>();
	

	public Porudzbina() {
		
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Sto getSto() {
		return sto;
	}


	public void setSto(Sto sto) {
		this.sto = sto;
	}


	public String getPlaceno() {
		return placeno;
	}
	
	
	public void setPlaceno(String placeno) {
		this.placeno = placeno;
	}


	public List<Stavka> getStavke() {
		return stavke;
	}


	public void setStavke(List<Stavka> stavke) {
		this.stavke = stavke;
	}

	public double getUkupnacena() {
		return ukupnacena;
	}


	public void setUkupnacena(double ukupnacena) {
		this.ukupnacena = ukupnacena;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Porudzbina other = (Porudzbina) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Porudzbina [id=" + id + ", sto=" + sto + ", placeno=" + placeno + ", stavke=" + stavke + "]";
	}
	
	

}