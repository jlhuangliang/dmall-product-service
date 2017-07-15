package com.dmall.product.model;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;
import java.util.Date;

public class Product {

	private String prodcutId;

	private String name;

	private Date posted;

	public Product() {
		super();

	}

	public Product(String prodcutId, String name, Date posted) {
		super();
		this.prodcutId = prodcutId;
		this.name = name;
		this.posted = posted;
	}

	public String getProdcutId() {
		return prodcutId;
	}

	public void setProdcutId(String prodcutId) {
		this.prodcutId = prodcutId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonSerialize(using = CustomDateToLongSerializer.class)
	public Date getPosted() {
		return posted;
	}

	public void setPosted(Date posted) {
		this.posted = posted;
	}

}

class CustomDateToLongSerializer extends JsonSerializer<Date> {

	@Override
	public void serialize(Date value, JsonGenerator jgen, SerializerProvider provider)
		throws IOException, JsonProcessingException {
		jgen.writeNumber(value.getTime());
	}
}


