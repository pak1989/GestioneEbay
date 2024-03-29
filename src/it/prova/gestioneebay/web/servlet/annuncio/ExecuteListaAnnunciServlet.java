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

@WebServlet("/ExecuteListaAnnunciServlet")
public class ExecuteListaAnnunciServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Autowired
//	private ContribuenteService contribuenteService;

	@Autowired
	private AnnuncioService annuncioService;

//	@Autowired
//	private AcquistoService acquistoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteListaAnnunciServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		Long idUtente = Long.parseLong(request.getParameter("idUtente"));

		request.setAttribute("listaAnnuncio",
				annuncioService.listByIdUtente(idUtente));			
		
		RequestDispatcher rd = request.getRequestDispatcher("/annuncio/listaAnnunci.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
