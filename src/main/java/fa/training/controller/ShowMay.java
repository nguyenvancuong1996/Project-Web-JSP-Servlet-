package fa.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.MayDao;
import fa.training.dao.MayDaoImpl;
import fa.training.entities.May;

@WebServlet("/listMay")
public class ShowMay extends HttpServlet {

	private static MayDao mayDao = new MayDaoImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<May> listMay = mayDao.getAllMay();
		req.setAttribute("listMay", listMay);
		RequestDispatcher rd = req.getRequestDispatcher("/DanhSachMay.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<May> listmay = mayDao.getAllMay();
		
		req.setAttribute("listmay",listmay);
		req.getRequestDispatcher("/DanhSachMay.jsp").forward(req, resp);
	}
}
