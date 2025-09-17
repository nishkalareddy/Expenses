import { useEffect, useState } from "react";
import { getBalance } from "./services/api";
import AddTransaction from "./components/AddTransaction";
import Balance from "./components/Balance";

function App() {
  const [balance, setBalance] = useState(0);
  const loadData = async () => {
    const res2 = await getBalance();
    setBalance(res2.data);
  };

  useEffect(() => {
    loadData();
  }, []);

  return (
    <div style={{ padding: "20px" }}>
      <h1>💰 Expense Tracker</h1>
      <Balance balance={balance} />
      <AddTransaction onAdd={loadData} />
    </div>
  );
}

export default App;
