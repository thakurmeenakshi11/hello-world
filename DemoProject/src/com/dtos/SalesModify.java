package com.dtos;

public class SalesModify {
	
	 public String modificationType; 
	    public int quantity; 
	    public Double price;
	    
		public String getModificationType() {
			return modificationType;
		}
		public void setModificationType(String modificationType) {
			this.modificationType = modificationType;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}

}
