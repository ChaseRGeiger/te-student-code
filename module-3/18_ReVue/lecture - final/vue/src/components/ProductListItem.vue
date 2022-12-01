<template>
  <h1>Product</h1>
</template>

<script>
export default {
    name: 'product-list-item'
}
</script>

<style>
div.product {
   border: 1px black solid;
   width: 30%;
   margin: 20px;
   border-radius: 5px;
   display: flex;
   flex-direction: column;
   justify-content: space-between;
}
 
div.product.bestseller {
   background-color: lightyellow;
}
div.product img {
   width: 75%;
   max-height: 200px;
   align-self: center;
}
div.product h2 {
   font-size: 1.1rem;
   color: black;
}
 
div.rating {
   display: flex;
   justify-content: center;
   margin-top: 5px;
 
}
div.rating img.ratingStar {
   width: 20px;
}
 
div.product div.notices {
   display: flex;
   justify-content: space-between;
   align-content: flex-end;
   margin-right: 10px;
   margin-left: 10px;
   margin-bottom: 5px;
   font-weight: 800;
}
div.product div.notices span.topseller {
   color: blue;
}
div.product div.notices span.limitedstock {
   color: red;
}

</style>