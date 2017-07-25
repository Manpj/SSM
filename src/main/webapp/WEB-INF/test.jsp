<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Sample Application</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
    	body { background-color: #eee; font: helvetica; }
    	#container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
    	.green { font-weight: bold; color: green; }
    	.message { margin-bottom: 10px; }
    	label {width:70px; display:inline-block;}
    	.hide { display: none; }
    </style>
  </head>
  <body>
	
	<div id="container">
	
		<br/><br/>
		<hr />
		<h2>Random Person Generator</h2>
		<input type="submit" id="randomPerson" value="Get Random Person" />
		<div id="personResponse"> </div>
	</div>
	
	
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			$('#randomPerson').click(function() {
				$.getJSON('${pageContext.request.contextPath}/test1.do', function(person) {
					$('#personResponse').text(person.name + ', age ' + person.age);
				});
			});
			
			$('#newsletterCheckbox').change(function() {
				toggleFrequencySelectBox();
			})
			
			toggleFrequencySelectBox(); // show/hide box on page load
		});
		
		function toggleFrequencySelectBox() {
			if(!$('#newsletterCheckbox').is(':checked')) {
				$('#frequencySelect').val('');
				$('#frequencySelect').prop('disabled', true);
			} else {
				$('#frequencySelect').prop('disabled', false);
			}
		}
	
	</script>
	
  </body>
</html>