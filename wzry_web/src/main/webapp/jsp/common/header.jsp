<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
<div class="hm-top-nav">
    <div class="hm-inner clearfix">
        <div class="hm-inner-l l"></div>
        <div class="hm-inner-r r">
            <c:if test="${empty sessionScope.user}">
                <div class="box">
                    <a href="javascript:void(0);" id="login" class="to-login">【游客登录】</a>
                    <a href="register.do">【新用户注册】</a>
                    <div id="dialogBg"></div>
                    <div id="dialog" class="animated">
                        <img class="dialogIco" width="50" height="40" src="${pageContext.request.contextPath}/images/ico.png"/>
                        <div class="dialogTop" style="height:25px;">
                            <a href="javascript:void(0);" class="closeDialogBtn">关闭</a>
                        </div>
                        <form action="${pageContext.request.contextPath}/user/login.do" method="post">
                            <ul class="editInfos">
                                <li>用户名：<input type="text" id="userName" name="userName" class="ipt"/></li>
                                <li>密&nbsp;&nbsp;&nbsp;码：<input type="password" id="userPass" name="userPass" class="ipt"/></li>
                                <li><input type="submit" value="登录" class="submitBtn"/></li>
                            </ul>
                        </form>
                    </div>
                </div>
            </c:if>
            <c:if test="${not empty sessionScope.user}">
                欢迎您，${sessionScope.user.userName}
                <a href="${pageContext.request.contextPath}/user/logout.do">退出</a>
            </c:if>
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
  $(function () {
      //显示弹框
      $('.box #login').click(function () {
          var className = $(this).attr('class');
          $('#dialogBg').fadeIn(300);
          $('#dialog').removeAttr('class').addClass('animated ' + className + '').fadeIn();
          $('#userName').focus();
          $("#j_fixedBar").hide();
      });

      //关闭弹窗
      $('.closeDialogBtn').click(function () {
          $('#dialogBg').fadeOut(300, function () {
              $('#dialog').addClass('bounceOutUp').fadeOut();
              $("#j_fixedBar").show();
          });
      });
  });
</script>
</html>