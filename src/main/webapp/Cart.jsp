

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="model.Order" %>
<%@ page import="model.Voucher" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
		
		<style>
			.offers-details {
			    overflow: visible;
			    width: 100%;
			    display: inline-block;
			    font-size: 13px;
			    margin-bottom: 2px;
			}
			.arrowIcon{
				height: 100%;
			}
			.listVoucher{
				display: block;
			}
			.showVoucher{
				height: 40px;
				line-height: 40px;
				display: flex;
			    font-size: 20px;
			    justify-content: space-between;
			    font-weight: 500;
			}
			
			.voucherContainer{
				display: block;
				position: relative;
				width: 100%;
			}
			
			.listVoucher{
				display:block;
				position: absolute;
				top: 40px;
			}
			
			.mgg-bl {
			    background: none;
			    border-radius: 10px;
			    margin: 7px;
			    display: flex;
			}
			.mgg-discount {
			    font-size: 15px;
			    text-align: center;
			    font-weight: 800;
			    color: #fff;
			    padding: 20px 0px;
			}
			
			.mgg-bottom {
				position: relative;
			    display: flex;
			    padding: 8px;
			    width: 75%;
			    float: right;
			    background: #eaf3f9ba;
			    border-radius: 0px 10px 10px 0px;
			    align-content: space-between;
			    flex-wrap: wrap;
			}
			.mgg-top {
				    width: 25%;
				    padding: 10px;
				    float: left;
				    background: #0a0a99;
				    border-radius: 10px 0px 0px 10px;
				    border-right: 2px #fff dotted;
				    display: flex;
				    justify-content: center;
				    flex-direction: column;
			}
			.receiveVoucherbtn{
				    float: right;
				    background: #ef29a9;
				    font-size: 15px;
				    border: none;
				    border-radius: 3px;
				    width: 40%;
				    height: 30px;
				    color: white;
				    text-align: center;
    				line-height: 30px;
			}
			.offers-voucher-title {
				    font-size: 15px;
				    font-weight: 500;
				    color: #ff009c;
				}
			.mgg-footer{
				width:100%;
				display: flex;
				align-items: center;
    			justify-content: space-between;
			}
		</style>
    </head>

    <body>
			</ul><a href="home" class="btn btn-dark rounded-pill py-2 btn-block">Quay Lại Trang Chủ</a>
            <div class="shopping-cart">
                <div class="px-4 px-lg-0">

                    <div class="pb-5">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12 p-5 bg-white rounded shadow-sm mb-5">

                                    <!-- Shopping cart table -->
                                    <div class="table-responsive">
                                        <table class="table">
                                            <thead>
                                                <tr>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="p-2 px-3 text-uppercase">Sản Phẩm</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Đơn Giá</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Số Lượng</div>
                                                    </th>
                                                    <th scope="col" class="border-0 bg-light">
                                                        <div class="py-2 text-uppercase">Xóa</div>
                                                    </th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${order.getItems()}" var="o">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="${o.getProduct().image}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> <a href="#" class="text-dark d-inline-block">${o.getProduct().name}</a></h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong>${o.getProduct().price}</strong></td>
                                                    <td class="align-middle">
                                                        <a href="reduceQuantityCart?pid=${o.getProduct().id }"><button class="btnSub">-</button></a> 
                                                        <strong>${o.quantity}</strong>
                                                        <a href="IncreaseQuantityCart?pid=${o.getProduct().id }"><button class="btnAdd">+</button></a>
                                                    </td>
                                                    <td class="align-middle"><a href="#" class="text-dark">
                                                            <button type="button" class="btn btn-danger">Delete</button>
                                                        </a>
                                                    </td>
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                <!-- End -->
                            </div>
                        </div>

                        <div class="row py-5 p-4 bg-white rounded shadow-sm">
                            <div class="col-lg-6">
                                <div class=" voucherContainer">
                                    <div class= "showVoucher">Chọn voucher cho đơn hàng
                                    <svg class="arrowIcon" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 448 512"><path d="M384 480c35.3 0 64-28.7 64-64l0-320c0-35.3-28.7-64-64-64L64 32C28.7 32 0 60.7 0 96L0 416c0 35.3 28.7 64 64 64l320 0zM224 352c-6.7 0-13-2.8-17.6-7.7l-104-112c-6.5-7-8.2-17.2-4.4-25.9s12.5-14.4 22-14.4l208 0c9.5 0 18.2 5.7 22 14.4s2.1 18.9-4.4 25.9l-104 112c-4.5 4.9-10.9 7.7-17.6 7.7z"/></svg>
                                	</div>
                                	<div class = "listVoucher">
	                            			<c:forEach items="${listVoucher }" var="v">
	                            					<div class="offers-details">
													   <div class="mgg-bl">
															<div class="mgg-top">
																<div class="mgg-discount">Giảm ${v.reducedMoney}$</div>
															</div>
															<div class="mgg-bottom">
																<span class="offers-voucher-title">Toàn sàn giảm ${v.reducedMoney}$ cho đơn từ đơn từ ${v.conditionMoney }$</span>
																<div class="mgg-footer">
																	<div class="polyxgo_hethan">Hạn SD: 31/05/2023</div>
																	<a href="getVoucher?vid=${v.getId()}" class="receiveVoucherbtn">
    																	${order.getVoucher() != null && order.getVoucher().getId() == v.getId() ? "Hủy ưu đãi" : "Nhận ưu đãi"}
  																	</a>
																</div>
															</div>	
													</div>
													</div>
	                            			</c:forEach>
	                            	</div>
                                
                                </div>
                            
                           </div>
                            <div class="col-lg-6">
                                <div class="bg-light rounded-pill px-4 py-3 text-uppercase font-weight-bold">Thành tiền</div>
                                <div class="p-4">
                                    <ul class="list-unstyled mb-4">
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng tiền hàng</strong><strong>${order.getPriceTotal()} $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Phí vận chuyển</strong><strong>${order.getShipFee()}$</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">VAT</strong><strong>${order.getVAT() } $</strong></li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Voucher</strong>
                                        <strong>
											  <%
											    Order order = (Order) session.getAttribute("order");
											    int reducedMoney = (order.getVoucher() == null) ? 0 : order.getVoucher().getReducedMoney();
											    out.println("<strong>" + reducedMoney +"$</strong>");
											  %>
                                        </strong>
                                        </li>
                                        <li class="d-flex justify-content-between py-3 border-bottom"><strong class="text-muted">Tổng thanh toán</strong>
                                            <h5 class="font-weight-bold">${order.getTotalBill() } $</h5>
                                        </li>
                                    </ul><a href="buy" class="btn btn-dark rounded-pill py-2 btn-block">Mua hàng</a>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>

</html>
</html>
