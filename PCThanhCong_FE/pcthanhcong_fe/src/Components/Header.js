import React from "react";
import { QRcode } from "../Asset/img/QRcode.png";

function Header(props) {
  return (
    <div class="app">
      <header className="header">
        <div className="grid">
          <nav className="header__navbar">
            <ul className="header__navbar-list">
              <li className="header__navbar-item header__navbar-item-has-qr header__navbar-item--separate">
                Vào cửa hàng trên ứng dụng KaKa-Shop
                {/* <!-- header QR --> */}
                <div className="header__qr">
                  <img src={QRcode} alt="QR code" className="header__qr-img" />
                  <div className="header__qr-apps">
                    <a href="" className="header__qr-link">
                      <img src={Appstore} alt="App store" className="header__qr-download-img" />
                    </a>
                    <a href="" className="header__qr-link">
                      <img src={CHplay} alt="Google play" className="header__qr-download-img" />
                    </a>
                  </div>
                </div>
              </li>
              <li className="header__navbar-item">
                <span className="header__navbar-title-no-pointer">Kết nối</span>
                <a href="https://www.facebook.com/ShopeeVN" className="header__navber-icon-link">
                  <FaFacebook className="header__navbar-icon" />
                </a>
                <a href="https://www.instagram.com/Shopee_VN/" className="header__navber-icon-link">
                  <AiFillInstagram className="header__navbar-icon header__navbar-icon--instagram" />
                </a>
              </li>
            </ul>

            <ul className="header__navbar-list">
              <li className="header__navbar-item header__navbar-item-has-notify">
                <a href="" className="header__navbar-item-link">
                  <FaRegBell className="header__navbar-icon" /> Thông báo
                </a>
                <div className="header__notify">
                  <header className="header__notify-header">
                    <h3>Thông báo mới nhận</h3>
                  </header>
                  <ul className="header__notify-list">
                    <li className="header__notify-item header__notify-item--viewed">
                      <a href="" className="header__notify-link">
                        <img src="https://cf.shopee.vn/file/55cffb105a05fe460c22c1377689825b_tn" alt="" className="header__notify-img" />
                        <div className="header__notify-info">
                          <span className="header__notify-name">Mỹ phẩm SENKA chính hãng</span>
                          <span className="header__notify-descrion">Mô tả mỹ phẩm SENKA chính hãng</span>
                        </div>
                      </a>
                    </li>

                    <li className="header__notify-item header__notify-item--viewed">
                      <a href="" className="header__notify-link">
                        <img src="https://cf.shopee.vn/file/68c85367616c19d82ff446f4f11f5f5f" alt="" className="header__notify-img" />
                        <div className="header__notify-info">
                          <span className="header__notify-name">
                            [Mã ELMALL500 giảm 10% đơn 500K] Điện Thoại Samsung Galaxy M12 (3GB/32GB) - Hãng Phân Phối Chính Thức
                          </span>
                          <span className="header__notify-descrion">
                            Màu sắc: xanh ( Green ) Cấu hình mạnh mẽ với vi xử lý 8 nhân tối ưu và tần số quét 90Hz Tần số quét màn hình 90Hz, lớn bậc nhất phân
                            khúc, hiển thị mượt mà mọi chuyển động dù là nhỏ nhất trên từng khung hình.
                          </span>
                        </div>
                      </a>
                    </li>

                    <li className="header__notify-item">
                      <a href="" className="header__notify-link">
                        <img src="https://cf.shopee.vn/file/027aed0847ed75986937c32d53245c9a" alt="" className="header__notify-img" />
                        <div className="header__notify-info">
                          <span className="header__notify-name">
                            [Mã ELBAU10 giảm 10% đơn 500K] Smart Tivi Samsung Màn Hình Cong Crystal UHD 4K 65 inch UA65TU8300KXXV
                          </span>
                          <span className="header__notify-descrion">Miễn phí lắp đặt</span>
                        </div>
                      </a>
                    </li>
                  </ul>
                  <footer className="header__notify-footer">
                    <a href="" className="header__notify-footer-btn">
                      Xem tất cả
                    </a>
                  </footer>
                </div>
              </li>
              <li className="header__navbar-item">
                <a href="https://help.shopee.vn/portal" className="header__navbar-item-link">
                  <FiHelpCircle className="header__navbar-icon" /> Trợ giúp
                </a>
              </li>
              <li className="header__navbar-item header__navbar-item--strong header__navbar-item--separate" onClick={handleclickRegister}>
                Đăng ký
              </li>
              <li className="header__navbar-item header__navbar-item--strong" onClick={handleclickLogin}>
                Đăng nhập
              </li>
            </ul>
          </nav>
          {/* <!-- header with search --> */}
          <div className="header-with-search">
            <div className="header__logo">
              <a href="" className="header__logo-link">
                <img src={Logo} alt="" className="header__logo-img" />
              </a>
            </div>
            <div className=" header__search ">
              <div className=" header__search-input-wrap ">
                <input type=" text " className=" header__search-input " placeholder=" Tìm kiếm sản phẩm " />
                {/* <!-- search history --> */}
                <div className=" header__search-history ">
                  <h3 className=" header__search-history-heading ">Lịch sử tìm kiếm</h3>
                  <ul className=" header__search-history-list ">
                    <li className=" header__search-history-item ">
                      <a href=" ">Laptop Lenovo Think pad</a>
                    </li>
                    <li className=" header__search-history-item ">
                      <a href=" ">TV SAMSUNG</a>
                    </li>
                  </ul>
                </div>
              </div>
              <div className=" header__search-select ">
                <span className=" header__search-select-label ">Trong Shop</span>
                <BsChevronDown className=" header__search-select-icon"></BsChevronDown>
                <ul className=" header__search-option ">
                  <li className=" header__search-option-item header__search-option-item--active ">
                    <span>Trong Shop</span>
                    <FaCheck className="header__search-option-item-icon"></FaCheck>
                  </li>
                  <li className=" header__search-option-item ">
                    <span>Ngoài Shop</span>
                    {/* <FaCheck className="header__search-option-item-icon"></FaCheck> */}
                  </li>
                </ul>
              </div>
              <button className=" header__search-btn ">
                <GoSearch className="header__search-btn-icon" />
              </button>
            </div>
            {/* <!-- cart layout --> */}
            <div className=" header__cart ">
              <div className=" header__cart-wrap ">
                <FaShoppingCart className=" header__cart-icon "></FaShoppingCart>

                <div className=" header__cart-notice ">3</div>
                {/* <!-- No cart: header__cart-list--nocart--> */}
                <div className=" header__cart-list ">
                  {/* <!-- cart item --> */}
                  <img src=" ./assets/img/no_cart.png " alt=" " className=" header__cart-nocart--img " />
                  <span className=" header__cart-list--nocart--msg ">Chưa có sản phẩm</span>
                  {/* <!-- cart has products --> */}
                  <h4 className=" header__cart-heading ">Sản phẩm đã thêm</h4>
                  <ul className=" header__cart-list-item ">
                    <li className=" header__cart-item ">
                      <img src=" https://cf.shopee.vn/file/e94fbe7e709d60bf6eaea1b0d9101ec9_tn " alt=" " className=" header__cart-img " />
                      <div className=" header__cart-item-info ">
                        <div className=" header__cart-item-head ">
                          <h5 className=" header__cart-item-name ">Sách đọc hay</h5>
                          <div className=" header__cart-item-price-wrap ">
                            <span className=" header__cart-item-price ">120.000đ</span>
                            <span className=" header__cart-item-multiply ">x</span>
                            <span className=" header__cart-item-qnt ">2</span>
                          </div>
                        </div>

                        <div className=" header__cart-item-body ">
                          <span className=" header__cart-item-description ">phân loại hàng: bạc</span>
                          <span className=" header__cart-item-remove ">Xóa</span>
                        </div>
                      </div>
                    </li>

                    <li className=" header__cart-item ">
                      <img src=" https://cf.shopee.vn/file/4fe102f07142cda744bb92fe384010ed_tn " alt=" " className=" header__cart-img " />
                      <div className=" header__cart-item-info ">
                        <div className=" header__cart-item-head ">
                          <h5 className=" header__cart-item-name ">Tai nghe bluetooth chính hãng</h5>
                          <div className=" header__cart-item-price-wrap ">
                            <span className=" header__cart-item-price ">1.520.000đ</span>
                            <span className=" header__cart-item-multiply ">x</span>
                            <span className=" header__cart-item-qnt ">1</span>
                          </div>
                        </div>

                        <div className=" header__cart-item-body ">
                          <span className=" header__cart-item-description ">phân loại hàng: Kim Cương</span>
                          <span className=" header__cart-item-remove ">Xóa</span>
                        </div>
                      </div>
                    </li>

                    <li className=" header__cart-item ">
                      <img
                        src=" https://scontent.fhan15-1.fna.fbcdn.net/v/t1.6435-9/74214384_1473146882836913_2630615929192448000_n.jpg?stp=dst-jpg_s640x640&_nc_cat=102&ccb=1-7&_nc_sid=174925&_nc_ohc=AZJwyIlYP3AAX_1Aolc&_nc_ht=scontent.fhan15-1.fna&oh=00_AT9qB5fbXpyuoefoQNu6Wd7QDN6esLE7nXm6j3YPTAWP2Q&oe=62DD4469 "
                        alt=" "
                        className=" header__cart-img "
                      />
                      <div className=" header__cart-item-info ">
                        <div className=" header__cart-item-head ">
                          <h5 className=" header__cart-item-name ">Bình Lê tươi ngon dành cho Ms.Thu</h5>
                          <div className=" header__cart-item-price-wrap ">
                            <span className=" header__cart-item-price ">0.đ</span>
                            <span className=" header__cart-item-multiply ">x</span>
                            <span className=" header__cart-item-qnt ">1</span>
                          </div>
                        </div>

                        <div className=" header__cart-item-body ">
                          <span className=" header__cart-item-description ">phân loại hàng: hiếm</span>
                          <span className=" header__cart-item-remove ">Xóa</span>
                        </div>
                      </div>
                    </li>
                  </ul>

                  <a href=" https://shopee.vn/cart " className=" header__cart-view-cart btn btn--primary ">
                    Xem giỏ hàng
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </header>
    </div>
  );
}

export default Header;
