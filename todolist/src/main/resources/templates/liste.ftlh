<#include "header.ftlh">
<h2>Liste: ${liste.tittel}</h2>

<form target="_self" method="get">
<input type=hidden name="liste_id" value="${liste.liste_id}"/>
Filter:<input type="text" name="filter" value="${filter}" />
<input type="submit" value="Søk"/>  
<a href="liste?action=duplikater&liste_id=${liste.liste_id}">Fjerne duplikater</a>
<hr>
<table>
    <tr>
        <th>Id</th>
        <th>Beskrivelse</th>
        <th>er Ferdig</th>
        <th>Kategorier</th>
        <th>...</th>
    </tr>
    <#list punkter as punkt>
        <tr>
            <td>${punkt.punkt_id}</td>
            <td>${punkt.tekst}</td>
            <td>${punkt.erFerdig?string('ja', 'nei')}</td>
            <td>${punkt.kategorier}</td>
            <td>
            <a href="liste?action=del&liste_id=${punkt.liste_id}&punkt_id=${punkt.punkt_id}">Slett</a>
            <a href="punkt?liste_id=${punkt.liste_id}&punkt_id=${punkt.punkt_id}">Endre</a>
            </td>
        </tr>
    </#list>
    <tr>
        <td></td>
        <td><input type="text" name="add" value="" /></td>
        <td></td>
        <td></td>
        <td><input type="button" value="Legge til ny" onclick="form.submit();"/></td>
    </tr>
    </table>
</form>
<#include "footer.ftlh">
