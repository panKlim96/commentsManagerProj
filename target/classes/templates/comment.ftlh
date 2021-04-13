<#import "parts/common.ftlh" as c>

<@c.page>
    <a class="btn btn-primary" data-bs-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Add new comment
    </a>
    <div class="collapse <#if comment??>show</#if>" id="collapseExample">
        <div class="form-group">
            <form method="post">
                <input type="text" class = "form-control mt-2v ${(textError??)?string('is-invalid','')}"
                       value="<#if comment??>${comment.text}</#if>" name="text" placeholder="Введите текст комментария"/>
                <#if textError??>
                    <div class="invalid-feedback">
                        ${textError}
                    </div>
                </#if>
                <input class = "form-control" type="hidden" name="_csrf" value="${_csrf.token}" />
                <button type="submit" class="btn btn-primary mt-2" type="submit"> Add </button>
            </form>
        </div>
    </div>
<div> Comments list </div>
<#list comments as comment>
    <#assign commentTime = .now?datetime>
    <div class="m-2">
        <div class="card-footer text-muted">
            <span>${comment.text}</span>
        </div>
            <i>${commentTime}</i>
            <strong>${comment.authorName}</strong>
    </div>
<#else>
    No comments </else>
</#list>
</@c.page>