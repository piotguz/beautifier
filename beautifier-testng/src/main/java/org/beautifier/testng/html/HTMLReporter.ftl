<!DOCTYPE html>
<html>
<title>W3.CSS</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<body>

<div class="w3-container">
  <h2>Test report</h2>
  <p>Created by ${user}@${host} at ${createdAt}</p>

  <#list suites as suite>

    <div class="w3-card-4" style="width:50%;">
      <header class="w3-container w3-blue">
        <h3>${suite.name}</h3>
      </header>

      <div class="w3-container">
		<#list suite.tests as test>
			<p>${test.name}</p>
			<ul class="w3-ul">
				<#list test.methods as method>
					<#if method.status == 'Failed'>
						<li class="w3-red">[${method.status}] ${method.methodQName}</li>
					<#else>
						<li>[${method.status}] ${method.methodQName}</li>
					</#if>
					
					
				</#list>
			</ul>
		</#list>
      </div>

      <footer class="w3-container w3-blue">
        <h5>Footer</h5>
      </footer>
    </div>
  </#list>
</div>

</body>
</html>