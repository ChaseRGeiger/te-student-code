<template>
  <div>
      <h1>Sales</h1>
      <div>
          <img src="../assets/Sales_counter.png" alt="">
      </div>
      <input type="button" value="Buy TV" v-on:click="buyTv" />
  </div> 
</template>

<script>
export default {
  methods: { 
    buyTv() {
      // inventory is removed from the VueX store by committing the mutation
      // that changes the inventory value
      //  commit( 'MUTATION_NAME', ...arguments)
      this.$store.commit('REMOVE_TVS_FROM_INVENTORY', 1);
    }
  }
}
</script>

<style>
input[type=button] {
  width: 200px;
  height: 40px;
  border-radius: 10px;
  background-color: lightgreen;
  font-size: 1.5rem;
  font-weight: 600;
}
</style>