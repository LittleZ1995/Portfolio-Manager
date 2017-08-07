<%@ page language="java" contentType="text/html; charset=utf-8"
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
<h2>all managers</h2>
		<table border="" cellspacing="" cellpadding="">
			<tr><th>id</th>
				<th>first name</th>
				<th>last name</th>
				<th>email</th>
				<th>telephone</th>
				<th>password</th>
				<th>operation</th>
			</tr>
			<c:forEach items="${fundManagers}" var="fundmanager" >
                <tr id = ${fundmanager.managerid} >
                <td>${fundmanager.managerid}</td>
				<td>${fundmanager.firstname}</td>
				<td>${fundmanager.lastname}</td>
				<td>${fundmanager.email}</td>
				<td>${fundmanager.phonenumber}</td>
				<td>${fundmanager.password}</td>
				<td><input type="button" name="delete" onclick="deleteManagerById(${fundmanager.managerid})" value="delete" /></td>
			</tr>
            </c:forEach>
			
		</table>
		
<h2>add manager</h2>	
		<form action="addManager" method="post">
				<input type="text" name="managerid" id="managerid" value="" />
				<input type="text" name="firstname" id="firstname" value="" />
				<input type="text" name="lastname" id="lastname" value="" />
				<input type="text" name="email" id="email" value="" />
				<input type="text" name="phonenumber" id="phonenumber" value="" />
				<input type="text" name="password" id="password" value="" />
				<input type="submit" value="confirm"/>
			</form>
		
		
		
</body>
		<script src="<%=path %>/js/jquery-3.1.1.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
				
				function deleteManagerById(managerid){
					console.log("11");
			        var j={"managerid":managerid};
			        /* var data = '{"managerid": "4"}'; */
			        console.log(JSON.stringify(j));
			        alert(JSON.stringify(j));
			        $.ajax({
			            data:JSON.stringify(j),
			            contentType:"text/html;charset=utf-8",       
			            type:"POST",
			            dataType:"json",
			            url:"deleteManagerById",
			            error:function(data){
			                console.error("error:"+JSON.stringify(data));
			            },
			            success:function(map){
			                console.log(JSON.stringify(map));
			                $("#"+managerid).remove();
			                alert(map.message);
			            }
			        });
			
			    }

			    
				
			
			
		</script>
</html>