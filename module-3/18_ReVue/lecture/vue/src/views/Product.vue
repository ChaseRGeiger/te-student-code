<template>
  <div id="product-display">
      <product-list-item v-bind:product="currentProduct"></product-list-item>
  </div>
</template>

<script>
import InventoryService from '../services/InventoryService'
import ProductListItem from '../components/ProductListItem.vue'
export default {
    components:{
        ProductListItem
    },
    data(){
        return{
            currentProduct:{}
        }
    },
    created(){
        const productId = this.$route.params.productId;
        InventoryService.getProductById(productId).then(response =>{
            this.currentProduct = response.data;
        }).catch(e => console.error(e))
    }
}
</script>

<style>

</style>