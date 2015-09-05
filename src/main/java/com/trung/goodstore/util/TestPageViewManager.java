package com.trung.goodstore.util;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.trung.goodstore.service.util.MailEngine;



public class TestPageViewManager {
public Log log=LogFactory.getLog(this.getClass());
public void test(){
	MailEngine bean=(MailEngine)SpringUtil.getBean("mailEngine");
	
}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestPageViewManager t=new TestPageViewManager();
		t.test();

	}

}
