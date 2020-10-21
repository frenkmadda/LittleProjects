package zoopark.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import zoopark.model.*;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //messaggio richiesta di una risorsa
		String email = request.getParameter("email"); //richiesta della mail
		String password = request.getParameter("password");  //richiesta della password
		UtenteModelDM model = new UtenteModelDM();
		try {
			Utente userBean = model.doRetrievebyKey(email);
			if(userBean.getEmail()==null || !userBean.getPassword().equals(password)) {  //caso in cui la mail e la password non esiste  
				HttpSession session = request.getSession(true); //se non c'è la sessione la crea per salvare l'utente in sessione
				session.setAttribute("userExists", "false");
				response.sendRedirect("./login.jsp");
			}
			else if(userBean.getPassword().equals(password)) {
				//login successful
				HttpSession session = request.getSession(true); //se non c'è una sessione la crea per poter salvare l'utente in sessione
				session.setAttribute("user", userBean);
				session.setMaxInactiveInterval(300);
				String redirect = response.encodeRedirectURL("./userarea/dashboard.jsp");
				response.sendRedirect(redirect);
			}
			
		} catch (SQLException e) {
			response.sendRedirect("./error.html");
		}
		
	}

}
