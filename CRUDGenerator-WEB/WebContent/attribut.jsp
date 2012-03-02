<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<table width="100%" class="tableau">
	<tr>
		<th>Nom Attribut</th>
		<th>Type</th>
		<th width="25px"></th>
		<th width="25px"></th>
	</tr>
	<logic:iterate id="attribut" name="listeAttribut">
		<tr>
			<td><bean:write name="attribut" property="nomAttribut" /></td>
			<td><bean:write name="attribut" property="type" /></td>
			<td align="center"><html:link paramId="id" paramName="attribut"
					paramProperty="id" action="ModificationAttribut.do">
					<img src="images/modifier.png" />
				</html:link></td>
			<td align="center"><html:link paramId="id" paramName="attribut"
					paramProperty="id" action="SuppressionAttribut.do">
					<img src="images/supprimer.png" />
				</html:link></td>
		</tr>
	</logic:iterate>
</table>
<h3>Ajout d'un attribut :</h3>
<html:form action="AjoutAttribut.do" style="">
	Nom de l'attribut :<br />
	<html:text property="nomAttribut" style="width:100%" />
	<br />
	
	Label de l'attribut :<br />
	<html:text property="label" style="width:100%" />
	<br />
	
	Type de l'attribut :<br />
	<html:select property="type" style="width:100%">
		<html:option value="String">String</html:option>
		<html:option value="Integer">Integer</html:option>
		<html:option value="Boolean">Boolean</html:option>
		<html:option value="Date">Date</html:option>
	</html:select>
	<br />

	<html:checkbox property="unique" /> : Unique <br />
	<html:checkbox property="clePrimaire" /> : Cl&eacute; Primaire <br />
	<html:checkbox property="requis" /> : Requis <br />
	<br />
	<html:submit value="Ajouter" />
</html:form>