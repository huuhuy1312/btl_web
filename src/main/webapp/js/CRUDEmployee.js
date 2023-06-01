
  const apiUrl = "https://6437c88f0c58d3b14579192a.mockapi.io/api/tour/employee";
  const employeeTable = document.querySelector("#employee-table");
  var idedit;
  fetch(apiUrl)
    .then(response => response.json())
    .then(data => {
      data.forEach((employee) => {
        const { id,name, position, age, phone, image } = employee;
        const employeeRow = `
          <tr>
            <td>${id}</td>
            <td>${name}</td>
            <td>${position}</td>
            <td>${phone}</td>
            <td>${age}</td>
            <td><img src=${image} alt="image"/></td>
            <td>
                  <button class="btn btn-danger btn-sm" onclick="deleteEmployee(${id})">Xóa</button>
            </td>
            <td>
                  <button class="btn btn-success btn-sm" onclick="editEmployee(${id})">Sửa</button>
            </td>
          </tr>
        `;
        employeeTable.innerHTML += employeeRow;
      });
    })
    .catch(error => {
      console.error("Có lỗi xảy ra khi tải dữ liệu:", error);
    });



  function deleteEmployee(idlaptop) {
    if (confirm(`Bạn có chắc chắn muốn xóa sản phẩm với mã là ${idlaptop} không?`)) {
      fetch(apiUrl+'/'+idlaptop, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({ idlaptop })
      })
        .then(response => response.json())
        .then(data => {
          console.log("Sản phẩm đã được xóa thành công:", data);
          location.reload();
        })
        .catch(error => {
          console.log("Có lỗi xảy ra khi xóa sản phẩm:", error);
        });
    }
  }
  function editEmployee(idlaptop) {
  console.log("sua");
  idedit = idlaptop;
  fetch(apiUrl+'/'+idlaptop)
    .then(response => response.json())
    .then(data => {
      const { name, phone, position, image, age } = data;
      document.querySelector("#edit-name").value = name;
      document.querySelector("#edit-phone").value = phone;
      document.querySelector("#edit-age").value = age;
      document.querySelector("#edit-image").value = image;
      document.querySelector("#edit-form").style.display = "block";
    })
    .catch(error => {
      console.error("Có lỗi xảy ra khi tải thông tin sản phẩm:", error);
    });
}
function submitEdit() {
  console.log("save")

  const name = document.querySelector("#edit-name").value;
  const age = document.querySelector("#edit-age").value;
  const position = document.querySelector("#edit-position").value;
  const phone = document.querySelector("#edit-phone").value;
  const image = document.querySelector("#edit-image").value;

  // Gửi yêu cầu PUT đến API để cập nhật thông tin nhân viên
  fetch(`${apiUrl}/${idedit}`, {
    method: "PUT",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify({ name, position, phone,image,age }),
  })
    .then((response) => response.json())
    .then((data) => {
      console.log("Sửa thông tin nhân viên thành công:", data);
      location.reload();
    })
    .catch((error) => {
      console.error("Có lỗi xảy ra khi sửa thông tin nhân viên:", error);
    });
}


function cancelEdit() {
  document.querySelector("#edit-id").value = "";
  document.querySelector("#edit-name").value = "";
  document.querySelector("#edit-position").value = "";
  document.querySelector("#edit-age").value = "";
  document.querySelector("#edit-image").value = "";
  document.querySelector("#edit-phone").value = "";


}
function search(){
  employeeTable.innerHTML = '';
  var keyWork = document.getElementById("searchTerm").value;
  var keyWork = keyWork.toLowerCase();
  fetch(apiUrl)
  .then(response => response.json())
  .then(products => {
    products.forEach(product => {
      if (product.name.toLowerCase().includes(keyWork)) {
        const { id,name, price, description, image } = product;
        const employeeRow = `
          <tr>
            <td>${id}</td>
            <td>${name}</td>
            <td>${price}</td>
            <td>${description}</td>
            <td><img src=${image} alt="image"/></td>
            <td>
              <button class="btn btn-danger btn-sm" onclick="deleteEmployee(${id})">Xóa</button>
            </td>
            <td>
              <button class="btn btn-success btn-sm" onclick="editEmployee(${id})">Sửa</button>
            </td>
          </tr>
        `;
        employeeTable.innerHTML += employeeRow;
      }
    }); // Dấu ngoặc nhọn đóng ở đây
  })
  .catch(error => {
    console.error("Có lỗi xảy ra khi tải dữ liệu:", error);
  });
}
