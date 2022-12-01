<template>
  <table>
    <thead>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th># Reviews</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="product in products" v-bind:key="product.id">
        <td>{{ product.id }}</td>
        <td>
          <router-link v-bind:to="{ 
            name: 'product-detail',
            params: {
              id: product.id
            } 
          }">
            {{ product.name }}
          </router-link>
        </td>
        <td>{{ product.reviews.length }}</td>
      </tr>
    </tbody>
  </table>
</template>

<script>
import ProductsService from '../services/ProductsService'
export default {
  name: "products-list",
  data(){
    return{
      products: []
    }
  },
  created(){
    ProductsService.getAllProducts()
      .then(response =>{
        this.products = response.data;
      })
      .catch(error => console.error(error))
  }
};
</script>

<style style="scoped">
th,
td {
  text-align: left;
}
td {
  padding-right: 10px;
  vertical-align: top;
}
tr:nth-child(even) {
  background-color: rgb(238, 238, 238);
}
</style>
