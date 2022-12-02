<template>
    <div id="app">
        <category-filter></category-filter>
        <main>
            <product-list></product-list>
        </main>
    </div>
    
</template>

<script>
import ProductList from '../components/ProductList.vue'
import CategoryFilter from '../components/CategoryFilter.vue'
export default {
    components:{
        ProductList,
        CategoryFilter
    }
}
</script>

<style>

</style>