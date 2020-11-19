<#include "header.ftlh">
<h2>Velg liste for ${bruker.navn} (${bruker.login})</h2>
<ul>
<#list lister as liste>
    <li>
        <a href="liste?liste_id=${liste.liste_id}">${liste.tittel}</a>
    </li>
</#list>
</ul>
<#include "footer.ftlh">
