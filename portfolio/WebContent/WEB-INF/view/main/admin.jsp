<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="login_wrap">
	<div class="input_wrap">
		<div class="row">
			<div class="title">
				아이디
			</div>
			<div class="input">
				<input type="text" id="login_id"/>
			</div>
		</div>
		<div class="row">
			<div class="title">
				비밀번호
			</div>
			<div class="input">
				<input type="password" id="login_pw"/>
			</div>
		</div>
	</div>
	<div class="btn_wrap">
		<div class="btn" onclick="login()">
			로그인
		</div>
	</div>
</div>