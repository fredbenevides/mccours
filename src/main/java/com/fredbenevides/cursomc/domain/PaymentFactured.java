package com.fredbenevides.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fredbenevides.cursomc.domain.enums.PaymentStatus;

@Entity
public class PaymentFactured extends Payment {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dueDate;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date paymentDate;

	public PaymentFactured() {
	}

	public PaymentFactured(Integer id, PaymentStatus status, Purchase purchase, Date dueDate, Date paymentDate) {
		super(id, status, purchase);
		this.dueDate = dueDate;
		this.paymentDate = paymentDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

}