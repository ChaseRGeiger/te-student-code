import Vue from 'vue'
import VueRouter from 'vue-router'
import Products from '@/views/Products'
import ProductDetail from '@/views/ProductDetail'
import AddReview from '@/views/AddReview'
import NotFound from '@/views/NotFound'
import Store from '@/store/index'

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
    redirect: { name: 'products' }
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
  Navigation Guard
  to - the route object where the user is trying to go
  from - the router object where the user is coming from
  next - an function used to set their next location
*/
router.beforeEach( (to, from, next) => {
  // Check if it is a route with an id in the path
  if (to.name === 'product-detail' || to.name==='add-review') {
    // Get the id from the url params
    const id = to.params.id;
    // Get the product from the Store with that id
    const product = Store.state.products.find( product => product.id == id )
    // If that product does not exist then send the user to the not-found route
    if (!product) {
      next( { name: 'not-found' } );
    }
  }
  // Otherwise, send the user to where they were trying to go
  next();
})

export default router
