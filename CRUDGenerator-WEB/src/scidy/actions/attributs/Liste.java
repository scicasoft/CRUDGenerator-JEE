package scidy.actions.attributs;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.AttributEjb;
import scidy.ejb.EntiteEjb;
import scidy.ejb.TypeBaseEjb;
import scidy.entites.Attribut;
import scidy.entites.Entite;
import scidy.entites.TypeBase;
import scidy.utils.BeanLocator;

public class Liste extends Action{
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return mapping.findForward("login");
		Entite entite;
		if (request.getParameter("id") != null) {
			Integer entite_id = Integer.parseInt(request.getParameter("id"));
			entite = BeanLocator.defaultLookup(EntiteEjb.class).find(entite_id);
			session.setAttribute("entite", entite);
		} else{
			entite = (Entite) session.getAttribute("entite");
		}
		
		List<Attribut> lAttribut = BeanLocator.defaultLookup(AttributEjb.class).findAll(entite);
		request.setAttribute("listeAttribut", lAttribut);
		
		return mapping.findForward("listeAttribut");
	}
}
