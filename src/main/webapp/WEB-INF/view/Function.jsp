<%@ page import="com.lawfalfirstspring.lawfalspringfirst.model.tbl_function" %>
<%@ page import="java.util.List" %>
<%@ page import="com.lawfalfirstspring.lawfalspringfirst.model.tbl_roles" %>

<% List<tbl_function> functionList = (List<tbl_function>) request.getAttribute("function");
   List<tbl_roles> rolesList = (List<tbl_roles>) request.getAttribute("roles");
%>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.82.0">
    <title>Checkout example · Bootstrap v5.0</title>

    <!-- CSS only -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

    <!-- JavaScript Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>

    <!-- Bootstrap core CSS -->

    <style>
        .container {
            max-width: 960px;
        }

        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>


    <!-- Custom styles for this template -->
</head>
<body class="bg-light">

<div class="container-fluid">
    <div class="py-5 text-center">
        <h2>Test Out Project Laras</h2>
    </div>

    <div class="row d-flex justify-content-center">
        <div class="col-md-4">
            <h6>Tabel Function</h6>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Function Id</th>
                    <th scope="col">Function Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Created_Date</th>
                </tr>
                </thead>
                <tbody>

                <% for(tbl_function data : functionList){ %>

                <tr>
                    <th scope="row"> <%=data.getId()%> </th>
                    <td> <%=data.getName()%> </td>
                    <td> <%=data.getDescription()%> </td>
                    <td> <%=data.getCreatedDate()%> </td>
                </tr>

                <%} %>
                </tbody>
            </table>
        </div>

        <div class="col-md-8">
            <h6>Tabel Roles</h6>
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th scope="col">Role Id</th>
                    <th scope="col">Role Name</th>
                    <th scope="col">Description</th>
                    <th scope="col">Created_Date</th>
                    <th scope="col">Map_Functions</th>
                </tr>
                </thead>
                <tbody>

                <% for(tbl_roles data : rolesList){ int i=0; %>

                <tr>
                    <th scope="row"> <%=data.getId()%> </th>
                    <td> <%=data.getName()%> </td>
                    <td> <%=data.getDescription()%> </td>
                    <td> <%=data.getCreatedDate()%> </td>
                    <td> <% for(tbl_function datas : data.getRolesFunctions()){ i++; %>
                         <%= i %>. <%=datas.getName()%> <br>
                         <%} %>
                    </td>
                </tr>

                <%} %>

                </tbody>
            </table>
        </div>

    </div>

    <div class="row d-flex justify-content-center mt-5 border-top pt-5">
        <div class="col-md-4">
            <h6>Insert Roles</h6>
            <form method="post" action="<% request.getContextPath(); %>/Roles/save">
                <div class="form-row">
                    <div class="col-md-12 mb-3">
                        <label>Role Id</label>
                        <input type="text" name="id" class="form-control" required>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label>Role Name</label>
                        <input type="text" name="name" class="form-control" required>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label>Description</label>
                        <input type="text" name="desc" class="form-control" required>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit" value="submit">Submit form</button>
            </form>
        </div>
        <div class="col-md-4">
            <h6>Insert Function</h6>
            <form method="post" action="<% request.getContextPath(); %>/Function/save">
                <div class="form-row">
                    <div class="col-md-12 mb-3">
                        <label>Function Id</label>
                        <input type="text" name="id" class="form-control" required>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label>Function Name</label>
                        <input type="text" name="name" class="form-control" required>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label>Last name</label>
                        <input type="text" name="desc" class="form-control" required>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit" value="submit">Submit form</button>
            </form>
        </div>
        <div class="col-md-4">
            <h6>Map Role_Function</h6>
            <form method="post" action="<% request.getContextPath(); %>/Roles/save/roles">
                <div class="form-row">
                    <div class="col-md-12 mb-3">
                        <label>Role</label>
                        <select class="form-select" name="roles" aria-label="Default select example">
                            <% for(tbl_roles data : rolesList){ %>
                            <option value="<%=data.getId()%>"> <%=data.getName()%> </option>
                            <%} %>
                        </select>
                    </div>
                    <div class="col-md-12 mb-3">
                        <label>Function</label>
                        <select class="form-select" name="function" aria-label="Default select example">
                            <% for(tbl_function data : functionList){ %>
                            <option value="<%=data.getId()%>"> <%=data.getName()%> </option>
                            <%} %>
                        </select>
                    </div>
                </div>
                <button class="btn btn-primary" type="submit" value="submit">Submit form</button>
            </form>
        </div>
    </div>

    <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2017 - 2021 EZ PEEZY</p>
    </footer>
</div>


<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function () {
        'use strict'

        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.querySelectorAll('.needs-validation')

        // Loop over them and prevent submission
        Array.prototype.slice.call(forms)
            .forEach(function (form) {
                form.addEventListener('submit', function (event) {
                    if (!form.checkValidity()) {
                        event.preventDefault()
                        event.stopPropagation()
                    }

                    form.classList.add('was-validated')
                }, false)
            })
    })()
</script>
</body>
</html>
