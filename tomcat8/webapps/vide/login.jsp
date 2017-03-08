﻿<!DOCTYPE html>
<html lang="fr">
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta http-equiv="content-type" content="text/html; charset=utf-8" />

	<title>Page de login</title>

	<!-- Bootstrap core CSS -->
	<link href="//getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet">
	
	</head>
	<body>
		<div class="container">
			<div class="page-header">
		    	<h1>Connexion</h1>
		    </div>
	    	<div class="row">
	        	<div class="col-xs-6 col-xs-offset-3">
					<form id="loginForm" method="POST" action="authen.jsp">
						<div class="form-group">
							<label for="login" class="control-label">Login</label>
							<input type="text" class="form-control" id="login" name="login" value="">
						</div>
						<div class="form-group">
							<label for="password" class="control-label">Mot de passe</label>
							<input type="password" class="form-control" id="password" name="mdp" value="">
						</div>

						<button type="submit" class="btn btn-success btn-block">Envoyer</button>
						<a href="new.jsp" class="btn btn-default btn-block">Créer un compte !</a>
					</form>
				</div>
			</div>
		</div>
	</body>
</html>

