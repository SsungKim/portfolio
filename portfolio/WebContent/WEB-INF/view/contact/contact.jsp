<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="/WEB-INF/view/main/loading.jsp"/>
<div class="section contact_section">
	<div class="section_title">
		<span>Contact</span>
	</div>
	<div class="content_section">
		<div class="row_wrap">
			<div class="mail_wrap">
				<div class="row">
					<div class="title">제목</div>
					<div class="input">
						<input type="text" id="contact_title" placeholder="제목을 입력해주세요. (최대 25자)" maxlength="25"/>
					</div>
				</div>
				<div class="row">
					<div class="title">연락처</div>
					<div class="input">
						<input type="text" id="contact_contact" placeholder="연락받으실 번호나 메일주소를 입력해주세요. (최대 25자)" maxlength="25"/>
					</div>
				</div>
				<div class="row">
					<div class="title">내용</div>
					<div class="input">
						<textarea id="contact_content" placeholder="내용을 입력해주세요. (최대 1000자)" maxlength="1000"></textarea>
					</div>
				</div>
			</div>
		</div>
		<div class="row_wrap">
			<div class="row">
				<div class="btn" onclick="contact_mail_send()">전송</div>
			</div>
		</div>
		<div class="row_wrap">
			<div class="row">
				<span>궁금하신 내용이나 기타 문의사항이 있으신분은 메일을 보내주세요! :)</span>
			</div>
		</div>
	</div>
</div>