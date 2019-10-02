package com.dtos;

import java.util.List;

public class MessageDTO {
	
	public List<SalesDTO> sales;
	
	public List<SalesDTO> getSales() {
		return sales;
	}
	public void setSales(List<SalesDTO> sales) {
		this.sales = sales;
	}
}
