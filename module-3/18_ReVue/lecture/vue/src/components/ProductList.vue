<template>
  <div class="products">
      <p v-if="filteredProducts.length === 0">No Products Found</p>
      <product-list-item v-else v-for="item in filteredProducts" v-bind:key="item.id"
      v-bind:product="item"></product-list-item>
  </div>
</template>

<script>
import InventoryService from '../services/InventoryService'
import ProductListItem from './ProductListItem.vue'

export default {
    name: 'product-list',
    components:{
        ProductListItem
    },
    data(){
        return{
            products:[]
        }
    },
    created(){
        InventoryService.getAllProducts().then(response =>{
            this.products = response.data;
        }).catch(e => console.error(e))
    },
    computed:{
        filteredProducts(){
            const category = this.$store.state.category;
            return this.products.filter(product =>{
                return category === 'All' ? true : category === product.category
            });
        }
    }
}
</script>

<style>
div.products {
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
}
div.products p {
    font-size: 1.5rem;
}
</style>