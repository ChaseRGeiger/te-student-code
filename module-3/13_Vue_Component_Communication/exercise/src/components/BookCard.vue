<template>
  <div class="card" v-bind:class="{ read: book.read }">

    <h2 class="book-title">{{ book.title }}</h2>
    <img v-if="book.isbn" v-bind:src="'http://covers.openlibrary.org/b/isbn/' + book.isbn + '-M.jpg'" />
    <h3 class="book-author">{{ book.author }}</h3>

    <div class="button-container">
        <button class="mark-read" v-on:click="readChange(true)" v-if="!book.read">Mark Read</button>
        <button class="mark-unread" v-on:click="readChange(false)" v-if="book.read">Mark Unread</button>
    </div>
    
  </div>
</template>

<script>
export default {
    name: 'book-card',
    props: ['book'],
    methods: {
        readChange(value) {
            this.$store.commit('SET_READ_STATUS', {book: this.book, value: value});
        }
    }
}
</script>

<style>
.card {
    border: 2px solid black;
    border-radius: 10px;
    width: 250px;
    height: 550px;
    margin: 20px;
}

.card.read {
    background-color: lightgray;
}

.card .book-title {
    font-size: 1.5rem;
}

.card .book-author {
    font-size: 1rem;
}
</style>