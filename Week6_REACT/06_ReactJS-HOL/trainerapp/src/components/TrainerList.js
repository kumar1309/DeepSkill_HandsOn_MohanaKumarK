import React from 'react';
import { Link } from 'react-router-dom';
function TrainerList({data}){
    return (
        <div>
            <h2>TrainerList</h2>
            <ul>
                {data.map((trainer)=>(
                    <li key={trainer.TrainerId}>
                        <Link to={`/trainers/${trainer.TrainerId}`}>
                            {trainer.name}
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    )
}
export default TrainerList;