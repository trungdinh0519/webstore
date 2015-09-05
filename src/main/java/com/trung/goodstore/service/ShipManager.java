package com.trung.goodstore.service;

import java.math.BigDecimal;
import java.util.List;

import com.trung.goodstore.model.ShipMethod;
import com.trung.goodstore.model.Shiprate;
import com.trung.goodstore.persistence.ShipDao;

public interface ShipManager extends Manager {
	void setShipDao(ShipDao dao);
	//void setProvinceManager(ProvinceManager p);
	Shiprate removeShiprate(String id);

	List getShiprates();

	Shiprate getShiprate(String id);

	void saveShiprate(Shiprate rate);

	//id updateShiprate(Shiprate rate, List<Province> provinces);

	//List<Province> getProvincesByShiprate(Shiprate rate);

	List<Shiprate> getShiprateByProvince(String province);

	List getShiprateByMethod(ShipMethod sm);

	BigDecimal calculate(String province, ShipMethod shipMethod, Double m);
}
