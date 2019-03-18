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
import it.prova.gestioneebay.service.annuncio.AnnuncioService;
import it.prova.gestioneebay.service.category.CategoryService;

@WebServlet("/ExecuteModificaAnnuncioServlet")
public class ExecuteModificaAnnuncioServlet extends HttpServlet {
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

	public ExecuteModificaAnnuncioServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("listAnnunciName", annuncioService.listAllAnnuncio());

		RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setAttribute("annuncioSingolo", annuncioService.listAllAnnuncio());
		
		String testoAnnuncio = request.getParameter("testoInput");
		int prezzo = 0;
		try {
			prezzo = Integer.parseInt(request.getParameter("prezzoInput"));
		} catch (NumberFormatException e) {
		}
		Set<Category> categorieAnnuncio = new HashSet<>();
		
		Long idAnnuncio = Long.parseLong(request.getParameter("idAnnuncio"));

		Annuncio annuncioDaModificare = annuncioService.caricaSingoloAnnuncioEager(idAnnuncio);
		
		annuncioDaModificare.setTestoAnnuncio(testoAnnuncio);
		annuncioDaModificare.setPrezzo(prezzo);

		String[] listaIdCategory = request.getParameterValues("categoryInput");

		if (listaIdCategory != null) {
			for (String idCategory : listaIdCategory) {

				Long idCategoryLong = Long.parseLong(idCategory);

				Category categoryTemp = categoryService.caricaSingoloCategory(idCategoryLong);

				categorieAnnuncio.add(categoryTemp);
			}
		}
		
		annuncioDaModificare.setCategory(categorieAnnuncio);
		
		annuncioService.aggiorna(annuncioDaModificare);

		request.setAttribute("annuncioSingolo", annuncioService.caricaSingoloAnnuncioEager(idAnnuncio));

		RequestDispatcher rd = request.getRequestDispatcher("/annuncio/dettaglio.jsp");
		rd.forward(request, response);
	}

}
