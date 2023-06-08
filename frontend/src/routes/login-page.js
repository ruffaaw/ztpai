/** @format */

import React, { useState } from "react";
import logo from "../img/logos/logo.svg";
import "../css/login.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faEyeSlash, faEye } from "@fortawesome/free-solid-svg-icons";

function LoginPage() {
  const [showPassword, setShowPassword] = useState(false);

  const handleShowPassword = (e) => {
    console.log(showPassword);
    e.preventDefault();
    setShowPassword(!showPassword);
  };

  return (
    <div className="container">
      <div className="logoContainer">
        <img src={logo}></img>
      </div>
      <div className="loginPanel">
        <form>
          <div className="inputDateEmail">
            <input
              className="email"
              type="text"
              placeholder="email@email.com"
            />
          </div>
          <div className="inputDatePassword">
            <input
              className="password"
              type={showPassword ? "text" : "password"}
              placeholder="password"
            />
            <button className="eyeButton" onClick={handleShowPassword}>
              {showPassword ? (
                <FontAwesomeIcon icon={faEye} />
              ) : (
                <FontAwesomeIcon icon={faEyeSlash} />
              )}
            </button>
          </div>
          <div className="buttons">
            <button className="loginButton" type="submit">
              LOGIN
            </button>
            <button className="signUpButton" type="submit">
              SIGN UP
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default LoginPage;
