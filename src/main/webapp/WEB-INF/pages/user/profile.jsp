<%@ include file = "../template/header.jsp" %>
<head>
  <title><spring:message code="profile"/></title>
</head>
<body>
   <a href='<pages:urlPrefix/>/preference'><spring:message code="preference"/></a>
   <c:out value="${user.id }"></c:out>
</body>
<%@ include file = "../template/footer.jsp" %>
