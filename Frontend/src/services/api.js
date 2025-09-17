import axios from "axios";

const API_URL = "http://localhost:8080/api/transactions";

export const getTransactions = () => axios.get(API_URL);
export const addTransaction = (transaction) => axios.post(API_URL, transaction);
export const deleteTransaction = (id) => axios.delete(`${API_URL}/${id}`);
export const getBalance = () => axios.get(`${API_URL}/balance`);
