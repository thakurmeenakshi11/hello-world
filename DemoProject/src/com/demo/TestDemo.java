package com.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dtos.MessageDTO;
import com.dtos.ProductDTO;
import com.dtos.SalesDTO;
import com.dtos.SalesModify;

public class TestDemo {

	public static int sales10Counter = 0;
	public static int count = 0;
	Map<String, Double> productPriceMap = new HashMap<>();
	Map<String, Integer> productQuantityMap = new HashMap<>();

	public static void main(String[] args) {
		// Create First Message Type
		TestDemo prog = new TestDemo();
		MessageDTO firstMessageDTO = prog.getMessageDTOType1();
		MessageDTO secondMessageDTO = prog.getMessageDTOType2();
		MessageDTO thirdMessageDTO = prog.getMessageDTOType3();

		List<MessageDTO> messages = new ArrayList<MessageDTO>();
		messages.add(firstMessageDTO);
		messages.add(secondMessageDTO);
		messages.add(thirdMessageDTO);

		processAllMessages(messages);
	}

	public MessageDTO getMessageDTOType1() {
		List<SalesDTO> sales = new ArrayList<SalesDTO>();

		ProductDTO productDTOApple = new ProductDTO();
		productDTOApple.setName("Apple");
		productDTOApple.setPrice(1.0);

		ProductDTO productDTOBanana = new ProductDTO();
		productDTOBanana.setName("Banana");
		productDTOBanana.setPrice(2.0);

		SalesDTO saleApple = new SalesDTO();
		saleApple.setProduct(productDTOApple);

		SalesDTO saleBanana = new SalesDTO();
		saleBanana.setProduct(productDTOBanana);

		sales.add(saleApple);
		sales.add(saleBanana);

		MessageDTO message = new MessageDTO();
		message.setSales(sales);

		return message;
	}

	public MessageDTO getMessageDTOType2() {
		List<SalesDTO> sales = new ArrayList<SalesDTO>();

		ProductDTO productDTOApple = new ProductDTO();
		productDTOApple.setName("Apple");
		productDTOApple.setPrice(1.0);

		ProductDTO productDTOBanana = new ProductDTO();
		productDTOBanana.setName("Banana");
		productDTOBanana.setPrice(2.0);

		SalesDTO saleApple = new SalesDTO();
		saleApple.setProduct(productDTOApple);
		saleApple.setQuantity(2);

		SalesDTO saleBanana = new SalesDTO();
		saleBanana.setProduct(productDTOBanana);
		saleBanana.setQuantity(2);

		sales.add(saleApple);
		sales.add(saleBanana);

		MessageDTO message = new MessageDTO();
		message.setSales(sales);

		return message;
	}

	public MessageDTO getMessageDTOType3() {
		List<SalesDTO> sales = new ArrayList<SalesDTO>();

		ProductDTO productDTOApple = new ProductDTO();
		productDTOApple.setName("Apple");
		productDTOApple.setPrice(1.0);

		ProductDTO productDTOBanana = new ProductDTO();
		productDTOBanana.setName("Banana");
		productDTOBanana.setPrice(2.0);

		SalesDTO saleApple = new SalesDTO();
		SalesModify saleModifyApple = new SalesModify();
		saleModifyApple.setModificationType("Add");
		saleModifyApple.setPrice(4.0);

		saleApple.setProduct(productDTOApple);
		saleApple.setQuantity(2);
		saleApple.setSalesModify(saleModifyApple);

		SalesDTO saleBanana = new SalesDTO();
		SalesModify saleModifyBanana = new SalesModify();
		saleModifyBanana.setModificationType("Substract");
		saleModifyBanana.setPrice(3.0);

		saleBanana.setProduct(productDTOBanana);
		saleBanana.setQuantity(2);
		saleBanana.setSalesModify(saleModifyBanana);

		sales.add(saleApple);
		sales.add(saleBanana);

		MessageDTO message = new MessageDTO();
		message.setSales(sales);

		return message;
	}

	public int processMessages(List<MessageDTO> messages) {

		try {
			for (MessageDTO message : messages) {
				System.out.println("-------------------------------------------------------------------------------");
				System.out.println("Message:" + (++count));
				logAllTheSales(message);
				++sales10Counter;
				getTotalProductPriceValue(message.getSales());
				if (count == 50) {
					return count;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return count;

	}

	public void LogAfterTenthMessageDTO() {
		System.out.println("\n***********Logging after every 10th message***********\n");
		for (Map.Entry<String, Double> entry : productPriceMap.entrySet()) {
			System.out.println("Product = " + entry.getKey() + " " + ",TotalQuantity:"
					+ productQuantityMap.get(entry.getKey()) + ", Total Value = " + entry.getValue());
		}

		System.out.println("\n");

	}

	public static void LogAfterFiftyMessageDTO() {

		for (Map.Entry<String, Double> entry : SalesDTO.initialPriceMap.entrySet()) {
			System.out.println("Product Name = " + entry.getKey() + " " + ", Initial Price = " + entry.getValue() + " "
					+ ",Modified Price:" + SalesDTO.modifiedPriceMap.get(entry.getKey()));
		}

	}

	public void getTotalProductPriceValue(List<SalesDTO> sales) throws Exception {
		try {
			if (sales10Counter == 10) {
				LogAfterTenthMessageDTO();
				sales10Counter = 0;
			}
			for (SalesDTO sale : sales) {
				if (productPriceMap.get(sale.getProduct().getName()) == null) {
					Double totalProductPrice = sale.getSalesPrice();
					if (totalProductPrice < 0) {
						throw new Exception(
								"EXCEPTION::::Sales Price adjustment not valid for the product:" + sale.getProduct().getName());
					}
					productQuantityMap.put(sale.getProduct().getName(), sale.getQuantity());
					productPriceMap.put(sale.getProduct().getName(), totalProductPrice);

				} else {
					int newQuantity = productQuantityMap.get(sale.getProduct().getName()) + sale.getQuantity();
					productQuantityMap.put(sale.getProduct().getName(), newQuantity);
					if (sale.getSalesPrice() < 0) {
						throw new Exception(
								"EXCEPTION::::Sales Price adjustment not valid for the product:" + sale.getProduct().getName());
					}
					Double newProductvalue = sale.getSalesPrice() + (productPriceMap.get(sale.getProduct().getName()));
					productPriceMap.put(sale.getProduct().getName(), newProductvalue);
				}
			}
		} finally {

		}
	}

	public void logAllTheSales(MessageDTO message) {
		for (SalesDTO sale : message.getSales()) {
			System.out.println("ProductName:" + sale.getProduct().getName() + " " + ",ProductPrice:"
					+ sale.getProduct().getPrice() + " " + ",ProductQuantity:" + sale.getQuantity());
		}
	}

	public static void processAllMessages(List<MessageDTO> messages) {
		TestDemo prog = new TestDemo();
		int count = 0;

		// NOTE: Looping since , no user interface to input 50 or more messages, so
		// looping on the same data to create a scenario to check the requirements

		try {
			if (messages.isEmpty()) {
				throw new Exception("EXCEPTION::::No message found");
			}
			for (int i = 0; i < 20; i++) {
				count = prog.processMessages(messages);
				// System.out.println("-------------------------------------------------------------------------------");
				if (count == 50) {
					System.out.println(
							"\n***********The system is pausing since 50 messages has been received***********\n");
					LogAfterFiftyMessageDTO();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
}
