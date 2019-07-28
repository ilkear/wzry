<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>用户信息</title>

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
	$(function () {
	   $("#query").click(function () {
		   
       })
    });
</script>
<body>
<div class="hrms_dept_container">
	<!-- 导航栏-->
	<%@ include file="/jsp/commom/head.jsp"%>


	<!-- 中间部分（左侧栏+表格内容） -->
	<div class="hrms_dept_body">
		<!-- 左侧栏 -->
		<%@ include file="/jsp/commom/leftsidebar.jsp"%>

		<!-- 表格内容 -->
		<div class="dept_info col-sm-10">
			<div class="panel panel-success">
				<!-- 路径导航 -->
				<div >
					<ol class="breadcrumb">
						<li><a href="#">用户信息</a></li>
					</ol>
				</div>
				<hr>
				<!-- Table -->
				<div>
					<div style="float: left">
						<form method="get" id="articleSearchForm" action="/userManager/findByCondition.do">
							<table>
								<tr>
									<th>
										<label  class="control-label">用户名:</label>
									</th>
									<th>
										<input type="text" id="title" class="form-control"
											   name="userName" >
										<%--<input type="hidden" id="pageNum" name="role" >--%>
									</th>
									<th>
										<label for="article_sendername" class="control-label">用户组:</label>
									</th>
									<th>
										<input type="text" id="article_sendername" class="form-control"
											   name="role" >
										<%--<input type="hidden" id="pageSize" name="size" >--%>
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
				<table class="table table-bordered table-hover" >
					<thead>
					<tr>
						<th>用户名</th>
						<th>用户组</th>
						<th>邮箱</th>
						<th>是否禁言</th>
						<th>最近登录时间</th>
						<th>操作</th>
					</tr>
					</thead>
					<tbody>
					<c:forEach items="${pageInfo.list}" var="user">
					<tr>
						<td width="15%">${user.userName}</td>
						<td width="20%" class="line-limit-length">${user.roleStr}</td>
						<td width="10%" class="line-limit-length">${user.email}</td>
						<td width="10%" class="line-limit-length">${user.talkStatusStr}</td>
						<td width="20%" class="line-limit-length">${user.lastLoginTimeStr}</td>
						<td width="10%" class="line-limit-length">

							<a href="/userManager/updateRole.do?userId=${user.userId}&role=${user.role}" class="btn btn-primary" >升级</a>
							<c:if test="${user.talkStatus == 0}">
							<a href="/userManager/updateTalkStatus.do?userId=${user.userId}&talkStatus=${user.talkStatus}" class="btn btn-danger">禁言</a>
							</c:if>
							<c:if test="${user.talkStatus == 1}">
								<a href="/userManager/updateTalkStatus.do?userId=${user.userId}&talkStatus=${user.talkStatus}" class="btn btn-info">恢复</a>
							</c:if>
						</td>


					</tr>
					</c:forEach>


					</tbody>
				</table>


			</div><!-- /.panel panel-success -->
			<!--显示分页信息-->
			<div class="row">
				<!--文字信息-->
				<div class="col-md-6">
					当前第 ${pageInfo.pageNum} 页.总共 ${pageInfo.pages} 页.一共 ${pageInfo.total} 条记录
				</div>

				<!--点击分页-->
				<div class="col-md-6">
					<nav aria-label="Page navigation">
						<ul class="pagination">
							<!--首页-->
							<li><a href="/userManager/findByPage.do?page=1&size=4" onclick="searchArticle(1)">首页</a></li>
							<!--上一页-->
							<li>
								<c:if test="${pageInfo.hasPreviousPage}">
									<a href="#" onclick="searchArticle('${pageInfo.pageNum-1}')" aria-label="Previous">
										<span aria-hidden="true">«</span>
									</a>
								</c:if>
							</li>

							<c:forEach items="${pageInfo.navigatepageNums}" var="page_num">
								<c:if test="${page_num == pageInfo.pageNum}">
									<li class="active"><a href="#">${page_num}</a></li>
								</c:if>
								<c:if test="${page_num != pageInfo.pageNum}">
									<li><a href="#" onclick="searchArticle('${page_num}')">${page_num}</a></li>
								</c:if>
							</c:forEach>

							<!--下一页-->
							<li>
								<c:if test="${pageInfo.hasNextPage}">
									<a href="javascript:void(0)" onclick="searchArticle('${pageInfo.pageNum+1}')"
									   aria-label="Next">
										<span aria-hidden="true">»</span>
									</a>
								</c:if>
							</li>
							<li><a href="javascript:void(0)" onclick="searchArticle('${pageInfo.pages}')">尾页</a></li>
						</ul>
					</nav>
				</div>
			</div>
		</div><!-- /.dept_info -->
		<!-- 尾部-->
		<%@ include file="/jsp/commom/foot.jsp"%>
	</div><!-- /.hrms_dept_body -->

</div><!-- /.hrms_dept_container -->

<%--<%@ include file="ArticleAdd.jsp"%>--%>
<%--<%@ include file="/WEB-INF/jsp/ArticlePage.jsp"%>--%>
</body>
</html>
