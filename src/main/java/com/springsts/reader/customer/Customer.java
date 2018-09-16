package com.springsts.reader.customer;

public class Customer {
	
	private int orderId;
	private String customerName;
	private String deliveryNumber;
	private String product;
	private String price;

    public Customer() {
    	
    }
	
	public Customer(int orderId, String customerName, String deliveryNumber, String product, String price) {
		this.orderId = orderId;
		this.customerName = customerName;
		this.deliveryNumber = deliveryNumber;
		this.product = product;
		this.price = price;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setorderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDeliveryNumber() {
		return deliveryNumber;
	}

	public void setDeliveryNumber(String deliveryNumber) {
		this.deliveryNumber = deliveryNumber;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String output = "";
		output = "Order ID: " + this.getOrderId() + "\n" +
				 "Customer Name: " + this.getCustomerName() + "\n" +
				 "Delivery Number: " + this.getDeliveryNumber() + "\n" +
				 "Product/service: " + this.getProduct() + "\n" +
				 "Price: $" + this.getPrice() + "\n" +
				 "=======================================";
		return output;
	}
}
