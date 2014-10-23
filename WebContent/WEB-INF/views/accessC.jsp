<%@taglib  uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="UTF-8">
<title>ContactApp</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/CSS/footer.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/Bootstrap-theme.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/Bootstrap/CSS/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/CSS/table.css">
</head>
<body>
	<div id="body">
		<div class="page-header">
	  		<h3>ContactApp <span class="label label-default">E.S.I.E.A</span></h3>
		  		<button type="button" class="btn btn-default btn-lg navbar-btn" id="btnS" onclick="self.location='signin'">Sign in</button>
		</div>
		<br>
		<ul class="nav nav-pills">
			<li><a href="home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
	  		<li class="active"><a href="contacts">
	  		<span class="badge pull-right">${nb}</span>
	  		Contacts List</a></li>
	  		<li><a href="addc">Add Contact</a></li>
	  		<li><a href="search">Search For Contact <span class="glyphicon glyphicon-search"></span></a></li>
	  		<li><a href="searchA">Search For Address  <span class="glyphicon glyphicon-search"></span></a></li>
		</ul>
		<br><br><br><br><br><br>
		<div id="listeContacts" class="container-fluid">
			<table class="table table-hover" id="table">
				<tr id="headT"> 
					<th id="t9"></th> <th id="t10"></th>
				</tr>
				<tr>
					<td id="t1" class="t1"> Last Name </td> 
					<td id="t3">  ${ct.nom}  </td> 
				</tr>
				<tr>
					<td id="t2"> First Name </td> 
					<td id="t4">  ${ct.prenom}  </td> 
				</tr>
				<tr>
					<td id="t5"> Mail Address </td> 
					<td id="t6">  ${ct.adresseMail}  </td>
				</tr>
				<tr>
					<td id="t7"> Date Of Birth </td> 
					<td id="t8">  ${ct.dateNaissance}  </td>
				</tr>
				<tr>
					<td id="t7"> List Of Addresses </td> 
					<td id="t8"> <a href="addresslist?adc=${ct.adresseMail}">Access To</a> </td>
				</tr>
				<tr id="headT"> 
					<th id="t9"></th> <th id="t10"></th>
				</tr>
			</table>
		</div>
	<br>
	</div>
	<div class="page-header" id="footer"> <p class="navbar-text navbar-right" id="footerT">@ CopyRight All Rights Reserved<a href="#" class="navbar-link"></a></p> </div>
</body>
</html>