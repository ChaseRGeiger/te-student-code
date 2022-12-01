<template>
  <div class="well">
    <span class="amount" v-on:click="updateFilter()">{{ stars }}</span>
    {{ rating }} Star Review{{ stars === 1 ? '' : 's' }}
  </div>
</template>

<script>
export default {
  name: "star-summary",
  props: ["rating", "reviews"],
  methods: {
    updateFilter() {
      this.$store.commit("UPDATE_FILTER", parseInt(this.rating));
    }
  },
  computed: {
    stars() {
      return this.reviews.reduce((currentCount, review) => {
        return currentCount + (review.rating === parseInt(this.rating) ? 1 : 0);
      }, 0);
    }
  }
};
</script>
