import React, { useEffect, useState } from "react";
import { axiosWithAuth } from "./axiosWithAuth";
import { useHistory } from "react-router-dom";

const GetUserInfo = (props) => {
  const [userData, setUserData] = useState({});
  const history = useHistory();

  const logout = () => {
    localStorage.clear("token");
    history.push("/");
  };
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

  const getPlants = () => {
    axiosWithAuth()
      .get(`/plants/${userData.userid}`)
      .then((res) => {
        console.log(res.data);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <>
      <div>
        <h1> Hi, {userData.username}! </h1>
        <h3> {userData.primaryemail} </h3>
        <br />
        <p>Congratulations! You are now a Back-end developer.</p>
        <button onClick={getPlants}>getplants</button>
      </div>
      <br />
      <div className="logout">
        <button type="button" onClick={logout}>
          {" "}
          Logout{" "}
        </button>
      </div>
    </>
  );
};

export default GetUserInfo;
