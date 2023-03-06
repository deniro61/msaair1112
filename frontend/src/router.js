
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ScheduleManager from "./components/listers/ScheduleCards"
import ScheduleDetail from "./components/listers/ScheduleDetail"

import MileageManager from "./components/listers/MileageCards"
import MileageDetail from "./components/listers/MileageDetail"

import ReservationManager from "./components/listers/ReservationCards"
import ReservationDetail from "./components/listers/ReservationDetail"

import NotificationManager from "./components/listers/NotificationCards"
import NotificationDetail from "./components/listers/NotificationDetail"


import ReservationHistView from "./components/ReservationHistView"
import ReservationHistViewDetail from "./components/ReservationHistViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/schedules',
                name: 'ScheduleManager',
                component: ScheduleManager
            },
            {
                path: '/schedules/:id',
                name: 'ScheduleDetail',
                component: ScheduleDetail
            },

            {
                path: '/mileages',
                name: 'MileageManager',
                component: MileageManager
            },
            {
                path: '/mileages/:id',
                name: 'MileageDetail',
                component: MileageDetail
            },

            {
                path: '/reservations',
                name: 'ReservationManager',
                component: ReservationManager
            },
            {
                path: '/reservations/:id',
                name: 'ReservationDetail',
                component: ReservationDetail
            },

            {
                path: '/notifications',
                name: 'NotificationManager',
                component: NotificationManager
            },
            {
                path: '/notifications/:id',
                name: 'NotificationDetail',
                component: NotificationDetail
            },


            {
                path: '/reservationHists',
                name: 'ReservationHistView',
                component: ReservationHistView
            },
            {
                path: '/reservationHists/:id',
                name: 'ReservationHistViewDetail',
                component: ReservationHistViewDetail
            },


    ]
})
