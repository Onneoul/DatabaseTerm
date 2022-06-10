function toUserDetail (code) {
    location.href = "user.detail.view?userCode=" + code;
}

function toUserJoin () {
	location.href = "user.join.go";
}

function userJoin () {
	location.href = "user.join"
}

function logout () {
	location.href = "user.logout";
}

function getUserAccess() {
	
}

function toUserUpdate(code) {
	location.href = "toUserUpdate?code" + code;
}