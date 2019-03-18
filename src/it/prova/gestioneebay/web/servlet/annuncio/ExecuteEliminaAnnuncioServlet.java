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

import it.prova.gestioneebay.model.Annuncio;
import it.prova.gestioneebay.service.annuncio.AnnuncioService;

@WebServlet("/ExecuteEliminaAnnuncioServlet")
public class ExecuteEliminaAnnuncioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Autowired
	private AnnuncioService annuncioService;

//	@Autowired
//	private CategoryService categoryService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteEliminaAnnuncioServlet() {
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
		
		Long idAnnuncio = Long.parseLong(request.getParameter("idAnnuncio"));
		
		Annuncio annuncioDaEliminare = annuncioService.caricaSingoloAnnuncioEager(idAnnuncio);

		annuncioService.rimuovi(annuncioDaEliminare);
		
		RequestDispatcher rd = request.getRequestDispatcher("/PrepareSearchAnnuncioServlet");
		rd.forward(request, response);
	}

}
