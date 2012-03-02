package scidy.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.GenerationEjb;
import scidy.utils.BeanLocator;

public class GenererAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		HttpSession session = request.getSession();
		if (session.getAttribute("user") == null)
			return mapping.findForward("login");
		
		
		final int id = Integer.parseInt(request.getParameter("id"));

		BeanLocator.defaultLookup(GenerationEjb.class).generer(id);

		return mapping.findForward("fListeEntite");
	}
	
}
