package c_datastructure.dto;

public class School implements Comparable<School> {
	
	private String name;
	private String address;
	private int levle;
	
	public School(String name, String address, int levle) {
		super();
		this.name = name;
		this.address = address;
		this.levle = levle;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getLevle() {
		return levle;
	}
	
	public void setLevle(int levle) {
		this.levle = levle;
	}
	
	@Override
	public String toString() {
		return "School [name=" + name + ", address=" + address + ", levle=" + levle + "]";
	}

	@Override
	public int compareTo(School o) {
		//* level 기준으로 오름차순 정렬하되, 만약 level이 같다면 대학교 이름으로 내림차순정렬
		if(this.levle == o.levle) {
			return this.name.compareTo(o.name) * -1;
		}
		
		return this.levle - o.levle;
	}


}
