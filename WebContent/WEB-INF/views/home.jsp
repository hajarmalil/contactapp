<html>
<title>ContactApp</title>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta charset="UTF-8">
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
	  		<h3>ContactApp <span class="label label-default">E.S.I.E.A</span>
	  			<button type="button" class="btn btn-default btn-lg navbar-btn" id="btnS" onclick="self.location='signin'">Sign in</button>
	  		</h3>
		</div>
		<br>
		<ul class="nav nav-pills">
			<li class="active"><a href="home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
	  		<li><a href="contacts">
	  		<span class="badge pull-right">${nb}</span>
	  		Contacts List</a></li>
	  		<li><a href="addc">Add Contact <span class="glyphicon glyphicon-plus"></span></a></li>
	  		<li><a href="search">Search For Contact <span class="glyphicon glyphicon-search"></span></a></li>
	  		<li><a href="searchA">Search For Address <span class="glyphicon glyphicon-search"></span></a></li>
		</ul>
		<br><br><br><br><br><br><br>
		 <ul class="media-list">
            <li class="media">
              <a class="pull-left" href="#"><img class="media-object" src="<%=request.getContextPath()%>/resources/Images/contact.jpg"></a>
              <div class="media-body">
                <h4 class="media-heading">Welcome To ContactApp</h4>
                <p>Looking for somebody's Address ? <br> ContactApp offer you the opportunity to look for an address<br>
                Are you a particular who needs his Address to be known ? Or a company ?<br>
                Log on now to ContactApp and get all your Addresses accessible by people...</p>
              </div>
              </li>
          </ul>
		</div>
	<div class="page-header" id="footer"> <p class="navbar-text navbar-right" id="footerT">@ CopyRight All Rights Reserved<a href="#" class="navbar-link"></a></p> </div>
</body>
</html>