import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Dashboard from './pages/Dashboardd';
import FaturaForm from './pages/FaturaFormm';

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Dashboard />} />
        <Route path="/veri-gir/fatura" element={<FaturaForm />} />
      </Routes>
    </Router>
  );
}

export default App;
