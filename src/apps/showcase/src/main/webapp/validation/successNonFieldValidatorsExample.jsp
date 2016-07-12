<%--
    successNonFieldValidatorsExample.jsp
    
    @author tm_jee
    @version $Date: 2012-10-19 20:49:39 +0200 (Fri, 19 Oct 2012) $ $Id: successNonFieldValidatorsExample.jsp 1400220 2012-10-19 18:49:39Z jogep $
--%>


<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>Struts2 Showcase - Validation - Success Non Field Validators Example</title>
	<s:head/>
</head>
<body>

<div class="page-header">
	<h1>Success !</h1>
</div>

<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">

			<table class="table table-striped table-bordered table-hover table-condensed">
            <tr>
                <td>Some Text: </td>
                <td><s:property value="someText" /></td>
            </tr>
            <tr>
                <td>Some Text Retyped: </td>
                <td><s:property value="someTextRetype" /></td>
            </tr>
            <tr>
                <td>Some Text Retyped Again: </td>
                <td><s:property value="someTextRetypeAgain" /></td>
            </tr>
        </table>
        
        <s:include value="footer.jsp" />
		</div>
	</div>
</div>
</body>
</html>
