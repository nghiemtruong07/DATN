import { NavLink } from "react-router-dom";
import first from "../static/images/slider_1_image_1.jpg";
import second from "../static/images/slider_2_image_1.jpg";
import third from "../static/images/slider_4_image_1.jpg";
import fourth from "../static/images/slider_5_image_1.jpg";
import React, { useState, useEffect } from "react";
import { getAllProducts } from "../api/ProductApi";
import Product from "./Product";

const Home = (props) => {
  const [products, setProducts] = useState([]);
  const [productsMH, setProductsMH] = useState([]);
  const [page, setPage] = useState(1);
  const [total, setTotal] = useState({});
  const [active, setActive] = useState(true);

 /* var rows = new Array(total).fill(0).map((zero, index) => (
    <li
      className={page === index + 1 ? "page-item active" : "page-item"}
      key={index}
    >
      <button
        className="page-link"
        style={{ borderRadius: 50 }}
        onClick={() => onChangePage(index + 1)}
      >
        {index + 1}
      </button>
    </li>
  ));*/

  useEffect(() => {
    getAllProducts(1,100, active).then((response) =>
        {
          let LapTop = response.data.content.filter(obj => {
            return obj.brand === 'Laptop';
          });
          setProducts(LapTop);
          let Manhinhs = response.data.content.filter(obj => {
           return obj.brand === 'Màn hình';
           });
          setProductsMH(Manhinhs);
          //setTotal(1);
        }
    )});
  //  props.changeHeaderHandler(1);
  //}, [page]);

  //const onChangePage = (page) => {
  //  setPage(page);
 // };

  return (
    <div>
      {/* Carousel */}
      <div id="slides" className="carousel slide  mb-5" data-ride="carousel">
        <ul className="carousel-indicators">
          <li data-target="#slides" data-slide-to={0} className="active" />
          <li data-target="#slides" data-slide-to={1} />
          <li data-target="#slides" data-slide-to={2} />
          <li data-target="#slides" data-slide-to={3} />
        </ul>
        <div className="carousel-inner mini-card">
          <div className="carousel-item active">
            <img src={second} alt="" />
          </div>
          <div className="carousel-item">
            <img src={first} alt="" />
          </div>
          <div className="carousel-item">
            <img src={third} alt="" />
          </div>
          <div className="carousel-item">
            <img src={fourth} alt="" />
          </div>
        </div>
      </div>
      <div className="col-11 container-fluid card">
      <h4 className="title text-primary" > Sản phẩm Lap top :</h4>
        <div className="row padding d-flex">
          { 
            products.map((item, index) => (                    
              <div className="col-md-4 mb-3" key={index}>      
                <div className="card h-100 mini-pro">
                  <div className="d-flex justify-content-between position-absolute w-100">
                  </div>                             
                  <NavLink to={`/product-detail/${item.id}`}>
                    <img
                      src={require(`../static/images/${item.image}`)}
                      style={{ width: 175, height: 200 }}
                      alt="Product"
                      className="mini-card"
                    />
                  </NavLink>                                   
                  <div className="card-body px-2 pb-2 pt-1">
                    <div className="d-flex justify-content-between">
                      <div>
                        <p className="h4 text-primary mini-card">
                          {(
                            (item.price * (100 - item.discount)) /
                            100
                          ).toLocaleString()}{" "}
                          đ
                        </p>
                      </div>
                    </div>
                  
                    <p className="mb-0">
                      <strong>
                        <NavLink
                          to={`/product-detail/${item.id}`}
                          className="text-secondary "
                        >
                          {item.name}
                        </NavLink>
                      </strong>
                    </p>
                    <p className="mb-1">
                      <small>
                        <NavLink to="#" className="text-secondary ">
                          {item.brand }
                        </NavLink>
                      </small>
                    </p>
                    <div className="d-flex mb-3 justify-content-between">
                      <div>                     
                        <p className="mb-0 small">
                          <b>Giá gốc: {item.price.toLocaleString()} đ</b>
                        </p>                    
                      </div>
                    </div>
                    <div className="d-flex justify-content-between">
                      <div className="col px-0 ">
                        <NavLink
                          to={`/product-detail/${item.id}`}
                          exact
                          className="btn btn-outline-primary btn-block"
                        >
                          Thêm vào giỏ
                          <i
                            className="fa fa-shopping-basket"
                            aria-hidden="true"
                          ></i>
                        </NavLink>
                      </div>
                      
                    </div>
                  </div>
                </div>               
                
              </div>                    
            ))}
        </div>
      </div>

      <div className="col-11 container-fluid card">
      <h4 className="title text-primary" > Sản phẩm Màn hình :</h4>
        <div className="row padding d-flex">
          { 
            productsMH.map((item, index) => (                    
              <div className="col-md-4 mb-3" key={index}>      
                <div className="card h-100 mini-pro">
                  <div className="d-flex justify-content-between position-absolute w-100">
                  </div>                             
                  <NavLink to={`/product-detail/${item.id}`}>
                    <img
                      src={require(`../static/images/${item.image}`)}
                      style={{ width: 175, height: 200 }}
                      alt="Product"
                      className="mini-card"
                    />
                  </NavLink>                                   
                  <div className="card-body px-2 pb-2 pt-1">
                    <div className="d-flex justify-content-between">
                      <div>
                        <p className="h4 text-primary mini-card">
                          {(
                            (item.price * (100 - item.discount)) /
                            100
                          ).toLocaleString()}{" "}
                          đ
                        </p>
                      </div>
                    </div>
                  
                    <p className="mb-0">
                      <strong>
                        <NavLink
                          to={`/product-detail/${item.id}`}
                          className="text-secondary "
                        >
                          {item.name}
                        </NavLink>
                      </strong>
                    </p>
                    <p className="mb-1">
                      <small>
                        <NavLink to="#" className="text-secondary ">
                          {item.brand }
                        </NavLink>
                      </small>
                    </p>
                    <div className="d-flex mb-3 justify-content-between">
                      <div>                     
                        <p className="mb-0 small">
                          <b>Giá gốc: {item.price.toLocaleString()} đ</b>
                        </p>                    
                      </div>
                    </div>
                    <div className="d-flex justify-content-between">
                      <div className="col px-0 ">
                        <NavLink
                          to={`/product-detail/${item.id}`}
                          exact
                          className="btn btn-outline-primary btn-block"
                        >
                          Thêm vào giỏ
                          <i
                            className="fa fa-shopping-basket"
                            aria-hidden="true"
                          ></i>
                        </NavLink>
                      </div>
                      
                    </div>
                  </div>
                </div>               
                
              </div>                    
            ))}
        </div>
      </div>
      {/*<nav aria-label="Page navigation">
        <ul className="pagination offset-5 mt-3">
          <li className={page === 1 ? "page-item disabled" : "page-item"}>
            <button
              className="page-link"
              style={{ borderRadius: 50 }}
              onClick={() => onChangePage(1)}
            >
              {`<<`}
            </button>
          </li>
          {rows}
          <li className={page === total ? "page-item disabled" : "page-item"}>
            <button
              className="page-link"
              style={{ borderRadius: 50 }}
              onClick={() => onChangePage(total)}
            >
              {`>>`}
            </button>
          </li>
        </ul>
                          </nav>*/}
    </div>
  );
};

export default Home;
