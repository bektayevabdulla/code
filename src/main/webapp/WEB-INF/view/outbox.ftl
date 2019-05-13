<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div align="center" style="margin-top: 15% ">
<h1>${login}</h1>
    <br>
<table>
    <tr>
        <th>Login To</th>
        <th>Message</th>
    </tr>
    <#list mails as mail>
    <tr>
        <td>${mail.loginto}</td><td>${mail.message}</td>
    </tr>
    </#list>
</table>
    <button><a href="/AbdullaGameArt_war/user/${login}">Back</a></button>
</div>
</body>
</html>