<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>문제</title>


</head>
<style>
html, body {
	height: 100%;
	width: 100%;
	background: skyblue;
}

#container {
	background: white;
	width: 98%;
	height: 100%;
}

#title {
	width: 100%;
	height: 50px;
	position: relative;
}

#title>div {
	margin: auto auto;
	display: block;
}

#title>div {
	float: left;
	display: inline-block;
}

#title>#select {
	float: right;
	display: inline-block;
}

#turn {
	width: 100px;
	height: 50px;
}

#select {
	position:absolute;
	right: 0px;
	height: 100%;
	text-align: center;
}
.title{
	font-size:20px;
	width: 1300px;
	text-align: center;
}
</style>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#"> <img alt="Brand" src="...">
			</a>
		</div>
		<p class="navbar-text title">Signed in as Mark Otto</p>
		<div id="select">
		<select><option>1과목</option>
			<option>2과목</option>
			<option>3과목</option>
		</select>
	</div>
	</div>
	
	</nav>

	<div id="title">
		<div id="st">
			<a>처음으로</a>
		</div>
		<div id="turn">
			<span>과목 회차</span>
		</div>

	</div>
	<div id="container">
		<div id="line1">
			<div id="quiz1"></div>
			<div id="quiz2"></div>
			<div id="quiz3"></div>
		</div>
		<div id="line2">
			<div id="quiz4"></div>
			<div id="quiz5"></div>
			<div id="quiz6"></div>
		</div>
	</div>
</body>
</html>