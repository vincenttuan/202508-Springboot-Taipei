// 需安裝 npm install react-router-dom
import React, { useState, useEffect } from "react";
import {
  BrowserRouter as Router,
  Routes,
  Route,
} from "react-router-dom";
import './App.css'
import Navbar from "./components/Navbar";
import Home from "./pages/Home";
import Footer from "./components/Footer";
// 登入相關
import LoginPage from "./pages/LoginPage";
import { checkLoginStatus, login, logout } from "./services/authService";

function App() {
  // 登入狀態
  const [isLoggedIn, setIsLoggedIn] = useState(false);

  // 處理登入邏輯
  const handleLogin = async (username, password) => {
    try {
      const data = await login(username, password); // 使用登入服務方法
      if(data.message === "登入成功") {
        setIsLoggedIn(true); // 修改登入狀態
        window.location.href = "/"; // 回到首頁
      } else {
        alert("登入失敗");
      }
    } catch(e) {
      console.error("登入錯誤:", e);
    }
  };

  return (
    <Router>
      <Navbar />
      <div className="content">
        <Routes>
          <Route path="/" element={<Home />} />
        </Routes>
      </div>
      <Footer />
    </Router>
  );
}

export default App
