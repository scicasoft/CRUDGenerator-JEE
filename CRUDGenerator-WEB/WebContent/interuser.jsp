<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="scidy.entites.Projet"%>

<%@taglib prefix="html" uri="http://struts.apache.org/tags-html"%>
<%@taglib prefix="logic" uri="http://struts.apache.org/tags-logic"%>
<%@taglib prefix="bean" uri="http://struts.apache.org/tags-bean"%>

<jsp:include page="/layout/head.jsp" />
<a href="Welcome.do">Projets</a>
&gt;
<%=((Projet) session.getAttribute("projet")).getNomProjet()%><br />
<br />
<div id="gauche">
	<div id="main">
		<div id="sidetreecontrol">
			<a href="?#">Fermer tout</a> | <a href="?#">Tout afficher</a>
		</div>
		<ul id="browser" class="filetree treeview-famfamfam">
			<li><span class="folder"><%=((Projet) session.getAttribute("projet")).getNomProjet()%></span></li>
			<li><span class="folder"><%=((Projet) session.getAttribute("projet")).getNomProjet()%>-EJB</span>
				<ul>
					<li><span class="folder">ejbModule</span>
						<ul>
							<li><span class="folder">META-INF</span>
								<ul>
									<li><span class="file">MANIFEST.MF</span></li>
									<li><span class="file">persistence.xml</span></li>
								</ul></li>
							<li><span class="folder">defaultpackage</span>
								<ul>
									<li><span class="folder">ejb</span>
										<ul>
											<logic:iterate id="entite" name="listeEntite">
												<li><span class="file"><bean:write name="entite"
															property="nomEntite" />EjbBean.java</span></li>
												<li><span class="file"><bean:write name="entite"
															property="nomEntite" />Ejb.java</span></li>
											</logic:iterate>
										</ul></li>
									<li><span class="folder">entites</span>
										<ul>
											<logic:iterate id="entite" name="listeEntite">
												<li><span class="file"><bean:write name="entite"
															property="nomEntite" />.java</span></li>
											</logic:iterate>
										</ul></li>
									<li><span class="folder">utils</span>
										<ul>
											<li><span class="file">AbstractFacade.java</span></li>
											<li><span class="file">BeanLocator.java</span></li>
										</ul></li>
								</ul></li>
						</ul></li>
				</ul></li>
			<li><span class="folder"><%=((Projet) session.getAttribute("projet")).getNomProjet()%>-WEB</span>
				<ul>
					<li><span class="folder">src</span>
						<ul>
							<li><span class="folder">defaultpackage</span>
								<ul>
									<li><span class="folder">actions</span>
										<ul>
											<logic:iterate id="entite" name="listeEntite">
												<li><span class="folder"><bean:write
															name="entite" property="nomEntite" /></span>
													<ul>
														<li><span class="file">Delete<bean:write
																	name="entite" property="nomEntite" />Action.java
														</span></li>
														<li><span class="file">FormUpdate<bean:write
																	name="entite" property="nomEntite" />Action.java
														</span></li>
														<li><span class="file">List<bean:write
																	name="entite" property="nomEntite" />Action.java
														</span></li>
														<li><span class="file">New<bean:write
																	name="entite" property="nomEntite" />Action.java
														</span></li>
														<li><span class="file">Update<bean:write
																	name="entite" property="nomEntite" />Action.java
														</span></li>
													</ul></li>
											</logic:iterate>
										</ul></li>
									<li><span class="folder">entitiesForm</span>
										<ul>
											<logic:iterate id="entite" name="listeEntite">
												<li><span class="folder"><bean:write
															name="entite" property="nomEntite" /></span>
													<ul>
														<li><span class="file"><bean:write
																	name="entite" property="nomEntite" />Form.java</span></li>
													</ul></li>
											</logic:iterate>
										</ul></li>
								</ul></li>
							<li><span class="file">MessageResources.properties</span></li>
							<li><span class="file">messages.properties</span></li>
						</ul></li>
					<li><span class="folder">WebContent</span>
						<ul>
							<li><span class="folder">css</span></li>
							<li><span class="folder">images</span></li>
							<li><span class="folder">js</span></li>
							<li><span class="folder">layout</span></li>
							<li><span class="folder">META-INF</span>
								<ul>
									<li><span class="file">MANIFEST.MF</span></li>
								</ul></li>
							<li><span class="folder">WEB-INF</span>
								<ul>
									<li><span class="folder">src</span>
										<ul>
											<li><span class="file">build.xml</span></li>
										</ul></li>
									<li><span class="file">struts-config.xml</span></li>
									<li><span class="file">struts-config-entites.xml</span></li>
									<li><span class="file">validation.xml</span></li>
									<li><span class="file">web.xml</span></li>
								</ul></li>
							<logic:iterate id="entite" name="listeEntite">
								<li><span class="folder"><bean:write name="entite"
											property="nomEntite" /></span>
									<ul>
										<li><span class="file">formulaire.jsp</span></li>
										<li><span class="file">index.jsp</span></li>
										<li><span class="file">modifier.jsp</span></li>
										<li><span class="file">show.jsp</span></li>
									</ul></li>
							</logic:iterate>
							<li><span class="file">index.jsp</span></li>
						</ul></li>
				</ul></li>
		</ul>
	</div>
</div>
<div id="droite">
	<div id="boutons">
		<html:form action="AjoutEntite.do">
			Ajouter une entit&eacute; :
			<html:text property="nomEntite" />
			<html:submit value="Valider" />
		</html:form>
	</div>
	<div id="entites">
		<div id="liste">
			<table width="100%" class="tableau">
				<logic:iterate id="entite" name="listeEntite">
					<tr>
						<td><html:link paramId="id" paramName="entite"
								paramProperty="id" action="ListeDesAttributs.do"
								onclick="gestion_entite($(this));return false;">
								<bean:write name="entite" property="nomEntite" />
							</html:link></td>
						<td align="center" width="25px"><html:link paramId="id"
								paramName="entite" paramProperty="id"
								action="ModificationEntite.do">
								<img src="images/modifier.png" />
							</html:link></td>
						<td align="center" width="25px"><html:link paramId="id"
								paramName="entite" paramProperty="id"
								action="SuppressionEntite.do">
								<img src="images/supprimer.png" />
							</html:link></td>
					</tr>
				</logic:iterate>
			</table>
		</div>
		<div id="gestion_entite"></div>
	</div>
	<bean:define id='id' name='projet' property='id' />
	<div style="text-align: right; float: right;">
		<h3>
			<html:link href='Generer.do' paramId='id' paramName='id'>
			Generer le projet
		</html:link>
		</h3>
	</div>
</div>
<jsp:include page="/layout/foot.jsp" />

<script type="text/javascript">
	function gestion_entite(link) {
		$("#gestion_entite").load(link.attr("href"));
		return false;
	}

	$(".tableau").attr("cellpadding", "3px").attr("cellspacing", "1px");

	$(".tableau tr").addClass("tableau_ligne");

	$("#browser").treeview({
		toggle : function() {
			console.log("%s was toggled.", $(this).find(">span").text());
		},
		collapsed : true,
		animated : "medium",
		control : "#sidetreecontrol",
		persist : "location"
	});
</script>