import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'
import AddReview from '@/views/AddReview'
import NotFound from '@/views/NotFound'
Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'products',
    component: Products
  },
  {
    path: '/products/:id',
    name: 'product-detail',
    component: ProductDetail
  },
  {
    path: '/products/:id/add-review',
    name: 'add-review',
    component: AddReview
  },
  {
    path: '/products',
    redirect: {name: 'products'}
  },
  {
    path: '*',
    name: 'not-found',
    component: NotFound
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

/*
  to - the rote object the user is trying to go to
  from - the router object the user is coming from
  next - an object used to set their next location
*/
router.beforeEach((to, from, next) =>{

  if(to.name === 'product-detail' || to.name === 'add-review'){
    const id = to.params.id;
    const product = Store.state.products.find(product => product.id == id)
    if(!product){
      next({name: 'not-found'})
    }
  }

  next();
})

export default router
