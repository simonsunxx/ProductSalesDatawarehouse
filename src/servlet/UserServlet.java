package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;
import entity.User_Mgr;

public class UserServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String userid=req.getParameter("userid");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		User u=new User(Integer.parseInt(userid),Integer.parseInt(password),2,username);
		User_Mgr um=new User_Mgr();
		int result=um.editUser(u);
		if(result>0)
			req.getRequestDispatcher("/page/crewManage.jsp").forward(req, resp);
		else
			req.getRequestDispatcher("/page/editUser.jsp?error=ÕÊºÅ»òÃÜÂë´íÎó&userid="+userid).forward(req, resp);
		
	}
	

}
