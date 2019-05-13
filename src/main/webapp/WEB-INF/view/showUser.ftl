<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Info</title>

</head>
<body>
<div align="center" style="margin-top: 10% ">
<h1><td>${user.name}</td></h1>
<button type="submit"><a href="/AbdullaGameArt_war/update/${user.login}">Edit</a></button>
<br>
<br>
<button type="submit"><a href="/AbdullaGameArt_war/message/inbox/${user.login}"> Inbox </a></button><div>         </div>
<button type="submit"><a href="/AbdullaGameArt_war/message/outbox/${user.login}"> Outbox </a></button>
<br>
<button type="submit"><a href="/AbdullaGameArt_war/message/${user.login}"> Messanger </a></button>
<br>
<br>
<button type="submit"><a href="/AbdullaGameArt_war/">Sign Out</a></button>
</div>
</body>

</html>