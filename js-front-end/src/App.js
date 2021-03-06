import React from "react";
import { Route } from "react-router-dom";
import Login from "./components/Login";
import GetUserInfo from "./components/UserInfo";
import ProtectedRoute from "./components/ProtectedRoute";
import "./App.css";
import SignUp from "./components/SignUp";
import Plants from "./components/Plants";

function App() {
  return (
    <div className="App">
      <SignUp />
      <Route exact path="/" component={Login} />
      <ProtectedRoute exact path="/userinfo" component={GetUserInfo} />
      <ProtectedRoute path="/plants" component={Plants} />
    </div>
  );
}

export default App;
