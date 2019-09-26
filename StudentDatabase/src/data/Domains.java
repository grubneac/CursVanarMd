package data;
//список направлений обучения
public enum Domains {

	PROGRAMMING("Программирование"),
	MATHS("Математика"),
	PHISICS("Физика");
	
	String name;

	private Domains(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString(){
		return name;
	}
}
