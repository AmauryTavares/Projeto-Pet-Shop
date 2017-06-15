package br.ufrpe.social_network.negocio.beans;

import java.time.LocalDate;

public class Person {

    private static long nextId = 1;
    
    private long id;
    private String name;
    private String country;
    private LocalDate birthDate;
    
    public Person(String name, String country, LocalDate birthDate) {
        // auto-generated ID
        this.id = nextId;
        nextId++;
        
        this.name = name;
        this.country = country;
        this.birthDate = birthDate;
    }
    
    public Person() {
        this(null, null, null);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    
    @Override
    public String toString() {
        return "ID: " + this.id + "\nName: " + this.name +"\nCountry: " + this.country + "\nBirthDate: " + this.birthDate + "\n";
    }

	@Override
	public boolean equals(Object obj) {     //Gerei esse equals para usar na verificação de Persons e Posts / obs: sem id na comparação
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (birthDate == null) {
			if (other.birthDate != null)
				return false;
		} else if (!birthDate.equals(other.birthDate))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
    
    
}
