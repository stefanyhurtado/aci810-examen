package com.example.examen.db.model;

import java.io.Serializable;

public class Compra implements Serializable{
	
public static final long serialVersionUID = 7526472295622776147L;
	
	private long id;
	private String compra;
	private String descriptions;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCompra() {
		return compra;
	}
	public void setCompra(String compra) {
		this.compra = compra;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	
	
	
	@Override
	  public String toString() {
	    return this.compra + " " + this.descriptions;
	  }

}






