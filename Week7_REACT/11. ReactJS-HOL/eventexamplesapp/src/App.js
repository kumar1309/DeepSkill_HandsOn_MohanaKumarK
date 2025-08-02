import React, { useState } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

function App() {
  const [count, setCount] = useState(1);

  const increment = () => {
    setCount(count + 1);
    sayHello();
    sayMessage();
  };

  const decrement = () => {
    setCount(count - 1);
  };

  const sayHello = () => {
    console.log("Hello");
  };

  const sayMessage = () => {
    alert("Static message: Value incremented!");
  };

  const sayWelcome = (message) => {
    alert(message);
  };

  const handleClick = () => {
    alert("I was clicked");
  };

  return (
    <div style={{ padding: '20px' }}>
      <h1>{count}</h1>
      <button onClick={increment}>Increment</button> <br /><br />
      <button onClick={decrement}>Decrement</button> <br /><br />
      <button onClick={() => sayWelcome("Welcome")}>Say welcome</button> <br /><br />
      <button onClick={handleClick}>Click on me</button>

      <br /><br />
      <CurrencyConvertor />
    </div>
  );
}

export default App;
