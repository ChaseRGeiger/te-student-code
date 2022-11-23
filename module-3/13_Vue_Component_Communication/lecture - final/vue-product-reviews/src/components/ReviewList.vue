<template>
  <div class="reviews">
        <div v-if="filteredReviews.length === 0">
            <p>No {{ $store.state.filter }} Star Reviews Found</p>
        </div>
      <ReviewDisplay 
        v-for="review in filteredReviews" 
        v-bind:key="review.id"
        v-bind:review="review" />
  </div>
</template>

<script>
import ReviewDisplay from './ReviewDisplay'

export default {
    name: 'review-list',
    components: {
        ReviewDisplay
    },
    computed: {
        filteredReviews() {
            const reviews = this.$store.state.reviews;
            const currentFilter = this.$store.state.filter;

            return reviews.filter( review => {
                return  currentFilter === 0 ? true : currentFilter === review.rating;
            });
        },
    }
}
</script>

<style>

</style>