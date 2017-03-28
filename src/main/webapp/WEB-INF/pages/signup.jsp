<%@ include file = "template/header.jsp" %>
<head>
    <title><spring:message code="sign_up"></spring:message></title>
</head>
<body>
<form role="form" id="regform">
                <div class="page-header">
                    <h2 class="text-center text-warning">
                        <i class="glyphicon glyphicon-comment"></i> 
                    </h2>
                </div>  
                <div class="channel-type">
                    <ul>
                        <li class="active" data-type="phone">
                            <span class="mdi-hardware-phone-iphone"></span>
                            <span class="text-hidden"> <spring:message code="phone_sign_up"/></span>
                        </li><li data-type="email">
                            <span class="mdi-maps-local-post-office"></span>
                            <span class="text-hidden"> <spring:message code="email_sign_up"/></span>
                        </li>
                    </ul>
                </div>
                <div class="clearfix"></div>
                <div class="input-group input-group-lg">
                  <span class="input-group-addon"><span class="mdi-action-account-circle"></span></span>
                  <input type="text" id="fullname" name="fullname" class="form-control validate[required,custom[onlyChineseLetterNumber],minSize[2]]" placeholder="用户昵称">
                </div>
                
                <div class="input-group input-group-lg" style="display: none;">
                  <span class="input-group-addon"><span class="mdi-communication-email"></span></span>
                  <input type="text" id="mail" name="email" class="form-control validate[required,custom[email]]" placeholder="注册邮箱">
                </div>

                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><span class="mdi-communication-phone"></span></span>
                    <input type="text" id="phone" name="phone" class="form-control validate[required,custom[phone]]" placeholder="注册手机号">
                </div>

                <div class="input-group input-group-lg">
                    <span class="input-group-addon"><span class="mdi-action-settings-cell"></span></span>
                    <input type="number" id="phone-captcha" class="form-control" placeholder="输入6位验证码">
                    <span class="input-group-btn">
                        <button href="javascript:;" class="btn btn-primary btn-flat phone-captcha" role="button" data-count="60">
                            <span class="mdi-content-send"></span>
                            <span class="text-hidden">获取手机验证码</span>
                        </button>
                    </span>
                </div>
                
                <div class="input-group input-group-lg">
                  <span class="input-group-addon"><span class="mdi-hardware-keyboard"></span></span>
                  <input type="password" id="pwd" name="password" class="form-control validate[required,minSize[6]]" placeholder="登录密码">
                </div>
                
                <div class="input-group input-group-lg" style="display: none;">
                  <span class="input-group-addon"><span class="mdi-action-work"></span></span>
                  <input type="text" id="captcha" name="captcha" class="form-control validate[required,minSize[7]]" placeholder="请输入验证码">
                </div>

                <div class="input-group input-group-lg" style="display: none;width:100%;height:50px;margin:0 auto;background:#FFF;">
                  <div class="form-control" id="gbcaptchawrapper">
                    <img class="img-responsive" alt="验证图片" src="/gb/gbcaptcha">
                  </div>
                  
                  <span class="input-group-addon">
                    <a class="btn btn-primary" id="refreshCaptcha"><span class="glyphicon glyphicon-refresh"></span></a>
                  </span>
                </div>
                
                <hr>
                
                <button type="button" class="btn btn-primary ladda-button pull-right" id="registerbutton" title="立刻注册" data-style="expand-right">
                    <span class="ladda-label">
                        <span class="glyphicon glyphicon-log-in"></span> &nbsp; 立刻注册
                    </span>
                </button>
                
                <div class="hidden">
                    <ul id="userlist"></ul>
                    <ul id="userfunctiontaglist"></ul>
                </div>
                
            </form>
</body>
<%@ include file = "template/footer.jsp" %>
