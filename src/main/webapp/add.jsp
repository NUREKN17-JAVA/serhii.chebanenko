<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="user" class="ua.nure.cs.chebanenko.usermanagement171.domain.User" scope="session"></jsp:useBean>
<html>
<head><title>User management171. Add</title></head>
<body>
	<form action="<%=request.getContextPath()%>/add" method="post">
		<input type="hidden" name="ID" value="${user.id}">
		First name <input type="text" name="Имя" value=""><br>
		Last name <input type="text" name="Фамилия" value=""><br>
		Date of birth <input type="text" name="Дата" value=""><br>
		<input type="submit" name="okButton" value="Ok">
		<input type="submit" name="cancelButton" value="Cancel">
	</form>
	<c:if test='${request.Scope.error != null}'>
	<script type="text/javascript">
		alert('${request.Scope.error}');
	</script>
	</c:if>
</body>
</html>