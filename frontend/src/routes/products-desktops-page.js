/** @format */

import React, { useState, useEffect } from "react";
import HeaderBar from "../components/header";
import Categories from "../components/categories";
import axios from "axios";
import "../css/products.css";

function ProductsDesktopsPage() {
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
    const addToCart = (cartItem) => {
        console.log(cartItem);
        const cartItemRequest = {
            products: {
                id: cartItem.id,
            },
            quantity: 1,
        };
        axios
            .post(
                `http://localhost:8080/api/shopping-cart/a53ce94c-bf0d-4f64-868f-6beccd9e3eea/add-item`,
                cartItemRequest
            )
            .then((response) => {
                console.log("Item added to cart:", response.data);
            })
            .catch((error) => {
                console.error("Error adding item to cart:", error);
            });
    };
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
                <button onClick={() => addToCart(product)}>Add to cart</button>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
}

export default ProductsDesktopsPage;
