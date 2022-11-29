<template>
  <div id="confirm">
      <div v-if="isLoading">
          <img src="../assets/loading_icon.gif" >
      </div>
      <div v-if="!isLoading" class="review">
        <p>
          Are you sure you want to delete this review?
        </p>
        <div class="buttons">
            <button v-on:click.prevent="deleteConfirmed()">Yes</button>
            <button v-on:click.prevent="returnToProductPage()">Cancel</button>
        </div>
        <div class="review-details">
            <p>Reviewer: {{ review.reviewer }}</p>
            <p>Title: {{ review.title }}</p>
            <p>{{review.review}}</p>
        </div>
      </div>
  </div>
</template>

<script>
// import ProductsService from '../services/ProductsService'

export default {
    data() {
        return {
            review: {},
            isLoading: true
        }
    },
    methods: {
        deleteConfirmed() {

        },
        returnToProductPage() {
            this.$router.push({ name: 'product-detail',
             params: {
                id: this.review.productId
            }})
        },
        
    },
    created() {
        // const reviewId = Number(this.$route.params.reviewId);
        // ProductsService.getReviewById(reviewId).then( response => {
        //     this.review = response.data;
        //     this.isLoading = false;
        // }).catch(err => console.error(err))
    }
}
</script>

<style>

div#confirm {
    display: flex;
    justify-content: center;
    margin-top: 50px;
}

div#confirm .review {
    display: flex;
    align-items: center;
    flex-direction: column;
}

div#confirm .review div.buttons {
    margin-bottom: 30px;
}

div#confirm .review div.buttons button {
    margin: 20px;
    width: 100px;
    border-radius: 10px;
    border: 1px solid black;
    font-weight: 600;
}

div#confirm .review div.buttons button:first-child {
    background-color: lightgreen;
}

div#confirm .review div.buttons button:last-child {
    background-color: rgb(240, 94, 94);
}

div#confirm .review div.buttons button:hover {
    cursor: pointer;
}

div#confirm .review-details {
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
}

div#confirm .review-details p {
    font-size: 1.2rem;
    padding: 5px;
    margin: 0;
}



</style>