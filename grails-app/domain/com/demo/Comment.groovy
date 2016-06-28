package com.demo

class Comment {
    String des

    static searchable = {
        des index: 'analyzed', boost: 4
//        event parent: true, component: true
//        description index: 'analyzed', boost: 3
    }
    static constraints = {
    }

}
