<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${urlRoot}">MEGA BIT</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${urlRoot}peliculas/index">Peliculas</a></li>
            	<li><a href="${urlRoot}noticias/index">Noticias</a></li>
            	<li><a href="${urlRoot}banners/index">Banner</a></li>             
            	<li><a href="${urlRoot}about">Acerca</a></li>
			</ul>

			<!-- menú del lado derecho -->
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Login</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
</nav>