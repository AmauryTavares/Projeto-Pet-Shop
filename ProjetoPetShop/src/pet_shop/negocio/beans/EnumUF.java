package pet_shop.negocio.beans;

public enum EnumUF {
	AC("Acre"),
	AL("Alagoas"),
	AM("Amazonas"),
	AP("Amapá"),
	BA("Bahia"),
	CE("Ceará"),
	DF("Distrito Federal"),
	ES("Espírito Santo"),
	GO("Goiás"),
	MA("Maranhão"),
	MG("Minas Gerais"),
	MS("Mato Grosso do Sul"),
	MT("Mato Grosso"),
	PA("Pará"),
	PB("Paraíba"),
	PE("Pernambuco"),
	PI("Piauí"),
	PR("Paraná"),
	RJ("Rio de Janeiro"),
	RN("Rio Grande do Norte"),
	RO("Rondônia"),
	RR("Roraima"),
	RS("Rio Grande do Sul"),
	SC("Santa Catarina"),
	SE("Sergipe"),
	SP("São Paulo"),
	TO("Tocantins");
	
	private String nome;
	
    EnumUF(String nome){
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}
 
}
