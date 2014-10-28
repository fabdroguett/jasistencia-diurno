<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="ie6 ielt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="ie7 ielt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="ie8"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!--> <html lang="en"> <!--<![endif]-->
<head>
<meta charset="utf-8">
<title>Paper Stack</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
<div class="container">
	<section id="content">
            <form action="iniciar.do" method="post">
			<h1>Login Form</h1>
			<div>
				<input type="text" placeholder="Run" name="txtRun" required="required" id="username" />
			</div>
			<div>
				<input type="password" name="txtPass"  placeholder="Password" required="required" id="password" />
			</div>
			<div>
				<input type="submit" value="Iniciar" />
                                <a href="menuadministrador.jsp">Acceder Administrador</a>
 			</div>
		</form><!-- form -->
		
	</section><!-- content -->
</div><!-- container -->
</body>
</html>