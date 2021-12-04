package com.laptrinhweb.dto;

import java.sql.Date;


public class AbstractDTO {
	private Long id;
	private Date createddate;
	private Date modifieddate;
	private String createdby;
	private String modifiedby;

	public Date getCreateddate() {
		return createddate;
	}

	

	public Date getModifieddate() {
		return modifieddate;
	}

	
	public String getCreatedby() {
		return createdby;
	}

	

	public String getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(String modifiedby) {
		this.modifiedby = modifiedby;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public void setCreateddate(Date createddate) {
		this.createddate = createddate;
	}



	public void setModifieddate(Date modifieddate) {
		this.modifieddate = modifieddate;
	}



	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}

	
	
	
	
	
	
}
