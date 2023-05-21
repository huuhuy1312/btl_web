package control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CategoryDAO;
import dao.DAO;
import model.Category;
import model.Product;

/**
 * Servlet implementation class DetailControll
 */
@WebServlet({ "/detail" })
public class DetailProductControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html,charset = UTF-8");
		String cateID = request.getParameter("cid");
		String id = request.getParameter("pid");
		DAO proDao = new DAO();
		Product p = proDao.getProbyID(id);
		request.setAttribute("detail", p);
		Product lastProduct = proDao.getLastProduct();
		CategoryDAO catDao = new CategoryDAO();
		List<Category> listC = catDao.getAllCategory();
		request.setAttribute("listC", listC);
		request.setAttribute("lastPro", lastProduct);
		request.setAttribute("tag", cateID);
		request.getRequestDispatcher("Detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
