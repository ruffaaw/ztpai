/** @format */
import { Routes, Route } from "react-router-dom";
import LoginPage from "./routes/login-page";
import SignUpPage from "./routes/signup-page";
import ProductsPage from "./routes/products-page";
import ProductsDesktopsPage from "./routes/products-desktops-page";
import ProductsLaptopsPage from "./routes/products-laptops-page";
import ProductsSmartphonesPage from "./routes/products-smartphones-page";
import ProductsTvPage from "./routes/products-tv-page";
import ShoppingCart from "./routes/shopping-cart";

function App() {
  return (
    <Routes>
      <Route path="/" element={<LoginPage />}></Route>
      <Route path="/login" element={<LoginPage />}></Route>
      <Route path="/signup" element={<SignUpPage />}></Route>
      <Route path="/products" element={<ProductsPage />}></Route>
      <Route
        path="/products/desktop"
        element={<ProductsDesktopsPage />}
      ></Route>
      <Route path="/products/laptop" element={<ProductsLaptopsPage />}></Route>
      <Route
        path="/products/smartphone"
        element={<ProductsSmartphonesPage />}
      ></Route>
      <Route path="/products/tv" element={<ProductsTvPage />}></Route>
      <Route path="/shoppingcart" element={<ShoppingCart />}></Route>
    </Routes>
  );
}

export default App;
