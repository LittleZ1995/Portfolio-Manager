<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%String path = request.getContextPath(); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${sessionScope.FundManager.email}

<h2>my portfolios</h2>
	<table border="" cellspacing="" cellpadding="">
			<tr><th>portfolioid</th>
				<th>portfolioname</th>
				<th>managerid</th>
				<th>operation</th>
			</tr>
			<c:forEach items="${portfolios}" var="portfolio" >
                <tr id = ${portfolio.portfolioid} >
                <td>${portfolio.portfolioid}</td>
				<td>${portfolio.name}</td>
				<td>${portfolio.managerid}</td>
				<td><button onclick="">operation</button></td>
			</tr>
            </c:forEach>
			
	</table>
	<h2>add portfolio</h2>	
		<form action="addPortfolio" method="post">
				<input type="text" name="name" id="name" value="" />
				<input type="submit" value="confirm"/>
		</form>
	
		
</body>
</html>