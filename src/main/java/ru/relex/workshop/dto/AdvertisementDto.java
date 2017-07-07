package ru.relex.workshop.dto;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import ru.relex.workshop.domain.Advertisement;

public class AdvertisementDto {

	@JsonProperty("id")
	private Long id;
	@NotNull
	@JsonProperty("name")
	private String name;
	@NotNull
	@JsonProperty("description")
	private String description;
	@NotNull
	@JsonProperty("price")
	private String price;
	@JsonProperty("address")
	private String address;

	@JsonProperty("phone")
	private String phone;

	public AdvertisementDto() {
	}

	public AdvertisementDto(Advertisement domain) {
		this.id = domain.getId();
		this.name = domain.getName();
		this.description = domain.getDescription();
		this.price = domain.getPrice();
		this.address = domain.getAddress();
		this.phone=domain.getPhone();
	}

	public Advertisement toDomain() {
		return new Advertisement(this.id, this.name, this.description, this.price, this.address, this.phone);
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
