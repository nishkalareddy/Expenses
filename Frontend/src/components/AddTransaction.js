import { useState } from "react";
import { addTransaction } from "../services/api";
export default function AddTransaction({ onAdd }) {
    const [amount, setAmount] = useState("");
    const [type, setType] = useState("expense");
    const [category, setCategory] = useState("");
    const handleSubmit = async (e) => {
    e.preventDefault();
    const newTransaction = { amount, type, category };
    await addTransaction(newTransaction);
    onAdd(); // refresh data
    setAmount("");
    setCategory("");
    };
return (
  <form onSubmit={handleSubmit} style={{ marginBottom: "20px" }}>
    <input
      type="number"
      placeholder="Amount"
      value={amount}
      onChange={(e) => setAmount(e.target.value)}
      required
    />
    <select value={type} onChange={(e) => setType(e.target.value)}>
      <option value="income">Income</option>
      <option value="expense">Expense</option>
    </select>
    <input
      type="text"
      placeholder="Category"
      value={category}
      onChange={(e) => setCategory(e.target.value)}
      required
    />
    <button type="submit">Add</button>
  </form>
);
}

