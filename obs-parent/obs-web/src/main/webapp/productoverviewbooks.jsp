<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="obs" tagdir="/WEB-INF/tags"%>

<?xml version="1.0" encoding="ISO-8859-1" ?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<obs:header title="Product Overzicht Boeken"></obs:header>
	<header id="banner" class="body"> 
		<h1><a href="#">Boeken overzicht! <strong>Lijst met alle boeken 
		<ins>2012</ins></strong></a></h1> 
		<nav><ul> 
		<li class="active"><a href="#">homepage</a></li> 
		<li><a href="#">Boeken overzicht</a></li> 
		<li><a href="#">DVD overzicht</a></li> 
		<li><a href="#">Winkelwagen</a>
		</li> 
		</ul></nav> 
	</header>
<body>
	<section id="content" class="body"> 
	<ol id="posts-list" class="hfeed"> 
	<li><article class="hentry"> 
	<header> 
	<h2 class="entry-title"><a href="#" rel="bookmark" 
	title="Permalink to this POST TITLE">This be the title</a></h2> 
	</header> 
	
	<footer class="post-info"> 
	<abbr class="published" title="2005-10-10T14:07:00-07:00"><!-- YYYYMMDDThh:mm:ss+ZZZZ --> 10th October 2005 
	</abbr> 
	
	<address class="vcard author"> 
	By <a class="url fn" href="#">Enrique Ramírez</a> 
	</address> 
	
	</footer><!-- /.post-info --> 
	
	<div class="entry-content"> 
	<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque venenatis nunc vitae libero iaculis elementum. Nullam et justo <a href="#">non sapien</a> dapibus blandit nec et leo. Ut ut malesuada tellus.</p> 
	</div><!-- /.entry-content --> 
	</article></li> 
	
	<li><article class="hentry"> 
	... 
	</article></li> 
	
	<li><article class="hentry"> 
	... 
	</article></li> 
	
	</ol><!-- /#posts-list --> 
	</section><!-- /#content --> 

</body>
</html>