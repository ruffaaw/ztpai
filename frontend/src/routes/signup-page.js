/** @format */

import React, { useState } from "react";
import logo from "../img/logos/logo.svg";
import "../css/signup.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faEyeSlash,
  faEye,
  faEnvelope,
  faLock,
  faUser,
  faMobile,
} from "@fortawesome/free-solid-svg-icons";

function SignUpPage() {
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [passwordsMatch, setPasswordsMatch] = useState(true);

  const handleShowPassword = (e) => {
    e.preventDefault();
    setShowPassword(!showPassword);
  };

  const handleShowConfirmPassword = (e) => {
    e.preventDefault();
    setShowConfirmPassword(!showConfirmPassword);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
    if (!passwordsMatch) {
      setPasswordsMatch(e.target.value === confirmPassword);
    }
  };

  const handleConfirmPasswordChange = (e) => {
    setConfirmPassword(e.target.value);
    setPasswordsMatch(e.target.value === password);
  };

  return (
    <div className="signUpMainContainer">
      <div className="logoContainer">
        <img src={logo} alt="Logo" />
      </div>
      <div className="signUpPanel">
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
          <div className="inputDateName">
            <div className="userName">
              <FontAwesomeIcon icon={faUser} />
            </div>
            <input className="name" type="text" placeholder="name" />
          </div>
          <div className="inputDateSurname">
            <div className="userSurname">
              <FontAwesomeIcon icon={faUser} />
            </div>
            <input className="surname" type="text" placeholder="surname" />
          </div>
          <div
            className={`inputDatePassword ${!passwordsMatch ? "error" : ""}`}
          >
            <div className="lockPassword">
              <FontAwesomeIcon icon={faLock} />
            </div>
            <input
              className="password"
              type={showPassword ? "text" : "password"}
              placeholder="password"
              onChange={handlePasswordChange}
            />
            <button className="eyeButton" onClick={handleShowPassword}>
              {showPassword ? (
                <FontAwesomeIcon icon={faEye} />
              ) : (
                <FontAwesomeIcon icon={faEyeSlash} />
              )}
            </button>
          </div>
          <div
            className={`inputDateConfirmPassword ${
              !passwordsMatch ? "error" : ""
            }`}
          >
            <div className="lockConfirmPassword">
              <FontAwesomeIcon icon={faLock} />
            </div>
            <input
              className="confirmPassword"
              type={showConfirmPassword ? "text" : "password"}
              placeholder="confirm password"
              onChange={handleConfirmPasswordChange}
            />
            <button className="eyeButton" onClick={handleShowConfirmPassword}>
              {showConfirmPassword ? (
                <FontAwesomeIcon icon={faEye} />
              ) : (
                <FontAwesomeIcon icon={faEyeSlash} />
              )}
            </button>
          </div>
          <div className="inputDatePhone">
            <div className="mobilePhone">
              <FontAwesomeIcon icon={faMobile} />
            </div>
            <input className="phone" type="text" placeholder="phone" />
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

export default SignUpPage;
