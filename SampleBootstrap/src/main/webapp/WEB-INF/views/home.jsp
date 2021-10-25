<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1"
	crossorigin="anonymous">

	<style >
	.container{
	background-color: #E0FFFF;
	}


	</style>




<title>Home</title>

</head>
<body>

<div class="card" style="width: 18rem;">
  <img src="..." class="card-img-top" alt="...">
  <div class="card-body">
    <h5 class="card-title">Card title</h5>
    <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
    <a href="#" class="btn btn-primary">Go somewhere</a>
  </div>
</div>


	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"/="anonymous"></script>
	<h1 class="p-3 mb-2 bg-success text-white bg-gradient">Hello
		world!</h1>



	<P class="text-danger">The time on the server is ${serverTime}.</P>

	<div class="container">
		<div class="row mb-2">
			<div class="col-md-2 bg-success text-white">aaaaaa</div>
			<div class="col-md-6 bg-warning text-dark">
				<label class="form-label" for="user">おなまえ</label> <input type="text"
					class="form-control" id="user">
			</div>
			<div class="col-md-4 bg-success text-white">ummmmmm</div>
		</div>


		<div class="row mb-1">
			<div class="col-2 bg-success text-white">aaaaaa</div>
			<div class="col-6 bg-secondary text-white">
				<label class="form-label" for="pass">パスワード</label> <input
					type="password" class="form-control" id="pass">
			</div>
			<div class="col-4 bg-success text-white">ummmmmm</div>
		</div>


		<div class="row mt-3">
			<div class="col-8"></div>
			<div class="col-2 ">
			<input type="submit" value="ログイン" class="btn btn-primary btn-lg" class="form-control"></div>
			<div class="col-2"></div>


		</div>


	</div>

</body>
</html>
