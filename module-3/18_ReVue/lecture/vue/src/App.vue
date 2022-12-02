<template>
  <div id="app">
    <header>
      <h1>Welcome to {{$store.state.storeName}}</h1>
    </header>
    <div id="nav">
      <router-link tag="button" class="chase" v-bind:to="{ name: 'home' }">Home</router-link>
      <span v-if="$store.state.token">
        <router-link tag="button" class="chase" v-bind:to="{name: 'products'}" >Product List</router-link>
        <router-link tag="button" class="chase" v-bind:to="{ name: 'logout' }">Logout</router-link>
      </span>
    </div>
    <router-view />
  </div>
</template>

<style scoped>

  h1{
    display: flex;
    justify-content: center;
  }

  .chase{
    margin: 2px;
    border-radius: 35px;
    
  }
  .chase:hover{
    border-color: blue;
    
  }
  #nav{
    display: flex;
    justify-content: flex-end;
    align-items: flex-end;
  }
</style>
