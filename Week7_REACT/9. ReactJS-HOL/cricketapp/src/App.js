
import './App.css';
import ListOfPlayers from './components/ListOfPlayers';
import React from 'react';
import IndianPlayers from './components/IndeianPlayers';


function App() {
  const flag=false;
  return (
    <div >
      {flag ? <IndianPlayers /> : <ListOfPlayers />}
    </div>
  );
}

export default App;
