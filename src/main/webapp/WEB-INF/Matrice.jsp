<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




     <%       
     
     String x= (String)request.getAttribute("x1");
     String y= (String)request.getAttribute("y1");
     
     int[][] matrice = (int[][]) request.getAttribute("matrice");%> <!-- on r�cup�re la matrice-->

<%if(x==null||y==null){
	%>

  <table >
        <%
            // Parcourez la matrice et g�n�rez les balises de la table    <!-- on cr�e la matrice--> 
            for (int i = 0; i < 10; i++) {
        %>
            <tr>
                <%
                    for (int j = 0; j < 10; j++) {
                %>
                    <td><%= matrice[i][j] %></td>
                <%
                    }
                %>
            </tr>
        <%
            }
        %>
    </table>
    
    
    <br>
    <br>
    Veuillez saisir x et y dans l'url s'il vous pla�t pour voir la valeur d'une coordonn�e.Ou bien remplissez ce formulaire !
    <br>
    
     <form method="get" action="matrice">
    
    
    <p><label>Ligne</label>
    	<input type="number" id="x" name="x"></input></p>
    	
    <p><label>Colonne</label>
    	<input type="number" id="y" name="y"></input></p>	
    	

    
    <p><input type="submit"></p>
    </form>
    
    
    <br><br>
    Modifier une valeur dans la matrice ? Remplissez ce formulaire s'il vous pla�t.
    
    <br>
    
    <form method="post" action="matrice">
    
    
    <p><label>Ligne</label>
    	<input type="number" id="ligne" name="ligne"></input></p>
    	
    <p><label>Colonne</label>
    	<input type="number" id="colonne" name="colonne"></input></p>	
    	
    <p><label>Valeur</label>
    	<input type="number" id="valeur" name="valeur"></input></p>	
    
    <p><input type="submit"></p>
    </form>
    
    <br><br>
    <form method="post" action="matrice">
    

    
    <p> <label>R�initialiser la matrice � la matrice nulle</label>
    <input type="submit" text="R�initialiser la matrice � 0 "></p>
    </form>
    
    
   <% }else{%> 
   
   
	   
   
   
    <p>Voici la valeur se trouvant ligne <%= request.getAttribute("x") %> et colonne <%= request.getAttribute("y") %>  : <%=request.getAttribute("valeur") %>
<%} %>




</body>
</html>