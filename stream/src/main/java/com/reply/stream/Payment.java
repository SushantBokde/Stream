package com.reply.stream;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Payment {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING)
	@Size(min =16, max=16, message="credit card should be of 16 digts")
	private String creditCardNum;
	
	@JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
	@Min(100)
	private int amount;
	
	public Payment() {
	}

	public String getCreditCardNum() {
		return creditCardNum;
	}

	public void setCreditCardNum(String creditCardNum) {
		this.creditCardNum = creditCardNum;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

}
