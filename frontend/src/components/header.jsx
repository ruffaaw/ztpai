/** @format */

import React from "react";
import Logo from "./logo";
import "../css/components.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faTruck,
  faCartShopping,
  faRightFromBracket,
} from "@fortawesome/free-solid-svg-icons";
import { useNavigate } from "react-router-dom";

function HeaderBar() {
  const navigate = useNavigate();

  const handleGoToShoppingCart = () => {
    navigate(`/shoppingcart`);
  };

  const handleGoToProducts = () => {
    navigate(`/products`);
  };

  const handleGoToLogin = () => {
    navigate(`/login`);
  };
  return (
    <div className="headerBarContainer">
      <div className="logo">
        <button onClick={handleGoToProducts}>
          <Logo />
        </button>
      </div>
      <div className="deliveryInformation">
        <FontAwesomeIcon className="truckIcon" icon={faTruck} />
        <label> Free Delivery from 199 PLN</label>
      </div>
      <div className="searchProduct">
        <input className="search" placeholder="search..." />
      </div>
      <button className="shoppingCartButton" onClick={handleGoToShoppingCart}>
        <FontAwesomeIcon className="icon" icon={faCartShopping} />
      </button>
      <button className="logoutButton" onClick={handleGoToLogin}>
        <FontAwesomeIcon className="icon" icon={faRightFromBracket} />
      </button>
    </div>
  );
}

export default HeaderBar;
