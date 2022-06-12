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