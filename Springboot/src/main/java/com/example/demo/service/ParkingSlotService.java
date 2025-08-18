package com.example.demo.service;

import java.util.List;

import com.example.demo.model.bean.ParkingSlot;

public interface ParkingSlotService {
	List<ParkingSlot> getAllSlots(); // 查詢所有停車位
	String parkCar(int slot, String plate); // 停放車輛
	String leaveCar(int slot); // 移除車輛
	String addSlot(int slot); // 增加車位
	String deleteSlot(int slot); // 移除車位
}
