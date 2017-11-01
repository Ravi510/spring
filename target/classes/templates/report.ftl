<html>
    <head>
        <title>Report</title>
        <link href="css/bootstrap.min.css" rel="stylesheet"/>
        <script src="scripts/jquery-2.1.1.js"></script>
        <script src="scripts/bootstrap.min.js"></script>
        <script src="scripts/angular.js"></script>
    </head>
    <body>
    <center><h2>Employees</h2></center>
    <button style="margin-right: 107px;" data-target="#myModal" data-toggle="modal" class="btn btn-sm btn-success pull-right" id="register">
				<span class="glyphicon glyphicon-plus"></span>
	</button>
	<div class="container">
          <table class="table table-bordered">
          	<thead style="background-color:#f5f5f5; color:#333;">
          	<tr>
          		<th>S.No.</th>
          		<th>Emp Id</th>
          		<th>First Name</th>
          		<th>Last Name</th>
          	</tr>
          	</thead>
          	<tbody>
          	<#list employees as employee>
          		<tr>
          			<td align='right'>${employee_index+1}</td>
	          		<td>${employee.id}</td>
	          		<td>${employee.firstname}</td>
	          		<td>${employee.lastname}</td>
          		</tr>
          	</#list>
          	</tbody>
          </table>
          </div>
          <div id="myModal" class="modal fade" role="dialog">
			  <div class="modal-dialog">
			
			    <!-- Modal content-->
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal">&times;</button>
			        <h4 class="modal-title">Employee Details</h4>
			      </div>
			      <form method="POST" action="/add">
			      <div class="modal-body">
			            <div>
			                <label for="id">Employee Id</label>
			                <input type="text" class="form-control col-md-4"
			                       id="id"
			                       name="id" />
			            </div>
			            <div>
			                <label for="firstName">First Name</label>
			                <input type="text" class="form-control col-md-4"
			                       id="firstName"
			                       name="firstName" />
			            </div>
			            <div>
			                <label for="lastName">Last Name</label>
			                <input type="text" class="form-control col-md-4"
			                       id="lastName"
			                       name="lastName" />
			            </div>
			      </div>
			      <div class="modal-footer">
			        <button type="submit" class="btn btn-success">Add</button>
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			      </div>
			      </form>
			    </div>
			
			  </div>
</div>
    <body>
</html>