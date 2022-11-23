<template>
  <div v-bind:style="'background-color: ' + backgroundColor">
      <h1>Event Delegation</h1>
      <ul id="colors" v-on:click="changeBackgroundColor($event)">
          <li>Red</li>
          <li>Green</li>
          <li>Blue</li>
          <li>Goldenrod</li>
          <li>Brown</li>
          <li>Yellow</li>
          <li>Transparent</li>
      </ul>
  </div>
</template>

<script>
export default {
    name: 'event-delegation',
    data() {
        return {
            backgroundColor: 'transparent'
        }
    },
    methods: {
        changeBackgroundColor(event) {
            this.backgroundColor = event.target.innerText;
        }
    }
}
</script>

<style>
ul {
    list-style: none;
}
</style>