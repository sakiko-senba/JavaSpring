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
			<table>
				<tr>
					<th>番号</th>
					<th>正解</th>
					<th>解答</th>
					<th>正誤</th>


				</tr>
				<c:forEach var="resultModel" items="${resultModelList }">
					<tr>
						<td><c:out value="${resultModel.questionId }" /></td>
						<td><c:out value="${resultModel.rightAnswer }" /></td>
						<td><c:out value="${resultModel.answer }" /></td>
						<td><c:out value="${resultModel.result ?'〇':'×' }" /></td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<c:out value="${examModel.name }" />
				さんは3問中
				<c:out value="${numberOfRightAnswers }" />
				問正解です。
			</div>
			<div class="links">
				<a href="top">トップへ戻る</a>
			</div>


		</main>
		<jsp:include page="footer.jsp" />
		</div>
</body>
</html>