<template>
  <form v-on:submit.prevent="saveChanges">
    <div class="form-element">
      <label for="reviewer">Name:</label>
      <input id="reviewer" type="text" v-model="newReview.reviewer" />
    </div>
    <div class="form-element">
      <label for="title">Title:</label>
      <input id="title" type="text" v-model="newReview.title" />
    </div>
    <div class="form-element">
      <label for="rating">Rating:</label>
      <select id="rating" v-model.number="newReview.rating">
        <option value="1">1 Star</option>
        <option value="2">2 Stars</option>
        <option value="3">3 Stars</option>
        <option value="4">4 Stars</option>
        <option value="5">5 Stars</option>
      </select>
    </div>
    <div class="form-element">
      <label for="review">Review</label>
      <textarea id="review" v-model="newReview.review"></textarea>
    </div>
    <div class="actions">
      <button v-on:click="resetForm" type="button">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
import ProductsService from '../services/ProductsService'

export default {
  name: "add-review",
  data() {
    return {
      newReview: {
        id: 0,
        productID: 0,
        reviewer: "",
        title: "",
        rating: 0,
        review: "",
        favorited: false
      },
      reviewId: 0,
      productID: 0
    };
  },
  methods: {
    saveChanges() {
      if (this.reviewId == 0) {
        this.addNewReview();
      } else {
        this.updateReview();
      }
    },
    updateReview() {
      ProductsService.updateReview(this.newReview).then( (response) => {
        if (response.status < 300) {
            this.$router.push( { 
              name: 'product-detail', 
              params: { id: this.productID }
            });
        }
      }).catch( error => console.error(error) );
    },
    addNewReview() {
      this.newReview.productID = this.productID;
      
      ProductsService.addReview(this.newReview, this.productID)
        .then(response => {
          if (response.status == 201) {
            this.$router.push( { 
              name: 'product-detail', 
              params: { id: this.productID }
            });
          } else {
            alert("Unxpected response returned: " + response.status + " : " + response.statusText);
          }
        })
      

    },
    resetForm() {
      this.newReview = {};
    }
  },
  created() {
      this.productID = this.$route.params.id;
      this.reviewId = Number(this.$route.params.reviewId);
      if (this.reviewId > 0) {
        ProductsService.getReviewById(this.reviewId).then( response => {
          this.newReview = response.data;
        })
      }
  }
};
</script>

<style scoped>
form {
  width: 500px;
  margin: 20px;
}
.form-element label {
  width: 100px;
  vertical-align: top;
}
.form-element input,
select,
textarea {
  width: 400px;
  font-size: 1.1rem;
}
.form-element textarea {
  height: 150px;
}
.actions {
  float: right;
}
.actions button {
  margin-left: 10px;
}
</style>
