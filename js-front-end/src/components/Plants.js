import React, { useEffect, useState } from "react";
import { axiosWithAuth } from "./axiosWithAuth";

export default function Plants(props) {
  const [userData, setUserData] = useState({});
  const [plants, setPlants] = useState([]);

  useEffect(() => {
    axiosWithAuth()
      .get("/users/getuserinfo")
      .then((res) => {
        setUserData(res.data);
      })
      .catch((err) => {
        debugger;
      });
  }, []);

  console.log(userData);

  useEffect(() => {
    axiosWithAuth()
      .get(`/plants/${userData.userid}`)
      .then((res) => {
        console.log(res.data);
        setPlants(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, [userData.userid]);
  console.log("plant", plants);

  return (
    <div>
      {plants.map((plant) => {
        return (
          <div key={plant.plantId}>
            <h1>{plant.nickname}</h1>
            <p>{plant.species}</p>
            <p>{plant.h2oFrequency}</p>
          </div>
        );
      })}
    </div>
  );
}
