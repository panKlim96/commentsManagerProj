<#import "parts/common.ftlh" as c>
<@c.page>
    <h5>${username}</h5>
    <form action="/user/profile" method="post">
        <div><label> User Name: <input class="form-control" type="text" name="username" value="${username}"/> </label></div>
        <div><label> Password: <input class="form-control"  type="password" name="password" placeholder="Password"/> </label></div>
        <div><label> Name: <input class="form-control"  type="text" name="name" value="${name}"/> </label></div>
        <div><label> Surname: <input class="form-control"  type="text" name="surname" value="${surname}"/> </label></div>
        <div><label> PassportData: <input class="form-control"  type="number" name="passportData" value="${passportData}"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-2" type="submit"> Save </button>
    </form>
</@c.page>