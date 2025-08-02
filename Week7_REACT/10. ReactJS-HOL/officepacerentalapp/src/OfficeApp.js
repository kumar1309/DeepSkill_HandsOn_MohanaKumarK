import React from "react";

const getRentColor = (rent) => {
  return rent <= 60000 ? { color: "red" } : { color: "green" };
};

const OfficeApp = () => {
  const heading = "Office Space Rental App";
  const officeList = [
    {
      Name: "DBS",
      Rent: 50000,
      Address: "Chennai",
      image: "https://images.pexels.com/photos/245240/pexels-photo-245240.jpeg?cs=srgb&dl=architecture-book-shelves-bookcase-245240.jpg&fm=jpg",
    },
    {
      Name: "Regus",
      Rent: 65000,
      Address: "Mumbai",
      image: "https://southgaterealtyllc.com/wp-content/uploads/2017/12/shutterstock_735875389.jpg",
    },
    {
      Name: "WeWork",
      Rent: 58000,
      Address: "Bangalore",
      image: "https://wallpapers.com/images/hd/office-pictures-l1uenky9l8d29djp.jpg",
    },
  ];

  return (
    <div style={{ padding: "20px" }}>
      <h1>{heading}</h1>
      <p>Find affordable office spaces in major Indian cities.</p>
      {officeList.map((item, index) => (
        <div key={index} style={{ marginBottom: "30px" }}>
          <img src={item.image} width="300px" alt="Office" />
          <h2>Name: {item.Name}</h2>
          <h3 style={getRentColor(item.Rent)}>Rent: Rs. {item.Rent}</h3>
          <h3>Address: {item.Address}</h3>
        </div>
      ))}
    </div>
  );
};

export default OfficeApp;
