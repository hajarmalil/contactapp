<%@taglib  uri="http://www.springframework.org/tags/form" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
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
	<f:form modelAttribute="adresse" method="post" action="searchadd"> 
		<div class="page-header">
		  	<h3>ContactApp <span class="label label-default">E.S.I.E.A</span>
		  		<button type="button" class="btn btn-default btn-lg navbar-btn" id="btnS" onclick="self.location='signin'">Sign in</button>
		  	</h3>
		</div>
		<br>
		<ul class="nav nav-pills">
			<li><a href="home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
		  	<li><a href="contacts">
		  	<span class="badge pull-right">${nb}</span>
		  	Contacts List</a></li>
		  	<li><a href="addc">
		  	Add Contact <span class="glyphicon glyphicon-plus"></span></a></li>
		  	<li><a href="search">Search For Contact <span class="glyphicon glyphicon-search"></span></a></li>
		  	<li class="active"><a href="searchA">Search For Address <span class="glyphicon glyphicon-search"></span></a></li>
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
		<br><br><br><br><br>
		<f:button type="submit" class="btn btn-primary btn-sm" id="btn">GO !</f:button>
	</f:form>
	<br>
	</div>
	<div class="page-header" id="footer"> <p class="navbar-text navbar-right" id="footerT">@ CopyRight All Rights Reserved<a href="#" class="navbar-link"></a></p> </div>
</body>
</html>