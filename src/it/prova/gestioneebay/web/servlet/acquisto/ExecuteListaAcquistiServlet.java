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

import it.prova.gestioneebay.service.acquisto.AcquistoService;

@WebServlet("/ExecuteListaAcquistiServlet")
public class ExecuteListaAcquistiServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

//	@Autowired
//	private ContribuenteService contribuenteService;

//	@Autowired
//	private AnnuncioService annuncioService;

	@Autowired
	private AcquistoService acquistoService;

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
	}

	public ExecuteListaAcquistiServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		
		Long idUtente = Long.parseLong(request.getParameter("idUtente"));

		request.setAttribute("listaAcquisto",
				acquistoService.listByIdUtente(idUtente));			
		
		RequestDispatcher rd = request.getRequestDispatcher("/acquisto/listaAcquisti.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
