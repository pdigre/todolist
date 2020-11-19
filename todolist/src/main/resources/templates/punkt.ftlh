<#include "header.ftlh">
<h2>Punkt:${liste.tittel}</h2>
<form target="_self" method="get">
<input type=hidden name="liste_id" value="${liste.liste_id}"/>
<input type=hidden name="punkt_id" value="${punkt.punkt_id}"/>
<table>
    <tr><th>Id</th><td>${punkt.punkt_id}</td></tr>
    <tr><th>Beskrivelse</th><td><input type="text" name="tekst" value="${punkt.tekst}" /></td></tr>
</table>
<input type="submit" value="Lagre"/>
<a href="liste?liste_id=${punkt.liste_id}">Tilbake</a>
<h3>Kategorier</h3>
<table>
    <#list kategorier as kategori>
        <tr>
            <td>${kategori}</td>
            <td><a href="punkt?del=${kategori}&liste_id=${punkt.liste_id}&punkt_id=${punkt.punkt_id}">Slett</a></td>
        </tr>
    </#list>
        <tr>
            <td><input type="text" name="add" value="" /></td>
            <td><input type="button" value="Legge til" onclick="form.submit();"/></td>
        </tr>
    </table>
<#include "footer.ftlh">
