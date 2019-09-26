<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" trimDirectiveWhitespaces="true"%>

<html>
<head>
	<title>Home</title>
	<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<script>

function update_form(){
	
  $.ajax({
    url: "${pageContext.request.contextPath}/json03",
    type: "POST",
    cache: false,
    dataType: "json",
/*     data: "b_no=" + b_no, */
    success: function(data){
    	console.log(data);

    },
    
    error: function (request, status, error){        
        var msg = "ERROR : " + request.status + "<br>"
      msg +=  + "내용 : " + request.responseText + "<br>" + error;
      console.log(msg);              
    }
  });
}

$(document).ready(function() {
	alert("success");
	update_form();
	console.log("Ready"); 
});
</script>


</body>
</html>
