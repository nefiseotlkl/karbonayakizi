// src/pages/FaturaForm.js
import React, { useState } from 'react';
import axios from 'axios';

function FaturaForm() {
    const [form, setForm] = useState({
        userId: 1,  // Geçici olarak sabit, login sisteminden sonra dinamik olur
        billId: '',
        consumption: '',
        billingMonth: ''
    });

    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        axios.post("http://localhost:8080/api/bills", form)
            .then(res => {
                alert("Fatura verisi başarıyla kaydedildi!");
                setForm({ ...form, consumption: '', billingMonth: '' }); // formu temizle
            })
            .catch(err => {
                console.error(err);
                alert("Hata oluştu, lütfen tekrar deneyin.");
            });
    };

    return (
        <div style={{ padding: '30px' }}>
            <h2>Fatura Girişi</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Fatura Türü:</label>
                    <select name="billId" value={form.billId} onChange={handleChange} required>
                        <option value="">Seçiniz</option>
                        <option value="1">Elektrik</option>
                        <option value="2">Su</option>
                        <option value="3">Doğalgaz</option>
                    </select>
                </div>

                <div>
                    <label>Tüketim Miktarı:</label>
                    <input
                        type="number"
                        name="consumption"
                        value={form.consumption}
                        onChange={handleChange}
                        required
                    />
                </div>

                <div>
                    <label>Ay (yyyy-mm):</label>
                    <input
                        type="month"
                        name="billingMonth"
                        value={form.billingMonth}
                        onChange={handleChange}
                        required
                    />
                </div>

                <button type="submit">Gönder</button>
            </form>
        </div>
    );
}

export default FaturaForm;
