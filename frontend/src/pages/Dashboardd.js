import React from 'react';
import { Link } from 'react-router-dom';

const cardStyle = {
    flex: 1,
    padding: 20,
    backgroundColor: '#4caf50',
    color: 'white',
    borderRadius: 8,
    cursor: 'pointer',
    textAlign: 'center',
    fontWeight: 'bold',
    margin: 10,
};

function Dashboard() {
    return (
        <div style={{ padding: 30, fontFamily: 'Arial, sans-serif', backgroundColor: '#f5f5f5', minHeight: '100vh' }}>
            <h1 style={{ color: '#333' }}>Karbon Ayak İzi Dashboard</h1>
            <div style={{ display: 'flex', gap: 20 }}>
                <Link to="/veri-gir/fatura" style={{ textDecoration: 'none', flex: 1 }}>
                    <div style={{ ...cardStyle, backgroundColor: '#1A73E8' }}>Fatura Girişi</div>
                </Link>
                <Link to="/veri-gir/beslenme" style={{ textDecoration: 'none', flex: 1 }}>
                    <div style={{ ...cardStyle, backgroundColor: '#F4B400' }}>Beslenme Girişi</div>
                </Link>
                <Link to="/veri-gir/ulasim" style={{ textDecoration: 'none', flex: 1 }}>
                    <div style={{ ...cardStyle, backgroundColor: '#34A853' }}>Ulaşım Girişi</div>
                </Link>
            </div>
        </div>
    );
}



<div style={cardStyle} onClick={() => window.location.href = '/veri-gir/fatura'}>
    Fatura Girişi
</div>

export default Dashboard;
