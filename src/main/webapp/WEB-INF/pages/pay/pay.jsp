<%@ include file="../template/header.jsp"%>
<head>
  <script src="<pages:urlPrefix/>/js/pay/pay.js"></script>
  <title><spring:message code="profile"></spring:message></title>
</head>
<body>  
    <div class="header">  
        <div class="container black">  
            <div class="qrcode">  
                <div class="littlecode">  
                    <img width="16px" src="img/little_qrcode.jpg" id="licode">  
                    <div class="showqrs" id="showqrs">  
                        <div class="shtoparrow"></div>  
                </div>        
            </div>  
        </div>  
        <div class="container blue">  
            <div class="title"></div>  
        </div>  
    </div>  
    <div class="content">  
        <%-- <form action="${ctx}/aliPay/open" class="alipayform" method="POST" target="_blank"> --%>  
            <div class="element" style="margin-top:60px;">  
                <div class="legend"></div>  
            </div>  
            <div class="element">  
                <div class="etitle">orderNo:</div>  
                <div class="einput"><input type="text" name="orderNo" id="out_trade_no"></div>  
                <br>  
                <div class="mark"></div>  
            </div>  
              
            <div class="element">  
                <div class="etitle">subjectName:</div>  
                <div class="einput"><input type="text" name="subjectName" id="WIDsubject" value="test123"></div>  
                <br>  
                <div class="mark"></div>  
            </div>  
            <div class="element">  
                <div class="etitle">fee:</div>  
                <div class="einput"><input type="text" name="fee" id="WIDtotal_fee" value="0.01"></div>  
                <br>  
                <div class="mark"></div>  
            </div>  
            <div class="element">  
                <div class="etitle">WIDbody:</div>  
                <div class="einput"><input type="text" name="WIDbody" id="WIDbody" value="test123"></div>  
                <br>  
                <div class="mark"></div>  
            </div>  
            <div class="element">  
                <input type="button" class="alisubmit" id="sbumitBtn">  
            </div>  
    </div>  
    <div id="returnAli"></div>  

</body>  

<%@ include file="../template/footer.jsp"%>