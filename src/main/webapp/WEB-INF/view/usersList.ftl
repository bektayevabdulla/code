<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Users List</h1>
<table>
    <tr>
        <th align="center">  Id  </th>
        <th align="center">  Name  </th>
        <th align="center">  Surname  </th>
        <th align="center">  Email  </th>
        <th align="center">  Login  </th>
        <th align="center">  Password  </th>
        <th align="center">  Delete  </th>
        <th align="center">  Update  </th>
    </tr>
    <#list users as user>
        <tr>
            <td align="center"><button type="submit"><a href ="user/${user.login}">${user.id}</a></button></td>
            <td align="center">${user.name}</td>
            <td align="center">${user.surname}</td>
            <td align="center">${user.email}</td>
            <td align="center">${user.login}</td>
            <td align="center">${user.password}</td>
            <td align="center"><button type="submit"><a href="/AbdullaGameArt_war/delete/${user.login}">Delete</a></button></td>
            <td align="center"><button type="submit"><a href="/AbdullaGameArt_war/update/${user.login}">Update</a></button></td>
        </tr>
    </#list>
</table>
<button type="submit"><a href="/AbdullaGameArt_war/addUser">Create</a></button>
<button type="submit"><a href="/AbdullaGameArt_war/">Sign Out</a></button>
</body>
</html>