import router from './router'
import store from './store'
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import '@/assets/css/global.css'
import * as ELIcons from '@element-plus/icons-vue'

const app = createApp(App)

app.use(store).use(ElementPlus).use(router).mount('#app')

for (let iconName in ELIcons) {app.component(iconName, ELIcons[iconName]) }
