// src/pages/Dashboard.js
import React from 'react';
import { Link } from 'react-router-dom';

function Dashboard() {
    return (
        <div>
            <h1>Karbon Ayak İzi Dashboard</h1>
            <div>
                <Link to="/veri-gir/fatura">
                    <button>Fatura Girişi</button>
                </Link>
                <Link to="/veri-gir/beslenme">
                    <button>Beslenme Girişi</button>
                </Link>
                <Link to="/veri-gir/ulasim">
                    <button>Ulaşım Girişi</button>
                </Link>
            </div>
        </div>
    );
}

export default Dashboard;
