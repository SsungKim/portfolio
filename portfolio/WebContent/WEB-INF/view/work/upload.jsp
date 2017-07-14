<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="/work/uploadSave" method="post" enctype="multipart/form-data" id="work_upload_form">
	<div class="section upload_section">
		<div class="upload_wrap">
			<div class="row">
				<div class="title">이름</div>
				<div class="txt">
					<input type="text" placeholder="포트폴리오" id="work_upload_name" name="name"/>
				</div>
			</div>
			<div class="row">
				<div class="title">이미지</div>
				<div class="txt">
					<input type="file" id="work_upload_file" name="file"/>
				</div>
			</div>
			<div class="row">
				<div class="title">URL</div>
				<div class="txt">
					<input type="text" placeholder="http://www.ssungkim.com" id="work_upload_url" name="url"/>
				</div>
			</div>
			<div class="row">
				<div class="title">작업환경</div>
				<div class="txt">
					<input type="text" value="STS, Photoshop, Jsp, Javascript, Jquery, Css" id="work_upload_tools" name="tools"/>
				</div>
			</div>
			<div class="row">
				<div class="title">작업인원</div>
				<div class="txt">
					<input type="text" placeholder="3명" id="work_upload_people" name="people"/>
				</div>
			</div>
			<div class="row">
				<div class="title">인원구성</div>
				<div class="txt">
					<input type="text" value="디자이너 - 1명 / 퍼블리셔 - 1명 / 개발자 - 1명(我)" id="work_upload_cons" name="cons"/>
				</div>
			</div>
			<div class="row">
				<div class="title">작업기간</div>
				<div class="txt">
					<input type="text" placeholder="17년 1월 1일 ~ 17년 1월 14일" id="work_upload_day" name="day"/>
				</div>
			</div>
			<div class="row">
				<div class="title">설명</div>
				<div class="txt content">
					<textarea id="work_upload_content" name="content"></textarea>
				</div>
			</div>
		</div>
		<div class="btn_wrap">
			<div class="btn" onclick="history.back()">취소</div>
			<div class="btn" onclick="work_upload()">저장</div>
		</div>
	</div>
</form>