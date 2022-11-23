<template>
  <!-- add main class to div#app -->
  <div id="app" class="main">

    <!-- Title and Description -->
    <h2>Product Reviews for {{ $store.state.name }}</h2>
    <p class="description">{{ $store.state.description }}</p>

    <!-- div.well-display -->
    <div class="well-display">
      <!-- Average Summary -->
      <AverageSummary />
      <!-- Star Summaries -->
      <StarSummary rating="1" />
      <StarSummary rating="2" />
      <StarSummary rating="3" />
      <StarSummary rating="4" />
      <StarSummary rating="5" />
    </div>
    <!-- Add Review -->
    <AddReview />
    <!-- Review List -->
    <ReviewList />
  </div>
</template>

<script>
import AverageSummary from './components/AverageSummary'
import StarSummary from './components/StarSummary'
import ReviewList from './components/ReviewList'
import AddReview from './components/AddReview'

export default {
  name: 'App',
  components: {
    AverageSummary,
    StarSummary,
    ReviewList,
    AddReview
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  max-width: 800px;
  margin: 60px auto 0 auto;
}
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
</style>
