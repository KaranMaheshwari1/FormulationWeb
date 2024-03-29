package com.Formula.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class RawFormulation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rmfmId;
	private int fmId;
	private String formulaName;
	@OneToMany(mappedBy = "rawFormulation")
	private List<RawMaterialRequest> rawList= new ArrayList<>() ;

	public int getRmfmId() {
		return rmfmId;
	}

	public void setRmfmId(int rmfmId) {
		this.rmfmId = rmfmId;
	}

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

	

}
