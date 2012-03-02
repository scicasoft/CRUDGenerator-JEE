<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<jsp:include page="/layout/head.jsp" />
<h1> liste des {{Entite}}</h1>
<a href="add{{Entite}}.do">Ajouter {{Entite}}</a>
<table cellpadding="5px" cellspacing="5px">
	<tr>
{{EN_TETE_LISTE_VUE}}
		<td></td>
		<td></td>
	</tr>
	<logic:iterate id="{{entite}}" name="list{{Entite}}">
{{CORPS_LISTE_VUE}}
	</logic:iterate>
</table>

<jsp:include page="/layout/foot.jsp" />