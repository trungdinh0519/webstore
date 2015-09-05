package com.trung.goodstore.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 
 * @author Trung Dinh
 * 
 */
public class Cart {
	private Hashtable<String, CartItem> itemMap = new Hashtable<String, CartItem>();

	private ArrayList<CartItem> items = new ArrayList<CartItem>();

	private BigDecimal shipcost = new BigDecimal(0).setScale(2);

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addItem(CartItem item) {
		if (itemMap.containsKey(item.getIdentify())) {
			CartItem cartItem = itemMap.get(item.getIdentify());
			if (item.getQuantity() > 0)
				cartItem.addQuantity(item.getQuantity());
		} else {
			if (item.getQuantity() > 0)
				itemMap.put(item.getIdentify(), item);
			items.add(item);
		}
	}

	public Double getWeight() {
		double total = 0.0;
		for (int i = 0; i < this.items.size(); i++) {
			CartItem item = items.get(i);
			total += item.getProduct().getWeight() * item.getQuantity();
		}
		return total;
	}

	public void removeItem(CartItem item) {
		if (itemMap.containsKey(item.getIdentify())) {
			itemMap.remove(item.getIdentify());
			items.remove(item);
		}
	}

	public void remove(int i) {
		CartItem item = items.get(i);
		if (item != null)
			this.removeItem(item);
	}

	public void update(int id, int quantity) {
		CartItem item = items.get(id);
		if (item != null) {
			if (quantity <= 0&&itemMap.containsKey(item.getIdentify())) {
				itemMap.remove(item.getIdentify());
				items.remove(item);
			} else
				item.setQuantity(quantity);
		}

	}

	public ArrayList<CartItem> getCartItems() {
		return this.items;
	}

	public BigDecimal getSubTotal() {
		BigDecimal total = new BigDecimal(0).setScale(2);
		List<CartItem> items = this.getCartItems();
		for (int i = 0; i < items.size(); i++) {
			total = total.add(items.get(i).getSubTotal());
		}
		return this.setScale(total);
	}

	public CartItem getCartItem(int i) {
		return items.get(i);
	}

	public int size() {
		return this.items.size();
	}
	public String getSoluong() {
		if(this.items.isEmpty())return "0";
		return String.valueOf(this.items.size());
	}
	protected BigDecimal setScale(BigDecimal value) {
		return value.setScale(2, BigDecimal.ROUND_HALF_UP);
	}

	public void empty() {
		this.itemMap.clear();
		this.items.clear();
	}

	public boolean isEmpty() {
		return this.items.isEmpty();
	}

	public BigDecimal getTotal() {
		BigDecimal total = new BigDecimal(0).setScale(2);
		total = total.add(this.getSubTotal());
		total = total.add(this.getShipcost());
		return this.setScale(total);
	}

	public ArrayList<CartItem> getItems() {
		return items;
	}

	public BigDecimal getShipcost() {
		return this.setScale(shipcost);
	}

	public void setItems(ArrayList<CartItem> items) {
		this.items = items;
	}

	public void setShipcost(BigDecimal shipcost) {
		this.shipcost = this.setScale(shipcost);
	}

	public Hashtable<String, CartItem> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Hashtable<String, CartItem> itemMap) {
		this.itemMap = itemMap;
	}
	
}
