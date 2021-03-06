package ru.relex.workshop.domain;

public class Advertisement {

	private Long id;
	private String name;
	private String description;
	private String price;
	private String address;
	private String phone;

	public Advertisement() {

	}

	public Advertisement(Long id, String name, String description, String price,
						 String address, String phone) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.address = address;
		this.phone = phone;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}
}

