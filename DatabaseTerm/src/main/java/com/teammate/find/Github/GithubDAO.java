package com.teammate.find.Github;

import java.lang.reflect.Type;
import java.net.URI;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.parser.Entity;

import org.apache.ibatis.session.SqlSession;
import org.apache.tomcat.util.http.fileupload.ParameterParser;
import org.apache.tomcat.util.http.parser.MediaType;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.Message;
import com.google.protobuf.Parser;
import com.mysql.cj.xdevapi.JsonArray;
import com.mysql.cj.xdevapi.JsonParser;
import com.teammate.find.User.User;

@Service
public class GithubDAO {
	
	@Autowired
	private SqlSession ss;
	
	@Autowired
	private Github g;
	
	public String getGitAccessToken(HttpServletRequest req, HttpServletResponse res) {

		try {
			
			String code = req.getParameter("code");
			
			MultiValueMap<String, String> multi = new LinkedMultiValueMap<>();
			multi.add("client_id", "9560c4b82e839019b0eb");
			multi.add("client_secret", "364a7358eb44caa31ebd16e1a391d559230d70c5");
			multi.add("code", code); // 파라미터 세팅
			
			String url = "https://github.com/login/oauth/access_token";
			

			String a = UriComponentsBuilder.fromUriString(url).queryParams(multi).build().encode().toString();
//			System.out.println("a = " + a);
			
			HttpHeaders headers = new HttpHeaders();
			HttpEntity<MultiValueMap<String, String>> gitReq = new HttpEntity<>(multi, headers);
			
			RestTemplate rest = new RestTemplate();
			ResponseEntity<String> result = rest.getForEntity(a, String.class ,gitReq);
			
			String gitHubBody = result.getBody();
			String[] gitAccessToken = gitHubBody.split("=|&");
//			
//			System.out.println("result = " + result);
//			System.out.printf("getBody = %s"  , result.getBody());
			
			
			return gitAccessToken[1];
			
			
		} catch (Exception err) {
			err.printStackTrace();
			return "error";
		}
	}


	public void getUser(String AccessToken, HttpServletRequest req, HttpServletResponse res) {

		try {

			RestTemplate rest = new RestTemplate();
			
//			AccessToken = ;
			String url = "https://api.github.com/user";
			
			MultiValueMap<String, String> multi = new LinkedMultiValueMap<>();
			multi.add("Authorization", "token " + AccessToken);
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.set("Authorization", "token " + AccessToken);
//			System.out.println(headers.get("Authorization")); 테스트
			
			HttpEntity<String> gitReq = new HttpEntity<>(headers);
			
			ResponseEntity<String> result = rest.exchange(url, HttpMethod.GET, gitReq, String.class);
			
//			System.out.println(result.getHeaders());
//			System.out.println(result.getBody()); 테스트
			
			String str1 = result.getBody();
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(str1);
			JSONObject jobj = (JSONObject) obj;
			
//			System.out.println(jobj.get("login"));
//			System.out.println(jobj.get("name"));
			
			req.setAttribute("loginGitId" ,jobj.get("login"));
			req.setAttribute("loginGitName", jobj.get("name"));
			req.setAttribute("loginGitLink", jobj.get("html_url"));
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
	}
	
	public void joinUser(String AccessToken, HttpServletRequest req, HttpServletResponse res) {

		try {

			RestTemplate rest = new RestTemplate();
			
//			AccessToken = ;
			String url = "https://api.github.com/user";
			
			MultiValueMap<String, String> multi = new LinkedMultiValueMap<>();
			multi.add("Authorization", "token " + AccessToken);
			
			HttpHeaders headers = new HttpHeaders();
			
			headers.set("Authorization", "token " + AccessToken);
			System.out.println(headers.get("Authorization"));
//			HttpEntity<MultiValueMap<String, String>> gitReq = new HttpEntity<>(multi, headers);
			HttpEntity<String> gitReq = new HttpEntity<>(headers);
		
			
			ResponseEntity<String> result = rest.exchange(url, HttpMethod.GET, gitReq, String.class);
			
			System.out.println(result.getHeaders());
			System.out.println(result.getBody());
			
			String[] str = result.getBody().split("\\{|,|\\}");
			
			for (int i = 0; i < str.length; i++) {
				System.out.println(str[i]);
			}
			
			Gson gson = new GsonBuilder().create();
			String jobj = gson.toJson(result);
			
			System.out.println(jobj);
			
			
			
			
		} catch (Exception err) {
			err.printStackTrace();
		}
		
	}
	
}
