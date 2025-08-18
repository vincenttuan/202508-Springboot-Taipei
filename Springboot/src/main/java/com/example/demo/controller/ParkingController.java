package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
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
	// 利用 Map 紀錄車位編號與車牌編號, 預設是 5 個空車位
	private Map<Integer, String> parkingSlots = new HashMap<>(Map.of(1, "", 2, "", 3, "", 4, "", 5, ""));
	
	/**
	 * 查詢功能: 顯示所有車位資訊
	 * 路徑: /parking
	 * */
	@GetMapping("/parking")
	public String getParking() {
		return parkingSlots.toString();
	}
	
	/**
	 * 停車功能: 將車輛停入指定車位
	 * 路徑: /parking/2?plate=ABC123
	 * */
	@GetMapping("/parking/{slot}")
	public String parkCar(@PathVariable Integer slot, @RequestParam String plate) {
		
		if(!parkingSlots.containsKey(slot)) {
			return String.format("車位 %d 號不存在", slot);
		}
		
		if(!parkingSlots.get(slot).equals("")) {
			return String.format("車位 %d 號已有車輛", slot);
		}
		
		parkingSlots.put(slot, plate);
		return String.format("車牌 %s 已停入 %d 號車位", plate, slot);
	}
	
	/**
	 * 離開功能: 車輛離開指定車位
	 * 路徑: /parking/leave/2
	 * */
	@GetMapping("/parking/leave/{slot}")
	public String leaveParking(@PathVariable Integer slot) {
		if(!parkingSlots.containsKey(slot)) {
			return String.format("車位  %d 號不存在", slot);
		}
		
		String plate = parkingSlots.get(slot);
		if(plate.equals("")) {
			return String.format("車位 %d 號沒車輛", slot);
		}
		
		parkingSlots.put(slot, "");
		return String.format("車牌 %s 已離開 %d 號車位", plate, slot);
		
	}
	
	/**
	 * 增加車位
	 * 路徑: POST /parking?slot=6
	 * */
	@PostMapping("/parking")
	public String addParkingSlot(@RequestParam Integer slot) {
		
		if(parkingSlots.containsKey(slot)) {
			return String.format("車位 %d 號已存在", slot);
		}
		
		parkingSlots.put(slot, "");
		return String.format("車位 %d 號加入成功", slot);
	}
	
	/**
	 * 刪除車位
	 * 路徑: DELETE /parking?slot=6
	 * */
	@DeleteMapping("/parking")
	public String deleteParkingSlot(@RequestParam Integer slot) {
		
		if(!parkingSlots.containsKey(slot)) {
			return String.format("車位 %d 號不存在", slot);
		}
		
		// 判定該車位目前是否有車, 有車也不能刪除 
		if(!parkingSlots.get(slot).equals("")) {
			return String.format("該車位 %d 號目前有車停放", slot);
		}
		
		parkingSlots.remove(slot);
		return String.format("車位 %d 號移除成功", slot);
		
	}
}
