<template>
  <div id="product-form">
      <form v-on:submit.prevent="saveProduct">
          <div class="form-field">
            <label for="category">Category:</label>
            <select id="category" v-model="newProduct.category">
                <option v-for="cat in categories" 
                    v-bind:key="cat" 
                    v-bind:value="cat">{{cat}}</option>
            </select>
          </div>
          <div class="form-field">
              <label for="name">Name:</label>
              <input type="text" id="name" v-model.trim="newProduct.name">
          </div>
        <div class="form-field">
              <label for="rating">Rating:</label>
              <input type="number" id="rating" v-model.number="newProduct.rating">
          </div>
        <div class="form-field">
              <label for="quantity">Quantity:</label>
              <input type="number" id="quantity" v-model.number="newProduct.quantity">
          </div>
        <div class="form-field">
              <label for="price">Price:</label>
              <input type="number" step="0.01" id="price" v-model.number="newProduct.price">
          </div>
        <div class="form-field">
              <label for="imageName">Image Name:</label>
              <input type="text" id="imageName" v-model.trim="newProduct.image_name">
          </div>
          <div class="form-field">
              <input type="submit" v-bind:disabled="!isValid">
          </div>
      </form>
  </div>
</template>

<script>
import productsService from '@/services/ProductsService'
export default {
    props: ['product'],
    data() {
        return {
            newProduct: {
                image_name: "grey-sofa.jpg",
                is_top_seller: false
            },
            categories: []
        }
    },
    computed: {
        isValid() {
            return this.newProduct.category && this.newProduct.name 
                && this.newProduct.rating >= 0 && this.newProduct.quantity >= 0
                && this.newProduct.price >= 0 && this.newProduct.image_name;
        }
    },
    methods: {
        saveProduct() {
            if (!this.newProduct.id) {
                this.addProduct();
            } else {
                this.updateProduct();
            }
        },
        updateProduct() {
            productsService.updateProduct(this.newProduct)
            .then( response => {
                if (response.status >= 200) {
                    this.$router.push({ name: 'products'});
                }
            })
            .catch( error => {
                if (error.response) {
                    console.error(error.status + " " + error.statusText);
                }
                else if (error.request) {
                    console.error("Could not connect to server")
                } else {
                    console.error(error);
                }
            })
        },
        addProduct() {
            productsService.addProduct(this.newProduct)
            .then( response => {
                if (response.status >= 200) {
                    this.$router.push({ name: 'products'});
                }
            })
            .catch( error => {
                if (error.response) {
                    console.error(error.status + " " + error.statusText);
                }
                else if (error.request) {
                    console.error("Could not connect to server")
                } else {
                    console.error(error);
                }
            })
        }
    },
    created() {
        productsService.getAllCategories().then( response => {
            this.categories = response.data;
        });
        if (this.product) {
            this.newProduct = this.product;
        }
    }
}
</script>

<style>

</style>