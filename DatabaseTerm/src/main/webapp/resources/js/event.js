function eventDetail(eventCode) {
	location.href = "teammate.eventDetail?eventCode=" + eventCode;
}

function toEventList() {
	location.href = "teammate.eventList";
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
	} else if(isEmpty(eventLinkInput) || containsHS(eventLinkInput)) {
		alert("이벤트 주소를 입력해주세요.");
		eventLinkInput.value = "";
		eventLinkInput.focus();
		return false;
	} else if(isEmpty(eventThumbnailInput) || (isNotType(eventThumbnailInput, "png") && isNotType(eventThumbnailInput, "jpg") 
											&& isNotType(eventThumbnailInput, "gif") && isNotType(eventThumbnailInput, "bmp"))) {
		alert("사진을 등록하세요.");
		return false;
	}
	alert("이벤트 등록이 완료되었습니다.");
	return true;
}