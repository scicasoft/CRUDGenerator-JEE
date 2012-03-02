package scidy.actions.projets;

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

public class Suppression extends Action{

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
		
		int id = Integer.parseInt(request.getParameter("id"));
		Projet projet = new Projet(id);
		BeanLocator.defaultLookup(ProjetEjb.class).remove(projet);
		return mapping.findForward("fSuppressionProjet");
	}

}
