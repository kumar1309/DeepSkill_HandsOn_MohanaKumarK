import React from 'react';
const ListOfPlayers=()=>{
    const players=[
    { name: 'Jack', score: 50 },
    { name: 'Michael', score: 70 },
    { name: 'John', score: 40 },
    { name: 'Amin', score: 61 },
    { name: 'Elisabeth', score: 61 },
    { name: 'Sachin', score: 95 },
    { name: 'Dhoni', score: 100 },
    { name: 'Virat', score: 84 },
    { name: 'Jadeja', score: 64 },
    { name: 'Raina', score: 75 },
    { name: 'Rohit', score: 80 },
  ];
  const filteredPlayers=players.filter(player=>player.score<70);
  return(
    <div>
        <h2>List of Players</h2>
        {players.map((player,index)=>(
            <li key={index}>Mr.{player.name} {player.score}</li>
        ))
        }
        <br/>
        <h2>List of Players having score less than 70</h2>
        {filteredPlayers.map((player,index)=>(
            <li key={index}>Mr.{player.name} {player.score}</li>
        ))}

        <p>When Flag=False</p>
     </div>
  );
}
export default ListOfPlayers;