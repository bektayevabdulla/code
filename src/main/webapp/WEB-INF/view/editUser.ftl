<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div align="center" style="margin-top: 10% ">
<form name="user" action="/AbdullaGameArt_war/updateUser" method="post">
    <p>Name</p>
    <input title="Name" type="text" name="name" value="${user.name}">
    <p>Surname</p>
    <input title="Surname" type="text" name="surname" value="${user.surname}">
    <p>Email</p>
    <input title="Email" type="text" name="email" value="${user.email}">
    <p>Login</p>
    <input title="Login" type="text" name="login" value="${user.login}">
    <p>Password</p>
    <input title="Password" type="text" name="password" value="">
    <br>
    <br>
    <button><a href="/AbdullaGameArt_war/user/${user.login}">Back</a></button><input type="submit" value="OK">
</form>
</div>
</body>
</html>