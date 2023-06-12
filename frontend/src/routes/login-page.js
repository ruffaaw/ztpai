/** @format */

import React, { useState } from "react";
import logo from "../img/logos/logo.svg";
import "../css/login.css";
import axios from "axios";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faEyeSlash,
  faEye,
  faEnvelope,
  faLock,
} from "@fortawesome/free-solid-svg-icons";
import { useNavigate } from "react-router-dom";

function LoginPage() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);

  const navigate = useNavigate();

  const handleEmailChange = (e) => {
    setEmail(e.target.value);
  };

  const handlePasswordChange = (e) => {
    setPassword(e.target.value);
  };

  const handleSignUpClick = () => {
    navigate(`/signup`);
  };

  const handleShowPassword = (e) => {
    console.log(showPassword);
    e.preventDefault();
    setShowPassword(!showPassword);
  };

  const handleLogin = async (e) => {
    e.preventDefault();

    try {
      const response = await axios.post(
        "http://localhost:8080/api/person/login",
        {
          email,
          password,
        }
      );
      console.log(response.data);

      if (response.status === 200) {
        window.location.href = "/products";
      } else {
        alert("Wrong email or password, please try again");
      }
    } catch (error) {
      console.log(error);
      alert("Wrong email or password, please try again");
    }
  };

  return (
    <div className="loginMaincontainer">
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
              value={email}
              onChange={handleEmailChange}
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
              value={password}
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
          <div className="buttons">
            <button className="loginButton" type="submit" onClick={handleLogin}>
              LOGIN
            </button>
            <button
              className="signUpButton"
              type="submit"
              onClick={handleSignUpClick}
            >
              SIGN UP
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default LoginPage;
