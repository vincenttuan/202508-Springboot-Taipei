package com.example.demo.model.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
use web;
create table if not exists parking_slot(
	slot int primary key,
    plate varchar(50) not null default ""
);

-- 初始化  1~5 號空車位
insert into parking_slot (slot, plate) values (1, ''), (2, ''), (3, ''), (4, ''), (5, '')
*/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ParkingSlot {
	private Integer slot;
	private String plate;
}
