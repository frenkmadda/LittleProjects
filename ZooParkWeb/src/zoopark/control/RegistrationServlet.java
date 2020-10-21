package zoopark.control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import zoopark.model.*;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json");
		Utente userBean = new Utente();
		String nome=request.getParameter("nome");
		String cognome=request.getParameter("cognome");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String text;
		if(nome != null && cognome != null && email !=null && password != null) {
			userBean.setNome(nome);
			userBean.setCognome(cognome);
			userBean.setEmail(email);
			userBean.setPassword(password);
			userBean.setIDRuolo("registered_user");
			userBean.setHaveTicket(false);
			UtenteModelDM model = new UtenteModelDM();
			try {
				Utente beanTest = model.doRetrievebyKey(userBean.getEmail());
				if(beanTest.getEmail()==null) {
					model.doSave(userBean);
					text = "{\"stato\" : \"ok\" }";
				}
				else text = "{\"stato\" : \"email\" }";

			} catch (SQLException e) {
				text = "{\"stato\" : \"SQL\" }";
			}
		}
		else {
			text = "{\"stato\" : \"errore\" }";
	
		}
		
		response.getWriter().write(text);
	}

}
