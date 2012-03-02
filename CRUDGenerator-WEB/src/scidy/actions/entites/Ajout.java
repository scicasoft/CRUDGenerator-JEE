package scidy.actions.entites;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.EntiteEjb;
import scidy.ejb.ProjetEjb;
import scidy.entites.Entite;
import scidy.entites.Projet;
import scidy.utils.BeanLocator;

public class Ajout extends Action{

	/* (non-Javadoc)
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.ActionMapping, org.apache.struts.action.ActionForm, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return mapping.findForward("login");
		
		
		Entite e = new Entite();
		e.setProjet((Projet) session.getAttribute("projet"));
		e.setNomEntite(request.getParameter("nomEntite"));
		e.setId(BeanLocator.defaultLookup(EntiteEjb.class).nextId());
		BeanLocator.defaultLookup(EntiteEjb.class).create(e);
		
		
		return mapping.findForward("fListeEntite");
	}
	
}
