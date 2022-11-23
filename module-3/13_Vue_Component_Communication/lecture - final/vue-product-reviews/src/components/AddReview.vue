<template>
  <div>
        <div v-show="!showForm">
            <a href="#" v-on:click.prevent="showForm = true">Add Review</a>
        </div>

        <form v-on:submit.prevent="addNewReview()" v-if="showForm">
            <div class="form-element">
                <label for="reviewer">Name:</label>
                <input type="text" id="reviewer" v-model.trim="newReview.reviewer" />
            </div>
            <div class="form-element">
                <label for="title">Title:</label>
                <input type="text" id="title" v-model.trim="newReview.title" />
            </div>
            <div class="form-element">
                <label for="rating">Rating:</label>
                <select id="rating" v-model.number="newReview.rating" >
                    <option value="1">1 Star</option>
                    <option value="2">2 Stars</option>
                    <option value="3">3 Stars</option>
                    <option value="4">4 Stars</option>
                    <option value="5">5 Stars</option>
                </select>
            </div>
            <div class="form-element">
                <label for="Review:">Review:</label>
                <textarea id="review" v-model="newReview.review"></textarea>
            </div>
            <input type="submit" value="Save" v-bind:disabled="!isFormValid" />
            <input type="button" value="Cancel" @click.prevent="resetForm" />
        </form>    
  </div>
</template>

<script>
export default {
    name: 'add-review',
    data() {
        return {
            showForm: false,
            newReview: {},
        }
    }, 
    computed: {
        isFormValid() {
           return this.newReview.reviewer && this.newReview.title
                && this.newReview.rating && this.newReview.review; 
        }
    },
    methods: {
        addNewReview() {
            this.$store.commit('ADD_REVIEW', this.newReview);
            this.resetForm();
        },
        resetForm() {
            this.newReview = {};
            this.showForm = false;
        }
    }
}
</script>

<style>
div.form-element {
 margin-top: 10px;
}
div.form-element > label {
 display: block;
}
div.form-element > input,
div.form-element > select {
 height: 30px;
 width: 300px;
}
div.form-element > textarea {
 height: 60px;
 width: 300px;
}
form > input[type="button"] {
 width: 100px;
}
form > input[type="submit"] {
 width: 100px;
 margin-right: 10px;
}
</style>