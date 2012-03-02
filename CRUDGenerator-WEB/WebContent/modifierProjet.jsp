<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<jsp:include page="/layout/head.jsp" />
<logic:notEmpty name="projet">
	<html:form action="ModificationIntermediaireProjet.do">
		<html:hidden name="projet" property="id" />
		<table>
			<tr>
				<td>Libell&eacute;</td>
				<td><html:text name="projet" property="nomProjet" /></td>
			</tr>
			<tr>
				<td colspan="2"><html:submit value="Valider" /></td>
			</tr>
		</table>
	</html:form>
</logic:notEmpty>
<html:errors />
<jsp:include page="/layout/foot.jsp" />