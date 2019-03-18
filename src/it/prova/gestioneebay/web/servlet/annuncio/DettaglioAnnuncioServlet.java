package it.prova.gestioneebay.web.servlet.annuncio;

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

import it.prova.gestioneebay.service.annuncio.AnnuncioService;

@WebServlet("/DettaglioAnnuncioServlet")
public class DettaglioAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Autowired
//	private ContribuenteService contribuenteService;

	@Autowired
	private AnnuncioService annuncioService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public DettaglioAnnuncioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Long idAnnuncio = Long.parseLong(request.getParameter("idAnnuncio"));

		request.setAttribute("annuncioSingolo",
				annuncioService.caricaSingoloAnnuncioEager(idAnnuncio));

		RequestDispatcher rd = request.getRequestDispatcher("/annuncio/dettaglio.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
