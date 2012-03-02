<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<jsp:include page="/layout/head.jsp" />
<logic:iterate id="projet" name="listeProjets">
	<bean:define id='id' name='projet' property='id' />
	<h3>
		<html:link href='Generer.do' paramId='id' paramName='id'>
			<bean:write name="projet" property="nomProjet" />
		</html:link>
	</h3>
</logic:iterate>
<jsp:include page="/layout/foot.jsp" />