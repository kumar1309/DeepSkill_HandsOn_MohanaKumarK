import React from 'react';
import StyleSheet from './CohortDetails.module.css';
function CohortDetails(props) {
    const getTitleColor=(status)=>{
        return status==="Ongoing" ? "green" : "blue";
    }
    return (
        <div className={StyleSheet.box}>
            <h3 style={{color: getTitleColor(props.cohort.currentStatus)}}> 
                {props.cohort.cohortCode} -
                <span>{props.cohort.technology}</span>
            </h3>
            <dl>
                <dt>Started On</dt>
                <dd>{props.cohort.startDate}</dd>
                <dt>Current Status</dt>
                <dd>{props.cohort.currentStatus}</dd>
                <dt>Coach</dt>
                <dd>{props.cohort.coachName}</dd>
                <dt>Trainer</dt>
                <dd>{props.cohort.trainerName}</dd>
            </dl>
        </div>

        
    );
}
export default CohortDetails;