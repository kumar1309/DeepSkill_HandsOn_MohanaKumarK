import React from 'react';


class Cart extends React.Component{
    render(){
        const { items } =this.props;
        return (
            <div>
                <h2 style={{color: 'green', textAlign: 'center'}}>Items Ordered</h2>
                <center>
                <table border='1' cellPadding='10'>
                    <thead>
                        <tr>
                            <th>Name</th>
                            <th>Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        {
                            items.map((iteam,index)=>(
                                <tr>
                                    <td>{iteam.itemname}</td>
                                    <td>{iteam.price}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
                </center>
            </div>
        )
    }
}
Cart.defaultProps={
    items:[
        {itemname:"default Item", price:"0"}
    ]
}
export default Cart;