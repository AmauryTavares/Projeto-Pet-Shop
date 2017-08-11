package pet_shop.negocio.beans;

public enum EnumUF {
	AC("Acre" , "AC"),
	AL("Alagoas", "AL"),
	AM("Amazonas", "AM"),
	AP("Amap�", "AP"),
	BA("Bahia", "BA"),
	CE("Cear�", "CE"),
	DF("Distrito Federal", "DF"),
	ES("Esp�rito Santo", "ES"),
	GO("Goi�s", "GO"),
	MA("Maranh�o", "MA"),
	MG("Minas Gerais","MG"),
	MS("Mato Grosso do Sul", "MS"),
	MT("Mato Grosso", "MT"),
	PA("Par�", "PA"),
	PB("Para�ba", "PB"),
	PE("Pernambuco", "PE"),
	PI("Piau�", "PI"),
	PR("Paran�", "PR"),
	RJ("Rio de Janeiro", "RJ"),
	RN("Rio Grande do Norte", "RN"),
	RO("Rond�nia", "RO"),
	RR("Roraima", "RR"),
	RS("Rio Grande do Sul", "RS"),
	SC("Santa Catarina", "SC"),
	SE("Sergipe", "SE"),
	SP("S�o Paulo", "SP"),
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
