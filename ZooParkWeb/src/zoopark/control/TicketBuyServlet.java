package zoopark.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import zoopark.model.Utente;
import zoopark.model.UtenteModelDM;

/**
 * Servlet implementation class TicketBuyServlet
 */
@WebServlet("/userarea/dashboard")
public class TicketBuyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TicketBuyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { //messaggio richiesta di una risorsa
		String nome = request.getParameter("nome");
		String cognome= request.getParameter("cognome");
		System.out.println(nome);
		UtenteModelDM model = new UtenteModelDM();
		try {
			Utente userBean = model.doRetrievebyName(nome);
			if(userBean.getNome()==null) {
				String redirect = response.encodeRedirectURL("./error.html");
				response.sendRedirect(redirect);
			}
			else
			if(userBean.getCognome().equals(cognome) && userBean.getNome().equals(nome)) {
			userBean.setHaveTicket(true);
			model.doUpdateTicket(userBean);	
			System.out.println("Egg fatt update");
			HttpSession session = request.getSession(true);
			session.setAttribute("user", userBean);
			String redirect = response.encodeRedirectURL("./completed.jsp");
			response.sendRedirect(redirect);	
			}
			else {
				String redirect = response.encodeRedirectURL("./error.html");
				response.sendRedirect(redirect);
			}
		} catch (SQLException e) {
			response.sendRedirect("./error.html");
		}
		
	}

}
