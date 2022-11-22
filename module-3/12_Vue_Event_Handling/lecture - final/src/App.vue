<template>
  <div id="app">
    <button v-on:click="toggleDisplay">{{ buttonText }}</button>
    <product-review v-if="showReviews"></product-review>
    <EventDelegation v-if="!showReviews" />
  </div>
</template>

<script>
import ProductReview from "./components/ProductReview.vue";
import EventDelegation from './components/EventDelegation';

export default {
  name: "app",
  components: {
    ProductReview,
    EventDelegation
  },
  data() {
    return {
      buttonText: 'Show Event Delegation',
      showReviews: true
    }
  },
  methods: {
    toggleDisplay() {
      this.showReviews = !this.showReviews;
      if (this.showReviews) {
        this.buttonText = 'Show Event Delegation';
      } else {
        this.buttonText = 'Show Product Reviews';
      }
    }
  }
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
</style>
