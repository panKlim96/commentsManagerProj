<#import "parts/common.ftlh" as c>
<@c.page>
    List of users
<table>
    <thead>
    <tr>
        <th>Username</th>
        <th>Name</th>
        <th>Surname</th>
        <th>PassportData</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td>${user.name}</td>
            <td>${user.surname}</td>
            <td>${user.passportData}</td>
            <td><#list user.roles as role> ${role}<#sep>, </#list></td>
            <td><a href="/user/${user.id}">edit</a></td>
        </tr>
    </#list>
    </tbody>
</table>
</@c.page>