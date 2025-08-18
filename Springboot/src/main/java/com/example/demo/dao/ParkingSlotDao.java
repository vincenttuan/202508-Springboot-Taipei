package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.bean.ParkingSlot;

public interface ParkingSlotDao {
	List<ParkingSlot> findAll(); // 查詢所有停車位
	boolean parkCar(int slot, String plate); // 停放車輛
	boolean leaveCar(int slot); // 移除車輛
	boolean addSlot(int slot); // 增加車位
	boolean deleteSlot(int slot); // 移除車位
}
