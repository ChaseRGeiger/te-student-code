<template>
    <div>
        <div class="loading" v-if="isLoading">
            <img src="../assets/loading_icon.gif" alt="" class="loading">
        </div>
        <div id="app" class="main" v-if="!isLoading">
            <h1>{{product.name}}</h1>
            <p class="description">{{ product.description }}</p>
            <div class="actions">
                <router-link v-bind:to="{ name:'products' }">Back to Products</router-link>
                &nbsp;|&nbsp;
                <router-link v-bind:to="{ 
                    name: 'add-review', 
                    params: {
                        id: product.id
                    }
                }">
                    Add Review
                </router-link>
            </div>
            <div class="well-display">
                <AverageSummary v-bind:reviews="product.reviews"/>
                <StarSummary rating="1" v-bind:reviews="product.reviews"/>
                <StarSummary rating="2" v-bind:reviews="product.reviews"/>
                <StarSummary rating="3" v-bind:reviews="product.reviews"/>
                <StarSummary rating="4" v-bind:reviews="product.reviews"/>
                <StarSummary rating="5" v-bind:reviews="product.reviews"/>
            </div>
            <ReviewList v-bind:reviews="product.reviews"/>
        </div>
    </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary'
import StarSummary from '@/components/StarSummary'
import ReviewList from '@/components/ReviewList'
import ProductsService from '@/services/ProductsService'

export default {
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },

    data(){
        return {
            product: {}
        }
    },
    created() {
        const activeProductId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);


        ProductsService.getProductById(activeProductId)
            .then(response =>{
                this.product = response.data;
                this.isLoading = false;
            })
            .catch(error => console.error(error))
    }
}
</script>

<style>
div.loading {
    height: 75vw;
    display:flex;
    justify-content: center;
    align-items: center;
}

div.error {
    display: flex;
    justify-content: center;
    align-items: center;
    margin-top:50px;
    background-color: red;
    color: white;
    height: 50px;
    font-size: 1.5rem;
}
</style>