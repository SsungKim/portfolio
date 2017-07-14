<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<form action="/board/modify" method="post" enctype="multipart/form-data" id="board_modify_form">
	<input type="hidden" name="num" value="${num }"/>
	<div class="write_section">
		<div class="title_wrap">
			<input type="text" id="board_modify_title" name="title" value="${title }"/>
		</div>
		<div class="content_wrap">
			<textarea id="board_modify_content" name="content">${content }</textarea>
		</div>
		<div class="btn_wrap">
			<div class="btn" onclick="history.back()">취소</div>
			<div class="btn" onclick="board_modify_save()">저장</div>
		</div>
	</div>
</form>

<script>
CKEDITOR.replace("board_modify_content", {
	filebrowserImageUploadUrl:"/ckUpload",
	enterMode: '2',
	shiftEnterMode: '3',
	height: 498,
	resize_enabled: false
});
</script>