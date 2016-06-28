package com.demo

class Event {
    String title
    String description
    String address
    String emailAddress

        static searchability = {
        title index: 'analyzed'
        description index: 'analyzed'
        emailAddress index: 'not_analyzed'
//        emailAddress index: 'analyzed'
        address index: 'analyzed'

    }


    static constraints = {
    }
}
