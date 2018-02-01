<%@ page language="java" import="entity.*" import="java.util.*" import="java.text.*" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:useBean id="Product_Mgr" class="entity.Product_Mgr"  scope="application"/>
<jsp:useBean id="Customer_Mgr" class="entity.Customer_Mgr" scope="application"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title></title>
	
	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	<link rel="stylesheet" href="assets/materialize/css/materialize.min.css" media="screen,projection" />
    <!-- Bootstrap Styles-->
    <link href="assets/css/bootstrap.css" rel="stylesheet" />
    <!-- FontAwesome Styles-->
    <link href="assets/css/font-awesome.css" rel="stylesheet" />
    <!-- Morris Chart Styles-->
    <link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
    <!-- Custom Styles-->
    <link href="assets/css/custom-styles.css" rel="stylesheet" />
    <!-- Google Fonts-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link rel="stylesheet" href="assets/js/Lightweight-Chart/cssCharts.css">
</head>
<body>    
<div id="wrapper">
        <nav class="navbar navbar-default top-navbar" role="navigation">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand waves-effect waves-dark" href="page/main.jsp"> <strong>Analysis</strong></a>
				
		<div id="sideNav" href=""><i class="material-icons dp48">toc</i></div>
            </div>

            <ul class="nav navbar-top-links navbar-right"> 
				<li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown4"><i class="fa fa-envelope fa-fw"></i> <i class="material-icons right">arrow_drop_down</i></a></li>				
				<li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown3"><i class="fa fa-tasks fa-fw"></i> <i class="material-icons right">arrow_drop_down</i></a></li>
				<li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown2"><i class="fa fa-bell fa-fw"></i> <i class="material-icons right">arrow_drop_down</i></a></li>
				  <li><a class="dropdown-button waves-effect waves-dark" href="#!" data-activates="dropdown1"><i class="fa fa-user fa-fw"></i> <b><%=session.getAttribute("userid") %></b> <i class="material-icons right">arrow_drop_down</i></a></li>
            </ul>
        </nav>
		<!-- Dropdown Structure -->
<ul id="dropdown1" class="dropdown-content">
<li><a href="#"><i class="fa fa-user fa-fw"></i> My Profile</a>
</li>
<li><a href="page/crewManage.jsp"><i class="fa fa-gear fa-fw"></i> Settings</a>
</li> 
<li><a href="page/index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
</li>
</ul>
                <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
               
                    <li>
                        <a class="active-menu waves-effect waves-dark" href="page/main.jsp"><i class="fa fa-dashboard"></i> Home</a>
                    </li>
                    <li>
                        <a href="page/productManage.jsp" class="waves-effect waves-dark"><i class="fa fa-desktop"></i> 产品列表</a>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> 多维分析<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="page/saleAnalysis.jsp">销售额分析<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="page/saleAnalysis.jsp">柱状图/折线图分析</a>
                                    </li>
                                    <li>
                                        <a href="page/saleAnalysisScatter.jsp">散点图分析</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">销售量分析<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="page/saleAmountCategory.jsp">比重分析</a>
                                    </li>
                                    <li>
                                        <a href="page/saleCountry.jsp">地区分析</a>
                                    </li>
                                </ul>
                            </li>
                              <li>
                                <a href="page/profitAnalysis.jsp">利润分析</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-qrcode"></i> 销售管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            <li>
                                <a href="page/saleManage.jsp">销售列表</a>

                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                              <a href="page/addSale.jsp">销售添加</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-sitemap"></i> 系统管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="page/crewManage.jsp">人员管理</a>

                            </li>
                        </ul>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->

        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                             销售数据添加
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="page/main.jsp">Home</a></li>
					  <li><a href="page/saleManage.jsp">销售管理</a></li>
					  <li class="active">销售数据添加</li>
					</ol> 
									
		</div>
		
            <div id="page-inner"> 
			 <div class="row">
			 <div class="col-lg-12">
			 <div class="card">
                        <div class="card-action">
                                                销售数据添加
                        </div>
                        <div class="card-content">
    <form name="addform" class="col s12" method="post" action="servlet/SaleAddServlet">
      <div class="row">
        <div class="input-field col s6">        
          <select id="productid" name="productid" class="dropdown-button waves-effect waves-dark" >
           <%
             java.util.HashMap<Integer,Product> map=new java.util.HashMap<Integer,Product>();
             Product_Mgr pm=new Product_Mgr();
             map=pm.getProductList();
             java.util.Iterator it=map.keySet().iterator(); 
             int i=0;
             while(it.hasNext())
             {
             Product p=(Product)map.get(it.next());
             i++;                                   %>
          <option value=<%=p.getProduct_id() %>><%=p.getProduct_name() %></option>
          <%} %>
          </select>         
        </div>
        <div class="input-field col s6"> 
          <select id="customerid" name="customerid" class="dropdown-button waves-effect waves-dark" >
           <%
             java.util.HashMap<Integer,Customer> mapc=new java.util.HashMap<Integer,Customer>();
             Customer_Mgr cm=new Customer_Mgr();
             mapc=cm.getCustomerList();
             java.util.Iterator itc=mapc.keySet().iterator();             
             while(itc.hasNext())
             {
             Customer c=(Customer)mapc.get(itc.next());
                                    %>
          <option value=<%=c.getCustomer_id() %>><%=c.getCustomer_id() %></option>
          <%} %>
          </select>
        </div>
          <div class="input-field col s6"> 
          <select id="channelid" name="channelid" class="dropdown-button waves-effect waves-dark" >
          <option value="1">直销</option>
          <option value="2">分销</option>
          </select>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="amountsold" name="amountsold" type="text" class="validate">
          <label for="amountsold">销售数量</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
        <%
           SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
           String time=df.format(new Date());
         %>
          <input id="timeid" name="timeid" type="text" class="validate" value=<%=time %>>
          <label for="timeid">时间
          </label>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
        <input type="submit" value="提交" style="width:300px;">
    </div>
     </div>
    </form>
	<div class="clearBoth"></div>
  </div>
    </div>
 </div>	
	 </div>
			</div>
             <!-- /. PAGE INNER  -->
            </div>
         <!-- /. PAGE WRAPPER  -->
        </div>
     <!-- /. WRAPPER  -->
    <!-- JS Scripts-->
    <!-- jQuery Js -->
    <script src="assets/js/jquery-1.10.2.js"></script>
	
	<!-- Bootstrap Js -->
    <script src="assets/js/bootstrap.min.js"></script>
	
	<script src="assets/materialize/js/materialize.min.js"></script>
	
    <!-- Metis Menu Js -->
    <script src="assets/js/jquery.metisMenu.js"></script>
    <!-- Morris Chart Js -->
    <script src="assets/js/morris/raphael-2.1.0.min.js"></script>
    <script src="assets/js/morris/morris.js"></script>
	
	
	<script src="assets/js/easypiechart.js"></script>
	<script src="assets/js/easypiechart-data.js"></script>
	
	 <script src="assets/js/Lightweight-Chart/jquery.chart.js"></script>
	
    <!-- Custom Js -->
    <script src="assets/js/custom-scripts.js"></script> 
</body>
</html>