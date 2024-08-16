import React from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';

import SignIn from './components/SignIn';
import SignUp from './components/SignUp';
import Farmers from './components/Farmers';
import Merchants from './components/Merchants';
import Workers from './components/Workers';
import Agronomists from './components/Agronomists';
import Home from './components/Home';

function App() {
  return (
    <Router>
      <Header />
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/farmers" element={<Navigate to="/signin?category=farmers" />} />
        <Route path="/merchants" element={<Navigate to="/signin?category=merchants" />} />
        <Route path="/workers" element={<Navigate to="/signin?category=workers" />} />
        <Route path="/agronomists" element={<Navigate to="/signin?category=agronomists" />} />
        <Route path="/signin" element={<SignIn />} />
        <Route path="/signup" element={<SignUp />} />
      </Routes>

      <Footer />
    </Router>
  );
}

export default App;
