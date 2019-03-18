package it.prova.gestioneebay.web.servlet.acquisto;

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

import it.prova.gestioneebay.model.Annuncio;
import it.prova.gestioneebay.model.Utente;
import it.prova.gestioneebay.service.acquisto.AcquistoService;
import it.prova.gestioneebay.service.annuncio.AnnuncioService;

@WebServlet("/ExecuteAcquistoServlet")
public class ExecuteAcquistoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnnuncioService annuncioService;

	@Autowired
	private AcquistoService acquistoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteAcquistoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listAnnunciName", annuncioService.listAllAnnuncio());

		Long idAnnuncio = Long.parseLong(request.getParameter("idAnnuncio"));

		Annuncio annuncio = annuncioService.caricaSingoloAnnuncio(idAnnuncio);

		Utente utenteInSession = (Utente) request.getSession().getAttribute("userInfo");

		if (!utenteInSession.verificaDisponibilita(annuncio.getPrezzo())) {
			response.sendRedirect(request.getContextPath());
			return;
		}

		acquistoService.eseguiAcquisto(utenteInSession, annuncio);

		request.setAttribute("listaAnnuncio", annuncio);
		
		RequestDispatcher rd = request.getRequestDispatcher("/acquisto/confermaAcquisto.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listAnnunciName", annuncioService.listAllAnnuncio());

		// String testoAnnuncio = request.getParameter("testoInput");
		// int prezzo = 0;
		// try {
		// prezzo = Integer.parseInt(request.getParameter("prezzoInput"));
		// } catch (NumberFormatException e) {
		// }
		// Set<Category> categorieAnnuncio = new HashSet<>();
		//
		// Annuncio example = new Annuncio(testoAnnuncio, prezzo);
		//
		// example.setCategory(categorieAnnuncio);
		//
		// String[] listaIdCategory = request.getParameterValues("categoryInput");
		//
		// if (listaIdCategory != null) {
		// for (String idCategory : listaIdCategory) {
		//
		// Long idCategoryLong = Long.parseLong(idCategory);
		//
		// Category categoryTemp =
		// categoryService.caricaSingoloCategory(idCategoryLong);
		//
		// example.getCategory().add(categoryTemp);
		// }
		// }

		// request.setAttribute("listaAnnuncio",
		// annuncioService.findByExample2(example));

		RequestDispatcher rd = request.getRequestDispatcher("/annuncio/resultAnnuncio.jsp");
		rd.forward(request, response);
	}

}
