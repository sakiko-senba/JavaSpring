<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>例外処理サンプル</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
	<header>
		<h1>エラーページ</h1>
	</header>
	<main>

		<p class="error">
			<c:out value="${error}" />
		</p>
		<p>
			<a href="<c:out value="${url}"/>">戻る</a>
		</p>
	</main>
	<footer>
		<hr>
		<div>
			<small>&copy;KENスクール</small>
		</div>
	</footer>

</body>
</html>