<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${menu_type != 'page' }">
	<c:import url="/WEB-INF/view/main/loading.jsp"/>
</c:if>
<div class="section board_section">
	<div class="section_title">
		<span>Board</span>
	</div>
	<div class="content_section">
		<div class="content_wrap">
			<div class="content" id="board_view_content">
				<c:choose>
					<c:when test="${content != null }">
						${content.content }
					</c:when>
					<c:otherwise>
						${boardList.size() > 0 ? boardList.get(0).content : '등록된 글이 없습니다.' }
					</c:otherwise>
				</c:choose>
			</div>
		</div>
		<div class="list_wrap">
			<div class="list_section">
				<div class="list list_title">
					<div class="cell1">
						No.
					</div>
					<div class="cell1 cell2 no_cursor">
						Title
					</div>
					<div class="cell1 cell3">
						Date
					</div>
					<div class="cell1 cell4">
						Writer
					</div>
				</div>
				<c:choose>
					<c:when test="${boardList.size() > 0 }">
						<c:forEach var="t" begin="0" end="${boardList.size()-1 }">
							<c:choose>
								<c:when test="${content != null }">
									<div class="list ${boardList.get(t).auto==content.auto ? 'sel' : '' }" id="board_list${boardList.get(t).auto }">
										<div class="cell1">
											${boardList.get(t).auto }
										</div>
										<div class="cell1 cell2" onclick="board_view(${boardList.get(t).auto})">
											<c:choose>
												<c:when test="${boardList.get(t).title.length() > 15 }">
													${boardList.get(t).title.substring(0, 15) } ...
												</c:when>
												<c:otherwise>
													${boardList.get(t).title }
												</c:otherwise>
											</c:choose>
										</div>
										<div class="cell1 cell3">
											${boardList.get(t).day }
										</div>
										<div class="cell1 cell4">
											${boardList.get(t).user }
										</div>
									</div>
								</c:when>
								<c:otherwise>
									<div class="list ${t==0 ? 'sel' : '' }" id="board_list${boardList.get(t).auto }">
										<div class="cell1">
											${boardList.get(t).auto }
										</div>
										<div class="cell1 cell2" onclick="board_view(${boardList.get(t).auto})">
											<c:choose>
												<c:when test="${boardList.get(t).title.length() > 15 }">
													${boardList.get(t).title.substring(0, 15) } ...
												</c:when>
												<c:otherwise>
													${boardList.get(t).title }
												</c:otherwise>
											</c:choose>
										</div>
										<div class="cell1 cell3">
											${boardList.get(t).day }
										</div>
										<div class="cell1 cell4">
											${boardList.get(t).user }
										</div>
									</div>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</c:when>
					<c:otherwise>
						<div class="no_content">등록된 글이 없습니다.</div>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="page_wrap">
				<c:forEach var="i" begin="${start }" end="${end }">
					<span class="${select == i ? 'sel' : '' }" onclick="location.href='/board/page/${i }'">${i }</span>
				</c:forEach>
			</div>
			<c:if test="${login != null }">
				<div class="btn_wrap">
					<div class="btn" onclick="board_delete()">
						삭제
					</div>
					<div class="btn" onclick="board_modify()">
						수정
					</div>
					<div class="btn" onclick="location.href='/board/write'">
						쓰기
					</div>
				</div>
			</c:if>
		</div>
	</div>
</div>

<script>
	// 글 저장 성공 여부
	$(document).ready(function(){
		var b = "${board_upload }";
		if(b != ""){
			if(b == "ture"){
				alert("등록되었습니다.");
			} else {
				alert("등록에 실패하였습니다.\n잠시후 다시 시도해주세요.");
			}
		}
	});
</script>