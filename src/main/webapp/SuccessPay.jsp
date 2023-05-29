<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="model.Order" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
		<style>
			.title{
				color: red;
				text-align: center;
    			padding-top: 50px;
				width: 100%;
			}
			body{
				height: 100vh;
				position:relative;
			}
			h2{
				text-align: end;
    			font-size: 20px;
    			padding-right: 30px;
			}
			button{
				border: none;
				width: 200px;
				height: 50px;
				margin: 0 auto;
			}
			.backHome{
				position: absolute;
				    align-items: center;
    				width: 100%;
    			display: flex;
    			background-color: #ff49498f;
    			
    			bottom:0px;
			}
			a{
				color: black;
    			font-size: 18px;
    			font-weight: 500;
			}
			.col-lg-12{
				padding-top: 50px;
			}
		</style>
</head>
<body>
	<h1 class ="title">Cảm ơn bạn đã đặt hàng</h1>
	<div class="">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-12  bg-white rounded shadow-sm ">

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
                                                    
                                                </tr>
                                            </thead>
                                            <tbody>
                                            <c:forEach items="${order.getItems()}" var="o">
                                                <tr>
                                                    <th scope="row">
                                                        <div class="p-2">
                                                            <img src="${o.getProduct().image}" alt="" width="70" class="img-fluid rounded shadow-sm">
                                                            <div class="ml-3 d-inline-block align-middle">
                                                                <h5 class="mb-0"> ${o.getProduct().name}</h5><span class="text-muted font-weight-normal font-italic"></span>
                                                            </div>
                                                        </div>
                                                    </th>
                                                    <td class="align-middle"><strong>${o.getProduct().price}</strong></td>
                                                    <td class="align-middle">
                                                        
                                                        <strong>${o.quantity}</strong>
                                                        
                                                    </td>
                                                    
                                                </tr> 
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                                
                            </div>
                           </div>
                           </div>
                          </div>
	<h2>Tổng giá trị đơn hàng: ${order.getTotalBill() } $</h2>
	<div class="backHome">
		<button><a href="backToHomeafterSucess">Back To Home</a></button>
	</div>
</body>
</html>