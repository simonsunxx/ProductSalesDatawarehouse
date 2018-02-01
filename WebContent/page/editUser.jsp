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
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->

        <div id="page-wrapper" >
		  <div class="header"> 
                        <h1 class="page-header">
                                                                           编辑用户
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="page/main.jsp">Home</a></li>
					  <li><a href="page/crewManage.jsp">人员管理</a></li>
					  <li class="active">编辑用户</li>
					</ol> 
									
		</div>
		
            <div id="page-inner"> 
			 <div class="row">
			 <div class="col-lg-12">
			 <div class="card">
               <div class="card-action">
                                                用户信息编辑
                        
                        <div class="card-content">
    <form name="editform" class="col s12" method="post" action="servlet/UserServlet">
      <div class="row">
        <div class="input-field col s12">  
       <%
         String userid = request.getParameter("userid"); 
       %>             
        <input id="userid" name="userid" type="text" value=<%=userid %> readonly="true" class="validate">
        <label for="userid">用户编号</label>
        </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="password" name="password" type="password" class="validate">
          <label for="password">新密码</label>
        </div>
      </div>
      <div class="row">
        <div class="input-field col s12">
          <input id="username" name="username" type="text" class="validate">
          <label for="username">用户名</label>
        </div>
      </div>
      <div class="row">
        <div class="col s12">
        <input type="submit" value="提交" style="width:200px;">
        <input type="submit"  value="返回" name="back" style="width:200px;" onclick="javascript:history.back(-1);">
    </div>
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