package it.prova.gestioneebay.web.servlet.utente;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestioneebay.model.Utente;
import it.prova.gestioneebay.service.utente.UtenteService;

@WebServlet("/admin/PrepareModificaUtenteServlet")
public class AdminPrepareModificaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Autowired
	private UtenteService utenteService;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}
       
    public AdminPrepareModificaUtenteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		long idUtente = Long.parseLong(request.getParameter("idUtente"));
		
		Utente utenteDaModificare = utenteService.caricaSingoloUtente(idUtente);
		
		request.setAttribute("utenteAttributeName", utenteDaModificare);
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/modificaForm.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
