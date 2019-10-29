package data;

public class Group implements Cloneable{
	private Integer id;
	private String name;
	private String code;

	public Group(){
		
	}
	public Group(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	public Group(Integer id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (obj == null || id == null) {
			if(this.getName().equals(other.getName())
					&& this.getCode().equals(other.getCode())
					)return true;
			else return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public Group clone() throws CloneNotSupportedException {
		return (Group)super.clone();
	}
}
