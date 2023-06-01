<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Chi tiết đơn hàng</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 20px;
      background-color: #f2f2f2;
    }

    .container {
      max-width: 800px;
      margin: 0 auto;
      background-color: #fff;
      border-radius: 5px;
      box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
      padding: 20px;
    }

    h1 {
      margin-bottom: 20px;
      text-align: center;
    }

    .order-details {
      border-bottom: 1px solid #ccc;
      padding-bottom: 20px;
      margin-bottom: 20px;
    }

    .order-details h2 {
      font-size: 20px;
      margin-bottom: 10px;
    }

    .order-details p {
      margin: 5px 0;
    }

    .product-list {
      margin-bottom: 20px;
    }

    .product-list table {
      width: 100%;
      border-collapse: collapse;
    }

    .product-list th, .product-list td {
      padding: 10px;
      text-align: left;
    }

    .product-list th {
      background-color: #f2f2f2;
      border-bottom: 1px solid #ccc;
    }

    .product-item img {
      width: 50px;
      height: 50px;
      object-fit: cover;
      border-radius: 50%;
    }

    .product-item td {
      vertical-align: middle;
    }

    .total-amount {
      font-weight: bold;
      font-size: 18px;
      margin-top: 10px;
    }

    .status {
      font-weight: bold;
      font-size: 18px;
      margin-top: 10px;
    }

    .back-button {
      display: block;
      text-align: center;
      margin-top: 20px;
    }
  </style>
</head>
<body>
  <div class="container">
    <h1>Chi tiết đơn hàng</h1>

    <div class="order-details">
      <h2>Thông tin đơn hàng</h2>
      <p><strong>Tên người mua:</strong> ${orders.getTenNguoiMua()}</p>
      <p><strong>Thời gian đặt hàng:</strong> ${orders.getThoigiandat()}</p>
      <p><strong>Số lượng sản phẩm:</strong> ${orders.getSoLuongSanPham()}</p>
    </div>

    <div class="product-list">
      <h2>Danh sách sản phẩm</h2>
      <table>
        <thead>
          <tr>
            <th>Ảnh</th>
            <th>Tên sản phẩm</th>
            <th>Số lượng</th>
            <th>Giá</th>
          </tr>
        </thead>
        <tbody>
          <c:forEach items="${listItems}" var="i">
            <tr class="product-item">
              <td><img src="${i.getProduct().getImage()}" alt="Product Image"></td>
              <td>${i.getProduct().getName()}</td>
              <td>${i.getQuantity()}</td>
              <td>${i.getPrice()}$</td>
            </tr>
          </c:forEach>
        </tbody>
      </table>
    </div>

    <p><strong>Tổng tiền:</strong> <span class="total-amount">${orders.getTotalBill()}$</span></p>
    <p><strong>Trạng thái:</strong> <span class="status">${orders.getStatus() }</span></p>
	<c:if test="${orders.getStatus().equals('Chưa Thanh Toán')}">
  		<a href="thanhToan?oid=${orders.getOid() }" class="back-button">Thanh Toán</a>
	</c:if>
    <a href="home" class="back-button">Quay lại trang chủ</a>
  </div>
</body>
</html>
