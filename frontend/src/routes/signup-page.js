/** @format */

import React, { useState } from "react";
import logo from "../img/logos/logo.svg";
import "../css/signup.css";
import axios from "axios";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faEyeSlash,
  faEye,
  faEnvelope,
  faLock,
  faUser,
  faMobile,
} from "@fortawesome/free-solid-svg-icons";
import { useNavigate } from "react-router-dom";

function SignUpPage() {
  const [email, setEmail] = useState("");
  const [name, setName] = useState("");
  const [surname, setSurname] = useState("");
  const [password, setPassword] = useState("");
  const [confirmPassword, setConfirmPassword] = useState("");
  const [phone, setPhone] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [showConfirmPassword, setShowConfirmPassword] = useState(false);
  const [passwordsMatch, setPasswordsMatch] = useState(true);

  const navigate = useNavigate();

  const handleCategoryClick = () => {
    navigate(`/login`);
  };

  const handleShowPassword = (e) => {
    e.preventDefault();
    setShowPassword(!showPassword);
  };

  const handleSignUp = async () => {
    if (!passwordsMatch) {
      alert("Password or password confirmation is incorrect. Please try again");
      return;
    }

    const userData = {
      email: email,
      name: name,
      surname: surname,
      password: password,
      phone: phone,
    };

    try {
      const response = await axios.post(
        "http://localhost:8080/api/person",
        userData
      );
      navigate(`/login`);
    } catch (error) {
      console.error(error);
    }
  };

  const handleShowConfirmPassword = (e) => {
    e.preventDefault();
    setShowConfirmPassword(!showConfirmPassword);
  };

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handleNameChange = (e) => {
    setName(e.target.value);
  };

  const handleSurnameChange = (e) => {
    setSurname(e.target.value);
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

  const handlePhoneChange = (e) => {
    setPhone(e.target.value);
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
              value={email}
              onChange={handleEmailChange}
            />
          </div>
          <div className="inputDateName">
            <div className="userName">
              <FontAwesomeIcon icon={faUser} />
            </div>
            <input
              className="name"
              type="text"
              placeholder="name"
              value={name}
              onChange={handleNameChange}
            />
          </div>
          <div className="inputDateSurname">
            <div className="userSurname">
              <FontAwesomeIcon icon={faUser} />
            </div>
            <input
              className="surname"
              type="text"
              placeholder="surname"
              value={surname}
              onChange={handleSurnameChange}
            />
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
            <input
              className="phone"
              type="text"
              placeholder="phone"
              value={phone}
              onChange={handlePhoneChange}
            />
          </div>
          <div className="buttons">
            <button
              className="loginButton"
              type="submit"
              onClick={handleCategoryClick}
            >
              LOGIN
            </button>
            <button
              className="signUpButton"
              type="submit"
              onClick={handleSignUp}
            >
              SIGN UP
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default SignUpPage;
