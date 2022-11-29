<template>
  <div id="app" class="main">
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
          <AverageSummary />
          <StarSummary rating="1" />
          <StarSummary rating="2" />
          <StarSummary rating="3" />
          <StarSummary rating="4" />
          <StarSummary rating="5" />
      </div>
      <ReviewList />
  </div>
</template>

<script>
import AverageSummary from '@/components/AverageSummary'
import StarSummary from '@/components/StarSummary'
import ReviewList from '@/components/ReviewList'

export default {
    components: {
        AverageSummary,
        StarSummary,
        ReviewList
    },
    computed: {
        product() {
            return this.$store.state.products.find(
                (p) => {
                    return p.id == this.$store.state.activeProduct;
                }
            )
        }
    },
    created() {
        const activeProductId = this.$route.params.id;
        this.$store.commit('SET_ACTIVE_PRODUCT', activeProductId);
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