<%-- 
    successVisitorValidatorsExample.jsp
    
    @author tm_jee
    @version $Date: 2012-10-19 20:49:39 +0200 (Fri, 19 Oct 2012) $ $Id: successVisitorValidatorsExample.jsp 1400220 2012-10-19 18:49:39Z jogep $
--%>


<%@taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
	<title>Struts2 Showcase - Validation - Success Visitor Validators Exameple</title>
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
                <td>User Name:</td>
                <td><s:property value="user.name" /></td>
            </tr>
            <tr>
                <td>User Age:</td>          
                <td><s:property value="user.age" /></td>
            </tr>
            <tr>
                <td>User Birthday:</td>
                <td><s:property value="user.birthday" /></td>
            </tr>
        </table>
        
        <s:include value="footer.jsp" />

		</div>
	</div>
</div>
</body>
</html>
