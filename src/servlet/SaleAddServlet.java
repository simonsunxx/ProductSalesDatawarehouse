package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Sales_fact_hive_Mgr;

public class SaleAddServlet extends HttpServlet {

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
		String productid = req.getParameter("productid");
		String channelid = req.getParameter("channelid");
		String customerid=req.getParameter("customerid");
		String amountsold=req.getParameter("amountsold");
		String timeid=req.getParameter("timeid");
		System.out.println(productid);
		System.out.println(channelid);
		System.out.println(customerid);
		System.out.println(amountsold);
		System.out.println(timeid);
		int result=0;
		Sales_fact_hive_Mgr sfhm=new Sales_fact_hive_Mgr();
		result=sfhm.addSaleFact(Integer.parseInt(productid), Integer.parseInt(customerid), Integer.parseInt(channelid), Integer.parseInt(amountsold), timeid);
		System.out.println(result);
		if(result>0) req.getRequestDispatcher("/page/saleManage.jsp").forward(req, resp);
		else req.getRequestDispatcher("/page/addSale.jsp?error=ÃÌº”Œ¥≥…π¶").forward(req, resp);
	}
	

}
