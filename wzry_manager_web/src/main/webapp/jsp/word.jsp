<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>敏感词汇管理</title>

</head>
<style type="text/css">
    html,body{
        overflow:auto;
        height:100%;
    }

    .line-limit-length {
        max-width: 220px;
        overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
    }
    .line1 a:link{color:#c12e2a}
    .line2 a:link{color:#28a4c9}

</style>

<script>

</script>
<body>
<div class="hrms_dept_container">
    <!-- 导航栏-->
    <%@ include file="commom/head.jsp"%>


    <!-- 中间部分（左侧栏+表格内容） -->
    <div class="hrms_dept_body">
        <!-- 左侧栏 -->
        <%@ include file="commom/leftsidebar.jsp"%>

        <!-- 表格内容 -->
        <div class="dept_info col-sm-10">
            <div class="panel panel-success">
                <!-- 路径导航 -->
                <div >
                    <ol class="breadcrumb">
                        <li><a href="#">用户帖管理</a></li>
                        <li class="active">敏感词汇管理</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="post" id="wordForm" action="/word/addWord.do" >
                            <table >
                                <tr>
                                    <th>
                                        <input type="text" id="wname" class="form-control"
                                               name="adname" placeholder="新增敏感词汇" >
                                    </th>
                                    <th colspan="2">
                                        <input type="submit" value="新增"  class="form-control btn-primary">
                                    </th>
                                </tr>
                            </table>

                        </form>
                    </div>
                </div>
                <div style="clear:both"></div>
                <hr>
                <table class="table table-bordered table-hover">
                    <tr>
                        <th>序号</th>
                        <th>敏感词</th>
                        <th>是否启用</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${words}" var="w" >

                        <tr >
                            <%--<td>${index.index}</td>--%>
                            <td>${w.wordId }</td>
                            <td>${w.word }</td>
                            <%--<td>${w.statusStr }</td>--%>
                            <td>
                                <c:if test="${w.status==0}">使用中</c:if>
                                <c:if test="${w.status==1}">已停用</c:if>
                            </td>
                                <%--<td><a>${w.statusUse }</a></td>--%>
                            <%--<td><button type="button" class="btn btn-primary" data-toggle="button" aria-pressed="false" autocomplete="off">--%>
                                    <%--${w.statusUse }--%>
                            <%--</button></td>--%>
                            <td>
                                <c:if test="${w.status==0}"><a href="${pageContext.request.contextPath}/word/updateStatus.do?wordId=${w.wordId }&status=${w.status}"><input type="button" value="停用" class="form-control btn-warning"></a></c:if>
                                <c:if test="${w.status==1}"><a href="${pageContext.request.contextPath}/word/updateStatus.do?wordId=${w.wordId }&status=${w.status}"><input type="button" value="启用" class="form-control btn-primary"></a></c:if>
                                <%--<c:if test="${w.status==1}"><input type="button" value="启用" class="form-control btn-primary" href="/word/updateStatus.do?wordId=${w.wordId },status=${w.status}"></c:if>--%>
                                <%--<c:if test="${w.status==0}"><input type="button" value="停用" class="form-control btn-warning" href="/word/updateStatus.do?wordId=${w.wordId },status=${w.status}"></c:if>--%>
                            </td>

                        </tr>
                    </c:forEach>




                </table>


            </div><!-- /.panel panel-success -->
            <!--显示分页信息-->
            <div class="row">
                <!--文字信息-->
                <div class="col-md-6">
                    当前第 ${articleMsgs.pageNum} 页.总共 ${articleMsgs.pages} 页.一共 ${articleMsgs.total} 条记录
                </div>

                <!--点击分页-->
                <div class="col-md-6">
                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <!--首页-->
                            <li><a href="#" onclick="searchArticle(1)">首页</a></li>
                            <!--上一页-->
                            <li>
                                <c:if test="${articleMsgs.hasPreviousPage}">
                                    <a href="#" onclick="searchArticle('${articleMsgs.pageNum-1}')" aria-label="Previous">
                                        <span aria-hidden="true">«</span>
                                    </a>
                                </c:if>
                            </li>

                            <c:forEach items="${articleMsgs.navigatepageNums}" var="page_num">
                                <c:if test="${page_num == articleMsgs.pageNum}">
                                    <li class="active"><a href="#">${page_num}</a></li>
                                </c:if>
                                <c:if test="${page_num != articleMsgs.pageNum}">
                                    <li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
                                </c:if>
                            </c:forEach>

                            <!--下一页-->
                            <li>
                                <c:if test="${articleMsgs.hasNextPage}">
                                    <a href="javascript:void(0)" onclick="searchArticle('${articleMsgs.pageNum+1}')"
                                       aria-label="Next">
                                        <span aria-hidden="true">»</span>
                                    </a>
                                </c:if>
                            </li>
                            <li><a href="javascript:void(0)" onclick="searchArticle('${articleMsgs.pages}')">尾页</a></li>
                        </ul>
                    </nav>
                </div>
            </div>
        </div><!-- /.dept_info -->
        <!-- 尾部-->
        <%@ include file="commom/foot.jsp"%>
    </div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%@ include file="ArticleUpdate.jsp"%>
</body>
</html>
