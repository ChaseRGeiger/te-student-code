<template>
  <div id="app">
    <display-shelf />
    <div class="spacer"></div>
    <sales-counter />
  </div>
</template>

<script>
import DisplayShelf from './components/DisplayShelf'
import SalesCounter from './components/SalesCounter'

export default {
  name: 'App',
  components: {
    DisplayShelf,
    SalesCounter
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
}
div.spacer {
  height: 200px;
}
</style>
