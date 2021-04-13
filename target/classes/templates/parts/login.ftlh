<#macro login path>
    <form action="${path}" method="post">
        <div  class="col-sm-4">
            <label class="form-label"> User Name:</label>
            <div>
                <input class="form-control"  type="text" name="username"/>
            </div>
        </div>
        <div  class="col-sm-4">
            <label class="form-label"> Password:</label>
            <div>
                <input class="form-control" width="1" type="password" name="password" aria-describedby="passwordHelpInline"/>
            </div>
        </div>
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <a class="mt-2" href="/registration">Add new user</a>
        <button type="submit" class="btn btn-primary  mt-2" type="submit"> Sign In </button>
    </form>
</#macro>

<#macro loginNotExistedUser path>
    <form action="${path}" method="post">
        <div>
            <label>User Name: </label>
            <div class="col-sm-6">
                <input type="text" name="username"
                                    class="form-control ${(usernameError??)?string('is-invalid','')}"
                                    placeholder="User name"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
        </div>
        <div>
            <label>Password: </label>
            <div class="col-sm-6">
                <input type="password" name="password"
                                 class="form-control ${(passwordError??)?string('is-invalid','')}"
                                 placeholder="Password"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <div>
            <label> Name:</label>
            <div class="col-sm-6">
               <input type="text" name="name"
                             class="form-control ${(nameError??)?string('is-invalid','')}"
                             placeholder="Name"/>
                <#if nameError??>
                    <div class="invalid-feedback">
                        ${nameError}
                    </div>
                </#if>
            </div>
        </div>
        <div>
            <label>Surname:</label>
            <div class="col-sm-6">
                <input type="text" name="surname"
                                class="form-control ${(surnameError??)?string('is-invalid','')}"
                                placeholder="Surname"/>
                <#if surnameError??>
                    <div class="invalid-feedback">
                        ${surnameError}
                    </div>
                </#if>
            </div>
        </div>
        <div>
            <label>PassportData:</label>
            <div class="col-sm-6">
                <input type="number" name="passportData"
                                     class="form-control ${(passportDataError??)?string('is-invalid','')}"
                                     placeholder="Passport data"/>
                <#if passportDataError??>
                    <div class="invalid-feedback">
                        ${passportDataError}
                    </div>
                </#if>
            </div>
        </div>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary mt-2" type="submit"> Sign In </button>
    </form>
</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <button type="submit" class="btn btn-primary ml-2 ml-sm-0" type="submit"> Sign Out </button>
    </form>
</#macro>
