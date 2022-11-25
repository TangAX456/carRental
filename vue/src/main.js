import Vue from 'vue'
import ElementUI from 'element-ui';
import App from './App.vue'
import router from './router'
import 'element-ui/lib/theme-chalk/index.css';
import './assets/global.css';
import request from "@/util/request"

Vue.config.productionTip = false

Vue.use(ElementUI,{size: "small"});

Vue.prototype.request = request

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
