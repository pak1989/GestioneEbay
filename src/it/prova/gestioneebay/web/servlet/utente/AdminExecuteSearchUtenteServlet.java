package it.prova.gestioneebay.web.servlet.utente;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import it.prova.gestioneebay.model.Ruolo;
import it.prova.gestioneebay.model.Utente;
import it.prova.gestioneebay.service.ruolo.RuoloService;
import it.prova.gestioneebay.service.utente.UtenteService;

@WebServlet("/admin/ExecuteSearchUtenteServlet")
public class AdminExecuteSearchUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UtenteService utenteService;
	
	@Autowired
	private RuoloService ruoloService;
		

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public AdminExecuteSearchUtenteServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nomeInput");
		String cognome = request.getParameter("cognomeInput");
		String username = request.getParameter("usernameInput");
		String dataString = request.getParameter("dataInput");		
	    Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(dataString);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
		Set<Ruolo> ruoliUtente = new HashSet<>();

		Utente example = new Utente(nome, cognome, username, data);
		
		example.setRuoli(ruoliUtente);
		
		String[] listaIdRuolo = request.getParameterValues("ruoliInput");
		
		if (listaIdRuolo != null) {
			for (String idRuolo : listaIdRuolo) {

				Long idRuoloLong = Long.parseLong(idRuolo);
				
				Ruolo ruoloTemp = ruoloService.caricaSingoloRuolo(idRuoloLong);

				example.getRuoli().add(ruoloTemp);
			}
		}

		request.setAttribute("listaUtentiAttributeName", utenteService.findByAttributes(example));

		RequestDispatcher rd = request.getRequestDispatcher("/admin/searchResult.jsp");
		rd.forward(request, response);

	}

}
