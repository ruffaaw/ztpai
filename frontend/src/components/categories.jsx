/** @format */

import React, { useState } from "react";

import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faBars,
  faDesktop,
  faLaptop,
  faMobile,
  faTv,
} from "@fortawesome/free-solid-svg-icons";
import { useNavigate } from "react-router-dom";

function Categories() {
  const [selectedCategory, setSelectedCategory] = useState(null);
  const navigate = useNavigate();

  const handleCategoryClick = (category) => {
    setSelectedCategory(category);
    navigate(`/products/${selectedCategory}`);
  };

  return (
    <div className="categoriesContainer">
      <div classname="categories">
        <FontAwesomeIcon className="categoriesIcon" icon={faBars} />
        <label className="categoriesLabel">Categories</label>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faDesktop} />
        <button
          className="categoriesButton"
          onClick={() => handleCategoryClick("desktop")}
        >
          <label className="categoriesProductsLabel">Desktop</label>
        </button>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faLaptop} />
        <button
          className="categoriesButton"
          onClick={() => handleCategoryClick("laptop")}
        >
          <label className="categoriesProductsLabel">Laptop</label>
        </button>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faMobile} />
        <button
          className="categoriesButton"
          onClick={() => handleCategoryClick("smartphone")}
        >
          <label className="categoriesProductsLabel">Smartphone</label>
        </button>
      </div>
      <div classname="categoriesProducts">
        <FontAwesomeIcon className="categoriesProductsIcon" icon={faTv} />
        <button
          className="categoriesButton"
          onClick={() => handleCategoryClick("tv")}
        >
          <label className="categoriesProductsLabel">TV</label>
        </button>
      </div>
    </div>
  );
}

export default Categories;
