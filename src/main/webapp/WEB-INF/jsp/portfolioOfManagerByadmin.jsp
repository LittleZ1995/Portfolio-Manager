<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Portfolio Management | PortfolioDetail</title>

  <!-- Bootstrap -->
  <link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap.min.css">
  <!-- Datatable -->
  <link rel="stylesheet" type="text/css" href="<%=path %>/css/dataTables.bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" type="text/css" href="<%=path %>/css/font-awesome.min.css">

  <!-- Custom Theme Style -->
  <link href="<%=path %>/css/custom.min.css" rel="stylesheet">
</head>

<body class="nav-md">
  <div class="container body">
    <div class="main_container">
      <div class="col-md-3 left_col">
        <div class="left_col scroll-view">
          <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Portfolio Management!</span></a>
          </div>

          <div class="clearfix"></div>

          <!-- menu profile quick info -->
          <div class="profile clearfix">
            <div class="profile_pic">
              <img src="<%=path %>/images/Pat.png" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
              <span>Welcome,</span>
              <h2>Admin</h2>
            </div>
          </div>
          <!-- /menu profile quick info -->

          <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <jsp:include page="navigationBar.jsp" flush="true"/>
            </div>
            <!-- /sidebar menu -->

        </div>
      </div>

      <!-- top navigation -->
      <div class="top_nav">
        <div class="nav_menu">
          <nav>
            <div class="nav toggle">
              <a id="menu_toggle"><i class="fa fa-bars"></i></a>
            </div>

            <ul class="nav navbar-nav navbar-right">
              <li class="">
                <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                  <img src="<%=path %>/images/Pat.png" alt="">Admin
                  <span class=" fa fa-angle-down"></span>
                </a>
                <ul class="dropdown-menu dropdown-usermenu pull-right">
                  <li><a href="javascript:;"> Profile</a></li>
                  <li>
                    <a href="javascript:;">
                      <span class="badge bg-red pull-right">50%</span>
                      <span>Settings</span>
                    </a>
                  </li>
                  <li><a href="javascript:;">Help</a></li>
                  <li><a href="<%=path %>/logout"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
                </ul>
              </li>


            </ul>
          </nav>
        </div>
      </div>
      <!-- /top navigation -->

      <!-- page content -->
      <div class="right_col" role="main">
        <div class=""  style="height: 1400px;">
          <div class="page-title">
            <div class="title_left">
              <h3>Portfolio Detail</h3>
            </div>
          </div>

          <div class="clearfix"></div>

          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Portfolio Report </h2>
                 <!--  -->
                  <div class="clearfix"></div>
                </div>
                <div class="managerInf" style="float: right;">                 
                </div>
                
                <div class="x_content">
                   <div class="col-md-6 col-sm-6 col-xs-12 ">
                      <div id="portfolio-graphPie" style="width: 100%; height: 400px"></div>
                   </div>
                   <div class="col-md-6 col-sm-6 col-xs-12 ">
                      <div id="portfolio-graphLine" style="width: 100%; height: 400px"></div>
                   </div>
                </div>
              </div> 
            </div>
          </div>
          
           <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Position List</h2>               
                 <!--  -->
                  <div class="clearfix"></div>
                </div>
          
           <div class="x_content">
                    <div class="" role="tabpanel" data-example-id="togglable-tabs">
                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                          <li role="presentation" class="active"><a href="#etf_tab_content" role="tab" id="etf-tab" data-toggle="tab" aria-expanded="false">Positions</a>
                          </li>
                          <li role="presentation" class=""><a href="#bond_tab_content" id="bond-tab" role="tab" data-toggle="tab" aria-expanded="true">Bond</a>
                          </li>
                          <li role="presentation" class=""><a href="#future_tab_content" role="tab" id="future-tab" data-toggle="tab" aria-expanded="false" >Future</a>
                          </li>
                          <li role="presentation" class=""><a href="#equity_tab_content" role="tab" id="equity_tab" data-toggle="tab" aria-expanded="false">Equity</a>
                          </li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                        	
                        	
                        	
                        	<div role="tabpanel" class="tab-pane fade active in" id="etf_tab_content" aria-labelledby="etf-tab">
           
                            <table id="position-table" class="table table-striped table-bordered bulk_action">
                              <thead>
                                <tr>
                                  <th>Symbol/ISIN</th>
                                  <th>Quantity</th>
                                  <th>InitialPrice</th>
                                  <th>CurrentPrice</th>
                                  <th>InitialValue</th>
                                  <th>CurrentValue</th>
                                  <th>Profit</th>
                                  <th>Proportion</th>
                                  <th>Operations</th>
                                </tr>
                              </thead>


                              <tbody>
                                
                               <c:forEach items="${results}" var="position" >
                                <tr id = "position${position.key.positionid}">
                                  <td>${position.value}</td>
                                  <td class="quantity">${position.key.quantity}</td>
                                  <td class="initialprice">${position.key.initialprice}</td>
                                  <td class="currentprice">${position.key.currentprice}</td>
                                  <td class="initialValue">${position.key.initialprice * position.key.quantity}</td>
                                  <td class="currentValue">${position.key.currentprice * position.key.quantity}</td>
                                  <td class="profit ${position.key.profit lt 0?'red':'green'}">${position.key.profit}</td>
                                  <td class="proportion"></td>
                                  <%-- <fmt:formatNumber value="${100/position.value.initialprice}"  minFractionDigits="2"/> --%>
                                  <td>
                                    <a href="viewSecurity?positionid=${position.key.positionid}" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                                   
                                  </td>
                                </tr>
							  </c:forEach>        
                                
                              </tbody>
                            </table>
                          </div>
                        	
                        	
                          <div role="tabpanel" class="tab-pane fade" id="bond_tab_content" aria-labelledby="bond-tab">

                            <!-- start recent activity -->                         
                            <table id="bonds-table" class="table table-striped table-bordered bulk_action">
                              <thead>
                               <tr>
                                  <th>ISIN</th>
                                  <th>Issuer</th>
                                  <th>Coupon</th>
                                  <th>Maturity</th>
                                  <th>Quantity</th>
                                  <th>InitialPrice</th>
                                  <th>CurrentPrice</th>
                                  <th>InitialValue</th>
                                  <th>CurrentValue</th>
                                  <th>Profit</th>
                                  <th>Proportion</th>
                                  <th>Operations</th>
                                </tr>
                              </thead>


                              <tbody>
                                 <c:forEach items="${bondresults}" var="bond" >
                                <tr id = 'bond${bond.key.positionid}'>
                                  <td>${bond.value.isin}</td>
                                  <td>${bond.value.issuer}</td>
                                  <td>${bond.value.coupon}</td>
                                  <td><fmt:formatDate value="${bond.value.maturity}" pattern="yyyy/MM/dd"/></td>
                                  <td class="quantity">${bond.key.quantity}</td>
                                  <td class="initialprice">${bond.key.initialprice}</td>
                                  <td class="currentprice">${bond.key.currentprice}</td>
                                  <td class="initialValue">${bond.key.initialprice*bond.key.quantity}</td>
                                  <td class="currentValue">${bond.key.currentprice*bond.key.quantity}</td>
                                  <td class="profit">${bond.key.profit}</td>
                                  <td class="proportion"></td>
                                  <td>
                                    <a href="viewSecurity?positionid=${bond.key.positionid}" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                                    
                                  </td>
                                </tr>
							  </c:forEach> 
                                
                              </tbody>
                            </table>
                            <!-- end recent activity -->

                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="future_tab_content" aria-labelledby="future-tab">

                            <!-- start user projects -->
                            future-tab
                           <table id="future-table" class="table table-striped table-bordered bulk_action">
                              <thead>
                               <tr >
                                  <th>Symbol</th>
                                  <th>DeliveryDate</th>                       
                                  <th>Quantity</th>
                                  <th>InitialPrice</th>
                                  <th>CurrentPrice</th>
                                  <th>InitialValue</th>
                                  <th>CurrentValue</th>
                                  <th>Profit</th>
                                  <th>Proportion</th>
                                  <th>Operations</th>
                                </tr>
                              </thead>


                              <tbody>
                                <c:forEach items="${futureresults}" var="future" >
                                <tr id = 'future${future.key.positionid}'>
                                  <td>${future.value.symbol}</td>
                                  <td><fmt:formatDate value="${future.value.deliverydate}" pattern="yyyy/MM/dd"/></td>
                                  <td class="quantity">${future.key.quantity}</td>
                                  <td class="initialprice">${future.key.initialprice}</td>
                                  <td class="currentprice">${future.key.currentprice}</td>
                                  <td class="initialValue">${future.key.initialprice*future.key.quantity}</td>
                                  <td class="currentValue">${future.key.currentprice*future.key.quantity}</td>
                                  <td class="profit">${future.key.profit}</td>
                                  <td class="proportion"></td>
                                  <td>
                                    <a href="viewSecurity?positionid=${future.key.positionid}" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                                     
                                  </td>
                                </tr>
							  </c:forEach>
                              </tbody>
                            </table>
                            <!-- end user projects -->

                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="equity_tab_content" aria-labelledby="equity_tab">
                            equity-table
                            <table id="equity-table" class="table table-striped table-bordered bulk_action">
                              <thead>
                                <tr>
                                  <th>Symbol</th>
                                  <th>Sector</th>
                                  <th>Industry</th>
                                  <th>Quantity</th>
                                  <th>InitialPrice</th>
                                  <th>CurrentPrice</th>
                                  <th>InitialValue</th>
                                  <th>CurrentValue</th>
                                  <th>Profit</th>
                                  <th>Proportion</th>
                                  <th>Operations</th>
                                </tr>
                              </thead>
							  <c:forEach items="${equityresults}" var="equity" >
                                <tr id = 'equity${equity.key.positionid}'>
                                  <td>${equity.value.symbol}</td>
                                  <td>${equity.value.sector}</td>
                                  <td>${equity.value.industry}</td>
                                  <td class="quantity">${equity.key.quantity}</td>
                                  <td class="initialprice">${equity.key.initialprice}</td>
                                  <td class="currentprice">${equity.key.currentprice}</td>
                                  <td class="initialValue">${equity.key.initialprice*equity.key.quantity}</td>
                                  <td class="currentValue">${equity.key.currentprice*equity.key.quantity}</td>
                                  <td class="profit">${equity.key.profit}</td>
                                  <td class="proportion"></td>
                                  <td>
                                    <a href="viewSecurity?positionid=${equity.key.positionid}" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                                    
                                  </td>
                                </tr>
							  </c:forEach>

                              <tbody>
                                
                              </tbody>
                            </table>
                          </div>

                        </div>
                      </div>
                </div>
          	</div>
          </div>
          
          
        </div>
      </div>
    </div>
  </div>
