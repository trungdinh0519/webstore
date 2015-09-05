package com.trung.goodstore.web.form;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.util.LabelValueBean;

import com.trung.goodstore.model.CartItem;

public class ShoppingCartForm extends BaseForm {
	public static final long serialVersionUID = 1237843523845623L;
	private LabelValueBean[] lvbeans;
	
	public ShoppingCartForm() {	
		lvbeans=new LabelValueBean[0];
	}
	public ShoppingCartForm(ArrayList<CartItem> items) {
		int number=items.size();
		lvbeans=new LabelValueBean[number];
		for(int i=0;i<number;i++){
			lvbeans[i]=new LabelValueBean(""+i,items.get(i).getQuantity()+"");
		}
	}
	public ShoppingCartForm(LabelValueBean[] lvbeans) {
		this.lvbeans=lvbeans;
	}
	public LabelValueBean[] getLvbeans() {
		return lvbeans;
	}
	public void setLvbeans(LabelValueBean[] lvbeans) {
		this.lvbeans = lvbeans;
	}

	public LabelValueBean getLabelValue(int index) {
		return lvbeans[index];
	}

	public void setLabelValue(int index, LabelValueBean lvbean) {
		lvbeans[index] = lvbean;
	}
	public List<LabelValueBean> getLabelValueBeans() {
		return java.util.Arrays.asList(lvbeans);
	}
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		ActionErrors errors = new ActionErrors();
		return errors;
	}
	
	public void reset(ActionMapping mapping, HttpServletRequest request) {
		super.reset(mapping, request);
	}
}
