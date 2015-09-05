package com.trung.goodstore.service.impl;

import java.math.BigDecimal;
import java.util.List;

import com.trung.goodstore.model.ShipMethod;
import com.trung.goodstore.model.Shiprate;
import com.trung.goodstore.persistence.ShipDao;
import com.trung.goodstore.service.ShipManager;

public class ShipManagerImpl extends ManagerImpl implements ShipManager {
	private ShipDao shipDao;

	//private ProvinceManager provinceManager;

	public void setShipDao(ShipDao dao) {
		this.shipDao = dao;
	}

	//public List<Province> getProvincesByShiprate(Shiprate rate) {

	//	return (List<Province>) this.shipDao.getProvincesByShiprate(rate);
	//}

	public Shiprate getShiprate(String id) {

		return this.shipDao.getShiprate(new Long(id));
	}

	public List getShiprates() {
		return this.shipDao.getShiprates();
	}

	public Shiprate removeShiprate(String id) {
		return this.shipDao.removeShiprate(new Long(id));

	}

	public void saveShiprate(Shiprate rate) {
		this.shipDao.saveShiprate(rate);
	}

	//public void updateShiprate(Shiprate rate, List<Province> provinces) {
	//	this.shipDao.updateShiprate(rate, provinces);
	//}

	public List getShiprateByMethod(ShipMethod sm) {
		return shipDao.getShiprateByMethod(sm);
	}

	public BigDecimal calculate(String province, ShipMethod shipMethod, Double m) {
		Double output = 0.0;
		try {
			List<Shiprate> shiprates = this.getShiprateByProvince(province);
			Double max = 0.0;
			int index = 0;
			for (int i = 0; i < shiprates.size(); i++) {
				Shiprate rate = shiprates.get(i);
				if (max < rate.getTo()) {
					max = rate.getTo();
					index = i;
				}
				if (rate.getMethod().getId().longValue() == shipMethod.getId()
						.longValue()) {
					if (m > rate.getFrom() && m <= rate.getTo()) {

						output += rate.getPrice();
						if (rate.getLevAmout() != null
								&& rate.getLevAmout() > 0
								&& rate.getLevPrice() != null
								&& rate.getLevPrice() > 0) {
							Double d = m - rate.getFrom();
							output += rate.getLevPrice()
									* (Math.ceil(d / rate.getLevAmout()));
						}
					}

				}
			}
			if (max > 0 && m > max && output == 0) {
				int number = (int) Math.floor(m / max);

				Double m2 = m - (number * max);

				Shiprate shiprate = shiprates.get(index);
				Double tmp = shiprate.getPrice();

				if (shiprate.getLevAmout() != null
						&& shiprate.getLevAmout() > 0) {
					double n = Math.ceil((max - shiprate.getFrom())
							/ shiprate.getLevAmout());

					output += number * (tmp + (shiprate.getLevPrice() * n));
				}

				if (m2 > 0)
					output += this.calculate(province, shipMethod, m2)
							.doubleValue();

			}
			// System.out.println("***********************************");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new BigDecimal(output).setScale(0);
	}

	@Override
	public List<Shiprate> getShiprateByProvince(String province) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
