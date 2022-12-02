import axios from 'axios'

export default{
    getAllProducts(){
        return axios.get('/products')
    },
    getAllCategories(){
        return axios.get('/categories')
    },
    getProductById(productId){
        return axios.get('/products/' + productId)

    }
}