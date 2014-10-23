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
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/CSS/table.css">
</head>
<body>
	<div id="body">
	<f:form modelAttribute="adresse" method="post" action="saveAddress?ref=${ad.reference}"> 
		<div class="page-header">
	  		<h3>ContactApp <span class="label label-default">E.S.I.E.A</span></h3>
	  		<button type="button" class="btn btn-default btn-lg navbar-btn" id="btnS" onclick="self.location='logout'">
	  		 <span class="glyphicon glyphicon-off"></span> Log Out</button>
		</div>
		<ul class="nav nav-pills">
	  		<li><a href="contact">Profil <span class="glyphicon glyphicon-user"></span></a></li>
	  		<li class="active"><a href="listAdd">
	  		<span class="badge pull-right">${nbl}</span>
	  		List Of Addresses</a></li>
	  		<li><a href="addAddress">Add Address <span class="glyphicon glyphicon-plus"></span></a></li>
	  		<li><a href="searchAddress">Search For Address <span class="glyphicon glyphicon-search"></span></a></li>
		</ul>
		<br><br><br><br><br><br>
		<div class="input-group">
		  <span class="input-group-addon">Number</span>
		  <f:input path="numero" type="text" class="form-control" placeholder=""/>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon">Street</span>
		  <f:input type="text" class="form-control" placeholder="" path="rue"/>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon">City</span>
		  <f:input type="text" class="form-control" placeholder="" path="ville"/>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon">Post Code</span>
		  <f:input type="text" class="form-control" placeholder="" path="codePostale"/>
		</div>
		<br>
		<div class="input-group">
		  <span class="input-group-addon">Country</span>
		  <f:input type="text" class="form-control" placeholder="" path="pays"/>
		</div>
		<br><br><br><br>
		<f:button type="submit" class="btn btn-primary btn-sm" id="btn">Save Changes</f:button>
	</f:form>
		</div>
	<div class="page-header" id="footer"> <p class="navbar-text navbar-right" id="footerT">@ CopyRight All Rights Reserved<a href="#" class="navbar-link"></a></p> </div>
</body>
</html>