</div>
<!-- /page content -->

<!-- modal -->

<div class="modal fade salePosition" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog ">
                          <div class="modal-content">

                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                              </button>
                              <h4 class="modal-title" id="myModalLabel2">Sale Position</h4>
                            </div>
                            <div class="modal-body">
                              <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
                              	<input id="positionId" type="hidden">
                              	<!-- <input id="quantityAll" type="hidden"> -->
                              	<div class="form-group">
                                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Quantity 
                                  </label>
                                  <div class="col-md-6 col-sm-6 col-xs-12">
                                    <label class="control-label" id="quantityAll"></label>
                                  </div>
                                </div>
                                <div class="form-group">
                                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Sale Quantity <span class="required">*</span>
                                  </label>
                                  <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="number" min="0"  id="sale" required="required" class="form-control col-md-7 col-xs-12">
                                  </div>
                                  <div class="col-md-3 col-sm-3 col-xs-12">
                                  	<span id = "tips"></span>
                                  </div>
                                </div>
                                
                                
                                <div class="ln_solid"></div>
                                <div class="form-group">
                                  <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                    <button class="btn btn-primary" type="button" data-dismiss="modal">Cancel</button>
                                    <button class="btn btn-primary" type="reset">Reset</button>
                                    <button type="button" class="btn btn-success" onclick="salePosition()">Submit</button>
                                  </div>
                                </div>
                              </form>
                            </div>
                          </div>
                        </div>
                      </div>
