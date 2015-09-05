package com.trung.goodstore.util;

import java.io.Serializable;

public class ParamUrl implements Serializable{
	public static final long serialVersionUID=342342342387954L;
private String name;
private String value;
public String getName() {
	return name;
}
public String getValue() {
	return value;
}
public void setName(String name) {
	this.name = name;
}
public void setValue(String value) {
	this.value = value;
}
public ParamUrl(String name, String value) {
	super();
	this.name = name;
	this.value = value;
}

}
