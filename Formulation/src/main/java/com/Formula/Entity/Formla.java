package com.Formula.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Formulas")
public class Formla {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int fmId;

	private String formulaName;

	private String otherProperties;

	private String fmNumber;

	public int getFmId() {
		return fmId;
	}

	public void setFmId(int fmId) {
		this.fmId = fmId;
	}

	public String getFormulaName() {
		return formulaName;
	}

	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}

	public String getOtherProperties() {
		return otherProperties;
	}

	public void setOtherProperties(String otherProperties) {
		this.otherProperties = otherProperties;
	}

	public String getFmNumber() {
		return fmNumber;
	}

	public void setFmNumber(String fmNumber) {
		this.fmNumber = fmNumber;
	}

}
