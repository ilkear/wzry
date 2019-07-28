<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>王者荣耀论坛</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common-new.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/search.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index-new.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hm-bbs.js"></script>
</head>
<%--今日贴数,总贴数--%>

<body>


<!-- 头部 -->
<jsp:include page="common/header.jsp"/>



<div class="hm-header"></div>
<div class="hm-body hm-body-bgc">
    <div class="hm-inner">
        <div class="hm-banner"></div>


        <!--头部，帖子统计，搜索-->
        <div class="hm-bbs-info">
            <div class="hm-bbs-icon l" style="width:130px;">
                <span><img src="${pageContext.request.contextPath}/images/bbs-icon.png" height="80"/></span>
            </div>
            <div class="hm-bbs-info-in l" style="margin-left:30px;">
                <div class="t clearfix"><h2 class="l">王者荣耀</h2></div>
                <p>
                    <span id="todayCount">今日帖数:${today}</span>
                    <span id="totalCount">总帖数:${total}</span>
                </p>
            </div>
            <div class="search-box l">
                <form action="javascript:;">
                    <input type="text" class="txt l" placeholder="请输入关键字">
                    <input type="button" value="搜索" class="btn l"/>
                </form>
            </div>
        </div>


        <!-- 导航 -->
        <ul class="hm-bbs-nav border-lrb clearfix">
            <li class="current">
                <a href="#"><em></em>综合交流区</a>
            </li>
            <li>
                <a href="#"><em></em>BUG反馈区</a>
            </li>
            <li>
                <a href="#"><em></em>新闻公告区</a>
            </li>
            <li>
                <a href="#"><em></em>活动专区</a>
            </li>
        </ul>


        <!-- 主体部分 -->
        <div class="hm-bbs-main border-lrb clearfix">
            <!-- 左侧列表 -->
            <div class="list-view l">
                <ul>
                    <c:forEach items="${list}" var="article">
                        <c:if test="${article.isTop == 1}">
                            <%--class = ding 置顶样式--%>
                            <li class="clearfix ding">
                            <div class="hm-index-title">
                            <i class="set-to-top">顶</i>
                        </c:if>
                        <c:if test="${article.isTop == 0}">
                            <li class="clearfix">
                            <div class="hm-index-title">
                        </c:if>
                        <a href="${pageContext.request.contextPath}/article/getArticle.do?articleId=${article.articleId}">
                                ${article.title}
                        </a>
                        </div>
                        <div class="hm-index-con">${article.content}</div>
                        <div class="hm-index-info l">
                            <span class="article-username">${article.senderName}</span>
                            <span class="post-time">${article.sendTime}</span>
                        </div>
                        <div class="hm-index-fun r">
                            <span class="icon-like"><i></i>${article.upvoteCount}</span>
                            <span class="icon-talk"><i></i>${article.replyCount}</span>
                        </div>
                        </li>
                    </c:forEach>

                    <li class="clearfix">
                        <div class="hm-index-title">
                            <i class="set-to-top">顶</i> <a href="article/getArticle.do">排位赛BUG，排不上！</a>
                        </div>
                        <div class="hm-index-con">现在黄金2，无论怎么匹配，都匹配不到？有次匹配了10分钟，这是为什么？</div>
                        <div class="hm-index-info l">
                            <span class="article-username">不哭不闹不炫耀</span><span
                                class="post-time">2017-05-24 09:10:00</span>
                        </div>
                        <div class="hm-index-fun r">
                            <span class="icon-like"><i></i>${article.upvotecount}</span>
                            <span class="icon-talk"><i></i>10</span>
                        </div>
                    </li>


                </ul>
            </div>


            <!-- 右侧侧边栏,在线用户 -->
            <div class="aside l">
                <div class="aside-box">
                    <h3 class="t">
                        <a href="javascript:;">在线用户(2)</a>
                    </h3>
                    <ul class="b clearfix">
                        <li>
                            <div><img src="images/default.png" height="55"/></div>
                            <p>Mr.King</p>
                        </li>
                        <li>
                            <div><img src="images/default.png" height="55"/></div>
                            <p>疯子</p>
                        </li>
                    </ul>
                </div>
            </div>


        </div>
    </div>
</div>


<!-- 底部 -->
<jsp:include page="common/footer.jsp"/>


<!-- 右边发帖，回顶部 -->
<div class="fixedBar" id="j_fixedBar">
    <c:if test="${empty user}">
        <a id="newTopicBtn2" onclick="alert('未登入请先登入！！')" class="newTopic"><span></span>发帖</a>
    </c:if>
    <c:if test="${!empty user}">
        <a id="newTopicBtn" href="javascript:a;" class="newTopic"><span></span>发帖</a>
    </c:if>
    <a href="#" class="goTop"><i></i><span>返回<br/>顶部</span></a>
</div>


<!-- 发帖弹出框 -->
<form action="/comment/posted.do"  method="post" id="formx">
    <div class="pop-box ft-box">
        <div class="mask"></div>
        <div class="win">
                <div class="win_hd">
                    <h4 class="l">主题帖</h4><span class="close r">&times;</span>
                </div>
                <div class="win_bd">
                    <div class="win_bd_t">
                        <input type="text" id="title" name="title" placeholder="帖子标题"/>
                    </div>
                    <div class="win_bd_b">
                        <textarea id="content" name="content" placeholder="正文"></textarea>
                    </div>
                    <input type="hidden" name="senderName" class="user_name" value="${sessionScope.user.userName}">
                    <input type="hidden" name="zoneId" class="zone_id" value="1">
                </div>
                <div class="win_ft">
                <div class="win_ft_in">
                    <input type="submit" class="btn" value="发表" id="ft"/>
                </div>
            </div>
        </div>
    </div>
</form>


</body>
</html>