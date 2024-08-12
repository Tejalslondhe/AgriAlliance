import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import Header from './components/Header';
import Footer from './components/Footer';
import Home from './components/Home';
import AboutUs from './components/AboutUs';
import Farmers from './components/Farmers';
import Merchants from './components/Merchants';
import Workers from './components/Workers';
import Doctors from './components/Doctors';
import ContactUs from './components/ContactUs';
import SignUp from './components/SignUp';
import SignIn from './components/SignIn';

function App() {
    return (
        <Router>
            <div>
                <Header />
                <Routes>
                    <Route path="/" element={<Home />} />
                    <Route path="/about" element={<AboutUs />} />
                    <Route path="/farmers" element={<Farmers />} />
                    <Route path="/merchants" element={<Merchants />} />
                    <Route path="/workers" element={<Workers />} />
                    <Route path="/doctors" element={<Doctors />} />
                    <Route path="/contact" element={<ContactUs />} />
                    <Route path="/signup/:userType" element={<SignUp />} />
                    <Route path="/signin" element={<SignIn />} />
                </Routes>
                <Footer />
            </div>
        </Router>
    );
}

export default App;
