package com.example.demo.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dao.ParkingSlotDao;
import com.example.demo.model.bean.ParkingSlot;

@Repository
public class ParkingSlotDaoImpl implements ParkingSlotDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// 查詢所有停車位
	@Override
	public List<ParkingSlot> findAll() {
		String sql = "select slot, plate from parking_slot order by slot";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(ParkingSlot.class));
	}
	
	// 停放車輛
	@Override
	public boolean parkCar(int slot, String plate) {
		String sql = "update parking_slot set plate = ? where slot = ? and plate = ''";
		int updated = jdbcTemplate.update(sql, plate, slot); 
		return updated > 0;
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
