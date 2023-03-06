<template>

    <v-data-table
        :headers="headers"
        :items="reservationHist"
        :items-per-page="5"
        class="elevation-1"
    ></v-data-table>

</template>

<script>
    const axios = require('axios').default;

    export default {
        name: 'ReservationHistView',
        props: {
            value: Object,
            editMode: Boolean,
            isNew: Boolean
        },
        data: () => ({
            headers: [
                { text: "id", value: "id" },
                { text: "reservationId", value: "reservationId" },
                { text: "reservationStatus", value: "reservationStatus" },
                { text: "scheduleStatus", value: "scheduleStatus" },
                { text: "milieage", value: "milieage" },
                { text: "customerId", value: "customerId" },
                { text: "scheduleId", value: "scheduleId" },
            ],
            reservationHist : [],
        }),
          async created() {
            var temp = await axios.get(axios.fixUrl('/reservationHists'))

            temp.data._embedded.reservationHists.map(obj => obj.id=obj._links.self.href.split("/")[obj._links.self.href.split("/").length - 1])

            this.reservationHist = temp.data._embedded.reservationHists;
        },
        methods: {
        }
    }
</script>

