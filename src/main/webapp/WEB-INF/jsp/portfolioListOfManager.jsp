<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

  <title>Portfolio Management | PortfoliosList</title>

  <!-- Bootstrap -->
  <link rel="stylesheet" type="text/css" href="<%=path %>/css/bootstrap.min.css">
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
              <img src="<%=path %>/images/zyz.jpg" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
              <span>Welcome,</span>
              <h2>${sessionScope.FundManager.firstname}${sessionScope.FundManager.lastname}</h2>
            </div>
          </div>
          <!-- /menu profile quick info -->

          <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                
                <ul class="nav side-menu">
         
                  <li><a><i class="fa fa-tasks"></i> Portfolio <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="portfoliosList_manager.html">View Portfolios</a></li>
                      <!-- <li><a href="form_advanced.html">Advanced Components</a></li> -->
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Position  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="positionsList_manager.html">View Positions</a></li>
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Security  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="securitiesList_manager.html">View Securities Performance</a></li>
                    </ul>
                  </li>
                </ul>
              </div>
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
                  <img src="<%=path %>/images/zyz.jpg" alt="">${sessionScope.FundManager.firstname}${sessionScope.FundManager.lastname}
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
                  <li><a href="login.html"><i class="fa fa-sign-out pull-right"></i> Log Out</a></li>
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
              <h3>Portfolio</h3>
            </div>
          </div>

          <div class="clearfix"></div>

          <div class="row">
            <div class="col-md-12">
              <div class="x_panel">
               <div class="x_title">
                  <h2>Portfolio Performance</small></h2>
                  
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  <div id="portfolio-graphLine-manager" style="width: 100%; height: 400px"></div>
                </div>
              </div>
            </div>
            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Portfolio List</small></h2>
                  <ul class="nav navbar-right ">
                    <li><a  class="btn btn-success btn-xs plus" data-toggle="modal" data-target=".bs-example-modal-sm"><i class="fa fa-plus"></i> Add </a></li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                  
                   <table id="portfolios-table" class="table table-striped table-bordered bulk_action">
                            <thead>
                              <tr>
                                <th>Portfolio Name</th>
                                <th>Profit</th>
                                <th>Operations</th>
                              </tr>
                            </thead>


                            <tbody>
                            <c:forEach items="${portfolios}" var="portfolio" >
                              <tr id = ${portfolio.portfolioid}>
                                <td>${portfolio.name}</td>
                                <td>${portfolio.profit}</td>
                                <td>                                
                                  <a href="viewOnePortfolio?portfolioid=${portfolio.portfolioid}" class="btn btn-info btn-xs"><i class="fa fa-pencil"></i> Edit </a>
                                  <a href="#" class="btn btn-danger btn-xs"><i class="fa fa-trash-o"></i> Delete </a>
                                </td>
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
<!-- /page content -->

<!-- model -->
<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
                        <div class="modal-dialog ">
                          <div class="modal-content">

                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
                              </button>
                              <h4 class="modal-title" id="myModalLabel2">Add Found Manager</h4>
                            </div>
                            <div class="modal-body">
                              <form id="demo-form2" data-parsley-validate  action="addPortfolio" method="post" class="form-horizontal form-label-left">
                                <div class="form-group">
                                  <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Portfolio Name <span class="required">*</span>
                                  </label>
                                  <div class="col-md-6 col-sm-6 col-xs-12">
                                    <input type="text" name="name" id="name" required="required" class="form-control col-md-7 col-xs-12">
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
<!-- /model -->

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
<script type="text/javascript" src="<%=path %>/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/validator.js"></script>
<!-- Custom Theme Scripts -->
<script src="<%=path %>/js/custom.js"></script>
<script type="text/javascript">

  var profit =  [];
  var names = [];
  <c:forEach items="${portfolios}" var="item" varStatus="status" >  
	 profit.push( ${item.profit});
	 names.push("${item.name}");
  </c:forEach>
  var portfolioGraphLine = echarts.init(document.getElementById('portfolio-graphLine-manager'));
  var option = {
          title: {
              text: 'Portfolios'
          },
          tooltip: {},
          legend: {
              data:['Profit']
          },
          xAxis: {
              data: names
          },
          yAxis: {},
          series: [{
              name: 'Profit',
              type: 'bar',
              data: profit
          }]
      };

        // 使用刚指定的配置项和数据显示图表。
        portfolioGraphLine.setOption(option);
</script>
</body>
</html>