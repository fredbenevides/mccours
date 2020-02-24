package com.fredbenevides.cursomc.domain;

import javax.persistence.Entity;

import com.fredbenevides.cursomc.domain.enums.PaymentStatus;

@Entity
public class PaymentCreditCard extends Payment {
	private static final long serialVersionUID = 1L;

	private Integer nbOfInstallments;

	public PaymentCreditCard() {
	}

	public PaymentCreditCard(Integer id, PaymentStatus status, Purchase purchase, Integer nbOfInstallments) {
		super(id, status, purchase);
		this.nbOfInstallments = nbOfInstallments;
	}

	public Integer getNbOfInstallments() {
		return nbOfInstallments;
	}

	public void setNbOfInstallments(Integer nbOfInstallments) {
		this.nbOfInstallments = nbOfInstallments;
	}

}