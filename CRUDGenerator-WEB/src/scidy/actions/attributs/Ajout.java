package scidy.actions.attributs;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.AttributEjb;
import scidy.ejb.EntiteEjb;
import scidy.entites.Attribut;
import scidy.entites.Entite;
import scidy.utils.BeanLocator;

public class Ajout extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return mapping.findForward("login");

		Attribut attribut = new Attribut();
		attribut.setEntite((Entite) session.getAttribute("entite"));
		attribut.setNomAttribut(request.getParameter("nomAttribut"));
		attribut.setId(BeanLocator.defaultLookup(AttributEjb.class).nextId());
		attribut.setLabel(request.getParameter("label"));
		attribut.setType(request.getParameter("type"));

		if (request.getParameter("requis") == null)
			attribut.setRequis(false);
		else
			attribut.setRequis(true);
		if (request.getParameter("clePrimaire") == null)
			attribut.setClePrimaire(false);
		else
			attribut.setClePrimaire(true);
		if (request.getParameter("unique") == null)
			attribut.setUnique(false);
		else
			attribut.setUnique(true);

		BeanLocator.defaultLookup(AttributEjb.class).create(attribut);

		return mapping.findForward("fListeEntite");
	}
}
