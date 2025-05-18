import React, { useState } from "react";
import axios from "axios";

function FaturaForm() {
    const [form, setForm] = useState({
        userId: 1,          // Şimdilik sabit kullanıcı ID, login ile dinamik yapılabilir
        billId: "",
        consumption: "",
        billingMonth: "",
    });

    // Form alanları değiştikçe state güncelle
    const handleChange = (e) => {
        setForm({ ...form, [e.target.name]: e.target.value });
    };

    // Form gönderildiğinde
    const handleSubmit = (e) => {
        e.preventDefault();

        // Basit validasyon: boş alan kontrolü
        if (!form.billId || !form.consumption || !form.billingMonth) {
            alert("Lütfen tüm alanları doldurun.");
            return;
        }

        // Backend'e POST isteği
        axios
            .post("http://localhost:8080/api/bills", form)
            .then((response) => {
                alert("Fatura verisi başarıyla kaydedildi!");
                // Formu temizle
                setForm({ ...form, billId: "", consumption: "", billingMonth: "" });
            })
            .catch((error) => {
                console.error(error);
                alert("Bir hata oluştu. Lütfen tekrar deneyin.");
            });
    };

    return (
        <div style={{ padding: "30px", fontFamily: "Arial, sans-serif" }}>
            <h2>Fatura Girişi</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>Fatura Türü:</label>
                    <select
                        name="billId"
                        value={form.billId}
                        onChange={handleChange}
                        required
                    >
                        <option value="">Seçiniz</option>
                        <option value="1">Elektrik</option>
                        <option value="2">Su</option>
                        <option value="3">Doğalgaz</option>
                    </select>
                </div>

                <div style={{ marginTop: 10 }}>
                    <label>Tüketim Miktarı:</label>
                    <input
                        type="number"
                        name="consumption"
                        value={form.consumption}
                        onChange={handleChange}
                        placeholder="Örn: 150"
                        required
                    />
                </div>

                <div style={{ marginTop: 10 }}>
                    <label>Ay (YYYY-MM):</label>
                    <input
                        type="month"
                        name="billingMonth"
                        value={form.billingMonth}
                        onChange={handleChange}
                        required
                    />
                </div>

                <button
                    type="submit"
                    style={{
                        marginTop: 20,
                        padding: "10px 20px",
                        backgroundColor: "#1A73E8",
                        color: "white",
                        border: "none",
                        borderRadius: 5,
                        cursor: "pointer",
                    }}
                >
                    Gönder
                </button>
            </form>
        </div>
    );
}

export default FaturaForm;
