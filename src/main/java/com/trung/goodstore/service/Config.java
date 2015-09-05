package com.trung.goodstore.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;



public class Config {
	private Properties info = new Properties();;

	private String filePath = "classpath:config.properties";

	private String realFilePath = "";

	public String getFilePath() {
		return filePath;
	}

	public String getRealFilePath() {
		return realFilePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
		if (this.filePath != null) {
			try {

				if (filePath.indexOf("classpath:") == 0) {
					String strFile = filePath.substring(10);
					if (!strFile.substring(0, 1).equals("/"))
						strFile = "/" + strFile;
					this.realFilePath = getClass().getResource(strFile)
							.getPath();// .getFile().substring(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public Properties getInfo() {
		return info;
	}

	public void setInfo(Properties info) {
		this.info = info;
	}

	public void load() {
		try {
			FileInputStream in = new FileInputStream(this.getRealFilePath());
			info.load(in);
			in.close();
			// System.out.println(info.elements());
		} catch (IOException e) {

		}
	}

	public void save() {
		try {
			FileOutputStream out = new FileOutputStream(this.realFilePath);
			this.info.store(out, "config goodstore");
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<String> getKeys() {
		List<String> list = new ArrayList<String>();
		for (Iterator ite = info.keySet().iterator(); ite.hasNext();) {
			list.add((String) ite.next());
		}
		return list;

	}
}
