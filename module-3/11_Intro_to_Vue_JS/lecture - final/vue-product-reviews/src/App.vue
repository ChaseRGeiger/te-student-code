<template>
  <div id="app">
    <ProductReview />
    <AddContacts />
  </div>
</template>

<script>
import ProductReview from './components/ProductReview.vue'
import AddContacts from './components/AddContacts.vue'

export default {
  name: 'App',
  components: {
    ProductReview,
    AddContacts
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
  margin-top: 60px;
  max-width:  800px;
  margin: 60px auto 0 auto;
}
</style>
