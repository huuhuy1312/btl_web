<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<html>
<head>
    <title>CRUD</title>
    <link rel="icon" type="image/x-icon" href="https://scontent.xx.fbcdn.net/v/t1.15752-9/329760136_495322139346198_6412973535947348003_n.png?stp=cp0_dst-png&_nc_cat=102&ccb=1-7&_nc_sid=aee45a&_nc_ohc=N7Wb25Hw448AX_ZX_Fe&_nc_ad=z-m&_nc_cid=0&_nc_ht=scontent.xx&oh=03_AdQELbUniDrEixWoqLM2_y88OwVGquT--EW7YAStAaZyCg&oe=640D48A7">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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
</head>
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
                <a class="nav-link" href="/dsnv.html">List Employee</a>
            </li>
        </ul>

    </div>
</nav>
<div class="container mt-5">
    <h1 class="text-center mb-5">Thêm Nhân Viên</h1>
    <button class="btn btn-primary" onclick="backHomepage()">Back Homepage</button>
    <form action="https://63e1d6414324b12d963f5108.mockapi.io/api/v11/laptop" method="post">
        <div class="form-group">
            <label for="name">Tên:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="position">Chức vụ:</label>
            <input type="text" class="form-control" id="position" name="position">
        </div>
        <div class="form-group">
            <label for="phone">phone:</label>
<input class="form-control" id="phone" name="phone"></input>
        </div>
        <div class="form-group">
            <label for="phone">age:</label>
            <input class="form-control" id="age" name="age"></input>
        </div>
        <div class="form-group">
            <label for="image">Link Ảnh:</label>
            <input class="form-control" id="image" name="image"/>
        </div>
        <button onclick="themSanPham()" type="submit" class="btn btn-primary">Thêm</button>
    </form>

</div>
<script>
  function backHomepage(){
    window.location.href="home";
    console.log("backHome")
  }


 const getFormData = () => {
  const form = document.querySelector("form");
  const name = document.getElementById("name").value;
  const position = document.getElementById("position").value;
  const image = document.getElementById("image").value;
  const phone = document.getElementById("phone").value;
  const age = document.getElementById("age").value;

  return { name, position, image, phone, age };
};
const submitForm = async () => {
  const formData = getFormData();
  const response = await fetch("https://6437c88f0c58d3b14579192a.mockapi.io/api/tour/employee", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(formData)
  });
  const data = await response.json();
  console.log(data);
};

function themSanPham(){
    submitForm();
    alert("Thêm thành công")
}

</script>
</body>
</html>
</body>
</html>