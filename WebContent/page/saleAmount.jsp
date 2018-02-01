<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%String path=request.getContextPath(); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
    <script src="http://echarts.baidu.com/build/dist/echarts.js"></script>
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
                <a class="navbar-brand waves-effect waves-dark" href="index.html"><i class="large material-icons">saleAmountx</i> <strong>Analysis</strong></a>
				
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
<li><a href="#"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
</li>
</ul>
<ul id="dropdown2" class="dropdown-content w250">
  <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 min</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
</ul>
<ul id="dropdown3" class="dropdown-content dropdown-tasks w250">
<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 1</strong>
					<span class="pull-right text-muted">60% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
						<span class="sr-only">60% Complete (success)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 2</strong>
					<span class="pull-right text-muted">28% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="28" aria-valuemin="0" aria-valuemax="100" style="width: 28%">
						<span class="sr-only">28% Complete</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 3</strong>
					<span class="pull-right text-muted">60% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
						<span class="sr-only">60% Complete (warning)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="#">
			<div>
				<p>
					<strong>Task 4</strong>
					<span class="pull-right text-muted">85% Complete</span>
				</p>
				<div class="progress progress-striped active">
					<div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="85" aria-valuemin="0" aria-valuemax="100" style="width: 85%">
						<span class="sr-only">85% Complete (danger)</span>
					</div>
				</div>
			</div>
		</a>
	</li>
	<li class="divider"></li>
	<li>
</ul>   
<ul id="dropdown4" class="dropdown-content dropdown-tasks w250">
  <li>
                            <a href="#">
                                <div>
                                    <strong>John Doe</strong>
                                    <span class="pull-right text-muted">
                                        <em>Today</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the 1500s...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since an kwilnw...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem Ipsum has been the industry's standard dummy text ever since the...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
