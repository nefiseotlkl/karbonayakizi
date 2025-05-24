import React from "react";

export const Dashboard = () => {
  const handleLogout = () => {
    localStorage.removeItem("token");
    window.location.href = "/";
  };

  return (
    <div style={{ padding: 20 }}>
      <h1>Dashboard - Korunmuş Sayfa</h1>
      <p>Başarılı giriş yaptınız!</p>
      <button onClick={handleLogout}>Logout</button>
    </div>
  );
};
