import React from 'react';
import { Link } from 'react-router-dom';

function Merchants() {
    return (
        <div>
            <h1>Merchants</h1>
            <Link to="/signup/merchant">Sign Up</Link>
            <Link to="/signin">Sign In</Link>
        </div>
    );
}

export default Merchants;