</ul>
          <!--/. NAV TOP  -->
        <nav class="navbar-default navbar-side" role="navigation">
            <div class="sidebar-collapse">
                <ul class="nav" id="main-menu">

                    <li>
                        <a class="active-menu waves-effect waves-dark" href="index.html"><i class="fa fa-dashboard"></i> Home</a>
                    </li>
                    <li>
                        <a href="productManage.html" class="waves-effect waves-dark"><i class="fa fa-desktop"></i> 产品管理</a>
                    </li>
                    <li>
                        <a href="chart.html" class="waves-effect waves-dark"><i class="fa fa-bar-chart-o"></i> 多维分析<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="saleAnalysis.html">销售情况分析</a>
                            </li>
                            <li>
                                <a href="#">价格分析<span class="fa arrow"></span></a>
                                <ul class="nav nav-third-level">
                                    <li>
                                        <a href="priceAnalysis1.html">单价分析</a>
                                    </li>
                                    <li>
                                        <a href="priceAnalysis2.html">价格比较</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>
                    </li>
                    <li>
                        <a href="saleManage.html" class="waves-effect waves-dark"><i class="fa fa-qrcode"></i> 销售管理</a>
                    </li>
                    <li>
                        <a href="#" class="waves-effect waves-dark"><i class="fa fa-sitemap"></i> 系统管理<span class="fa arrow"></span></a>
                        <ul class="nav nav-second-level">
                            <li>
                                <a href="dataManage">数据管理</a>
                            </li>
                            <li>
                                <a href="crewManage">人员管理<span class="fa arrow"></span></a>

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
                            销售情况分析
                        </h1>
						<ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  <li><a href="#">多维分析</a></li>
					  <li class="active">销售情况分析</li>
					</ol>
		</div>
            <div id="page-inner">
				<div id="main" style="width: 1000px;height:500px;">
                 <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
      require.config({
            paths: {
                echarts: 'http://echarts.baidu.com/build/dist'
            }
        });
        
        // 使用
        require(
            [
                'echarts',
                'echarts/chart/pie' // 使用柱状图就加载bar模块，按需加载
            ],
            function (ec) {
                // 基于准备好的dom，初始化echarts图表
                var myChart = ec.init(document.getElementById('main')); 
                
                var idx = 1;
                option = {
                    timeline : {
                        data : ['2012','2013','2014','2015','2016','2017'],
                        label : {
                            formatter : function(s) {
                                return s.slice(0, 4);
                            }
                        }
                    },
                    options : [
                        {
                            title : {
                                text: '浏览器占比变化',
                                subtext: '纯属虚构'
                            },
                            tooltip : {
                                trigger: 'item',
                                formatter:"{a} <br/>{b} : {c} ({d}%)"
                                
                            },
                            legend: {
                            	orient:'vertical',
                            	x:'left',
                            	y:'center',                            	
                                data:[]
                            },
                            toolbox: {
                                show : true,
                                feature : {
                                    mark : {show: true},
                                    dataView : {show: true, readOnly: false},
                                    magicType : {
                                        show: true, 
                                        type: ['pie', 'funnel'],
                                        option: {
                                            funnel: {
                                                x: '25%',
                                                width: '50%',
                                                funnelAlign: 'left',
                                                max: 1700
                                            }
                                        }
                                    },
                                    restore : {show: true},
                                    saveAsImage : {show: true}
                                }
                            },
                            series : [
                                {
                                    name:'2012',
                                    type:'pie',
                                    center: ['50%', '45%'],
                                    radius: '50%',
                                    data:[
                                        {value: idx * 128 + 80,  name:'Chrome'},
                                        {value: idx * 64  + 160,  name:'Firefox'},
                                        {value: idx * 32  + 320,  name:'Safari'},
                                        {value: idx * 16  + 640,  name:'IE9+'},
                                        {value: idx++ * 8  + 1280, name:'IE8-'}
                                    ]
                                }
                            ]
                        },
                        {
                            series : [
                                {
                                    name:'2013',
                                    type:'pie',
                                    data:[
                                        {value: idx * 128 + 80,  name:'Chrome'},
                                        {value: idx * 64  + 160,  name:'Firefox'},
                                        {value: idx * 32  + 320,  name:'Safari'},
                                        {value: idx * 16  + 640,  name:'IE9+'},
                                        {value: idx++ * 8  + 1280, name:'IE8-'}
                                    ]
                                }
                            ]
                        },
                        {
                            series : [
                                {
                                    name:'2014',
                                    type:'pie',
                                    data:[
                                        {value: idx * 128 + 80,  name:'Chrome'},
                                        {value: idx * 64  + 160,  name:'Firefox'},
                                        {value: idx * 32  + 320,  name:'Safari'},
                                        {value: idx * 16  + 640,  name:'IE9+'},
                                        {value: idx++ * 8  + 1280, name:'IE8-'}
                                    ]
                                }
                            ]
                        },
                        {
                            series : [
                                {
                                    name:'2015',
                                    type:'pie',
                                    data:[
                                        {value: idx * 128 + 80,  name:'Chrome'},
                                        {value: idx * 64  + 160,  name:'Firefox'},
                                        {value: idx * 32  + 320,  name:'Safari'},
                                        {value: idx * 16  + 640,  name:'IE9+'},
                                        {value: idx++ * 8  + 1280, name:'IE8-'}
                                    ]
                                }
                            ]
                        },
                        {
                            series : [
                                {
                                    name:'2016',
                                    type:'pie',
                                    data:[
                                        {value: idx * 128 + 80,  name:'Chrome'},
                                        {value: idx * 64  + 160,  name:'Firefox'},
                                        {value: idx * 32  + 320,  name:'Safari'},
                                        {value: idx * 16  + 640,  name:'IE9+'},
                                        {value: idx++ * 8  + 1280, name:'IE8-'}
                                    ]
                                }
                            ]
                        },
                        {
                            series : [
                                {
                                    name:'2017',
                                    type:'pie',
                                    data:[
                                        {value: idx * 128 + 80,  name:'Chrome'},
                                        {value: idx * 64  + 160,  name:'Firefox'},
                                        {value: idx * 32  + 320,  name:'Safari'},
                                        {value: idx * 16  + 640,  name:'IE9+'},
                                        {value: idx++ * 8  + 1280, name:'IE8-'}
                                    ]
                                }
                            ]
                        }                      
                       
                    ]
                };
                // 为echarts对象加载数据 
                $.ajax({  
            type : "post",  
            async : true, //异步执行  
            url : "../servlet/SaleAmountServlet",  
            dataType : "json", //返回数据形式为json  
            success : function(json) {  
                if (json) {  
                            myChart.hideLoading();
                            option.timeline.data=json.timetoolData;
                            option.options[0].legend.data=json.legendData;
                            for(var i=0;i<json.lsize;i++)
                            {
                            	//option.options[i].legend.data=json.legendData;
                            	option.options[i].series.name=json.seriesList[i]['name'];
                            	option.options[i].series.type=json.seriesList[i]['type'];
                            	option.options[i].series.data=json.seriesList[i]['data'];
                            
                            }
                            myChart.setOption(option);
                            /*myChart.setOption({
                            	timeline:{
                            		data:json.timetoolData
                            	},                             
                            	options:[{
                            	legend:{
                            		data:json.legendData
                            	},
                               series:function(){
                            	   var ser=[];
                            	   var l=json.lsize;                            	   
                            	   //alert(json.seriesList[0].data[0]['name']);
                            	   for(var i=0;i<l;i++)
                            		   {  
                            		       var item={
                            		    	   name:json.seriesList[i]['name'],
                            		    	   type:json.seriesList[i]['type'],
                            		    	   data:function(){
                            		    		   var da=[];
                            		    		   var k=json.seriesList[i].data.length;
                            		    		   for(var j=0;j<k;j++)
                            		    			{
                            		    			   var it={
                            		    					   value:json.seriesList[i].data[j]['value'],
                            		    					   name:json.seriesList[i].data[j]['name']
                            		    			   }
                            		    			   da.push(it);
                            		    			   
                            		    			}
                            		    		   return da;
                            		    	   }()
                            		    	  
                            		    	   
                            		       }
                            		       ser.push(item);
                            		   }
                            	   return ser;
                               }() 
                            }]}
                            	
                            	
                            ); */ 
                                    
            }  
            },  
            error : function(errorMsg) {
                alert("请求数据失败");  
            }  
        });
     
                myChart.setOption(option); 
            }
        ); 
 
    </script>
    

                <!-- /. ROW  -->	   						

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

		
				<footer>
  <p>Copyright &copy; 2016.Company name All rights reserved.</p>
				
        
				</footer>
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