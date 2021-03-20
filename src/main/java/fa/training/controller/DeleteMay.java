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

@WebServlet("/DeleteMay")
public class DeleteMay extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			MayDao mayDao = new MayDaoImpl();

			if (mayDao.deleteByID(id)) {
				System.out.println("Thanh Cong");
			}
			RequestDispatcher rd = req.getRequestDispatcher("/listMay");
			rd.forward(req, resp);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
