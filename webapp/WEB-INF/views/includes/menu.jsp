<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<spring:url value="/" var="urlRoot" />
<!-- Fixed navbar -->
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
	
	<sec:authorize access="isAnonymous()">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
			</button>
			<a class="navbar-brand" href="${urlRoot}admin/index">MEGA BIT | Administración</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${urlRoot}peliculas/index">Peliculas</a></li>
            	<li><a href="${urlRoot}noticias/index">Noticias</a></li>
            	<li><a href="${urlRoot}banners/index">Banner</a></li> 
            	<li><a href="${urlRoot}usuarios/create">Crear Usuario</a></li>             
            	<li><a href="${urlRoot}about">Acerca</a></li>
            	<li><a href="${urlRoot}admin/logout">Salir</a></li>	
			</ul>

			<!-- menú del lado derecho -->
			<ul class="nav navbar-nav navbar-right">
			<li><a href="${urlRoot}formLogin">Login</a></li>
				 <li><a href="${urlRoot}admin/logout">Salir</a></li> 		
			</ul>
		</div>
				
		<!--/.nav-collapse -->
		</sec:authorize>
		
		<sec:authorize access="hasAnyAuthority('VENDEDOR')">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
			</button>
			<a class="navbar-brand" href="${urlRoot}admin/index">MEGA BIT | Vendedor</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${urlRoot}peliculas/index">Peliculas</a></li>
            	<li><a href="${urlRoot}about">Acerca</a></li>
            	<li><a href="${urlRoot}login">Salir</a></li>
			</ul>

			<!-- menú del lado derecho -->
			<ul class="nav navbar-nav navbar-right">
				 <li><a href="${urlRoot}admin/logout">Salir</a></li> 
				<!--<li><a href="${urlRoot}login">Salir</a></li>	-->			
			</ul>
		</div>
		<!--/.nav-collapse -->
		</sec:authorize>
		
		<sec:authorize access="hasAnyAuthority('ADMINISTRADOR')">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
			</button>
			<a class="navbar-brand" href="${urlRoot}admin/index">MEGA BIT | Administración</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li><a href="${urlRoot}peliculas/index">Peliculas</a></li>
            	<li><a href="${urlRoot}noticias/index">Noticias</a></li>
            	<li><a href="${urlRoot}banners/index">Banner</a></li>             
            	<li><a href="${urlRoot}about">Acerca</a></li>
            	<li><a href="${urlRoot}login">Salir</a></li>
			</ul>

			<!-- menú del lado derecho -->
			<ul class="nav navbar-nav navbar-right">
				 <li><a href="${urlRoot}admin/logout">Salir</a></li> 
				<!--<li><a href="${urlRoot}login">Salir</a></li>	-->			
			</ul>
		</div>
		<!--/.nav-collapse -->
		</sec:authorize>
		
	</div>
</nav>