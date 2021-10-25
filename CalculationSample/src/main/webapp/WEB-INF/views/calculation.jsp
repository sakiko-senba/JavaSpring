<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>






<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>例外処理サンプル</title>
</head>
<body>
	<header>
		<h1>計算フォーム</h1>
	</header>
	<main>
	<p>
	<c:out value="${message }"></c:out></p>
	<form:form modelAttribute="calculationModel">

	<p>
	<form:input path="value1"/>
	<form:select path="operator">
	<form:option value="1">＋</form:option>
	<form:option value="2">－</form:option>
	<form:option value="3">×</form:option>
	<form:option value="4">÷</form:option>
	</form:select>
	<form:input path="value2"/>
	＝
	<c:out value="${answer}"></c:out>
	</p>
	<p><input type="submit" value="計算"/></p>
	</form:form>
	</main>
	<footer>
		<hr>
		<div>
			<small>&copy;KENスクール</small>
		</div>
	</footer>

</body>
</html>