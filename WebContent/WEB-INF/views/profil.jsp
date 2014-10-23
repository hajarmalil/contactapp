<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib  uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="UTF-8">
<title>ContactApp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/CSS/form.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/CSS/footer.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/Bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap-theme.min.css">
</head>
<body>
	<div id="body">
		<div class="page-header">
	  		<h3>ContactApp <span class="label label-default">E.S.I.E.A</span></h3>
	  		<button type="button" class="btn btn-default btn-lg navbar-btn" id="btnS" onclick="self.location='logout'">
	  		 <span class="glyphicon glyphicon-off"></span> Log Out</button>
		</div>
		<ul class="nav nav-pills">
	  		<li class="active"><a href="contact">Profil <span class="glyphicon glyphicon-user"></span></a></li>
	  		<li><a href="listAdd">
	  		<span class="badge pull-right">${nbl}</span>
	  		List Of Addresses</a></li>
	  		<li><a href="addAddress">Add Address <span class="glyphicon glyphicon-plus"></span></a></li>
	  		<li><a href="searchAddress">Search For Address <span class="glyphicon glyphicon-search"></span></a></li>
		</ul>
		<br><br><br><br><br><br>
		<div id="listeContacts" class="container-fluid">
			<table class="table table-hover" id="table">
				<tr> 
					<td id="headT1"> First Name </td> <td id="t3"> ${ct.prenom} </td> 
				</tr>
				<tr> 
					<td id="headT2"> Last Name </td> <td id="t4"> ${ct.nom} </td> 
				</tr>
				<tr> 
					<td id="headT3"> E-Mail </td> <td id="t5"> ${ct.adresseMail} </td> 
				</tr>
				<tr> 
					<td id="headT4"> Date Of Birth </td> <td id="t6"> ${ct.dateNaissance} </td> 
				</tr>
				<tr> 
					<td id="headT5"> Password </td> <td id="t7"> ******** </td> 
				</tr>
				<tr> 
					<td id="headT5"> <a href="ConfirmDeleteAccount"> Delete My Account <span class="glyphicon glyphicon-trash"></span></a></td> <td id="t7"> </td> 
				</tr>
			</table>
		</div>
		<br><br><br><br>
		<button type="button" class="btn btn-primary btn-sm" id="btn" onclick="self.location='profilmod'">Modify</button>
		<br>
	</div>
	<div class="page-header" id="footer"> <p class="navbar-text navbar-right" id="footerT">@ CopyRight All Rights Reserved<a href="#" class="navbar-link"></a></p> </div>
</body>
</html>