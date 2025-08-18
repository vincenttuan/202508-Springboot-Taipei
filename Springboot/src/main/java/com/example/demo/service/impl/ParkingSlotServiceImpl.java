package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ParkingSlotDao;
import com.example.demo.model.bean.ParkingSlot;
import com.example.demo.service.ParkingSlotService;

@Service
public class ParkingSlotServiceImpl implements ParkingSlotService {
	
	@Autowired
	private ParkingSlotDao dao;
	
	@Override
	public List<ParkingSlot> getAllSlots() {
		return dao.findAll();
	}

	@Override
	public String parkCar(int slot, String plate) {
		boolean check = dao.parkCar(slot, plate);
		if(check) {
			return String.format("車牌 %s 已停入 %d 號車位", plate, slot);
		} else {
			return String.format("車牌 %s 無法停入 %d 號車位", plate, slot);
		}
	}

	@Override
	public String leaveCar(int slot) {
		boolean check = dao.leaveCar(slot);
		if(check) {
			return String.format("%d 號車位的車子已經離開", slot);
		} else {
			return String.format("%d 號車位目前無車", slot);
		}
	}

	@Override
	public String addSlot(int slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteSlot(int slot) {
		// TODO Auto-generated method stub
		return null;
	}

}
