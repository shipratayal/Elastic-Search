<%@ page import="com.demo.Event" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'event.label', default: 'Event')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<a href="#list-event" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                            default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-event" class="content scaffold-list" role="main">
    <div style="float: right">
        <g:form action="eventSearch" controller="elasticSearch">
            <input type="text" placeholder="Search" name="search" id="search"/>
            <input type="submit" value="Search"/>
        </g:form>
    </div>

    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="description"
                              title="${message(code: 'event.description.label', default: 'Description')}"/>

            <g:sortableColumn property="title" title="${message(code: 'event.title.label', default: 'Title')}"/>
            <g:sortableColumn property="address" title="${message(code: 'event.address.label', default: 'Address')}"/>
            <g:sortableColumn property="emailAddress"
                              title="${message(code: 'event.emailAddress.label', default: 'EmailAddress')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${eventInstanceList}" status="i" var="eventInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                %{--<td><g:link action="show"--}%
                %{--id="${eventInstance?.id}">${fieldValue(bean: eventInstance, field: "description")}</g:link></td>--}%
                <td><g:link action="show"
                            id="${eventInstance?.id}">${eventInstance.description.encodeAsHTML()}</g:link></td>

                <td>${fieldValue(bean: eventInstance, field: "title")}</td>
                <td>${fieldValue(bean: eventInstance, field: "address")}</td>
                <td>${fieldValue(bean: eventInstance, field: "emailAddress")}</td>

            </tr>
        </g:each>
        </tbody>

        <div class="pagination">
            <g:paginate total="${eventInstanceCount ?: 0}"/>
        </div>

        <div>
            <label>Total Found :${total}</label>
            <label>Count Hits :${countHits}</label>
        </div>
    </table>
</body>
</html>
