<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<jsp:include page="/layout/head.jsp" />
<logic:notEmpty name="attribut">
	<html:form action="ModificationIntermediaireAttribut.do">
		<html:hidden name="attribut" property="id" />
		<table>
			<tr>
				<td>Libell&eacute;</td>
				<td><html:text name="attribut" property="nomAttribut" /></td>
			</tr>
			<tr>
				<td>Type</td>
				<td><html:text name="attribut" property="type" /></td>
			</tr>
			<tr>
				<td colspan="2"><html:submit value="Valider" /></td>
			</tr>
		</table>
	</html:form>
</logic:notEmpty>
<html:errors />
<jsp:include page="/layout/foot.jsp" />