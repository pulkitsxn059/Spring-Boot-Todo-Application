<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
<title>Yahoo!!</title>
</head>
<body>
    <div class="container">
        <form:form method="post" modelAttribute ="todo">
            <form:hidden  path="id" />
            <fieldset  class="form-group" >
            <form:label path="desc"> Description : </form:label>
            <form:input type="text" path="desc" class="form-control" required="required" />
            </fieldset>
            <fieldset  class="form-group" >
             <form:label path="desiredDate"> Target Date : </form:label>
             <form:input type="text" path="desiredDate" class="form-control" required="required" />
             <form:errors path="desiredDate" CssClass="text-warning" />
             </fieldset>
        <button type="submit" class="btn btn-success"> Submit </button>
        </form:form>
    </div>
</body>
        <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <script src="webjars/bootstrap-datepicker/1.0.1/js/bootstrap-datepicker.js"></script>
	    <script>
        		$('#desiredDate').datepicker({
        			format : 'dd/mm/yyyy'
        		});
        	</script>

</html>