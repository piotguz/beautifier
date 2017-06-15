<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<body>


<div class="w3-bar w3-blue">
	<div class="w3-bar-item">Test report</div>
	<#list suites as suite>
		<a href="#${suite.name}" class="w3-bar-item w3-button w3-hide-small"><span class="w3-badge w3-red">${suite.failedTestsCount}</span> ${suite.name}</a>
	</#list>
	<a href="javascript:void(0)" class="w3-bar-item w3-button w3-right w3-hide-large w3-hide-medium" onclick="myFunction()">&#9776;</a>
</div> 


  <#list suites as suite>
	<article class="w3-container">
		<h2>${suite.name}</h2>
		<#list suite.tests as test>
			<button onclick="myFunction('${test.name}')" class="w3-button w3-grey w3-block w3-left-align"><span class="w3-badge w3-red">${test.failedMethodsCount}</span> ${test.name}, duration: ${test.duration}</button>
			<div id="${test.name}" class="w3-hide w3-container">
				<#list test.methods as method>
					    <p>
						<#if method.status == 'Failed'>
							<i class="fa fa-exclamation-circle" style="color:red"></i>
						<#elseif method.status == 'Passed'>
							<i class="fa fa-check-circle" style="color:green"></i>
						<#else>
							<i class="fa fa-warning" style="color:orange"></i>
						</#if>
					${method.qName}</p>
				</#list>
			</div>
		</#list>
	</article>
  </#list>
  
  
  
</div>

<footer class="w3-container">
	<p>Created by ${user}@${host} at ${createdAt}</p>
</footer>
<script>
function myFunction(id) {
    var x = document.getElementById(id);
    if (x.className.indexOf("w3-show") == -1) {
        x.className += " w3-show";
    } else {
        x.className = x.className.replace(" w3-show", "");
    }
}

</script>

</body>
</html>