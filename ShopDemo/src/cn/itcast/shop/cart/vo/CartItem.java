package cn.itcast.shop.cart.vo;

import cn.itcast.shop.product.vo.Product;

public class CartItem {

	private Product product;
	private int count;
	@SuppressWarnings("unused")
	private double subtotal;
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	//商品小计自动计算
	public double getSubtotal() {
		return count * product.getShop_price();
	}
	
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
}
