import React from 'react'
import '../Stylesheets/CalculatorScore.css'
const percentageTodecimal = (decimal) => {
    return (decimal.toFixed(2)+ "%");
}
const calcScore = (total, goal) => {
    return percentageTodecimal((total / goal));
}
const CalculatorScore = (props) => {
    const { name, school, total, goal } = props;
    const score = calcScore(total, goal);
    return (
        <div className="formatStyle">
            <h1><font color="Brown"> Student Details</font></h1>
            <div className='Name'>
                <b><span>Name:</span></b>
                <span>{name}</span>
            </div>
            <div className='School'>
                <b><span>School:</span></b>
                <span>{school}</span>
            </div>
            <div className='Total'>
                <b><span>Total:</span></b>
                <span>{total}</span>
            </div>
            <div className='Score'>
                <b><span>Score:</span></b>
                <span>{score}</span>
            </div>
        </div>
    )
}

export default CalculatorScore