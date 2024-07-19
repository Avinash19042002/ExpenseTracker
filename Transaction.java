package com.amdocs.assigments;

import java.util.Date;


public class Transaction {
	
	private long id;
	private int accountId;
	private String message;
	private Status status;
	private Date dateTime;
	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Transaction(int accountId, String message, Status status, Date dateTime) {
		super();
		this.id = System.currentTimeMillis();
		this.accountId = accountId;
		this.message = message;
		this.status = status;
		this.dateTime = dateTime;
	}
	@Override
	public String toString() {
		return "Transaction [id=" + id + ", accountId=" + accountId + ", message=" + message + ", status=" + status
				+ ", dateTime=" + dateTime + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
		
	

}