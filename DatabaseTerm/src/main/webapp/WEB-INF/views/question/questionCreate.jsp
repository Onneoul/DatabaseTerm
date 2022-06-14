<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType = "text/html;charset=utf-8" %>
<html>
	<head>
		<meta name="description" content="Tagify">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="viewport" content="width=device-width">
  		<meta name="author" content="Yair Even Or">
  		
		<title>Title</title>
		
		<style>
		    .tagifyinput{
		      display: block !important;
		      position: static !important;
		      transform: none !important;
		      width: 100%;
		      margin-top: 1em;
		      padding: .5em;
		    }
		    .tags-look .tagify__dropdown__item{
			  display: inline-block;
			  border-radius: 3px;
			  padding: .3em .5em;
			  border: 1px solid #CCC;
			  background: #F3F3F3;
			  margin: .2em;
			  font-size: .85em;
			  color: black;
			  transition: 0s;
			}
			
			.tags-look .tagify__dropdown__item--active{
			  color: black;
			}
			
			.tags-look .tagify__dropdown__item:hover{
			  background: lightyellow;
			  border-color: gold;
			}
	  	</style>
	</head>
	<body>
	<script type="text/javascript">
	var input = document.querySelector('input[name="tags"]')
	
		var tagify = new Tagify(input, {
			  maxTags: 5,
			  dropdown: {
			    maxItems :10, 
			    enabled: 0
			  }, whitelist: ["C","C#","C++","D","Java","Python","JavaScript","Android","IOS","HTML","CSS","DBMS","Database","Ruby","PHP","R","Objective-c",
			   				".NET", "Django", "Flask", "Spring", "Hibernate", "Grails", "GWT", "Struts", "JSF", "Vaadin", "Blade", "Play", "React", "Angular", "Vue", 
			   				"Svelte", "Backbone.js", "Ember.js", "JQuery", "Inferno", "Asp.net", "NestJS", "Blazor", "Sql-server", "Oracle", "MySQL", "MariaDB", "DB2", "PostgreSQL"]
			  
		})
	  </script>
		<form action="question.create" name="questionCreateForm" id="questionCreateForm" method="post" >
			<div><input type="hidden" name="writer" value="${sessionScope.loginUser.code }"></div>
			<hr>
			<div id="questionTitle"><input type="text" class="questionInput" name="title" placeholder="질문 제목"> </div>
			<hr>
			<div id="questionContentArea"><textarea name="content" id="questionContentInput">질문 내용</textarea></div>
			<hr>
			<button>작성 완료</button>
		</form>
	</body>
</html>
