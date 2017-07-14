<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/view/main/loading.jsp"/>
<c:import url="/WEB-INF/view/main/site_popup.jsp"/>
<div class="section main_section">
	<div class="main_slide">
		<div class="slide_wrap" id="main_slide">
			<div class="slide">
				<img src="/img/main/main_slide1.jpeg"/>
			</div>
			<div class="slide">
				<img src="/img/main/main_slide2.jpeg"/>
			</div>
			<div class="slide">
				<img src="/img/main/main_slide3.jpeg"/>
			</div>
		</div>
		<div class="arrow_wrap">
			<div class="arrow" id="main_left">
				<img src="/img/main/left.png"/>
			</div>
			<div class="arrow" id="main_right">
				<img src="/img/main/right.png"/>
			</div>
		</div>
	</div>
	<div class="main_content">
		<div class="main_content_wrap">
			<div class="content_title">
				<span onclick="location.href='/work'">Work</span>
			</div>
			<div class="content_list">
				<c:forEach var="t" begin="0" end="${workList.size() - 1 > 4 ? 4 : workList.size() - 1 }">
					<div class="row">
						<span onclick="location.href='/work/view/${workList.get(t).auto }'">${workList.get(t).name }</span>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="main_content_wrap">
			<div class="content_title">
				<span onclick="location.href='/board'">Board</span>
			</div>
			<div class="content_list">
				<c:forEach var="t" begin="0" end="${boardList.size() - 1 > 4 ? 4 : boardList.size() - 1 }">
					<div class="row">
						<span onclick="location.href='/board/view2/'+${boardList.get(t).auto }">${boardList.get(t).title }</span>
					</div>
				</c:forEach>
			</div>
		</div>
		<div class="main_content_wrap">
			<div class="content_title">
				Site
			</div>
			<div class="content_list">
				<div class="row">
					<span onclick="site_popup('Development')">Development</span>
				</div>
				<div class="row">
					<span onclick="site_popup('Css')">Css</span>
				</div>
				<div class="row">
					<span onclick="site_popup('Image')">Image</span>
				</div>
				<div class="row">
					<span onclick="site_popup('Plugin')">Plugin</span>
				</div>
				<div class="row">
					<span onclick="site_popup('Api')">Api</span>
				</div>
			</div>
		</div>
	</div>
</div>