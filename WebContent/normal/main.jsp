<%@ page language="java" import="java.util.*" import="java.text.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <base href="<%=basePath%>">
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Home</title>
	
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
                <button type="button" class="navbar-toggle waves-effect waves-dark" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand waves-effect waves-dark" href="index.html"><i class="large material-icons">normal_main</i> <strong>Analysis</strong></a>
				
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
<li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
</li> 
<li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
</li>
</ul>
         <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">           
                    <li>
                        <a class="active-menu waves-effect waves-dark" href="normal/main.jsp"><i class="fa fa-dashboard"></i> Home</a>
                    </li>
                    <li>
                        <a href="normal/productManage.jsp" class="waves-effect waves-dark"><i class="fa fa-desktop"></i> 产品列表</a>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> 多维分析<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="normal/saleAnalysis.jsp">销售额分析<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="normal/saleAnalysis.jsp">柱状图/折线图分析</a>
                                    </li>
                                    <li>
                                        <a href="normal/saleAnalysisScatter.jsp">散点图分析</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">销售量分析<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="normal/saleAmountCategory.jsp">比重分析</a>
                                    </li>
                                    <li>
                                        <a href="normal/saleCountry.jsp">地区分析</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                </ul>

            </div>

        </nav>
        <!-- /. NAV SIDE  -->



        <div id="page-wrapper">
		  <div class="header"> 
                        <h1 class="page-header">
                            Home
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					</ol>
		</div>
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="card-content">
                                 <div class="alert alert-info">
                                 <strong>Welcome</strong>
                                 </div>
                                <div class="alert alert-success">
                                <strong>当前时间：<%
                                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                String time=df.format(new Date());
                                %><%=time %></strong>
                                </div>
                            </div>
                        </div>
                    </div>
                     <div class="col-md-6 col-sm-6" style="width:1060px">
                    <div class="card">
                        <div class="card-action">
                            Tabs
                        </div>
                        <div class="card-content">
                           <div class="col">
							  <ul class="tabs">
								<li class="tab col s3" style="width:150px"><a href="#test1">Tips One</a></li>
								<li class="tab col s3" style="width:150px"><a class="active" href="#test2">Tips Two</a></li>								
								<li class="tab col s3" style="width:150px"><a href="#test4">Tips Three</a></li>
							  </ul>
							</div>
							<div class="clearBoth"><br/></div>
							<div id="test1" class="col s12"><p>Introduction: This system is for Analysis</p></div>
							<div id="test2" class="col s12"><p>System Construction:WEB PROJECT: java EE , Hadoop, Hive , Sqoop , Mysql , Shell</p></div>						
							<div id="test4" class="col s12"><p>Your permission: you can just look for the analysis chart/diagram, you cannot cope with data</p></div>
                           <div class="clearBoth"><br/></div>
                            </div>
                        </div>
                    </div>
                    <div class="fixed-action-btn horizontal click-to-toggle">
    <a class="btn-floating btn-large red">
      <i class="material-icons">menu</i>
    </a>
    <ul>
      <li><a class="btn-floating red"><i class="material-icons">insert_chart</i></a></li>
      <li><a class="btn-floating yellow darken-1"><i class="material-icons">format_quote</i></a></li>
      <li><a class="btn-floating green"><i class="material-icons">publish</i></a></li>
      <li><a class="btn-floating blue"><i class="material-icons">attach_file</i></a></li>
    </ul>
  </div>
		
				<footer><p>Copyright &copy; 2017.Company name All rights reserved.</p>
				
        
				</footer>
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