package scidy.actions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import scidy.ejb.UserEjb;
import scidy.utils.BeanLocator;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		final String pseudo = request.getParameter("pseudo");
		final String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		int idUser = BeanLocator.defaultLookup(UserEjb.class).existe(pseudo, password);
		if (idUser != 0)
		{
			session.setAttribute("user", BeanLocator.defaultLookup(UserEjb.class).find(idUser));
			return mapping.findForward("welcome");
		} else {
			return mapping.findForward("login");
		}
	}

}
