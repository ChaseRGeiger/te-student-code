<template>
  
</template>

<script>
export default {
    name: 'review-display',
    methods: {

    }
}
</script>

<style>
div.main div.review {
   border: 1px black solid;
   border-radius: 6px;
   padding: 1rem;
   margin: 10px;
}
 
div.main div.review div.rating {
   height: 2rem;
   display: inline-block;
   vertical-align: top;
   margin: 0 0.5rem;
}
 
div.main div.review div.rating img {
   height: 100%;
}
 
div.main div.review p {
   margin: 20px;
}
 
div.main div.review h3 {
   display: inline-block;
}
 
div.main div.review h4 {
   font-size: 1rem;
}
 
div.main div.review.favorited {
   background-color: lightyellow;
}

</style>