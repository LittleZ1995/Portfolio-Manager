<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath(); %>
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
        <div class="">
          <div class="page-title">
            <div class="title_left">
              <h3>Security Detail</h3>
            </div>
          </div>

          <div class="clearfix"></div>

          <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Security Report </h2>
                 <!--  -->
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                   <div id="security_graphLine" style="width:100%; height:380px;"></div>
                </div>
              </div> 
            </div>
            
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Security Price List </h2>
                 <!--  -->
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                   <table id="prices-table" class="table table-striped table-bordered bulk_action">
                   		<thead>
                        	<tr>
                            	<th>Date</th>
                                <th>Bid Price</th>
                                <th>Offer Price</th>
                            </tr>
                        </thead>


                        <tbody>
                        <c:forEach items="${prices}" var="price" >
                        <tr>
                        
                        	<td class="dates"><fmt:formatDate value="${price.date}" pattern="yyyy/MM/dd HH:mm"/></td>
                            <td><label>$</label>${price.bidprice}</td>
                            <td><label>$</label>${price.offerprice}</td>                         
                            </tr>
                        </c:forEach>
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
<!-- /page content -->

<!-- modal -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog ">
    <div class="modal-content">

      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">Ã</span>
        </button>
        <h4 class="modal-title" id="myModalLabel2">Edit Found Manager</h4>
      </div>
      <div class="modal-body">
        <form id="demo-form2" data-parsley-validate class="form-horizontal form-label-left">
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">First Name <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" id="first-name" required="required" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="last-name">Last Name <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" id="last-name" name="last-name" required="required" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="email">Email <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="email" id="email" name="email" required="required" class="form-control col-md-7 col-xs-12">
            </div>
          </div>
          <div class="form-group">
            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="phone">Phone <span class="required">*</span>
            </label>
            <div class="col-md-6 col-sm-6 col-xs-12">
              <input type="text" id="Phone" name="Phone" required="required" class="form-control col-md-7 col-xs-12">
            </div>
          </div>

          <div class="ln_solid"></div>
          <div class="form-group">
            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
              <button class="btn btn-primary" type="button" data-dismiss="modal">Cancel</button>
              <button class="btn btn-primary" type="reset">Reset</button>
              <button type="submit" class="btn btn-success">Submit</button>
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
	var bidprices =  [];
	var offprices =  [];
	var dates = [];
	<c:forEach items="${prices}" var="item" varStatus="status" >  
		bidprices.push(${item.bidprice});
		offprices.push(${item.offerprice});
	</c:forEach>

	$(".dates").each(function(){
		dates.push($(this).text());
		});
	
        var security_graphLine = echarts.init(document.getElementById('security_graphLine'));
        var  option = {
        	    title : {
        	        text: 'Security perfomece',
        	    },
        	    tooltip : {
        	        trigger: 'axis'
        	    },
        	    legend: {
        	        data:['BidPrice','OfferPrice']
        	    },
        	    toolbox: {
        	        show : true,
        	        feature : {
        	            mark : {show: true},
        	            magicType : {show: true, type: ['line', 'bar'],title :'bar'},
        	            restore : {show: true,title :'restore'},
        	            saveAsImage : {show: true,title :'save'}
        	        }
        	    },
        	    calculable : true,
        	    xAxis : [
        	        {
        	            type : 'category',
        	            boundaryGap : false,
        	            data : dates
        	        }
        	    ],
        	    yAxis : [
        	        {
        	            type : 'value',
        	            axisLabel : {
        	                formatter: '${value}'
        	            }
        	        }
        	    ],
        	    series : [
        	        {
        	            name:'BidPrice',
        	            type:'line',
        	            data:bidprices,
        	            markPoint : {
        	                data : [
        	                    {type : 'max', name: 'Max'},
        	                    {type : 'min', name: 'Min'}
        	                ]
        	            },
        	            markLine : {
        	                data : [
        	                    {type : 'average', name: 'Average'}
        	                ]
        	            }
        	        },
        	        {
        	            name:'OfferPrice',
        	            type:'line',
        	            data:offprices,
        	            markPoint : {
        	                data : [
        	                    {name : 'min', value : -2, xAxis: 1, yAxis: -1.5}
        	                ]
        	            },
        	            markLine : {
        	                data : [
        	                    {type : 'average', name : 'Average'}
        	                ]
        	            }
        	        }
        	    ]
        	};

        // ä½¿ç¨åæå®çéç½®é¡¹åæ°æ®æ¾ç¤ºå¾è¡¨ã
        security_graphLine.setOption(option);
      </script>
    </body>
    </html>