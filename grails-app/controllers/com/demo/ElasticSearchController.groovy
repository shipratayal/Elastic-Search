package com.demo

import com.event.EventVO
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.sort.SortBuilders

class ElasticSearchController {

    def elasticSearchService

//    def eventSearch = { String search ->
//        def result = Event.search(search)
//        Integer countHits = Event.countHits(search)
////        Integer countHits = Event.countHits(search, [indices: 'event'])
//        List list = []
//        println("===========FOUND==========${result.total}")
//        result.searchResults.eachWithIndex { i, index ->
//            EventVO eventVO = new EventVO()
//            eventVO.description = i.description
//            eventVO.title = i.title
//            eventVO.id = index
//            eventVO.address = i.address
//            eventVO.emailAddress = i.emailAddress
//            list << eventVO
//        }
//
//        render(view: '/event/index', model: [eventInstanceList: list, total: result.total, countHits: countHits])
//    }

    //=====================Filtrs================================
//    def eventSearch = { String search ->
//        def result = elasticSearchService.search(search,[indices:Event])
//        def highlighted = result.highlight
////        Integer countHits = Event.countHits(search)
//        Integer countHits = Event.countHits(search, [indices: 'event'])
//        List list = []
//        println("===========FOUND==========${result.total}")
//        result.searchResults.eachWithIndex { i, index ->
//            EventVO eventVO = new EventVO()
//            eventVO.description = i.description
//            eventVO.title = i.title
//            eventVO.id = index
//            list << eventVO
//        }
//
//        render(view: '/event/index', model: [eventInstanceList: list, total: result.total, countHits: countHits])
//    }

    //===================Sorter Builders=====================================

//    def eventSearch = { String search ->
//        def sortBuilder = SortBuilders.fieldSort("emailAddress")
//        def result = Event.search(search, [indices: Event, sort: sortBuilder])
//        def highlighted = result.highlight
////        Integer countHits = Event.countHits(search)
//        Integer countHits = Event.countHits(search, [indices: 'event'])
//        List list = []
//        println("===========FOUND==========${result.total}")
//        result.searchResults.eachWithIndex { hit, index ->
//            EventVO eventVO = new EventVO()
//            eventVO.description = hit.description
//            eventVO.title = hit.title
//            eventVO.id = index
//            eventVO.emailAddress = hit.emailAddress
//            eventVO.address = hit.address
//
//            list << eventVO
//        }
//
//        render(view: '/event/index', model: [eventInstanceList: list, total: result.total, countHits: countHits])
//    }


    def highlightSettings = {
        field 'description'
        preTags "<strong>"
        postTags "</strong>"
    }
    //=======================For HIghLights===================
    def eventSearch = { String search ->
        def result = Event.search(search, [highlight: { field 'address' }])
        def highlighted = result.highlight
        Integer countHits = Event.countHits(search, [indices: 'event'])
        List list = []
        def fragments
        println("===========FOUND==========${result.total}")
        result?.searchResults?.eachWithIndex { hit, index ->
            // Retrieve the 'message' field fragments for the current hits
            fragments = highlighted[index].address?.fragments
            EventVO eventVO = new EventVO()
            eventVO.title = hit.title
            eventVO.id = index
            eventVO.description = hit.description
            eventVO.address = fragments[0]
            eventVO.emailAddress = hit.emailAddress


            list << eventVO


        }
        render(view: '/event/index', model: [eventInstanceList: list, total: result.total, countHits: countHits])
    }


}
