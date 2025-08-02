import React from 'react';
const IndianPlayers=()=>{
    const players=['Sachin', 'Dhoni', 'Virat', 'Rohit', 'Yuvraj', 'Raina'];
    const [first,second,third,fourth,fifith,sixth]=players;
    const T20Players=['first Player', 'second Player', 'third Player'];;
    const RanjiPlayers=['fourth Player', 'fifth Player', 'sixth Player'];
    const mergePlayers=[...T20Players,...RanjiPlayers];
    return(
        <div>
            <h2>Odd Players</h2>
            <li>First: {first}</li>
            <li>Third: {third}</li>
            <li>Fifth: {fifith}</li>


            <h2>Even Players</h2>
            <li>Second: {second}</li>
            <li>Fourth: {fourth}</li>
            <li>Sixth: {sixth}</li>
            <br/>
            <h2>List of Indian Players</h2>
            {mergePlayers.map((player,index)=>(
                <li key={index}>Mr.{player}</li>
            ))}
        </div>
    )
}
export default IndianPlayers;