package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ParkingSlotService;

@RestController
@RequestMapping("/parking")
public class ParkingController {
	/**
	 * 停車場車位管理練習題
	 * 題目說明
	 * 請設計一個簡單的停車場管理程式，使用 Spring Boot Controller，利用 Map 紀錄車位與車牌。

	 * 功能需求
	 * 停車
	 * 路徑：GET /parking/{slot}
	 * 功能：將車輛停入指定車位，使用查詢參數取得車牌號碼。
	 * 若車位不存在或已經有車，回傳錯誤訊息。

	 * 離開
	 * 路徑：GET /parking/leave/{slot}
	 * 功能：車輛離開指定車位，清空該車位資料。
	 * 若車位不存在或沒有車，回傳錯誤訊息。

	 * 查詢
	 * 路徑：GET /parking
	 * 功能：顯示所有有車的車位及車牌。

	 * 範例測試
	 * 查詢：GET /parking/2?plate=ABC123 → 「車牌 ABC123 已停入車位 2」
	 * 查詢：GET /parking/2?plate=XYZ → 「車位 2 已有車輛」
	 * 查詢：GET /parking/leave/2 → 「車牌 ABC123 離開車位 2」
	 * 查詢：GET /parking → 顯示目前停車狀況（車位與車牌）
	 * */
	
	@Autowired
	private ParkingSlotService service;
	
	/**
	 * 查詢功能: 顯示所有車位資訊
	 * 路徑: /parking
	 * */
	@GetMapping
	public String getParking() {
		return service.getAllSlots().toString();
	}
	
	/**
	 * 停車功能: 將車輛停入指定車位
	 * 路徑: /parking/2?plate=ABC123
	 * */
	@GetMapping("/{slot}")
	public String parkCar(@PathVariable Integer slot, @RequestParam String plate) {
		return service.parkCar(slot, plate);
	}
	
	/**
	 * 離開功能: 車輛離開指定車位
	 * 路徑: /parking/leave/2
	 * */
	@GetMapping("/leave/{slot}")
	public String leaveParking(@PathVariable Integer slot) {
		return service.leaveCar(slot);
	}
	
	/**
	 * 增加車位
	 * 路徑: POST /parking?slot=6
	 * */
	@PostMapping
	public String addParkingSlot(@RequestParam Integer slot) {
		return service.addSlot(slot);
	}
	
	/**
	 * 刪除車位
	 * 路徑: DELETE /parking?slot=6
	 * */
	@DeleteMapping
	public String deleteParkingSlot(@RequestParam Integer slot) {
		return service.deleteSlot(slot);
	}
}
