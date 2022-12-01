import axios from 'axios';

const productApi = axios.create({
    baseURL: "http://localhost:8080"
});

export default{


    getAllProducts(){
        return productApi.get('/products');
    },

    getProductById(productId){
        return productApi.get('/products/' + productId);
    },


    updateReview(review){
        return productApi.put('/reviews/' + review.id, review);
    },

    addReview(review, productId){
        return productApi.post(`/products/${productId}/reviews`, review)
    }
}