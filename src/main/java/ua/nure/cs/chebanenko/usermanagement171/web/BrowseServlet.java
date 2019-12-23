package ua.nure.cs.chebanenko.usermanagement171.web;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import ua.nure.cs.chebanenko.usermanagement171.domain.User;
import ua.nure.cs.chebanenko.usermanagement171.db.DaoFactory;
import ua.nure.cs.chebanenko.usermanagement171.DatabaseException;

public class BrowseServlet extends HttpServlet {
	protected void service (HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
		if (req.getParameter("addButton") != null) {
			add(req, resp);
		}
		else if (req.getParameter("editButton") != null) {
			edit(req, resp);
		}
		else if (req.getParameter("deleteButton") != null) {
			delete(req, resp);
		}
		else if (req.getParameter("detailsButton") != null) {
			details(req, resp);
		}
		else {
			browse(req, resp);
		}
	}

	private void details(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String idStr = 	req.getParameter("id");
		if (idStr == null || idStr.trim().length() == 0) {
			req.setAttribute("error", "Вы должны выбрать пользователя");
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		try {
			User user = DaoFactory.getInstance().getUserDao().find(new Long(idStr));
			req.getSession().setAttribute("user", user);
		} catch (Exception e) {
			req.setAttribute("error", "ОШИБКА:" + e.toString());
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/details").forward(req, resp);
	}

	private void delete(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String idStr = 	req.getParameter("id");
		if (idStr == null || idStr.trim().length() == 0) {
			req.setAttribute("error", "Вы должны выбрать пользователя");
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		try {
			User user = DaoFactory.getInstance().getUserDao().find(new Long(idStr));
			req.getSession().setAttribute("user", user);
		} catch (Exception e) {
			req.setAttribute("error", "ОШИБКА:" + e.toString());
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/delete").forward(req, resp);
	}

	private void edit(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		String idStr = 	req.getParameter("id");
		if (idStr == null || idStr.trim().length() == 0) {
			req.setAttribute("error", "Вы должны выбрать пользователя");
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		try {
			User user = DaoFactory.getInstance().getUserDao().find(new Long(idStr));
			req.getSession().setAttribute("user", user);
		} catch (Exception e) {
			req.setAttribute("error", "ОШИБКА:" + e.toString());
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
			return;
		}
		req.getRequestDispatcher("/edit").forward(req, resp);
	}

	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		req.getRequestDispatcher("/add").forward(req, resp);
	}

	private void browse(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Collection users;
		try {
			users = DaoFactory.getInstance().getUserDao().findAll();
			req.getSession().setAttribute("users", users);
			req.getRequestDispatcher("/browse.jsp").forward(req, resp);
		} catch (DatabaseException e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}
}
