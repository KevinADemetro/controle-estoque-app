<template>
  <div id="app" class="p-5">
    <h1>Controle de equipamentos</h1>
    <router-view></router-view>
  </div>
</template>

<script>
  import { routes } from './routes';
  export default {
    data() {
      return {
          routes : routes.filter(route => route.menu)
      }
    }
  }
</script>
