function seeUserProfile (userNumber) {
    location.href = "user.profile.view?userNumber=" + userNumber;
}













// Project Part
function toProjectview () {
	location.href = "project.view";
}

function toProject (projectNumber) {
	location.href = "project.view?projectNumber=" + projectNumber;
}

function toProjectInsert () { // 로그인중인 유저 ID받아서 인수로 주고 이동해야함
	location.href ="project.insert";
}