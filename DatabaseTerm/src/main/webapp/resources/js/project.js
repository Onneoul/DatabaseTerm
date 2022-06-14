function projectCreate (projectName, projectContent /*기술 스택, 레벨 등등*/) {
	
};

function projectCreateCheck (projectName) {
    
};

function toProjectview () {
	location.href = "project.view";
}

function toProjectDetail (projectNumber) {
	location.href = "project.detail?projectCode=" + projectCode;
}

function toProjectInsert () { // 로그인중인 유저 ID받아서 인수로 주고 이동해야함
	location.href ="to.project.create";
} 

function toProjectDelete(code) {
	var ok = confirm("정말 이 글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "project.delete?projectCode=" + code;
		alert("삭제되었습니다.");
	} else {
		alert("삭제를 취소하셨습니다.");
	}
}

function toFeedBackDelete(code) {
	var ok = confirm("정말 이 글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "project.feedback.delete?feedBackCode=" + code;
		alert("삭제되었습니다.");
	} else {
		alert("삭제를 취소하셨습니다.");
	}
}