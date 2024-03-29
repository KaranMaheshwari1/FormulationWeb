package com.Formula.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rawMaterial")
public class RawMaterialRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rmId;
	private String rmNumber;
	private String rmName;
	private String otherProperty;
	private long quantity;
	private String unit;
	@ManyToOne
	private RawFormulation rawFormulation;

	public int getRmId() {
		return rmId;
	}

	public void setRmId(int rmId) {
		this.rmId = rmId;
	}

	public String getRmNumber() {
		return rmNumber;
	}

	public void setRmNumber(String rmNumber) {
		this.rmNumber = rmNumber;
	}

	public String getRmName() {
		return rmName;
	}

	public void setRmName(String rmName) {
		this.rmName = rmName;
	}

	public String getOtherProperty() {
		return otherProperty;
	}

	public void setOtherProperty(String otherProperty) {
		this.otherProperty = otherProperty;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

}
