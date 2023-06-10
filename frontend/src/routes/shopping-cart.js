/** @format */

import React, { useState, useEffect } from "react";
import HeaderBar from "../components/header";
import axios from "axios";
import "../css/shoppingcart.css";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faTrash } from "@fortawesome/free-solid-svg-icons";

function ShoppingCart() {
  const [cartItems, setCartItems] = useState([]);

  useEffect(() => {
    axios
      .get(
        "http://localhost:8080/api/shopping-cart/a53ce94c-bf0d-4f64-868f-6beccd9e3eea"
      )
      .then((response) => {
        setCartItems(response.data.cartItems);
      })
      .catch((error) => {
        console.error("Error fetching cart items:", error);
      });
  }, []);

  const removeCartItem = (itemId) => {
    axios
      .delete(
        `http://localhost:8080/api/shopping-cart/a53ce94c-bf0d-4f64-868f-6beccd9e3eea/delete-item/${itemId}`
      )
      .then((response) => {
        if (response.status === 200) {
          setCartItems(cartItems.filter((item) => item.cartItemsId !== itemId));
        }
      })
      .catch((error) => {
        console.error("Error removing cart item:", error);
      });
  };

  return (
    <div className="shoppingCartContainer">
      <div className="headerContainer">
        <HeaderBar />
      </div>
      <div className="cartItems">
        <h2>Your Shopping Cart</h2>
        {cartItems.length === 0 ? (
          <p>Your shopping cart is empty</p>
        ) : (
          cartItems.map((item) => (
            <div key={item.cartItemsId} className="cartItemDetails">
              <h3>{item.products.name}</h3>
              <div className="product">
                <div className="cartDetails">
                  <p>Quantity: {item.quantity}</p>
                  <p className="price">Price: {item.products.price} PLN</p>
                </div>
                <div className="trash">
                  <button onClick={() => removeCartItem(item.cartItemsId)}>
                    <FontAwesomeIcon className="trashIcon" icon={faTrash} />
                  </button>
                </div>
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  );
}

export default ShoppingCart;
