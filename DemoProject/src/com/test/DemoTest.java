package com.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.demo.TestDemo;
import com.dtos.MessageDTO;
import com.dtos.ProductDTO;
import com.dtos.SalesDTO;
import com.dtos.SalesModify;

public class DemoTest {

	MessageDTO firstMessage = new MessageDTO();
	MessageDTO secondMessage = new MessageDTO();
	MessageDTO thirdMessage = new MessageDTO();
	List<MessageDTO> messagesType1 = new ArrayList<MessageDTO>();
	List<MessageDTO> messagesType2 = new ArrayList<MessageDTO>();
	List<MessageDTO> messagesType3 = new ArrayList<MessageDTO>();
	List<MessageDTO> messagesAllType = new ArrayList<MessageDTO>();

	@Before
	public void setUp() {
		setUpMessageDTOs();
	}

	TestDemo prog = new TestDemo();

	@Test
	public void testProcesssMessageType1() {
		prog.processMessages(messagesType1);
		assertEquals(4.0, messagesType1.get(0).getSales().get(0).getSalesPrice(), 0);

	}

	@Test
	public void testProcesssMessageType2() {
		prog.processMessages(messagesType2);
		assertEquals(6.0, messagesType2.get(0).getSales().get(0).getSalesPrice(), 0);

	}

	@Test
	public void testProcesssMessageType3() {
		prog.processMessages(messagesType3);
		assertEquals(60.0, messagesType3.get(0).getSales().get(0).getSalesPrice(), 0);

	}

	@Test
	public void testProcesssMessageAllType() {
		prog.processMessages(messagesAllType);
		assertEquals(4.0, messagesAllType.get(0).getSales().get(0).getSalesPrice(), 0);
		assertEquals("Add", messagesAllType.get(2).getSales().get(0).getSalesModify().getModificationType());

	}

	public void setUpMessageDTOs() {

		List<SalesDTO> sales = new ArrayList<SalesDTO>();
		List<SalesDTO> sales2 = new ArrayList<SalesDTO>();
		List<SalesDTO> sales3 = new ArrayList<SalesDTO>();

		ProductDTO productDTOApple = new ProductDTO();
		productDTOApple.setName("Apple");
		productDTOApple.setPrice(4.0);

		ProductDTO productDTOBanana = new ProductDTO();
		productDTOBanana.setName("Banana");
		productDTOBanana.setPrice(12.0);

		ProductDTO productDTOOrange = new ProductDTO();
		productDTOOrange.setName("Orange");
		productDTOOrange.setPrice(8.0);

		SalesDTO saleApple = new SalesDTO();
		saleApple.setProduct(productDTOApple);

		SalesDTO saleBanana = new SalesDTO();
		saleBanana.setProduct(productDTOBanana);

		SalesDTO saleOrange = new SalesDTO();
		saleOrange.setProduct(productDTOBanana);

		sales.add(saleApple);
		sales.add(saleBanana);
		sales.add(saleOrange);

		/////

		ProductDTO productDTOPizza = new ProductDTO();
		productDTOPizza.setName("Pizza");
		productDTOPizza.setPrice(3.0);

		ProductDTO productDTOBurger = new ProductDTO();
		productDTOBurger.setName("Burger");
		productDTOBurger.setPrice(2.5);

		ProductDTO productDTOFrenchFries = new ProductDTO();
		productDTOFrenchFries.setName("FrenchFries");
		productDTOFrenchFries.setPrice(4.5);

		ProductDTO productDTOCoke = new ProductDTO();
		productDTOCoke.setName("Coke");
		productDTOCoke.setPrice(6.0);

		SalesDTO salePizza = new SalesDTO();
		salePizza.setProduct(productDTOPizza);
		salePizza.setQuantity(2);

		SalesDTO saleBurger = new SalesDTO();
		saleBurger.setProduct(productDTOBurger);
		saleBurger.setQuantity(4);

		SalesDTO saleFrenchFries = new SalesDTO();
		saleFrenchFries.setProduct(productDTOFrenchFries);
		saleFrenchFries.setQuantity(2);

		SalesDTO saleCoke = new SalesDTO();
		saleCoke.setProduct(productDTOCoke);
		saleCoke.setQuantity(2);

		sales2.add(salePizza);
		sales2.add(saleBurger);
		sales2.add(saleFrenchFries);
		sales2.add(saleCoke);

		////

		ProductDTO Battery = new ProductDTO();
		Battery.setName("Battery");
		Battery.setPrice(4.0);

		ProductDTO WineBottle = new ProductDTO();
		WineBottle.setName("WineBottle");
		WineBottle.setPrice(10.0);

		SalesDTO saleBattery = new SalesDTO();
		SalesModify saleModifyBattery = new SalesModify();
		saleModifyBattery.setModificationType("Add");
		saleModifyBattery.setPrice(2.0);

		saleBattery.setProduct(Battery);
		saleBattery.setQuantity(10);
		saleBattery.setSalesModify(saleModifyBattery);

		SalesDTO saleWineBottle = new SalesDTO();
		SalesModify saleModifyWineBottle = new SalesModify();
		saleModifyWineBottle.setModificationType("Substract");
		saleModifyWineBottle.setPrice(2.0);

		saleWineBottle.setProduct(WineBottle);
		saleWineBottle.setQuantity(5);
		saleWineBottle.setSalesModify(saleModifyWineBottle);

		sales3.add(saleBattery);
		sales3.add(saleWineBottle);

		firstMessage.setSales(sales);
		secondMessage.setSales(sales2);
		thirdMessage.setSales(sales3);

		messagesType1.add(firstMessage);
		messagesType2.add(secondMessage);
		messagesType3.add(thirdMessage);

		messagesAllType.add(firstMessage);
		messagesAllType.add(secondMessage);
		messagesAllType.add(thirdMessage);
	}
}
