<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<jsp:include page="/layout/head.jsp" />
<div id="droite">
	<h3>Ajout d'un projet</h3>
	<html:form action="AjoutProjet.do">
		Nom du projet : <br />
		<html:text property="nomProjet" style="width:100%" />
		<br />
		
		Nom de la base de donnees : <br />
		<html:text property="nomBase" style="width:100%" />
		<br />
		
		Source de donnees : <br />
		<html:text property="sourceDonneesDs" style="width:100%" />
		<br />
		
		Racine du projet : <br />
		<html:text property="racineProjet" style="width:100%" />
		<br />
		
		Type de base de donnees : <br />
		<html:select property="typeBaseId" style="width:100%">
			<html:options collection="typeBases" property="id"
				labelProperty="driver" />
		</html:select>

		<br />
		<html:submit value="Valider" />
	</html:form>
</div>
<div id="gauche">
	<h3>Mes projets</h3>
	<div id="liste" style="width: 100%">
		<table width="95%" class="tableau">
			<logic:iterate id="projet" name="listeProjet">
				<tr>
					<td><html:link paramId="id" paramName="projet"
							paramProperty="id" action="ListeDesEntites.do">
							<bean:write name="projet" property="nomProjet" />
						</html:link></td>
					<td align="center" width="25px"><html:link paramId="id"
							paramName="projet" paramProperty="id"
							action="ModificationProjet.do">
							<img src="images/modifier.png" />
						</html:link></td>
					<td align="center" width="25px"><html:link paramId="id"
							paramName="projet" paramProperty="id"
							action="SuppressionProjet.do">
							<img src="images/supprimer.png" />
						</html:link></td>
				</tr>
			</logic:iterate>
		</table>
	</div>
</div>
<jsp:include page="/layout/foot.jsp" />