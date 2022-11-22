<template>
    <!-- class main moves to main div on App.vue -->
    <div class="main">
        
        <!-- Title and Description move to App.vue -->
        <h2>Product Reviews for {{ name }}</h2>
        <p class="description">{{ description }}</p>

        <!-- div.well-display moves to App.vue -->
        <div class="well-display">
            <!-- div for average rating moves to AverageSummary.vue -->
            <div class="well">
                <span class="amount" v-on:click="filter = 0">{{ averageRating }}</span>
                Average Rating
            </div>

            <!-- divs for individual star ratings move to StarSummary.vue -->
            <div class="well">
                <span class="amount" v-on:click="filter = 1">{{ numberOfOneStarReviews }}</span>
                1 Star Review{{ numberOfOneStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount" v-on:click="filter = 2">{{ numberOfTwoStarReviews }}</span>
                2 Star Review{{ numberOfTwoStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount" v-on:click="filter = 3">{{ numberOfThreeStarReviews }}</span>
                3 Star Review{{ numberOfThreeStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount" v-on:click="filter = 4">{{ numberOfFourStarReviews }}</span>
                4 Star Review{{ numberOfFourStarReviews === 1 ? '' : 's' }}
            </div>

            <div class="well">
                <span class="amount" v-on:click="filter = 5">{{ numberOfFiveStarReviews }}</span>
                5 Star Review{{ numberOfFiveStarReviews === 1 ? '' : 's' }}
            </div>
        </div>


        <!-- Show Form button and the form move to AddReview.vue -->
        <div v-show="!showForm">
            <a href="#" v-on:click.prevent="showForm = true">Add Review</a>
        </div>

        <form v-on:submit.prevent="addNewReview()" v-if="showForm">
            <div class="form-element">
                <label for="reviewer">Name:</label>
                <input type="text" id="reviewer" v-model.trim="newReview.reviewer" />
            </div>
            <div class="form-element">
                <label for="title">Title:</label>
                <input type="text" id="title" v-model.trim="newReview.title" />
            </div>
            <div class="form-element">
                <label for="rating">Rating:</label>
                <select id="rating" v-model.number="newReview.rating" >
                    <option value="1">1 Star</option>
                    <option value="2">2 Stars</option>
                    <option value="3">3 Stars</option>
                    <option value="4">4 Stars</option>
                    <option value="5">5 Stars</option>
                </select>
            </div>
            <div class="form-element">
                <label for="Review:">Review:</label>
                <textarea id="review" v-model="newReview.review"></textarea>
            </div>
            <input type="submit" value="Save" v-bind:disabled="!isFormValid" />
            <input type="button" value="Cancel" @click.prevent="resetForm" />
        </form>

        <!-- No reviews found moves to ReviewList.vue -->
        <div v-if="filteredReviews.length === 0">
            <p>No {{ filter }} Star Reviews Found</p>
        </div>

        <!-- div for an indvidual review moves to ReviewDisplay.vue.  v-for moves to ReviewList.vue -->
        <div class="review" v-for="review in filteredReviews" v-bind:key="review.id"
            v-bind:class="{ favorited: review.favorited }">
            <h4>{{ review.reviewer }}</h4>
            <div class="rating">
                <img src="../assets/star.png" v-for="i in review.rating"
                    v-bind:key="i" v-bind:title="review.rating + ' Star Review'" />
            </div>
            <h3>{{ review.title }}</h3>
            <p>{{review.review}}</p>
            <p>Favorite? <input type="checkbox" v-model="review.favorited" /></p>
        </div>

    </div>
</template>

<script>

export default {
    name: 'product-reviews',
    data() {
        return {
            // name, description, filter, reviews move to the VueX Store
            name: 'Cigar Parties for Dummies',
            description: 'Host and plan the perfect cigar party for all your squirrelly friends',
            filter: 0,
            reviews: [
                {
                    reviewer: 'Malcolm Gladwell',
                    title: 'What a book!',
                    review:
                    "It certainly is a book. I mean, I can see that. Pages kept together with glue (I hope that's glue) and there's writing on it, in some language.",
                    rating: 3
                },
                {
                    reviewer: 'Tim Ferriss',
                    title: 'Had a cigar party started in less than 4 hours.',
                    review:
                    "It should have been called the four hour cigar party. That's amazing. I have a new idea for muse because of this.",
                    rating: 4
                },
                {
                    reviewer: 'Ramit Sethi',
                    title: 'What every new entrepreneurs needs. A door stop.',
                    review:
                    "When I sell my courses, I'm always telling people that if a book costs less than $20, they should just buy it. If they only learn one thing from it, it was worth it. Wish I learned something from this book.",
                    rating: 1
                },
                {
                    reviewer: 'Gary Vaynerchuk',
                    title: 'And I thought I could write',
                    review:
                    "There are a lot of good, solid tips in this book. I don't want to ruin it, but prelighting all the cigars is worth the price of admission alone.",
                    rating: 3
                }
            ],
            // showForm and newReviw move to AddReview.vue
            showForm: false,
            newReview: {},
        
        }
    },
    computed: {
        // filteredReviews: move to ReviewList.vue
        filteredReviews() {
            return this.reviews.filter( review => {
                return this.filter === 0 ? true : this.filter === review.rating;
            });
        },
        // averageRating: move to AverageSummary.vue
        averageRating() {
            let sum = this.reviews.reduce( (currentSum, review) => {
                return currentSum + review.rating;
            }, 0);
            return (sum / this.reviews.length).toFixed(2);
        },
        // numberOfXStarReviews: no longer needed as they are handled by the StarSummary component
        numberOfOneStarReviews() {
            return this.numberOfReviews(1);
        },
        numberOfTwoStarReviews() {
            return this.numberOfReviews(2);
        },
        numberOfThreeStarReviews() {
            return this.numberOfReviews(3);
        },
        numberOfFourStarReviews() {
            return this.numberOfReviews(4);
        },
        numberOfFiveStarReviews() {
            return this.numberOfReviews(5);
        },
        // isFormValid: Move to AddReview.vue
        isFormValid() {
           return this.newReview.reviewer && this.newReview.title
                && this.newReview.rating && this.newReview.review; 
        }
    },
    methods: {
        // numberOfReviews: move to StarSummary.vue
        numberOfReviews(numOfStars) {
           return this.reviews.reduce( (currentCount, review) => {
                return currentCount + (review.rating === numOfStars);
            }, 0);
        },
        // addNewReview and resetForm: Move to AddReview.vue
        addNewReview() {
            this.reviews.unshift(this.newReview);
            this.resetForm();
        },
        resetForm() {
            this.newReview = {};
            this.showForm = false;
        }
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


