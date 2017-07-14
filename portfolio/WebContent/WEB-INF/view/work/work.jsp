<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/view/main/loading.jsp"/>
<div class="top_wrap">
	<div class="top" onclick="scroll_top()">
		<img src="/img/main/top.png"/>
		<div class="txt">TOP</div>
	</div>
</div>
<div class="section work_section">
	<div class="section_title">
		<span>Work</span>
		<c:if test="${login != null }">
			<div class="btn" onclick="location.href='/work/upload'">업로드</div>
		</c:if>
	</div>
	<div class="content_section">
		<div class="slide_section">
			<div class="slide_wrap">
				<c:forEach var="t" begin="0" end="${workList.size()-1 }">
					<div class="slide" id="workSlide_${workList.get(t).auto }">
						<div class="img_wrap">
							<div class="work_slide">
								<div class="work_img" id="work_${t+1 }">
									<img src="/file/work/${workList.get(t).uuid }" id="workImg_${t+1 }"/>
								</div>
							</div>
							<img src="/img/work/imac.png"/>
						</div>
						<div class="txt_wrap">
							<div class="row">
								<div class="title">이름</div>
								<div class="txt">${workList.get(t).name }</div>
							</div>
							<div class="row">
								<div class="title">URL</div>
								<div class="txt">
									<c:choose>
										<c:when test="${workList.get(t).url == '-' }">
											${workList.get(t).url }
										</c:when>
										<c:otherwise>
											<a href="${workList.get(t).url }" target="_blank">${workList.get(t).url }</a>
										</c:otherwise>
									</c:choose>
								</div>
							</div>
							<div class="row">
								<div class="title">작업환경</div>
								<div class="txt">${workList.get(t).tools }</div>
							</div>
							<div class="row">
								<div class="title">작업인원</div>
								<div class="txt">${workList.get(t).people }</div>
							</div>
							<div class="row">
								<div class="title">인원구성</div>
								<div class="txt">${workList.get(t).cons }</div>
							</div>
							<div class="row">
								<div class="title">작업기간</div>
								<div class="txt">${workList.get(t).day }</div>
							</div>
							<div class="row">
								<div class="title">설명</div>
								<div class="txt content">
									${workList.get(t).content }
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>

<script>
	$(document).ready(function(){
		var viewNum = "${viewNum }";
		if(viewNum != ""){
			var top = $("#workSlide_"+viewNum).offset().top;
			setTimeout(function(){
				$(".work_section").stop().animate({
					scrollTop: top-150
				});
			}, 2000);
		}
	});
</script>