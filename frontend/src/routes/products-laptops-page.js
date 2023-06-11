/** @format */

import React, { useState, useEffect } from "react";
import HeaderBar from "../components/header";
import Categories from "../components/categories";
import axios from "axios";
import "../css/products.css";

function ProductsLaptopsPage() {
  const [products, setProducts] = useState([]);

  useEffect(() => {
    axios
      .get("http://localhost:8080/api/products/type/1")
      .then((response) => {
        setProducts(response.data);
      })
      .catch((error) => {
        console.error("Error fetching products:", error);
      });
  }, []);
  return (
    <div className="productsMainContainer">
      <div className="headerContainer">
        <HeaderBar />
      </div>
      <div className="mainContainer">
        <div className="mainCategoriesContainer">
          <Categories />
        </div>
        <div className="productsContainer">
          {products.map((product) => (
            <div key={product.id} className="productItem">
              <img src={product.image} alt={product.name} />
              {console.log(product.image)}
              <h3>{product.name}</h3>
              <p>{product.price} PLN</p>
              <div className="addToCartButton">
                <button>Add to cart</button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ProductsLaptopsPage;
