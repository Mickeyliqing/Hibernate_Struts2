package cn.itcast.shop.cart.vo;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@SuppressWarnings("serial")
public class Cart implements Serializable{
	//购物车的属性
	//购物项集合：Map的key就是商品的pid,value:购物项
	private Map<Integer, CartItem> map = new LinkedHashMap<Integer, CartItem>();
	
	//Cart对象中有一个叫cartItem的属性
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	//购物车总计
	private double total;

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
	
	//购物车功能，自定义方法
	//添加方法
	public void addCart(CartItem cartItem){
		Integer pid = cartItem.getProduct().getPid();
		if(map.containsKey(pid)){
			//存在
			CartItem _cartItem = map.get(pid);
			_cartItem.setCount(_cartItem.getCount()+cartItem.getCount());
		}else{
			//不存在
			map.put(pid, cartItem);
		}
		//设置总计数量
		total += cartItem.getSubtotal();
	}
	//移出购物车
	public void removeCart(Integer pid){
		CartItem cartItem = map.remove(pid);
		total -= cartItem.getSubtotal();
	}
	//清空购物车
	public void clearCart(){
		map.clear();
		total = 0;
	}
}
