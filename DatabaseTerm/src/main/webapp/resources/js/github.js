function getParameter(name) {
    name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
        results = regex.exec(location.search);
    return results === null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
}

function getToken() {
	location.href = "https://github.com/login/oauth/authorize?client_id=9560c4b82e839019b0eb&redirect_uri=http://localhost:80/find/github";
}

function getAccessToken (token) {
	window.location.href = "https://github.com/login/oauth/access_token?client_id=9560c4b82e839019b0eb&client_secret=209cc5d84fb3f533d51a59682223c72769381761&code="+token;
}