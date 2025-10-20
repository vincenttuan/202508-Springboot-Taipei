// src/pages/TestPage.jsx
import React, { useState } from "react";

// 匯入 service 函式
import {
  login,
  logout,
  checkLoginStatus,
} from "../services/authService";

import {
  checkoutCart,
  fetchOrderHistory,
} from "../services/cartService";

import {
  fetchFavorites,
  addFavorite,
  removeFavorite,
} from "../services/favoriteService";

import {
  fetchProducts,
  addProduct,
} from "../services/productService";

const TestPage = () => {
  const [apiResult, setApiResult] = useState(null); // 顯示結果

  // ========== Auth ==========
  const handleLogin = async () => {
    try {
      const res = await login("john", "1234"); // 🔥 硬編碼帳密，POST JSON 格式
      console.log("✅ 登入成功", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 登入失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  const handleLogout = async () => {
    try {
      const res = await logout();
      console.log("✅ 登出成功", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 登出失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  const handleCheckLogin = async () => {
    try {
      const res = await checkLoginStatus();
      console.log("✅ 登入狀態", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 取得登入狀態失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  // ========== Cart ==========
  const handleCheckout = async () => {
    try {
      const res = await checkoutCart([
        { productId: 1, quantity: 2 },
        { productId: 2, quantity: 1 },
      ]);
      console.log("✅ 結帳成功", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 結帳失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  const handleFetchOrders = async () => {
    try {
      const res = await fetchOrderHistory();
      console.log("✅ 訂單紀錄", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 無法取得訂單紀錄", err.message);
      setApiResult({ error: err.message });
    }
  };

  // ========== Favorites ==========
  const handleFetchFavorites = async () => {
    try {
      const res = await fetchFavorites();
      console.log("✅ 關注清單", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 無法取得關注清單", err.message);
      setApiResult({ error: err.message });
    }
  };

  const handleAddFavorite = async () => {
    try {
      const res = await addFavorite(1);
      console.log("✅ 已新增關注", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 新增關注失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  const handleRemoveFavorite = async () => {
    try {
      const res = await removeFavorite(1);
      console.log("✅ 已移除關注", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 移除關注失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  // ========== Products ==========
  const handleFetchProducts = async () => {
    try {
      const res = await fetchProducts();
      console.log("✅ 產品列表", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 取得產品列表失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  const handleAddProduct = async () => {
    try {
      const newProduct = {
        name: "測試商品",
        price: 100,
        description: "這是一個測試用商品",
        stock: 10,
      };
      const res = await addProduct(newProduct);
      console.log("✅ 新增商品成功", res);
      setApiResult(res);
    } catch (err) {
      console.error("❌ 新增商品失敗", err.message);
      setApiResult({ error: err.message });
    }
  };

  return (
    <div style={{ padding: "20px", fontFamily: "Arial" }}>
      <h2>🧪 API 測試頁</h2>

      <h3>🔐 Auth</h3>
      <button onClick={handleLogin}>登入（POST, JSON）</button>
      <button onClick={handleCheckLogin}>檢查登入狀態</button>
      <button onClick={handleLogout}>登出</button>

      <h3>🛒 Cart</h3>
      <button onClick={handleCheckout}>結帳</button>
      <button onClick={handleFetchOrders}>取得訂單紀錄</button>

      <h3>⭐ Favorites</h3>
      <button onClick={handleFetchFavorites}>取得關注清單</button>
      <button onClick={handleAddFavorite}>新增關注 (productId: 1)</button>
      <button onClick={handleRemoveFavorite}>移除關注 (productId: 1)</button>

      <h3>📦 Products</h3>
      <button onClick={handleFetchProducts}>取得產品列表</button>
      <button onClick={handleAddProduct}>新增商品</button>

      <h3>📋 API 回傳結果</h3>
      <pre
        style={{
          background: "#f4f4f4",
          padding: "10px",
          borderRadius: "5px",
          maxHeight: "400px",
          overflowY: "auto",
        }}
      >
        {apiResult ? JSON.stringify(apiResult, null, 2) : "尚未執行操作"}
      </pre>
    </div>
  );
};

export default TestPage;
