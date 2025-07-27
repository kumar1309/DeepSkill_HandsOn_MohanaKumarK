import React from 'react';
import Cart from './Cart';


class OnlineShopping extends React.Component {
    render(){
        const items=[
            {itemname:"Laptop",price:80000},
            {itemname:"TV",price:120000},
            {itemname:"WashingMachine",price:50000},
            {itemname:"Mobile",price:30000},
            {itemname:"Fridge",price:70000}
        ]
        return(
            <div>
                <Cart items={items} />
            </div>
        )
    }
}
export default OnlineShopping;