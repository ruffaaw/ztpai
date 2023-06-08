/** @format */

import React, { useState } from "react";
import logo from "../img/logos/logo.svg";
import "../css/login.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faEyeSlash,
  faEye,
  faEnvelope,
  faLock,
} from "@fortawesome/free-solid-svg-icons";

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
        <img src={logo} alt="Logo" />
      </div>
      <div className="loginPanel">
        <form>
          <div className="inputDateEmail">
            <div className="envelopeMail">
              <FontAwesomeIcon icon={faEnvelope} />
            </div>
            <input
              className="email"
              type="text"
              placeholder="email@email.com"
            />
          </div>
          <div className="inputDatePassword">
            <div className="lockPassword">
              <FontAwesomeIcon icon={faLock} />
            </div>
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
