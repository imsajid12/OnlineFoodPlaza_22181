package com.food.pojo;

public class Cart {
	private int cartId,foodId, quantity;
	private String foodName, foodCategory, customerEmail;
	private double foodPrice;
	
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(int foodId, int quantity,String customerEmail) {
		super();
		this.foodId = foodId;
		this.quantity = quantity;
		this.customerEmail = customerEmail;
	}

	public Cart(int cartId, int foodId, int quantity, String customerEmail) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.customerEmail = customerEmail;
	}

	public Cart(int cartId, int foodId, int quantity, String foodName, String foodCategory, String customerEmail,
			double foodPrice) {
		super();
		this.cartId = cartId;
		this.foodId = foodId;
		this.quantity = quantity;
		this.foodName = foodName;
		this.foodCategory = foodCategory;
		this.customerEmail = customerEmail;
		this.foodPrice = foodPrice;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodCategory() {
		return foodCategory;
	}

	public void setFoodCategory(String foodCategory) {
		this.foodCategory = foodCategory;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public double getFoodPrice() {
		return foodPrice;
	}

	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", foodId=" + foodId + ", quantity=" + quantity + ", foodName=" + foodName
				+ ", foodCategory=" + foodCategory + ", customerEmail=" + customerEmail + ", foodPrice=" + foodPrice
				+ "]";
	}
	
	
}
