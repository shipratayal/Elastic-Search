class BootStrap {

    def eventService
    def init = { servletContext ->
        eventService.addEvent("Expo Pakistan", "2 days expo of Pakistan, all stuffs...at expo center", "New Delhi", "abc@email.com")
        eventService.addEvent("New Year Even", "Enjoy new year night at beach club", "New Delhi", "abc@email.com")
        eventService.addEvent("Children's Day", "Kids play, activities, sports, fun, family", "New Delhi", "abc@email.com")
        eventService.addEvent("Education Expo", "3 days Eduction expo, college, schools at expo center...", "New Delhi", "new@email.com")
        eventService.addEvent("Arena sports area", "All year open, indoor activities, bowling, snooker, ice skating", "New Delhi", "sh@email.com")
        eventService.addEvent("All you can eat", "All you can eat offer is back in this ramadan at Pizza Hut", "New Delhi", "fg@email.com")
        eventService.addEvent("All-you-can.xyz", "All-you-can-eat-offer-is-back-in-this-ramadan=at=Pizza=Hut", "New Delhi", "aa@email.com")

    }
    def destroy = {
    }
}