<!-- footer content -->
<footer>
  <div class="pull-right">
    Java 6 <a href="https://github.com:LittleZ1995/Portfolio-Manager.git
">Portfolio</a>
  </div>
  <div class="clearfix"></div>
</footer>
<!-- /footer content -->
</div>
</div>

<!-- jQuery -->
<script src="<%=path %>/js/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="<%=path %>/js/bootstrap.min.js"></script>

<!-- Echart -->
<script type="text/javascript" src="<%=path %>/js/echarts.js"></script>
<!-- Datatable -->
<script type="text/javascript" src="<%=path %>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/dataTables.bootstrap.min.js"></script>
<!-- Custom Theme Scripts -->
<script src="<%=path %>/js/custom.js"></script>
<script type="text/javascript">

	$(document).ready(function(){
		$(".proportion").each(function(){
		    $(this).text((($(this).prev().text())/($(this).parent().children(".initialValue").text())).toFixed(2));
		    if($(this).text()<0){
		    	$(this).addClass("red");
			}else{
				$(this).addClass("green");
		    }
		  });
		
	
	});

  function submitToModel(posId,quantityAll){
	  $("#positionId").val(posId);
	  $("#quantityAll").text(quantityAll);
	  $("#sale").val(0);
	  $("#sale").attr("max",quantityAll);
  }



	function salePosition(){
	  var posId = $("#positionId").val();
	  /* alert(posId); */
	  var sale =  $("#sale").val();
      var jsonData = {
    	      "posId":posId,
    	      "sale":sale
    	      };
      $.ajax({
          data:JSON.stringify(jsonData),
          contentType:"text/html;charset=utf-8",       
          type:"POST",
          dataType:"json",
          url:"salePosition",
          error:function(data){
              console.error("error:"+JSON.stringify(data));
          },
          success:function(map){
             $(".salePosition").modal('hide');
        	 $("#position"+posId + ">.quantity").text(map.currentQuantity);
        	 $("#position"+posId + ">.profit").text(map.profit);
        	 var initialValue = map.currentQuantity*$("#position"+posId + ">.initialprice").text();
        	 var currentValue = map.currentQuantity*$("#position"+posId + ">.currentprice").text();
        	 var proportion = (map.profit/initialValue*100).toFixed(2);
        	 $("#position"+posId + ">.initialValue").text(initialValue);
        	 $("#position"+posId + ">.currentValue").text(currentValue);
        	 $("#position"+posId + ">.proportion").text(proportion);
        	 
        	 $("#" + map.securityType + posId + ">.quantity").text(map.currentQuantity);
        	 $("#" + map.securityType + posId + ">.profit").text(map.profit);
        	 $("#" + map.securityType + posId + ">.initialValue").text(initialValue);
        	 $("#" + map.securityType + posId + ">.currentValue").text(currentValue);
        	 $("#" + map.securityType + posId + ">.proportion").text(proportion);
          }
      });

	}
  
    
  var portfolioGraphPie = echarts.init(document.getElementById('portfolio-graphPie'));
  var option = {
		   title: {
             text: 'Portfolio Compoment',
             left: 'center',
             top: 20,
             textStyle: {
                 color: '#73879C'
             }
         },
		     tooltip : {
             trigger: 'item',
             formatter: "{b} : {c} "
         },

		    legend: {
		        orient : 'vertical',
		        x : 'left',
		        data:['Bond','Equity','Future']
		    },
		    toolbox: {
		        show : true,
		        feature : {		           
		            saveAsImage : {show: true,title :'save'}
		        }
		    },
		    
		    calculable : true,
		    series : [
		        {     
		            type:'pie',
		            radius : '55%',
		            center: ['50%', '60%'],
		            data:[
		              	{value:"${bondvalue}", name:'Bond'},
		                {value:"${equityvalue}", name:'Equity'},
		                {value:"${futurevalue}", name:'Future'}


		            ],
		             roseType: 'radius',
                 label: {
                     normal: {
                         textStyle: {
                             color: '#73879C'
                         },
                         formatter: "{b} : {d}%"
                     }
                 }
		        }
		    ]
		};

        // 使用刚指定的配置项和数据显示图表。
        portfolioGraphPie.setOption(option);

        var portfolioFraphLine = echarts.init(document.getElementById('portfolio-graphLine'));
        var option = {
                color: ['#3498DB'],

                title: {
                    text: 'Portfolio',
                    left: 'center',
                    top: 20,
                    textStyle: {
                        color: '#73879C'
                    }
                },

                grid: {
                  left: '3%',
                  right: '4%',
                  bottom: '3%',
                  containLabel: true
                },
                toolbox: {
    		        show : true,
    		        feature : {		           
    		            saveAsImage : {show: true,title :'save'}
    		        }
    		    },
                xAxis : [
                {
                  data : ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
                  axisLine: {
                    // show: false
                    lineStyle: {
                      color:'#73879C'
                    }
                  },
                  axisTick: {
                    show: false
                  }
                }
                ],
                yAxis : [
                {
                  type : 'value',
                  axisLine: {
                    lineStyle: {
                      color:'#73879C'
                    }
                  },
                  axisTick: {
                    show: false,
                  },
                }
                ],
                series : [
                {

                  type:'line',
                  data:["${portfolio.profit}", 52, 200, 334, 390, 330, 220],
                  label:{
                    normal:{
                      show:true
                    }
                  }
                }
                ]
              };

        // 使用刚指定的配置项和数据显示图表。
        portfolioFraphLine.setOption(option);
      </script>
    </body>
    </html>