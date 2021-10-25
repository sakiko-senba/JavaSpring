<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<header>
	<h1>Java問題集</h1>
	<c:if test="${!empty examModel }">
		<div class="user-info">
			<c:out value="${examModel.name }" />さん
			<c:if test="${resultModelList == null }">解答中．．．</c:if>
			<c:if test="${resultModelList != null }">最終結果</c:if>
		</div>
	</c:if>
</header>
