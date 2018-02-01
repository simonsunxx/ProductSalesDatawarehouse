<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Analysis</title>
	
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
    <script src=echarts.js></script>
    <script src=jquery-3.2.0.js></script>
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
                <a class="navbar-brand waves-effect waves-dark" href="main.jsp"> <strong>Analysis</strong></a>
				
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
<li><a href="crewManage.jsp"><i class="fa fa-gear fa-fw"></i> Settings</a>
</li> 
<li><a href="index.jsp"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
</li>
</ul>
           <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
                    <li>
                        <a class="active-menu waves-effect waves-dark" href="main.jsp"><i class="fa fa-dashboard"></i> Home</a>
                    </li>
                    <li>
                        <a href="productManage.jsp" class="waves-effect waves-dark"><i class="fa fa-desktop"></i> 产品列表</a>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> 多维分析<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="saleAnalysis.jsp">销售额分析<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="saleAnalysis.jsp">柱状图/折线图分析</a>
                                    </li>
                                    <li>
                                        <a href="saleAnalysisScatter.jsp">散点图分析</a>
                                    </li>
                                </ul>
                            </li>
                            <li>
                                <a href="#">销售量分析<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="saleAmountCategory.jsp">比重分析</a>
                                    </li>
                                    <li>
                                        <a href="saleCountry.jsp">地区分析</a>
                                    </li>
                                </ul>
                            </li>
                             <li>
                                <a href="profitAnalysis.jsp">利润分析</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-qrcode"></i> 销售管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                            <li>
                                <a href="saleManage.jsp">销售列表</a>

                            </li>
                        </ul>
                          <ul class="nav nav-second-level">
                            <li>
                              <a href="addSale.jsp">销售添加</a>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-sitemap"></i> 系统管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="crewManage.jsp">人员管理</a>

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
                            价格比较
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="main.jsp">Home</a></li>
					  <li><a href="#">多维分析</a></li>
					  <li class="active">销售量分析</li>
                       <li class="active">比重分析</li>
					</ol> 
									
		</div>
 <div id="choice"> 
  <select id="year" class="dropdown-button waves-effect waves-dark" style="height: 32px; width: 100px" onchange="changeAxis()">
  <option value="1">Customer</option>
  <option value="2" selected>Channel</option>
  </select>
  </div>
            <div id="page-inner">
		<div id="main" style="width: 1000px;height:500px;">
                 <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));  
         
        option = {
        	    title : {
        	        text: '销量分析',       	        
        	        x:'center'
        	    },
        	    tooltip : {
        	        trigger: 'item',
        	        formatter: "{a} <br/>{b} : {c} ({d}%)"
        	    },
        	    legend: {
        	        x : 'center',
        	        y : 'bottom',
        	        data:[]
        	    },
        	    toolbox: {
        	        show : true,
        	        feature : {
        	            mark : {show: true},
        	            dataView : {show: true, readOnly: false},
        	            magicType : {
        	                show: true,
        	                type: ['pie', 'funnel']
        	            },
        	            restore : {show: true},
        	            saveAsImage : {show: true}
        	        }
        	    },
        	    calculable : true,
        	    series : [
        	        {
        	            name:'半径模式',
        	            type:'pie',
        	            radius : [20, 110],
        	            center : ['25%', '50%'],
        	            roseType : 'radius',
        	            label: {
        	                normal: {
        	                    show: false
        	                },
        	                emphasis: {
        	                    show: true
        	                }
        	            },
        	            lableLine: {
        	                normal: {
        	                    show: false
        	                },
        	                emphasis: {
        	                    show: true
        	                }
        	            },
        	            data:[]
        	        },
        	        {
        	            name:'面积模式',
        	            type:'pie',
        	            radius : [30, 110],
        	            center : ['75%', '50%'],
        	            roseType : 'area',
        	            data:[]
        	        }
        	    ]
        	};
        $.ajax({  
            type : "post",  
            async : true, //异步执行  
            url : "../servlet/SaleAmountServlet2",  
            dataType : "json", //返回数据形式为json  
            success : function(json) {  
                if (json) {  
                	        //var obj=JSON.stringify(json.seriesList[0].data[0]) ;
                            myChart.hideLoading();  
                            option.legend.data=json.legendData;
                            option.series[0].data=json.seriesList[0].data;
                            option.series[1].data=json.seriesList[0].data;
                            myChart.setOption(option);
                                    
            }  
            },  
            error : function(errorMsg) {
                alert("请求数据失败");  
            }  
        });  
        myChart.setOption(option); 
        
       //myChart.showLoading();  
        //通过Ajax获取数据  
       
              
 
    </script>
	   
				
				

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
		
				<footer><p>Copyright &copy; 2016.Company name All rights reserved.</p>
				
        
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