package com.trung.goodstore;

import java.util.List;

import com.trung.goodstore.model.Product;
import com.trung.goodstore.service.ProductManager;
import com.trung.goodstore.util.SpringUtil;

public class Helloworld {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		ProductManager pm = (ProductManager) SpringUtil
				.getBean("productManager");
		List l1 = pm.getProductNew();
		List l2 = pm.getProductDiscount();
		System.out.println("moi");
		for (int i = 0; i < l1.size(); i++) {
			Product p = (Product) l1.get(i);
			System.out.println(p.getName() + "," + p.getDiscount() + ","
					+ p.getCdate());
		}
		System.out.println("ha gia");
		for (int i = 0; i < l2.size(); i++) {
			Product p = (Product) l2.get(i);
			System.out.println(p.getName() + "," + p.getDiscount() + ","
					+ p.getCdate());
		}
	}

	public void test() throws Exception {

	}

}
