package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Sales_fact_hive_Mgr;

public class saleDeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html");
		String sales_fact_id = req.getParameter("sales_fact_id");
		int result=0;
		Sales_fact_hive_Mgr sfhm=new Sales_fact_hive_Mgr();
		result=sfhm.deleteSaleFact(Integer.parseInt(sales_fact_id));
		System.out.println(result);
		if(result>0) req.getRequestDispatcher("/page/saleManage.jsp").forward(req, resp);
		else req.getRequestDispatcher("/page/deleteSale.jsp?error=ÃÌº”Œ¥≥…π¶").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req,resp);
	}
	

}
