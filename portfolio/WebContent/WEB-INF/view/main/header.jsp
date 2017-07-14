<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="logo_wrap">
	<img src="/img/main/ajax.gif" onclick="location.href='/'"/>
</div>
<div class="menu_wrap">
	<div class="menu">
		<span id="menu_home" onclick="location.href='/'" class="${menu == 'Home' ? 'sel' : '' }">Home</span>
		<div class="underline">
			<img src="/img/main/underline.png" id='underline_home'/>
		</div>
	</div>
	<div class="menu">
		<span id="menu_about" onclick="location.href='/about'" class="${menu == 'About' ? 'sel' : '' }">About</span>
		<div class="underline">
			<img src="/img/main/underline.png" id='underline_about'/>
		</div>
	</div>
	<div class="menu">
		<span id="menu_work" onclick="location.href='/work'" class="${menu == 'Work' ? 'sel' : '' }">Work</span>
		<div class="underline">
			<img src="/img/main/underline.png" id='underline_work'/>
		</div>
	</div>
	<div class="menu">
		<span id="menu_board" onclick="location.href='/board'" class="${menu == 'Board' ? 'sel' : '' }">Board</span>
		<div class="underline">
			<img src="/img/main/underline.png" id='underline_board'/>
		</div>
	</div>
	<div class="menu">
		<span id="menu_contact" onclick="location.href='/contact'" class="${menu == 'Contact' ? 'sel' : '' }">Contact</span>
		<div class="underline">
			<img src="/img/main/underline.png" id='underline_contact'/>
		</div>
	</div>
</div>