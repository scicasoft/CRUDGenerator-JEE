package scidy.actions.projets;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.ProjetEjb;
import scidy.entites.User;
import scidy.form.ProjetForm;
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
		
		ProjetForm p = (ProjetForm)form;
		p.setUserId(((User) session.getAttribute("user")).getId());
		p.setId(BeanLocator.defaultLookup(ProjetEjb.class).nextId());
		
		BeanLocator.defaultLookup(ProjetEjb.class).create(p.toProjetEJB());
		return mapping.findForward("fListeProjet");
	}

}
