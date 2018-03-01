package org.sdrc.boot.web.domain;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UtData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dataId;
	
	private Timestamp createdDate;
	
	private Long numeratorValue;
	
	private Long denominatorValue;
	
	private Double percentage;

	public Integer getDataId() {
		return dataId;
	}

	public void setDataId(Integer dataId) {
		this.dataId = dataId;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public Long getNumeratorValue() {
		return numeratorValue;
	}

	public void setNumeratorValue(Long numeratorValue) {
		this.numeratorValue = numeratorValue;
	}

	public Long getDenominatorValue() {
		return denominatorValue;
	}

	public void setDenominatorValue(Long denominatorValue) {
		this.denominatorValue = denominatorValue;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	
	
}
