<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>帖信息管理页面</title>

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


</style>
<script>
   <%--function report() {--%>
        <%--window.location.href="${pageContext.request.contextPath}/article/updateReport.do?articleId=${article.articleId}&isReport=${article.isReport}"--%>
      <%--&lt;%&ndash;window.location.href="${pageContext.request.contextPath}/word/findByPage.do"&ndash;%&gt;--%>
    <%--}--%>
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
                        <li class="active">帖子信息</li>
                    </ol>
                </div>
                <hr>
                <!-- Table -->
                <div>
                    <div style="float: left">
                        <form method="get" id="articleSearchForm" action="${pageContext.request.contextPath}/article/likeArticle.do">
                            <table>
                                <tr>
                                    <th>
                                        <label for="title" class="control-label">标题:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="title" class="form-control"
                                               name="title" value="">
                                       <%-- <input type="hidden" id="pageNum" name="pn">--%>
                                    </th>
                                    <th>
                                        <label for="article_sendername" class="control-label">创帖人:</label>
                                    </th>
                                    <th>
                                        <input type="text" id="article_sendername" class="form-control"
                                               name="sendername">
                                    </th>
                                    <th colspan="2">
                                        <input type="submit" value="查询" class="form-control btn-primary">
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
                        <th>标题</th>
                        <th>内容</th>
                        <th>创帖人</th>
                        <th>是否置顶</th>
                        <th>回复数</th>
                        <th>点赞数</th>
                        <th>浏览数</th>
                        <th>所在交流区</th>
                        <th>操作</th>
                    </tr>

<c:forEach items="${article}" var="article">
    <tr>
        <td>${article.title}</td>
        <td>${article.content}</td>
        <td>${article.senderName}</td>
        <%--<td>${article.isTop}</td>--%>
        <td>
            <c:if test="${article.isTop==0}"><a href="${pageContext.request.contextPath}/article/updateTop.do?articleId=${article.articleId}&isTop=${article.isTop}"><input type="button" value="是" class="form-control btn-primary"></a></c:if>
            <c:if test="${article.isTop==1}"><a href="${pageContext.request.contextPath}/article/updateTop.do?articleId=${article.articleId}&isTop=${article.isTop}"><input type="button" value="否" class="form-control btn-block"></a></c:if>
        </td>

        <td>${article.replyCount}</td>
        <td>${article.upvoteCount}</td>
        <td>${article.browseCount}</td>
        <td>${article.zoneId}</td>
        <%--<td>${article.isReport}</td>--%>
        <td>
            <%--<c:if test="${article.isReport==0}"><input type="button" value="有举报" class="form-control btn-danger" onclick="report()"></c:if>--%>
                <c:if test="${article.isReport==0}"><a href="${pageContext.request.contextPath}/article/updateReport.do?articleId=${article.articleId}&isReport=${article.isReport}"><input type="button" value="屏蔽" class="form-control btn-warning"></a></c:if>
            <c:if test="${article.isReport==1}"><a href="${pageContext.request.contextPath}/article/updateReport.do?articleId=${article.articleId}&isReport=${article.isReport}"><input type="button" value="正常" class="form-control btn-primary"></a></c:if>
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
