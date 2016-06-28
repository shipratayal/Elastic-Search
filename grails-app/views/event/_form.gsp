<%@ page import="com.demo.Event" %>



<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'description', 'error')} required">
    <label for="description">
        <g:message code="event.description.label" default="Description"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="description" required="" value="${eventInstance?.description}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'title', 'error')} required">
    <label for="title">
        <g:message code="event.title.label" default="Title"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="title" required="" value="${eventInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'title', 'error')} required">
    <label for="title">
        <g:message code="event.address.label" default="address"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="address" required="" value="${eventInstance?.address}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: eventInstance, field: 'title', 'error')} required">
    <label for="title">
        <g:message code="event.emailAddress.label" default="emailAddress"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="emailAddress" required="" value="${eventInstance?.emailAddress}"/>

</div>

