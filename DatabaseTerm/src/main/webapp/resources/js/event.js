function toEventDetail(eventCode) {
	location.href = "teammate.eventDetail?eventCode=" + eventCode;
}

function toEventList() {
	location.href = "teammate.eventList";
}

function toEventCreate() {
	location.href = "teammate.toEventCreate";
}

function toEventUpdate(code) {
	location.href = "teammate.toEventUpdate?code="+ code;
}

function toEventDelete(code) {
	var ok = confirm("정말 이 글을 삭제하시겠습니까?");
	if (ok) {
		location.href = "teammate.eventDelete?code=" + code;
		alert("삭제되었습니다.");
	} else {
		alert("삭제를 취소하셨습니다.");
	}
}

function eventCreateCheck() {
	var eventTitleInput = document.eventCreateForm.eventTitleInput;
	var eventContentInput = document.eventCreateForm.eventContentInput;
	var eventThumbnailInput = document.eventCreateForm.eventThumbnailInput;
	var eventLinkInput = document.eventCreateForm.eventLinkInput;

	if(isEmpty(eventTitleInputInput) || containsHS(eventTitleInputInput)) {
		alert("이벤트 제목을 입력해주세요.");
		eventTitleInput.value = "";
		eventTitleInput.focus();
		return false;
	} else if(isEmpty(eventContentInput) || containsHS(eventContentInput)) {
		alert("이벤트 내용을 입력해주세요.");
		eventContentInput.value = "";
		eventContentInput.focus();
		return false;
	}
	alert("이벤트 등록이 완료되었습니다.");
	return true;
}