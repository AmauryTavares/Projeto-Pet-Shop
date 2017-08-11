package pet_shop.negocio.beans;

import java.io.Serializable;

public class Endereco implements Serializable{

	private static final long serialVersionUID = -2086842017446725271L;
	private EnumUF uf;
	private String rua;
	private String numCasa;
	private String bairro;
	private String cidade;
	
	public Endereco (String rua, String numCasa, String bairro, String cidade, EnumUF uf) {
		this.setRua(rua);
		this.setNumCasa(numCasa);
		this.setBairro(bairro);
		this.setCidade(cidade);
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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
		if (cidade == null) {
			if (other.cidade != null)
				return false;
		} else if (!cidade.equals(other.cidade))
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
				", " + this.getCidade() + "\n";
	}
	
	

}
