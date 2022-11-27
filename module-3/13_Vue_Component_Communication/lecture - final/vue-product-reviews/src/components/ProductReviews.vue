<template>
    <!-- class main moves to main div on App.vue -->
    <div >
        
        <!-- Title and Description move to App.vue -->
   

        <!-- div.well-display moves to App.vue -->
        
            <!-- div for average rating moves to AverageSummary.vue -->
   

            <!-- divs for individual star ratings move to StarSummary.vue -->
    


     


        <!-- Show Form button and the form move to AddReview.vue -->


        <!-- No reviews found moves to ReviewList.vue -->


        <!-- div for an indvidual review moves to ReviewDisplay.vue.  v-for moves to ReviewList.vue -->


    </div>
</template>

<script>

export default {
    name: 'product-reviews',
    data() {
        return {
            // name, description, filter, reviews move to the VueX Store
            
        
            // showForm and newReviw move to AddReview.vue
    
        
        }
    },
    computed: {
        // filteredReviews: move to ReviewList.vue

        // averageRating: move to AverageSummary.vue

        // isFormValid: Move to AddReview.vue

    },
    methods: {
        // numberOfReviews: move to StarSummary.vue
    
        // addNewReview and resetForm: Move to AddReview.vue

    }
}
</script>


<style scoped>

/* Move these styles to App.vue */
div.main {
    margin: 1rem 0;
}
div.main div.well-display {
    display: flex;
    justify-content: space-around;
}

div.main div.well-display div.well {
    display: inline-block;
    width: 15%;
    border: 1px black solid;
    border-radius: 6px;
    text-align: center;
    margin: 0.25rem;
}

div.main div.well-display div.well span.amount {
    color: darkslategray;
    display: block;
    font-size: 2.5rem;
}

div.main div.well-display div.well span.amount:hover {
    color: blue;
    cursor: pointer;
}


/* Move these styles to ReviewDisplay.vue */
div.main div.review {
    border: 1px black solid;
    border-radius: 6px;
    padding: 1rem;
    margin: 10px;
}

div.main div.review div.rating {
    height: 2rem;
    display: inline-block;
    vertical-align: top;
    margin: 0 0.5rem;
}

div.main div.review div.rating img {
    height: 100%;
}

div.main div.review p {
    margin: 20px;
}

div.main div.review h3 {
    display: inline-block;
}

div.main div.review h4 {
    font-size: 1rem;
}

div.main div.review.favorited {
    background-color: lightyellow;
}



/* Move these styles to AddReview.vue */
div.form-element {
 margin-top: 10px;
}
div.form-element > label {
 display: block;
}
div.form-element > input, div.form-element > select {
 height: 30px;
 width: 300px;
}
div.form-element > textarea {
 height: 60px;
 width: 300px;
}
form > input[type=button] {
 width: 100px;
}
form > input[type=submit] {
 width: 100px;
 margin-right: 10px;
}


</style>


