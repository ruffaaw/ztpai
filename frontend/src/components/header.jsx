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

  const handleShoppingCartClick = () => {
    navigate(`/shoppingcart`);
  };
  return (
    <div className="headerBarContainer">
      <div className="logo">
        <Logo />
      </div>
      <div className="deliveryInformation">
        <FontAwesomeIcon className="truckIcon" icon={faTruck} />
        <label> Free Delivery from 199 PLN</label>
      </div>
      <div className="searchProduct">
        <input className="search" placeholder="search..." />
      </div>
      <button className="shoppingCartButton" onClick={handleShoppingCartClick}>
        <FontAwesomeIcon className="icon" icon={faCartShopping} />
      </button>
      <button className="logoutButton">
        <FontAwesomeIcon className="icon" icon={faRightFromBracket} />
      </button>
    </div>
  );
}

export default HeaderBar;