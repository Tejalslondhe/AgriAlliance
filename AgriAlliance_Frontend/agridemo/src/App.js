// App.js
import React, { useContext } from 'react';
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';

import SignIn from './Auth/LoginPage';
import ForgotPasswordPage from './Auth/ForgotPasswordPage';
import RoleSelectionPage from './Auth/RoleBaseSelection'; 
import FAQPage from './components/FAQPage';
import AboutUsPage from './components/AboutUsPage';
import Home from './components/Home';
import RegistrationPage from './Auth/RegistrationPage';
import MerchantDashboard from './dashboard/MerchantDashboard';
import WorkerDashboard from './dashboard/WorkerDashboard';
import DoctorDashboard from './dashboard/DoctorDashboard';
import { AuthContext } from './Auth/AuthContext'; 
import FetchInstrument from './dashboard/FetchInstrument';
import BookInstrument from './dashboard/BookInstrument';
import FarmerDashboard from './dashboard/FarmerDashboard';

const App = () => {
  const { isLoggedIn, userInfo, handleLogout } = useContext(AuthContext);

  return (
    <Router>
      <Header isLoggedIn={isLoggedIn} userInfo={userInfo} handleLogout={handleLogout} />
      
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/role-selection" element={<RoleSelectionPage />} />
        <Route path="/faq" element={<FAQPage />} />
          <Route path="/about-us" element={<AboutUsPage />} />
        <Route path="/login" element={<SignIn />} />
        <Route path="/forgot-password" element={<ForgotPasswordPage />} />
        <Route path="/register" element={<RegistrationPage />} />
        <Route path="/farmerdashboard" element={isLoggedIn ? <FarmerDashboard /> : <Navigate to="/login?role=FARMER" />} />
        <Route path="/merchantdashboard" element={isLoggedIn ? <MerchantDashboard /> : <Navigate to="/login?role=MERCHANT" />} />
        <Route path="/workerdashboard" element={isLoggedIn ? <WorkerDashboard /> : <Navigate to="/login?role=WORKER" />} />
        <Route path="/doctordashboard" element={isLoggedIn ? <DoctorDashboard /> : <Navigate to="/login?role=DOCTOR" />} />
        <Route path="/instruments" element={<FetchInstrument />} />
        <Route path="/book-instrument" element={<BookInstrument />} />
        <Route path="/dashboard" element={<FarmerDashboard />} />
        
      </Routes>

      <Footer />
    </Router>
  );
}

export default App;
