
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>敏感词汇管理</title>
<%--    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/detail.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/getArticle.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>--%>


        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
        <title>Bootstrap 101 Template</title>

        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/bootstrap/bootstrap.min.css" rel="stylesheet">

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>

        <![endif]-->

    <style>
        tr{
            text-align: center;
        }
    </style>


</head>
<body>

<table class="table table-bordered">
    <div style="text-align: center">是否需要添加敏感词？
        <input type="text">
        <input type="submit" value="添加">
    </div>

    <tr>
        <td>序号</td>
        <td>敏感词</td>
        <td>是否启用</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${words}" var="w">

        <tr >
            <td>${w.wordId }</td>
            <td>${w.word }</td>
            <td>${w.statusStr }</td>
            <td><a>${w.statusUse }</a></td>
        </tr>
    </c:forEach>
</table>


</body>
</html>