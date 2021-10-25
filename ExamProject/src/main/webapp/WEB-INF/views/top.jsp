<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java問題集</title>
<link rel="stylesheet" href="/exam/resources/styles.css">
</head>
<body>
	<div class="container">
		<header>
			<h1>Java問題集</h1>
		</header>
		<main>
			<form:form modelAttribute="examModel">
				<div class="form-row">
					これからJavaの問題を3問出題します。<br> 名前を入力して、［開始］ボタンをクリックして開始してください。
				</div>
				<div class="form-row">
					<label>名前</label>
					<form:input path="name" />
					<input type="submit" value="開始" class="btn">
				</div>
				<form:errors path="name" cssClass="form-row errors" />
			</form:form>
		</main>
		<jsp:include page="footer.jsp"/>


	</div>

</body>
</html>