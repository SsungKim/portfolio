// 페이지 로딩 완료시 페이지 숨김
$(window).load(function(){
	// 페이지 로딩바
	$("#loading_bar").stop().animate({
		width: '100%'
	}, 1000);
	// 로딩페이지 숨김
	setTimeout(function(){
		$(".loading_wrap").fadeOut('slow');
	}, 1000);
});

// 메뉴 underline
$(document).ready(function(){
	$(".menu span").mouseover(function(){
		var id = $(this).context.id;
		id = id.substring(id.indexOf('_')+1);
		$("#underline_"+id).stop().animate({
			width: '80%'
		});
	});
	$(".menu span").mouseleave(function(){
		var id = $(this).context.id;
		id = id.substring(id.indexOf('_')+1);
		$("#underline_"+id).stop().animate({
			width: '0%'
		});
	});
});

//ajax 로딩
$(document).ready(function(){
	// ajax 실행시 로딩이미지 보여주기
	$(window).ajaxStart(function(){
		$(".ajax_section").show();
	})
	// ajax 종료시 로딩이미지 숨기기
	.ajaxStop(function(){
		$(".ajax_section").hide();
	});
});

// 로그인
function login(){
	var id = $("#login_id").val();
	var pw = $("#login_pw").val();
	if(id == "" || pw == ""){
		alert("아이디 또는 비밀번호를 확인해주세요.");
		return;
	}
	$.ajax({
		type : "post",
		url : "/login/"+id+"/"+pw,
		async : false,
		success : function(txt){
			if(txt){
				location.href='/';
			} else {
				alert("아이디 또는 비밀번호를 확인해주세요.");
				return;
			}
		}
	});
}

// 로그인 페이지 비밀번호 입력란 엔터
$(document).ready(function(){
	$("#login_pw").keydown(function(e){
		if(e.keyCode == 13){
			login();
		}
	});
});

// 게시판 글쓰기 저장
function board_save(){
	CKupdate();
	$("#board_form").ajaxForm({
		url : "/board/upload",
		enctype : "multipart/form-data",
		success : function(txt){
			if(txt){
				alert("등록되었습니다.");
				location.href='/board';
			} else {
				alert("등록에 실패하였습니다.");
			}
		}
	});
	$("#board_form").submit();
}

// 게시판 글쓰기 저장 ckeditor 데이터 변환
function CKupdate(){
	for ( instance in CKEDITOR.instances )
		CKEDITOR.instances[instance].updateElement();
}

// 게시판 글 보기
var board_num = 0;
function board_view(num){
	$(".list_wrap .list_section .list").removeClass("sel");
	$.ajax({
		type : "post",
		url : "/board/view/"+num,
		async : false,
		success : function(txt){
			$("#board_view_content").html(txt.content);
			board_num = num;
			$("#board_list"+num).addClass(" sel");
		}
	});
}

// 게시판 글 삭제
function board_delete(){
	var del = confirm("삭제하시겠습니까?");
	if(del){
		$.ajax({
			type : "post",
			url : "/board/delete/"+board_num,
			async : false,
			success : function(txt){
				if(txt){
					alert("삭제되었습니다.");
					location.reload();
				} else {
					alert("삭제에 실패하였습니다.");
				}
			}
		});
	}
}

// 게시판 글 수정
function board_modify(){
	location.href="/board/modify/"+board_num;
}

// 게시판 글 수정 저장
function board_modify_save(){
	CKupdate();
	$("#board_modify_form").ajaxForm({
		url : "/board/modify",
		enctype : "multipart/form-data",
		success : function(txt){
			if(txt){
				alert("수정되었습니다.");
				location.href='/board';
			} else {
				alert("수정에 실패하였습니다.");
			}
		}
	});
	$("#board_modify_form").submit();
}

// contact 메일 전송
function contact_mail_send(){
	var title = $("#contact_title").val();
	var contact = $("#contact_contact").val();
	var content = $("#contact_content").val();
	if(title == "" || contact == "" || content == ""){
		alert("모든 항목을 입력해주세요.");
		return;
	}
	$.ajax({
		type : "post",
		url : "/contact/send/"+title+"/"+contact+"/"+content,
		async : false,
		success : function(txt){
			if(txt){
				alert("전송되었습니다.");
				location.reload();
			} else {
				alert("전송에 실패하였습니다.\n같은 증상이 반복된다면 010-9999-6771으로 연락바랍니다.");
			}
		}
	});
}

