import React from 'react';
class CountPeople extends React.Component {
    constructor(){
        super();
        this.state={
            entrycount: 0,
            exitcount: 0
        }
    }
    updateentry=()=>{
        this.setState((prevState)=>({
            entrycount: prevState.entrycount + 1
        }))
    }

    updateexit=()=>{
        this.setState((prevState)=>({
            exitcount: prevState.exitcount + 1
        }))
    }
    render(){
        return(
            <div style={{textAlign: "center ", marginTop: "50px"}}>
                <button onClick={this.updateentry} style={{marginRight:"20px", backgroundColor:"lightgreen"}}>Login</button>
                <span> {this.state.entrycount} People Entered !!!</span>
                <button onClick={this.updateexit} style={{marginRight:"20px", backgroundColor:"lightgreen"}}>Exit</button>
                <span> {this.state.exitcount} People Left !!!</span>
            </div>
        )
    }
}
export default CountPeople;