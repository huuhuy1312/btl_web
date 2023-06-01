<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
  <!-- Include Bootstrap CSS -->
  <link rel="icon" type="image/x-icon" href="https://scontent.xx.fbcdn.net/v/t1.15752-9/329760136_495322139346198_6412973535947348003_n.png?stp=cp0_dst-png&_nc_cat=102&ccb=1-7&_nc_sid=aee45a&_nc_ohc=N7Wb25Hw448AX_ZX_Fe&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AdQELbUniDrEixWoqLM2_y88OwVGquT--EW7YAStAaZyCg&oe=640D48A7">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script></head>
  
  <style>
        img{
        width:50px;
        height:50px;
    }
        #my-menu {
    position: sticky;
    top: 0;
    background-color: #fff;
    }
  </style>
<body>
<nav id="my-menu" class="navbar navbar-expand-lg navbar-dark bg-dark">
  <a class="navbar-brand" href="/CRUDadm2002">Admin panel</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="/CRUDadm2002">Create Employee <span class="sr-only">(current)</span></a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/listSp">List Employee</a>
      </li>
    </ul>
  </div>
</nav>
<div class="d-flex">
  <input id="searchTerm" class="form-control me-2" placeholder="Search" >
  <button onclick="search()" class="btn btn-outline-success" >Search</button>
</div>
<!-- Table to display the list of orders -->
<h3 style="text-align:center; background-color:gray;color:white;padding:10px">LIST PRODUCT</h3>
<table class="table">
  <thead>
  <tr>
    <th>Mã</th>
    <th>Tên</th>
    <th>Chức Vụ</th>
    <th>Phone</th>
    <th>Tuổi</th>
    <th>Ảnh</th>
    <th>Xóa</th>
    <th>Sửa</th>
  </tr>
  </thead>
  <tbody id="employee-table">
  </tbody>
</table>
<div id="edit-form" style="display: none;">
  <h2>Chỉnh sửa sản phẩm</h2>
  <label for="edit-name">Tên:</label>
<input type="text" id="edit-name" name="edit-name">
  <label for="edit-position">Chức vụ:</label>
  <input type="text" id="edit-position" name="edit-position">
  <label for="edit-phone">Số DT:</label>
  <input id="edit-phone" name="edit-phone"></input>
  <label for="edit-image">Ảnh:</label>
  <input id="edit-image" name="edit-image"></input>
  <label for="edit-age">Tuổi:</label>
  <input type="text" id="edit-age" name="edit-age">
  <button  onclick="submitEdit()">Lưu</button>
  <button  onclick="cancelEdit()">Hủy</button>
</div>
<!-- Include jQuery and Bootstrap JavaScript -->
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha384-ZvpUoO/+PpLXR1lu4jmpXWu80pZlYUAfxl5NsBMWOEPSjUn/6Z/hRTt8+pR6L4N2" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
<script src="js/CRUDEmployee.js" type="text/javascript"></script>
</body>
</html>