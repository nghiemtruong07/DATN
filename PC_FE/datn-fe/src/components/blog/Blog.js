import React, { useEffect } from "react";
import "./Blog.css";

const Blog = (props) => {
  useEffect(() => {
    props.changeHeaderHandler(4);
  }, [props]);

  return (
    <div className="col-10 offset-1 card">
      <h4 className="text-uppercase text-primary">Cam kết sản phẩm</h4>
      <p>1 . Tất cả sản phẩm PC bán ra 100% là Chính Hãng .</p>
      <hr />
      <h4 className="text-uppercase text-primary">HỖ TRỢ MUA HÀNG</h4>
      <p>1 . Bảo Hành Cho Quý Khách .</p>
      <h6 className="fw-fw-bolder"> Liên hệ </h6>
      <p>1 .Qúy khách liên hệ số điện thoại sau : 0978641896.</p>
    </div>
  );
};

export default Blog;
