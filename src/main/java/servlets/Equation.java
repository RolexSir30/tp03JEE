package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Equation
 */

public class Equation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Equation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// On récupère les paramètres a, b et c passés dans l'url
		String a1 = request.getParameter("a"); 
	    String b1 = request.getParameter("b");
	    String c1 = request.getParameter("c");
	    String resultat="";
	    
	    
	    

	    
	    //Si les paramètres sont nuls on retourne sur la page jsp afin de ne pas éxécuter le code suivant.
	    if(a1==null||b1==null||c1==null) {
	    	request.setAttribute("a1",a1);
	    	request.setAttribute("a1",a1);
	    	request.setAttribute("a1",a1);

			this.getServletContext().getRequestDispatcher("/WEB-INF/Equation.jsp").forward(request, response);
  
	    }else {
	    //On transforme les strings en float pour pouvoir s'en servir dans le code java suivant.
		float a=Float.parseFloat(a1);
		float b=Float.parseFloat(b1);
        float c=Float.parseFloat(c1);
        
        float d = b*b - 4*a*c;  //calcul du discriminant
        
        if(d<0) {
        
       resultat ="Pas de discriminant";
        }
        
        if(d==0) {
        	float x = -b/2*a;
        	resultat="La racine est "+x;
        }
        
        if(d>0) {
        	float x1=(-b+d)/(2*a);
        	float x2=(-b-d)/(2*a);
        	resultat="Les racines sont : x1 = "+x1+" et x2 = "+x2;
        }
        
        
        
        //Envoie des paramètres dans la jsp
        
        request.setAttribute(c1, "c1");
        request.setAttribute(a1, "a1");
        request.setAttribute(b1, "b1");

        request.setAttribute("a", a);
        request.setAttribute("b", b);
        request.setAttribute("c", c);
        request.setAttribute("d", d);
        request.setAttribute("resultat", resultat);
        
        
        
		this.getServletContext().getRequestDispatcher("/WEB-INF/Equation.jsp").forward(request, response);
	}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
