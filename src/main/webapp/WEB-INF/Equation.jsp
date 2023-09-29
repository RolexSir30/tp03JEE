<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>





 <form action="equation" method="get">
        
        <input type="number" name="a" id="a" required>x^2+
        

        <input type="number" name="b" id="b" required>x+

        <input type="number" name="c" id="c" required>=0
        <br><br>

        <input type="submit" value="Envoyer">
<br>
<%


if(request.getParameter("a")==null||request.getParameter("b")==null||request.getParameter("c")==null){

	%>
	
	Paramètres nulles veuillez saisir a b et c dans l'url s'il vous plaît


<%}else{ %>

 <% 
 float d = Float.parseFloat(request.getAttribute("d").toString());
 // Récupérer la valeur de d depuis la requête

    %>
     

    
     <% 
        if (d > 0) {
    %>
        <p style="color: green;"><%= request.getAttribute("resultat") %></p>
    <%
        } else if (d < 0) {
    %>
        <p style="color: red;"><%= request.getAttribute("resultat") %></p>
    <%
        } else if(d==0){
    %>
        <p style="color: white;text-shadow: -1px -1px 0 black, 1px -1px 0 black, -1px 1px 0 black, 1px 1px 0 black; padding: 5px;"><%= request.getAttribute("resultat") %></p>
    <%
        }}
    %>

     

</body>
</html>