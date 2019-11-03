package ua.lviv.lgs.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.lviv.lgs.domain.Book;
import ua.lviv.lgs.service.BookService;
import ua.lviv.lgs.service.impl.BookServiceImpl;

@WebServlet("/book")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	BookService bookService = BookServiceImpl.getBookService();

	//create books
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String isbn = request.getParameter("isbn");
		String price = request.getParameter("price");
		String quantity = request.getParameter("quantity");

		bookService.create(new Book(name, description, getValidatedPrice(price), isbn, getValidatedQuantity(quantity)));
		response.setContentType("text");
		response.setCharacterEncoding("UTF-8");	
		response.getWriter().write("Success");
	}
	
	private double getValidatedPrice(String price) {
		if (price == null || price.isEmpty()) {
			return 0;
		}
		return Double.parseDouble(price);
	}
	
	private int getValidatedQuantity(String quantity) {
		if (Integer.parseInt(quantity) < 0) {
			return 0;
		}
		return Integer.parseInt(quantity);
	}

	
	//get books
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		Book book = bookService.read(id);
		request.setAttribute("book", book);
		request.getRequestDispatcher("singleBook.jsp").forward(request, response);
	}

	//update books
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doPut(req, resp);
	}
	
	//delete books
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		super.doDelete(req, resp);
	}

}
