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
		// 判斷該車位是否有車
		boolean exist = dao.hasCar(slot);
		if(exist) {
			return String.format("%d 號車位已有車無法停入", slot);
		}
		// 停車
		boolean check = dao.parkCar(slot, plate);
		if(check) {
			return String.format("車牌 %s 已停入 %d 號車位", plate, slot);
		}
		return String.format("車牌 %s 無法停入 %d 號車位", plate, slot);
	}

	@Override
	public String leaveCar(int slot) {
		// 判斷該車位是否有車
		boolean exist = dao.hasCar(slot);
		if(!exist) {
			return String.format("%d 號車位目前無車可以移出", slot);
		}
		// 移車
		boolean check = dao.leaveCar(slot);
		if(check) {
			return String.format("%d 號車位的車子已經離開", slot);
		}
		return String.format("%d 號車位目前無車", slot);
	}

	@Override
	public String addSlot(int slot) {
		// 查詢該車位是否存在
		boolean exist = dao.exists(slot);
		if(exist) {
			return String.format("%d 號車位已經存在無法新增", slot);
		}
		// 新增車位
		boolean check = dao.addSlot(slot);
		if(check) {
			return String.format("新增 %d 號車位成功", slot);
		}
		return String.format("新增 %d 號車位失敗", slot);
	}

	@Override
	public String deleteSlot(int slot) {
		// 查詢該車位是否存在
		boolean exist = dao.exists(slot);
		if(!exist) {
			return String.format("%d 號車位不存在無法刪除", slot);
		}
		// 刪除車位
		boolean check = dao.deleteSlot(slot);
		if(check) {
			return String.format("移除 %d 號車位成功", slot);
		}
		return String.format("移除 %d 號車位失敗", slot);
	}

}
