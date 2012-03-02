<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<jsp:include page="/layout/head.jsp" />
<b><i><html:errors /></i></b>
<BR>
<bean:define id="{{entite}}" name="{{entite}}" />
<html:form action="/update{{Entite}}.do">
{{FORM_MODIFICATION}}
	<html:submit />
</html:form>
<jsp:include page="/layout/foot.jsp" />