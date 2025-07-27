import React from 'react';
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import './App.css';
import Home from './components/Home';
import TrainerList from './components/TrainerList';
import TrainerDetails from './components/TrainerDetails';
import TrainerMock from './TrainerMock';
function App() {
  return (
    <BrowserRouter>
      <div style={{
        padding: "30px",
        fontFamily: "Arial, sans-serif",
        backgroundColor: "#f0f0f0",
        minHeight: "100vh"
      }}>
        <h1>My Academy Trainers App</h1>
        <nav>
          <Link to="/" style={{ marginRight: "15px", color: "purple", textDecoration: "underline" }}>
            Home
          </Link>
          <Link to="/trainers" style={{ color: "purple", textDecoration: "underline" }}>
            Show Trainers
          </Link>
        </nav>
        <hr />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/trainers" element={<TrainerList data={TrainerMock} />} />
          <Route path="/trainers/:id" element={<TrainerDetails/>} />
        </Routes>
      </div>
    </BrowserRouter>

  );
}

export default App;
