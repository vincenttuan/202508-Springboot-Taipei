package com.example.todolist.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest API
 * ------------------------------------
 * Method | URI     | Message
 * ------------------------------------
 * GET    | "/"     | 取得所有代辦事項
 * POST   | "/"     | 新增代辦事項
 * PUT    | "/{id}" | 修改代辦事項
 * DELETE | "/{id}" | 刪除代辦事項
 * ------------------------------------
 * */

@RestController
@RequestMapping("/todolist")
@CrossOrigin(origins = "http://localhost:5173") // 設定跨域請求
public class TodoController {

}
