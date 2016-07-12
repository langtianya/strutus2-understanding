<%-- 
    nonFieldValidatorsExample.jsp
    
    @author tm_jee
    @version $Date: 2012-10-19 20:49:39 +0200 (Fri, 19 Oct 2012) $ $Id: nonFieldValidatorsExample.jsp 1400220 2012-10-19 18:49:39Z jogep $
--%>


<%@taglib prefix="s" uri="/struts-tags" %>

<html>
<head>
	<title>Struts2 Showcase - Validation - Non Field Validator Example</title>
	<s:head/>
</head>
<body>

<div class="page-header">
	<h1>Non Field Validator Example</h1>
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">

			<!-- START SNIPPET: nonFieldValidatorsExample -->
			<s:actionerror/>

			<s:form method="POST" action="submitNonFieldValidatorsExamples" namespace="/validation">
				<s:textfield name="someText" label="Some Text"/>
				<s:textfield name="someTextRetype" label="Retype Some Text"/>
				<s:textfield name="someTextRetypeAgain" label="Retype Some Text Again"/>
				<s:submit label="Submit" cssClass="btn btn-primary"/>
			</s:form>


			<!--  END SNIPPET: nonFieldValidatorsExample -->


			<s:include value="footer.jsp"/>
		</div>
	</div>
</div>
</body>
</html>

