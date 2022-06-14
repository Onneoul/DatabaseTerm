function toQuestionCreate() {
	location.href = "to.question.create";
}

function toQuestionList() {
	location.href = "question.list";
}

function toQuestionDetail(code) {
	location.href = "question.detail?questionCode=" + code;
}

function toQuestionUpdate(code) {
	location.href = "to.question.update?questionCode=" + code;
}

function toQuestionDelete(code) {
	var ok = confirm("정말 이 글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "question.delete?questionCode=" + code;
		alert("삭제되었습니다.");
	} else {
		alert("삭제를 취소하셨습니다.");
	}
}

function toAnswerDelete(questionCode, code) {
	var ok = confirm("정말 이 글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "answer.delete?questionCode="+ questionCode +"&answerCode=" + code;
		alert("삭제되었습니다.");
	} else {
		alert("삭제를 취소하셨습니다.");
	}
}

function toUserDelete(code) {
	var ok = confirm("정말 탈퇴하시겠습니까?");
	if (ok) {
		location.href = "user.delete?userCode=" + code;
		alert("탈퇴 되셨습니다.");
	} else {
		alert("탈퇴를 취소하셨습니다.");
	}
}