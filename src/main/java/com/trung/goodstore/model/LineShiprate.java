package com.trung.goodstore.model;

import java.math.BigDecimal;

public class LineShiprate extends BaseObject {
	public static final long serialVersionUID = 73472375725727547L;

	private ShipMethod shipMethod;

	private BigDecimal shiprate = new BigDecimal(0).setScale(0);

	public LineShiprate() {
		super();
		
	}

	public ShipMethod getShipMethod() {
		return shipMethod;
	}

	public BigDecimal getShiprate() {
		return shiprate;
	}

	public void setShipMethod(ShipMethod shipMethod) {
		this.shipMethod = shipMethod;
	}

	public void setShiprate(BigDecimal shiprate) {
		this.shiprate = shiprate;
	}

}
