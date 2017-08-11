package pet_shop.negocio.beans;

public enum EnumUF {
	AC("Acre" , "AC"),
	AL("Alagoas", "AL"),
	AM("Amazonas", "AM"),
	AP("Amapá", "AP"),
	BA("Bahia", "BA"),
	CE("Ceará", "CE"),
	DF("Distrito Federal", "DF"),
	ES("Espírito Santo", "ES"),
	GO("Goiás", "GO"),
	MA("Maranhão", "MA"),
	MG("Minas Gerais","MG"),
	MS("Mato Grosso do Sul", "MS"),
	MT("Mato Grosso", "MT"),
	PA("Pará", "PA"),
	PB("Paraíba", "PB"),
	PE("Pernambuco", "PE"),
	PI("Piauí", "PI"),
	PR("Paraná", "PR"),
	RJ("Rio de Janeiro", "RJ"),
	RN("Rio Grande do Norte", "RN"),
	RO("Rondônia", "RO"),
	RR("Roraima", "RR"),
	RS("Rio Grande do Sul", "RS"),
	SC("Santa Catarina", "SC"),
	SE("Sergipe", "SE"),
	SP("São Paulo", "SP"),
	TO("Tocantins", "TO");
	
	private String nome;
	private String sigla;
	
    EnumUF(String nome, String sigla){
		this.nome = nome;
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public String getSigla() {
		return sigla;
	}
 
}
