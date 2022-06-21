import Vue from 'vue';
import App from './App.vue';
import { routes } from './routes';  
import VueRouter from 'vue-router';
import 'bootstrap/dist/css/bootstrap.css';
import 'jquery/dist/jquery.js';

Vue.use(VueRouter);

const router = new VueRouter({ 
  routes,
  mode: 'history'
});

new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
