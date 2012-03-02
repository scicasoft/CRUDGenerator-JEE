package scidy.actions.projets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.ProjetEjb;
import scidy.ejb.TypeBaseEjb;
import scidy.entites.Projet;
import scidy.entites.TypeBase;
import scidy.entites.User;
import scidy.utils.BeanLocator;

public class Liste extends Action{

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
		
		List<Projet> lProjet = BeanLocator.defaultLookup(ProjetEjb.class).findAll((User) session.getAttribute("user"));
		request.setAttribute("listeProjet", lProjet);
		
		List<TypeBase> typeBases = BeanLocator.defaultLookup(TypeBaseEjb.class).findAll();
		request.setAttribute("typeBases", typeBases);
		return mapping.findForward("listeProjet");
	}

}
