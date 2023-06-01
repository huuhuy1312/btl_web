<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<style>
			.container--listOrder{
				position:relative;
				
			}
			.listOrder{
				z-index: 9999;
				position: absolute;
			    background-color: #fff;
			    list-style: none;
			    top: 98%;
			    left: 0;
			    box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
			    padding: 0;
			    width: 400px;
			    display: none;
			}
			.listOrder-item{
				display:flex;
				    justify-content: space-between;
				    border: 1px solid;
			}
			.icon-order{
				    display: flex;
				    font-size: 30px;
				    padding: 0 30px;
				   
				    align-items:center;
			}
			.name-items{
				display:flex;
			}
			.listorder-btn:hover
			+.listOrder
			{
				display: block;
			}
			.listOrder:hover{
				display:block;
			}
		</style>
	</head>
	<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="home">Laptop</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse justify-content-end" id="navbarsExampleDefault">
                    <ul class="navbar-nav m-auto">
                    <c:if test = "${sessionScope.acc.isAdmin ==1}">
                        <li class="nav-item">
                            <a class="nav-link" href="home">Manager Account</a>
                        </li>
                     </c:if>
                     <c:if test = "${sessionScope.acc.isSell ==1}">
                        <li class="nav-item">
                            <a class="nav-link" href="managerProduct">Manager Product</a>
                        </li>
                     </c:if>
                        <c:if test = "${sessionScope.acc !=null}">
	                        <li class="nav-item">
                            	<a class="nav-link" href="home">Hello ${sessionScope.acc.user}</a>
                        	</li>
	                        <li class="nav-item">
	                            <a class="nav-link" href="logout">Logout</a>
	                        </li>
                        </c:if>
                        <c:if test = "${sessionScope.acc ==null}">
                        <li class="nav-item">
                            <a class="nav-link" href="Login.jsp">Login</a>
                        </li>
                        </c:if>
                        <c:if test = "${sessionScope.acc !=null}">
                        <li class="nav-item container--listOrder">
                            <div class="nav-link listorder-btn" >Orders List V</div>
                            <ul class= "listOrder">
                            	<c:forEach items="${listOrder}" var="o">
                            		
	                            	<li class ="listOrder-item">
	                            	<div class="icon-order">
	                            		<svg  xmlns="http://www.w3.org/2000/svg" height="1em" viewBox="0 0 576 512"><!--! Font Awesome Free 6.4.0 by @fontawesome - https://fontawesome.com License - https://fontawesome.com/license (Commercial License) Copyright 2023 Fonticons, Inc. --><path d="M0 24C0 10.7 10.7 0 24 0H69.5c22 0 41.5 12.8 50.6 32h411c26.3 0 45.5 25 38.6 50.4l-41 152.3c-8.5 31.4-37 53.3-69.5 53.3H170.7l5.4 28.5c2.2 11.3 12.1 19.5 23.6 19.5H488c13.3 0 24 10.7 24 24s-10.7 24-24 24H199.7c-34.6 0-64.3-24.6-70.7-58.5L77.4 54.5c-.7-3.8-4-6.5-7.9-6.5H24C10.7 48 0 37.3 0 24zM128 464a48 48 0 1 1 96 0 48 48 0 1 1 -96 0zm336-48a48 48 0 1 1 0 96 48 48 0 1 1 0-96z"/></svg>
	                            	</div>
	                            	<div class="order-detail" style="padding: 0 10px;border-left: 1px solid">
	                            		<div  style="color: #00ff45;;font-size: 15px;font-weight: 800">${o.getTotalBill()}$</div>
	                            		<div style="width: 100%;font-size: 12px;font-weight: 600;">
	                            		<div style="display:inline-block">Tên người mua: ${o.getTenNguoiMua()}</div>
	                            		<!--  
	                            		<div class="name-items">
	                            		<c:forEach items="${o.getListitem()}" var="i">
    										<div><c:out value="${i}" /></div>
										</c:forEach>
										</div>
										-->
										<div style="display:inline-block">Số lượng:${o.getSoLuongSanPham()}</div>
										</div>
										<div class="timeOrder" style="font-size: 10px;">Trạng Thái: ${o.getStatus()}</div>
									</div>
									<div style="display: flex;align-items: center;padding: 0 5px;background-color: #5cdee8;"><a href="viewOrderDetail?oid=${o.getOid()}">Xem Chi tiết</a></div>
	                            	</li>
	                            </c:forEach>
	                         </ul>
                            
                        </li>
                        </c:if>
                    </ul>

                    <form action="search" method="post" class="form-inline my-2 my-lg-0">
                        <div class="input-group input-group-sm">
                            <input value = "${txtS}" name="txt" type="text" class="form-control" aria-label="Small" aria-describedby="inputGroup-sizing-sm" placeholder="Search...">
                            <div class="input-group-append">
                                <button type="submit" class="btn btn-secondary btn-number">
                                    <i class="fa fa-search"></i>
                                </button>
                            </div>
                        </div>
                        <a class="btn btn-success btn-sm ml-3" href="cartShow">
                            <i class="fa fa-shopping-cart"></i> Cart
                            <span class="badge badge-light">${order.getItems().size()}</span>
                        </a>
                    </form>
                </div>
            </div>
        </nav>
        <section class="jumbotron text-center">
            <div class="container">
                <h1 class="jumbotron-heading">Siêu thị Laptop chất lượng cao</h1>
                <p class="lead text-muted mb-0">Uy tín tạo nên thương hiệu với hơn 10 năm cung cấp các sản phầm chuyên về Laptop</p>
            </div>
        </section>
        </body>