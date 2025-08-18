package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.ParkingSlotDao;
import com.example.demo.model.bean.ParkingSlot;

@Repository
public class ParkingSlotDaoImpl implements ParkingSlotDao {

	@Override
	public List<ParkingSlot> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean parkCar(int slot, String plate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean leaveCar(int slot) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addSlot(int slot) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteSlot(int slot) {
		// TODO Auto-generated method stub
		return false;
	}

}
