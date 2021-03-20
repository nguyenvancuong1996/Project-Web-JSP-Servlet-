package fa.training.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fa.training.dao.KhachhangDao;
import fa.training.dao.KhachhangImpl;
import fa.training.entities.Khachhang;

@WebServlet("/listkh")
public class ShowKhachHang extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhachhangDao khachhangDao = new KhachhangImpl();
		List<Khachhang> listKhachhangs = khachhangDao.getAllKhachhang();
		req.setAttribute("listkhach", listKhachhangs);
		RequestDispatcher rd = req.getRequestDispatcher("/ListKhachHang.jsp");
		rd.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		KhachhangDao khachhangDao = new KhachhangImpl();
		List<Khachhang> listKh = khachhangDao.getAllKhachhang();
		req.setAttribute("listkh",listKh);
		req.getRequestDispatcher("/ListKhachHang.jsp").forward(req, resp);
	}
}
