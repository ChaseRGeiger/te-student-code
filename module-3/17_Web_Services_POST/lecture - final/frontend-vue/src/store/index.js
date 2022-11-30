import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    activeProduct: 0,
    filter: 0
  },
  mutations: {
    UPDATE_FILTER(state, filter) {
      state.filter = filter;
    },
    SET_ACTIVE_PRODUCT(state, productID) {
      state.activeProduct = productID;
    }
  },
  actions: {
  },
  modules: {
  },
  // Strict should not be used in production code. It is used here as a
  // learning aid to warn you if state is modified without using a mutation.
  strict: true
})
