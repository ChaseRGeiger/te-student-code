import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    inventory: {
      tvs: 5
    }
  },
  mutations: {
    REMOVE_TVS_FROM_INVENTORY(state, amount) {
      if (state.inventory.tvs > 0) {
        state.inventory.tvs -= amount;
      }
    }
  },
  actions: {
  },
  modules: {
  }
})
