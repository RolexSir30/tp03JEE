package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MatriceServlet
 */
public class MatriceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	int[][] matrice = new int[10][10];

	
    public MatriceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//this.getServletContext().getRequestDispatcher("/WEB-INF/Matricepost.jsp").forward(request, response);

		
	   

	    
	    request.setAttribute("matrice", matrice);
	    
	    String x1 = request.getParameter("x");// prend les valeurs saisies par l'utilisateur sous forme de strings
	    String y1 = request.getParameter("y");//change le string en int
	   
	    
	    if(x1==null||y1==null) {
	    	
		this.getServletContext().getRequestDispatcher("/WEB-INF/Matrice.jsp").forward(request, response);

	    }else {
	    
	    int x = Integer.parseInt(x1);
	    int y = Integer.parseInt(y1);
	    
	    //On vérifie que x et y sont bien compris entre 1 et 10 sinon l'utilisateur voit un message d'erreur
	    if(x<1||x>10||y>10||y<1) {
	        PrintWriter out = response.getWriter();

	    	out.println("Valeur introuvable");
			//this.getServletContext().getRequestDispatcher("/WEB-INF/Matrice.jsp").forward(request, response);

	    }else {


	    
	    
	    int valeur=matrice[x-1][y-1];
	    
	    request.setAttribute("x1", x1);
	    request.setAttribute("y1", y1);
	    request.setAttribute("x",x);
	    request.setAttribute("y",y);
	    request.setAttribute("valeur",valeur);
	    
	    
	    
	    
		this.getServletContext().getRequestDispatcher("/WEB-INF/Matrice.jsp").forward(request, response);
	    }
	   }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//int[][] matrice = new int[10][10]; //matrice 
	
	     String ligne1=request.getParameter("ligne");
	     String colonne2=request.getParameter("colonne");
	     String value1=request.getParameter("valeur");

	     if(ligne1==null&&colonne2==null&&value1==null) { // si les 3 valeurs sont nuls on met la matrice à 0 autrement dit si on clique sur recommencer
	    	 for(int i =0;i<10;i++) {
	    		 for(int j =0;j<10;j++) {
	    			 matrice[i][j]=0;	
	    			 
	    			 }
	    	 }
	    	 
		     //response.sendRedirect("/TP03/matrice");
	    	 PrintWriter out = response.getWriter();

			 out.println("Les valeurs de la matrice ont été remis à 0.");
	     }else {
	     
	     int ligne=Integer.parseInt(ligne1);
	     int colonne=Integer.parseInt(colonne2);
	     int value = Integer.parseInt(value1);
	     
	     
	     //Si une des coordonnée n'est pas valable on recommence le processus de saisie ! 
		if(ligne<1||ligne>10||colonne<1||colonne>10) {
			 PrintWriter out = response.getWriter();

		    out.println("Erreur de saisie des coordonnées");
			
		}else {

	     matrice[ligne-1][colonne-1]=value;
	   
	    }
	     response.sendRedirect("/TP03/matrice");

	     }
	}
	     
}


