<%@ taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>
<%@ taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@ taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@ taglib prefix="nested" uri="http://struts.apache.org/tags-nested"%>
<jsp:include page="/layout/head.jsp" />
<html:errors />
<BR>
<html:form action="/new{{Entite}}.do">
{{FORM_AJOUT}}
	<html:submit />
</html:form>
<jsp:include page="/layout/foot.jsp" />