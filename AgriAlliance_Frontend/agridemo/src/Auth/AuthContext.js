import React, { createContext, useState, useEffect } from 'react';

// Create Context
export const AuthContext = createContext();

// Create Provider Component
export const AuthProvider = ({ children }) => {
  const [isLoggedIn, setIsLoggedIn] = useState(false);
  const [userInfo, setUserInfo] = useState(null);

  // Check if user is already logged in on component mount
  useEffect(() => {
    const token = localStorage.getItem('token');
    if (token) {
      // Optionally, verify the token with the backend here and fetch user info
      // For now, just set the state based on token presence
      setIsLoggedIn(true);
      setUserInfo(JSON.parse(localStorage.getItem('userInfo')));
    }
  }, []);

  const handleLogin = (userData) => {
    setIsLoggedIn(true);
    setUserInfo(userData);
    localStorage.setItem('token', userData.token);
    localStorage.setItem('userInfo', JSON.stringify(userData));
  };

  const handleLogout = () => {
    setIsLoggedIn(false);
    setUserInfo(null);
    localStorage.removeItem('token');
    localStorage.removeItem('userInfo');
  };

  return (
    <AuthContext.Provider value={{ isLoggedIn, userInfo, handleLogin, handleLogout }}>
      {children}
    </AuthContext.Provider>
  );
};
