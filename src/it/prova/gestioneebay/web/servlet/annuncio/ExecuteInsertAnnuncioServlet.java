package it.prova.gestioneebay.web.servlet.annuncio;

import java.io.IOException;
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

import it.prova.gestioneebay.model.Annuncio;
import it.prova.gestioneebay.model.Category;
import it.prova.gestioneebay.model.Utente;
import it.prova.gestioneebay.service.annuncio.AnnuncioService;
import it.prova.gestioneebay.service.category.CategoryService;

@WebServlet("/ExecuteInsertAnnuncioServlet")
public class ExecuteInsertAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnnuncioService annuncioService;

	@Autowired
	private CategoryService categoryService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteInsertAnnuncioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		String testoAnnuncio = request.getParameter("testoInput");
		int prezzo = 0;
		
		try {
			prezzo = Integer.parseInt(request.getParameter("prezzoInput"));
		} catch (NumberFormatException e) {
		}
		
		Utente utenteInSession = (Utente) request.getSession().getAttribute("userInfo");
		Annuncio nuovoAnnuncio = new Annuncio(testoAnnuncio, prezzo);
		
		nuovoAnnuncio.setAperto(true);
		nuovoAnnuncio.setUtente(utenteInSession);

		Set<Category> categorieAnnuncio = new HashSet<>();
		String[] listaIdCategory = request.getParameterValues("categoryInput");

		if (listaIdCategory != null) {
			for (String idCategory : listaIdCategory) {

				Long idCategoryLong = Long.parseLong(idCategory);

				Category categoryTemp = categoryService.caricaSingoloCategory(idCategoryLong);

				categorieAnnuncio.add(categoryTemp);
			}
		}
		
		nuovoAnnuncio.setCategory(categorieAnnuncio);
		
		annuncioService.inserisciNuovoAnnuncio(nuovoAnnuncio);

		request.setAttribute("annuncioSingolo", annuncioService.caricaSingoloAnnuncioEager(nuovoAnnuncio.getId()));

		RequestDispatcher rd = request.getRequestDispatcher("/annuncio/dettaglio.jsp");
		rd.forward(request, response);
	}

}
