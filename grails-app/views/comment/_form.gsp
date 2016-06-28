<%@ page import="com.demo.Comment" %>



<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'des', 'error')} required">
	<label for="des">
		<g:message code="comment.des.label" default="Des" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="des" required="" value="${commentInstance?.des}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: commentInstance, field: 'event', 'error')} required">
	<label for="event">
		<g:message code="comment.event.label" default="Event" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="event" name="event.id" from="${com.demo.Event.list()}" optionKey="id" required="" value="${commentInstance?.event?.id}" class="many-to-one"/>

</div>

