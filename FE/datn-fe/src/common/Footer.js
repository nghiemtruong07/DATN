import React from 'react'
import '../static/css/style.css'
import des from '../static/images/title-des.jpg'
import { NavLink } from 'react-router-dom'
const Footer = () => {
  return (
    <div>
        <div className="container-fluid padding mt-5 mb-5">
          <div className="row padding">
            <div className="col-lg-6 mx-auto d-block">
              <img src={des} className="img-fluid" alt=''/>
            </div>
          </div>
          <hr className="my-4" />
        </div>
               
        <footer>
          <div className="container-fluid padding bg-light text-dark">
            <div className="row text-center">
              <div className="col-md-4">
                <hr className="light" />
                <p>Tư vấn mua hàng </p>
                <p>1800 6601 </p>
                <p>Hỗ trợ kỹ thuật</p>
                <p>1800 6601 </p>
              </div>
              <div className="col-md-4">
                <hr className="light" />
                <h5>Giờ làm việc</h5>
                <hr className="light" />
                <p>Thứ hai-Chủ nhật </p>
                <hr className="light" />
                <p> 8:00 - 21:00</p>
              </div>
              <div className="col-md-4">
                <hr className="light" />
                <h5>Hệ thống cửa hàng</h5>
                <hr className="light" />
                <p>Chính sách đổi trả</p>
                <p>Chính sách trả góp</p>
                <p>Hướng dẫn mua trả góp</p>
              </div>
              <div className="col-12">
                <hr className="light-100" />
                <h5>© 2023 PC Shop và Phụ Kiện </h5>
              </div>
            </div>
          </div>
        </footer>
      </div>
  )
}

export default Footer