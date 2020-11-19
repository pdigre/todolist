<#include "header.ftlh">
<h2>Velg bruker</h2>
<table>
    <tr>
        <th>Id</th>
        <th>Login</th>
        <th>Navn</th>
        <th>Epost</th>
    </tr>
    <#list brukere as bruker>
        <tr>
            <td>${bruker.bruker_id}</td>
            <td><a href="bruker?bruker_id=${bruker.bruker_id}">${bruker.login}</a></td>
            <td>${bruker.navn}</td>
            <td>${bruker.epost}</td>
        </tr>
    </#list>
</table>
<#include "footer.ftlh">
