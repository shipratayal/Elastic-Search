package com.demo

import grails.transaction.Transactional

@Transactional

class EventService {
    def elasticSearchService

    def addEvent(String title, String description, String address, String email) {
        println("*********ADDED************")
        Event event = new Event(title: title, description: description, address: address, emailAddress: email)
        event.save(flush: true)
        elasticSearchService.index(event)
    }
}
