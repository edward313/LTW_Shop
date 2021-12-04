<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Verify Page</title>
    </head>
    <body>
    <div class="form-verify-box">
        <div class='verify-top-text'>
            <span>We already send a verification code to your email.</span>
        </div>
        <form id="login" class="input-group" action="dang-nhap" method="post" style="text-align:center; top:auto;">
            <input type="text" lass="input-field" name="code">
            <input type="submit" class="submit-btn" value="verify">
            <input type="hidden" name="action" value="checkCode">
            <c:if test="${wrong_code != null}">
                <c:if test="${wrong_code == '1'}">
                    <p style="color:red ;font-size: 14px" >WRONG CODE !</p>
                </c:if>
            </c:if>
        </form>
    </div>
    </body>
</html>