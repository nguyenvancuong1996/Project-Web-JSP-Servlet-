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

@WebServlet("/updateMay")
public class SuaMay extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String username = req.getParameter("id");
			MayDao dao = new MayDaoImpl();
			May user = dao.getMay(username);

			req.setAttribute("may", user);
			RequestDispatcher rd = req.getRequestDispatcher("/updateMay.jsp");
			rd.forward(req, resp);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try {
			MayDao mayDao = new MayDaoImpl();
			May may = new May();

			may.setMaMay(req.getParameter("mamay"));
			may.setTrangThai(req.getParameter("trangthai"));
			may.setViTri(req.getParameter("vitri"));

			if (mayDao.update(may)) {
				System.out.println("Sua Thanh Cong");
			}
			resp.sendRedirect("/hrms/listMay");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