// top 클릭
function scroll_top(){
	$(".section").stop().animate({
		scrollTop: 0
	});
	$(".top_wrap").hide();
}

// top 보이기
$(document).ready(function(){
	$(".section").on("mousewheel", function(e){
		var top = $(".section").scrollTop()-300;
		if(top > 0){
			$(".top_wrap").show();
		} else {
			$(".top_wrap").hide();
		}
	});
});

// work 프로젝트 이미지 슬라이드
$(document).ready(function(){
	var workCount = 0;
	$.ajax({
		type : "post",
		url : "/work/count",
		async : false,
		success : function(txt){
			workCount = txt;
		}
	});
	var work_high = new Array();
	var work_num = new Array();
	for(var i=0; i<workCount; i++){
		work_high[work_high.length] = 506;
		work_num[work_num.length] = 0;
	}
	setInterval(work_slide, 2500);
	function work_slide(){
		for(var i=0; i<work_high.length; i++){
			if(work_num[i] == 0){
				$("#work_"+(i+1)).stop().animate({
					top: -(work_high[i]*0.65)
				}, 2000);
				work_num[i]++;
			} else {
				$("#work_"+(i+1)).stop().animate({
					top: 0
				}, 2000);
				work_num[i] = 0;
			}
		}
	}
});

// work upload
function work_upload(){
	var name = $("#work_upload_name").val();
	var file = $("#work_upload_file").val();
	var url = $("#work_upload_url").val();
	var tool = $("#work_upload_tools").val();
	var people = $("#work_upload_people").val();
	var cons = $("#work_upload_cons").val();
	var day = $("#work_upload_day").val();
	var content = $("#work_upload_content").val();
	if(name == "" || url == "" || tool == "" || people == "" || cons == "" || day == "" || content == ""){
		alert("입력하지 않은 항목이 있습니다.");
		return;
	}
	$("#work_upload_form").ajaxForm({
		type : "post",
		url : "/work/uploadSave",
		enctype : "multipart/form-data",
		async : false,
		success : function(txt){
			if(txt){
				alert("등록되었습니다.");
				location.href="/work";
			} else {
				alert("등록에 실패하였습니다.");
			}
		}
	});
	$("#work_upload_form").submit();
}

// main slide
$(document).ready(function(){
	var slide_length = $("#main_slide .slide").length;
	var width = $(".main_slide")[0].clientWidth;
	
	$("#main_slide").width( width*(slide_length+2) );
	$("#main_slide .slide").width(width);
	
	$first = $("#main_slide .slide").first().clone();
    $last = $("#main_slide .slide").last().clone();
    
    $("#main_slide").append($first);
    $("#main_slide").prepend($last);
    
    $("#main_slide").css("left", -width);
    
    var mainSlideTimer = setInterval(main_slide_right, 3000);
    
    $("#main_left").hover(
		function(){
			clearInterval(mainSlideTimer);
		},
		function(){
			mainSlideTimer = setInterval(main_slide_right, 3000);
		}
	);
    $("#main_right").hover(
		function(){
			clearInterval(mainSlideTimer);
		},
		function(){
			mainSlideTimer = setInterval(main_slide_right, 3000);
		}
	);
    $("#main_slide").hover(
		function(){
			clearInterval(mainSlideTimer);
		},
		function(){
			mainSlideTimer = setInterval(main_slide_right, 3000);
		}
	);
    
    $("#main_right").click(function(){
		main_slide_right();
	});
	$("#main_left").click(function(){
		main_slide_left();
	});
	
	var slide_num = 1;
	function main_slide_right(){
		slide_num++;
		$("#main_slide").stop().animate({
            left: -width * slide_num
        }, function(){
            if ( slide_num == slide_length + 1 ) {
                slide_num = 1;
                $("#main_slide").css("left", -width * slide_num );
            }
        });
	}
	function main_slide_left(){
		slide_num--;
		$("#main_slide").stop().animate({
            left: -width * slide_num
        }, function(){
            if ( slide_num == 0 ) {
                slide_num = slide_length;
                $("#main_slide").css("left", -width * slide_num );
            }
        });
	}
});

// main site popup
function site_popup(type){
	console.log(type);
	$(".site_popup").show();
	$("#siteTitle").html(type);
	$(".site_list").hide();
	$("#"+type+"Div").show();
}