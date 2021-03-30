import React, { useState } from "react";
import axios from "axios";
// import { useDispatch } from "react-redux";
// import { signInFunc } from "../../store/actions/loginActions";

const SignUp = (props) => {
  const [credentials, setCredentials] = useState({
    username: "",
    password: "",
    phoneNumber: "",
  });
  //   const dispatch = useDispatch();
  //   const submitHandler = (e) => {
  //     e.preventDefault();
  //     dispatch(signInFunc(credentials));
  //     console.log("submitted");
  //   };

  const handleChange = (e) =>
    setCredentials({
      ...credentials,
      [e.target.name]: e.target.value,
    });

  const submitHandler = (e) => {
    e.preventDefault();
    axios
      .post(
        "https://watermyplant-tt7.herokuapp.com/createnewuser",
        JSON.stringify(credentials)
      )
      .then((res) => {
        console.log(res);
      })
      .catch((err) => {
        console.log(err);
      });
  };

  return (
    <div className="Sign-Up">
      <h3>Sign-up Today!</h3>
      <form onSubmit={submitHandler}>
        <label>
          Username:
          <input
            type="text"
            name="username"
            value={credentials.username}
            onChange={handleChange}
          />
        </label>
        <label>
          Password:
          <input
            type="password"
            name="password"
            value={credentials.password}
            onChange={handleChange}
          />
        </label>
        <label>
          Mobile Phone Number:
          <input
            type="phoneNumber"
            name="phoneNumber"
            value={credentials.phoneNumber}
            onChange={handleChange}
          />
        </label>
        <button>Sign-Up</button>
      </form>
    </div>
  );
};
export default SignUp;
