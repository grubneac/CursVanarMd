package data;

public class Group {
	private Integer id;
	private String name;
	private String code;

	public Group(){
		
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
	
	
}
