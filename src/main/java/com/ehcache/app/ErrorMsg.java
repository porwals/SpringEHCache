package com.ehcache.app;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "ErrorCodes")
public class ErrorMsg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	String errCode;
	public String getErrCode() {
		return errCode;
	}

	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

	String errMsg;

    @JsonCreator
    public ErrorMsg(@JsonProperty("errCode") String errCode, 
    		            @JsonProperty("errMsg") String errMsg) {
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

}
