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
	
	// 移除車輛
	@Override
	public boolean leaveCar(int slot) {
		String sql = "update parking_slot set plate = '' where slot = ? and plate <> ''";
		int updated = jdbcTemplate.update(sql, slot);
		return updated > 0;
	}
	
	// 增加車位
	@Override
	public boolean addSlot(int slot) {
		String sql = "insert into parking_slot(slot, plate) values (?, '')";
		int result = jdbcTemplate.update(sql, slot);
		return result > 0;
	}
	
	// 移除車位
	@Override
	public boolean deleteSlot(int slot) {
		String sql = "delete from parking_slot where slot = ? and plate = ''";
		int result = jdbcTemplate.update(sql, slot);
		return result > 0;
	}
	
	// 該車位是否存在 ?
	@Override
	public boolean exists(int slot) {
		String sql = "select count(*) from parking_slot where slot = ?";
		Integer count = jdbcTemplate.queryForObject(sql, Integer.class, slot);
		return count > 0;
	}
	
	// 該車位是否有車 ?
	@Override
	public boolean hasCar(int slot) {
		// TODO Auto-generated method stub
		return false;
	}

}
