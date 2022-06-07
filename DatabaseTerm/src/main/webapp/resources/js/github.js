var token;

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
    var http = new XMLHttpRequest();
    var url = "https://github.com/login/oauth/authorize";
    var parameter = "client_id=9560c4b82e839019b0eb&redirect_uri=http://localhost:80/find/github";
    http.open('GET', url, true, parameter);

    http.setRequestHeader("client_id", "9560c4b82e839019b0eb")

}

function getAccessToken1(token) {
    alert(token);
    url = "https://github.com/login/oauth/access_token";
    fetch("https://github.com/login/oauth/access_token", {
        method: "POST",
        parameter: {
            "client_id": "9560c4b82e839019b0eb",
            "client_secret": "209cc5d84fb3f533d51a59682223c72769381761",
            "code": token
        }
    }).then((response) => response.json ).then((data) => console.log(data));
}

function githubUser(access_token) {
    url = "https://github.com/login/oauth/access_token";
    fetch("https://api.github.com/user", {
        method: "GET",
        headers: {
            "Authorization": "token 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"
        }
    }).then((response) => response.json ).then((data) => console.log(data));
}

