package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import entity.User_Mgr;

public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String userid = req.getParameter("userid");
		String password = req.getParameter("password");
		HttpSession session = req.getSession();
		//System.out.println("username=" + userid);
		//System.out.println("password=" + password);
		User_Mgr um = new User_Mgr();
		int result = 0;
		result = um.verifyUser(Integer.parseInt(userid),Integer.parseInt(password));
		String priv = "" + result;
		switch (result) {
		case 0://
			req.getRequestDispatcher("/index.jsp?error=帐号或密码错误").forward(req, resp);
			break;
		case 1:
			session.setAttribute("priv", priv);
			session.setAttribute("userid", userid);
			req.getRequestDispatcher("/page/main.jsp").forward(req, resp);
			break;
		case 2://学生用户
			session.setAttribute("priv", priv);
			session.setAttribute("userid", userid);
			req.getRequestDispatcher("/normal/main.jsp").forward(req, resp);
			break;
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
	

}
