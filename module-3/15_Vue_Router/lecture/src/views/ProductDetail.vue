<template>
    <div id="app" class="main">
        <h1>{{product.name}}</h1>
        <p class="description">{{product.description}}</p>
        <div class="actions">
            <router-link v-bind:to="{name: 'products'}">Back to Products</router-link>
            &nbsp; | &nbsp;
            <router-link v-bind:to="{
                name: 'add-review',
                params: {
                    id: product.id
                }
            }">Add Review</router-link>
        </div>
        <div class="well-display">
            <average-summary></average-summary>
            <star-summary rating="1"></star-summary>
            <star-summary rating="2"></star-summary>
            <star-summary rating="3"></star-summary>
            <star-summary rating="4"></star-summary>
            <star-summary rating="5"></star-summary>
        </div>

        <review-list></review-list>
    </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary'
import StarSummary from '@/components/StarSummary'
import ReviewList from '@/components/ReviewList'
export default {

    components:{
        AverageSummary,
        StarSummary,
        ReviewList
    },

    computed: {
        product(){
            return this.$store.state.products.find(p => p.id == this.$store.state.activeProduct);
        }
    },

    created(){
        const activeProductId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);
    }

}
</script>

<style>

</style>