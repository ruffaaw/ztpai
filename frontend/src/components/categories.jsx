/** @format */

import React from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faBars,
  faDesktop,
  faLaptop,
  faMobile,
  faTv,
} from "@fortawesome/free-solid-svg-icons";
// import "../css/components.css";
function Categories() {
  return (
    <div className="categoriesContainer">
      <div classname="categories">
        <FontAwesomeIcon className="categoriesIcon" icon={faBars} />
        <label className="categoriesLabel">Categories</label>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faDesktop} />
        <button className="categoriesButton">
          <label className="categoriesProductsLabel">Desktop</label>
        </button>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faLaptop} />
        <button className="categoriesButton">
          <label className="categoriesProductsLabel">Laptop</label>
        </button>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faMobile} />
        <button className="categoriesButton">
          <label className="categoriesProductsLabel">Smartphone</label>
        </button>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faTv} />
        <button className="categoriesButton">
          <label className="categoriesProductsLabel">TV</label>
        </button>
      </div>
    </div>
  );
}

export default Categories;
