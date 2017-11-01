<html>
    <head>
    	<link href="css/bootstrap.min.css" rel="stylesheet"/>
        <title>Welcome</title>
    </head>
    <body>
        <form method="POST" action="/add">
        <center><h2>Employee Details</h2></center>
        <div class="row">
        <div class="col-md-4"></div>
        <div class="col-md-4">
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
            <div class="col-md-4"></div>
            </div><br>
            <center><button type="submit" class="btn btn-default">Add</button></center>
        </form>
    <body>
</html>