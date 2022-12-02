<template>
  <div class="filter">
      <label for="category">Category</label>
      <select id="category" v-model="selectedCategory" v-on:change="setCategoryFilter()">
          <option v-for="cat in $store.state.categories" v-bind:key="cat" 
          v-bind:value="cat">{{cat}}</option>
      </select>
  </div>
</template>

<script>
import InventoryService from '../services/InventoryService'
export default {
    data(){
        return{
            selectedCategory: this.$store.state.category
        }
    },
    methods:{
        setCategoryFilter(){
            this.$store.commit('SET_CATEGORY', this.selectedCategory)
        }
    },
    created(){
        InventoryService.getAllCategories().then(response =>{
            this.$store.commit('SET_CATEGORIES', response.data)
        }).catch(e => console.error(e))
    }
}
</script>

<style>

</style>