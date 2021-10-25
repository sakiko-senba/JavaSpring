<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>






<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Java問題集</title>
<link rel="stylesheet" href="/exam/resources/styles.css">
</head>
<body>
	<div class="container">
		<jsp:include page="header.jsp" />
		<main>
			<h2>
				<c:out value="${mainHeader }" />
			</h2>
			<form:form modelAttribute="examModel">
				<div class="form-row">
					<c:out value="${questionSentence }" />
				</div>
				<c:forEach var="questionsOption" items="${questionsOptionList}">


					<div class="form-row">
					<form:radiobutton
					path="${questionsOption.path }"
					label="${questionsOption.label }"
					value="${questionsOption.value }"
					cssStyle="margin-right:4px;"/>

					</div>
				</c:forEach>
				<div class="form-row">
				<input type="submit" value="<c:out value="${submitValue }"/>" class="btn">
				</div>
			</form:form>
		</main>
		<jsp:include page="footer.jsp" />
	</div>
</body>
</html>