package pet_shop.negocio.beans;

public class Endereco {
	
	private EnumUF uf;
	private String rua;
	private String numCasa;
	private String bairro;
	private String complemento;
	
	public Endereco (String rua, String numCasa, String bairro, String complemento, EnumUF uf) {
		this.setRua(rua);
		this.setNumCasa(numCasa);
		this.setBairro(bairro);
		this.setComplemento(complemento);
		this.setUf(uf);
	}

	public EnumUF getUf() {
		return uf;
	}

	public void setUf(EnumUF uf) {
		this.uf = uf;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		if (bairro == null) {
			if (other.bairro != null)
				return false;
		} else if (!bairro.equals(other.bairro))
			return false;
		if (complemento == null) {
			if (other.complemento != null)
				return false;
		} else if (!complemento.equals(other.complemento))
			return false;
		if (numCasa == null) {
			if (other.numCasa != null)
				return false;
		} else if (!numCasa.equals(other.numCasa))
			return false;
		if (rua == null) {
			if (other.rua != null)
				return false;
		} else if (!rua.equals(other.rua))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Endereco: " + this.getRua() + ", " + this.getNumCasa() + ", " + this.getBairro() +
				", " + this.getComplemento() + "\n";
	}
	
	

}
