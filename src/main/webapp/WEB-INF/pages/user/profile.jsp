<%@ include file = "../template/header.jsp" %>
<head>
  <title><spring:message code="profile"></spring:message></title>
</head>
<body>
   <c:out value="${user._id }"></c:out>
</body>
<%@ include file = "../template/footer.jsp" %>
