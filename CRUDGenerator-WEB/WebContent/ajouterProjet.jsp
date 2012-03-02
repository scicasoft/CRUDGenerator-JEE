<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<jsp:include page="/layout/head.jsp" />
<div id="droite">
	<html:form action="AjoutProjet.do">
		<html:text property="nomProjet" />
		<html:submit value="Valider" />
	</html:form>
</div>
<jsp:include page="/layout/foot.jsp" />