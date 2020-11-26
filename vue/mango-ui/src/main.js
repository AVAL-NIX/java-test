// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import api from './http'
import global from '@/utils/global'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import mockjs from '@/mock/index.js'
import 'font-awesome/css/font-awesome.min.css'
import VueI18n from 'vue-i18n'
import store from './store'
import enLocale from 'element-ui/lib/locale/lang/en'
import zhLocale from 'element-ui/lib/locale/lang/zh-CN'
import zh from '@/assets/languages/zh.json'
import en from '@/assets/languages/en.json'

Vue.config.productionTip = false

Vue.use(ElementUI)
Vue.use(api) // 引入API模块

Vue.prototype.global = global // 挂载全局配置模块

Vue.use(VueI18n)

//国际化
const i18n = new VueI18n({
  locale: 'zh',
  messages: {
    zh: Object.assign(zh, zhLocale),
    en: Object.assign(en, enLocale)
  }
})

// 为了实现element的多语言切换
Vue.use(ElementUI, {
  i18n: (key, value) => i18n.t(key, value)
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  i18n,
  store,
  components: { App },
  template: '<App/>'
})
