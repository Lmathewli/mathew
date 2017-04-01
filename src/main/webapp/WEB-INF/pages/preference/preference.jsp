<%@ include file="../template/header.jsp"%>
<head>
  <title><spring:message code="profile"></spring:message></title>
</head>

<body>
    <form class="form-horizontal" role="form" action='<pages:urlPrefix/>/preference' method="POST">
        <div class="form-group">
            <label for="inputEmail3" class="col-sm-2 control-label"><spring:message code="logo"/></label>
            <div class="col-sm-10">
                <input type="file" class="form-control" id="inputEmail3"
                    placeholder="<spring:message code='logo'/>" name="logo">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label"><spring:message code="sign"/></label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputPassword3"
                    placeholder='<spring:message code="sign"/>' name="backgroundImage">
            </div>
        </div>
        <div class="form-group">
            <label for="inputPassword3" class="col-sm-2 control-label"><spring:message code="backgroud"/></label>
            <div class="col-sm-10">
                <input type="file" class="form-control" id="inputPassword3"
                    placeholder='<spring:message code="backgroud"/>' name="welcomeMessage">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <button type="submit" class="btn btn-default"><spring:message code="edit"/></button>
            </div>
            <div class="col-sm-offset-2 col-sm-10">
                <button type="button" class="btn btn-default"><spring:message code="cancel"/></button>
            </div>
        </div>
    </form>
</body>

<%@ include file="../template/footer.jsp"%>