package com.dtos;

import java.util.HashMap;
import java.util.Map;

public class SalesDTO {
	
	public ProductDTO product; 
    public int quantity = 1;
    public SalesModify salesModify;
    public Double salesPrice;
    
    public static  Map<String,Double> initialPriceMap = new HashMap<>();
    public static Map<String,Double> modifiedPriceMap = new HashMap<>();
    
	public ProductDTO getProduct() {
		return product;
	}
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public SalesModify getSalesModify() {
		return salesModify;
	}
	public void setSalesModify(SalesModify salesModify) {
		this.salesModify = salesModify;
	}
	public Double getSalesPrice() {
		if (this.salesModify == null)
        {

            Double totalPrice =this.product.price*this.quantity;
            return totalPrice;
           
        }
        else
        {
                            switch (this.salesModify.modificationType)
                            {
                                case "Add": 
                                	
                                Double totalPriceAdd = (this.product.price + this.salesModify.price) * (this.quantity);
                                initialPriceMap.put(this.product.name, this.product.price);
                                modifiedPriceMap.put(this.product.name, this.salesModify.price);
                                
                                return totalPriceAdd;
                                
                                case "Substract": 
                                
                                Double totalPriceSub =	(this.product.price - this.salesModify.price) *(this.quantity);
                                initialPriceMap.put(this.product.name, this.product.price);
                                modifiedPriceMap.put(this.product.name, this.salesModify.price);
                                return totalPriceSub;
                                    //TODO: Create Multiply case
                            }
                            
            return 1.0;
        }
	}
	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}
}
