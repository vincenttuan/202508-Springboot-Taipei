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

function App() {
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
