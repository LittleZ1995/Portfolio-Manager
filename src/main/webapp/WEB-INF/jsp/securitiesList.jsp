<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<%String path = request.getContextPath(); 
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Portfolio Management | FundManagersList</title>

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
              <div class="menu_section">
                
                <ul class="nav side-menu">
                  <li><a href="../index.html"><i class="fa fa-home"></i> Home <span class="fa fa-chevron-down"></span></a>
                    
                  </li>
                  <li><a><i class="fa fa-user"></i> Found Manager <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="fundManagersList.html">View Found Managers</a></li>
                      <!-- <li><a href="form_advanced.html">Advanced Components</a></li> -->
                    </ul>
                  </li>
                  <li><a><i class="fa fa-tasks"></i> Portfolio <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="portfoliosList.html">View Portfolios</a></li>
                      <!-- <li><a href="form_advanced.html">Advanced Components</a></li> -->
                    </ul>
                  </li>
                  <li><a><i class="fa fa-table"></i> Security  <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="securitiesList.html">View Securities</a></li>
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
              <h3>Security</h3>
            </div>

          </div>

          <div class="clearfix"></div>

          <div class="row">

            <div class="col-md-12 col-sm-12 col-xs-12">
              <div class="x_panel">
                <div class="x_title">
                  <h2>Security List</small></h2>
                  <ul class="nav navbar-right ">
                    <li><a  href="updatePrices"  class="btn btn-danger btn-xs plus"><i class="fa fa-plus"></i> Update Prices </a></li>
                  </ul>
                  <div class="clearfix"></div>
                </div>
                <div class="x_content">
                    <div class="" role="tabpanel" data-example-id="togglable-tabs">
                        <ul id="myTab" class="nav nav-tabs bar_tabs" role="tablist">
                          <li role="presentation" class="active"><a href="#bond_tab_content" id="bond-tab" role="tab" data-toggle="tab" aria-expanded="true">Bond</a>
                          </li>
                          <li role="presentation" class=""><a href="#future_tab_content" role="tab" id="future-tab" data-toggle="tab" aria-expanded="false" >Future</a>
                          </li>
                          <li role="presentation" class=""><a href="#equity_tab_content" role="tab" id="equity_tab" data-toggle="tab" aria-expanded="false">Equity</a>
                          </li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                          <div role="tabpanel" class="tab-pane fade active in" id="bond_tab_content" aria-labelledby="bond-tab">

                            <!-- start recent activity -->

                            <table id="bonds-table1" class="table table-striped table-bordered bulk_action">
                              <thead>
                                <tr>
                                  <th>ISIN</th>
                                  <th>Issuer</th>
                                  <th>Coupon</th>
                                  <th>Maturity</th>                               
                                  <th>BidPrice</th>
                                  <th>OffPrice</th>
                                  <th>Operations</th>
                                </tr>
                              </thead>


                              <tbody>
                              <c:forEach items="${bondsresults}" var="bond" >
                                <tr>
                                  <td>${bond.key.isin}</td>
                                  <td>${bond.key.issuer}</td>
                                  <td>${bond.key.coupon}</td>
                                  <td>${bond.key.maturity}</td>
                                  <td>${bond.value.bidprice}</td>
                                  <td>${bond.value.offerprice}</td>
                                  <td>
                                    <a href="<%=path %>/viewSecurity?positionid=0&securityid=${bond.key.securityid}" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                                  </td>
                                </tr>  
                                </c:forEach>                                                          
                              </tbody>
                            </table>
                            <!-- end recent activity -->

                          </div>
                          <div role="tabpanel" class="tab-pane fade" id="future_tab_content" aria-labelledby="future-tab">

                            <!-- start user projects -->

                           <table id="future-table1" class="table table-striped table-bordered bulk_action">
                              <thead>
                                 <tr >
                                  <th>Symbol</th>
                                  <th>DeliveryDate</th>                       
                                  <th>BidPrice</th>
                                  <th>OffPrice</th>
                                  <th>Operations</th>
                                </tr>
                              </thead>


                              <tbody>
                                <c:forEach items="${futureresults}" var="future" >
                                <tr>
                                  <td>${future.key.symbol}</td>
                                  <td>${future.key.deliverydate}</td>
                                  <td>${future.value.bidprice}</td>
                                  <td>${future.value.offerprice}</td>
                                  <td>
                                    <a href="<%=path %>/viewSecurity?positionid=0&securityid=${future.key.securityid}" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                                  </td>
                                </tr>  
                                </c:forEach> 
                              </tbody>
                            </table>
                            <!-- end user projects -->

                          </div>
						  
                          <div role="tabpanel" class="tab-pane fade" id="equity_tab_content" aria-labelledby="equity_tab">
                            <table id="equity-table1" class="table table-striped table-bordered bulk_action">
                              <thead>
                                <tr>
                                
                                  <th>Symbol</th>       
                                  <th>Sector</th>
                                  <th>Industry</th>                     
                                  <th>BidPrice</th>
                                  <th>OffPrice</th>
                                  <th>Operations</th>
                                </tr>
                              </thead>


                              <tbody>
                               <c:forEach items="${equityresults}" var="equity" >
                                <tr>
                                  <td>${equity.key.symbol}</td>
                                  <td>${equity.key.sector}</td>
                                  <td>${equity.key.industry}</td>
                                  <td>${equity.value.bidprice}</td>
                                  <td>${equity.value.offerprice}</td>
                                  <td>
                                    <a href="<%=path %>/viewSecurity?positionid=0&securityid=${equity.key.securityid}" class="btn btn-primary btn-xs" ><i class="fa fa-folder"></i> View </a>
                               
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

    </div>
  </div>
</div>
<!-- /page content -->
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
<script src="<%=path %>js/bootstrap.min.js"></script>

<!-- Echart -->
<script type="text/javascript" src="<%=path %>js/echarts.js"></script>
<script type="text/javascript" src="<%=path %>js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="<%=path %>js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="<%=path %>js/validator.js"></script>
<!-- Custom Theme Scripts -->
<script src="<%=path %>js/custom.js"></script>
<script type="text/javascript">

/*   function updatePrices(){
					console.log("Start to update prices");

			        $.ajax({
			            contentType:"text/html;charset=utf-8",       
			            type:"POST",
			            dataType:"json",
			            url:"updatePrices",
			            error:function(data){
			                console.error("error when update prices");
			            },
			            success:function(map){
			                console.log("End to start date");
			                alert(map.message);
			            }
			        });
			
  }		  */   
</script>
</body>
</html>