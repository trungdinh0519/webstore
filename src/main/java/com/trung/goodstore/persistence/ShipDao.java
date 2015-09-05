package com.trung.goodstore.persistence;

import java.util.List;

import com.trung.goodstore.model.ShipMethod;
import com.trung.goodstore.model.Shiprate;

/**
 * 
 * @author trung dinh
 * 
 */
public interface ShipDao extends Dao {
	Shiprate removeShiprate(Long id);

	List getShiprates();

	Shiprate getShiprate(Long id);

	void saveShiprate(Shiprate rate);

	//void updateShiprate(Shiprate rate, List<Province> provinces);

	List getProvincesByShiprate(Shiprate rate);

	List getShiprateByMethod(ShipMethod sm);

	//List getShiprateByProvince(Province province);
}
