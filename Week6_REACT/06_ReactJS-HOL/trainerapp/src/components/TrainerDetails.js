import React from 'react'
import { useParams } from 'react-router-dom'
import TrainerMock from '../TrainerMock'
const TrainerDetails = () => {
  const { id } = useParams()
  console.log("URL id param:", id);
  const trainer = TrainerMock.find(t => t.TrainerId === id)
  console.log("Matched Trainer:", trainer);
  return trainer ? (
    <div style={{
      border: "1px solid black",
      padding: "20px",
      margin: "20px",
      width: "400px",
      backgroundColor: "white",
    }}>
      <h2>Trainer Details</h2>
      <h3>{trainer.name} ({trainer.technology})</h3>
      <p>{trainer.email}</p>
      <p>{trainer.phone}</p>
      <ul>
        {trainer.skills.map((skill, index) => (
          <li key={index}>{skill}</li>
        ))}
      </ul>
    </div>
  ) :
    (
      <div>
        <h2>Trainer Not Found</h2>
      </div>
    )
}

export default TrainerDetails