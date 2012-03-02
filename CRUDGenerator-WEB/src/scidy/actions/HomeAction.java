package scidy.actions;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.ProjetEjb;
import scidy.entites.Projet;
import scidy.entites.User;
import scidy.utils.BeanLocator;

public class HomeAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return mapping.findForward("login");
		
		List<Projet> projets = BeanLocator.defaultLookup(ProjetEjb.class)
				.findAll((User) session.getAttribute("user"));

		request.setAttribute("listeProjets", projets);

		return mapping.findForward("accueil");
	}

}
