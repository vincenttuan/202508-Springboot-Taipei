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
// 商品相關
import Products from "./pages/Products";


function App() {
  // 登入狀態
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  // 購物車資料
  const [cartItems, setCartItems] = useState([]);

  useEffect(() => {
    const initializeLoginStatus = async () => {
      try {
        const apiResponse = await checkLoginStatus(); // 使用判斷是否已登入服務方法
        setIsLoggedIn(apiResponse.data.isLoggedIn);
      } catch (error) {
        console.error("無法檢查登入狀態:", error);
        alert("無法連接到伺服器，請檢查網路連線或伺服器狀態。");
      }
    };

    initializeLoginStatus();
  }, []);

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
      alert(e);
      console.error("登入錯誤:", e);
    }
  };

  // 處理登出邏輯
  const handleLogout = async() => {
    try {
      const data = await logout(); // 使用登出服務方法
      setIsLoggedIn(false);
      alert(data.message);
      window.location.href = '/';
    } catch (error) {
      alert(error);
    }
  };

  // 加入購物車
  const addToCart = (product) => {
    const item = {
      product: product,
      qty: 1
    };
    console.log(product);
    setCartItems([...cartItems, item]);
  }

  return (
    <Router>
      {/* 導航列-位於最上方 */}
      <Navbar isLoggedIn={isLoggedIn} onLogout={handleLogout} />
      {/* 主要內容區塊-位於中間部分 */}
      <div className="content">
        <Routes>
          {/* 首頁路由 Home 組件 */}
          <Route path="/" element={<Home />} />

          {/* 商品路由 Product 組件 */}
          <Route path="/products" element={<Products addToCart={addToCart} isLoggedIn={isLoggedIn} />} />
          
          {/* 登入路由 LoginPage 組件 */}
          <Route path="/login" element={<LoginPage onLogin={handleLogin} />} />
..
        </Routes>
      </div>
      {/* 頁尾-位於最下方 */}
      <Footer />
    </Router>
  );
}

export default App
