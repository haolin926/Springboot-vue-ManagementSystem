import { createRouter, createWebHistory } from 'vue-router'
import EmpView from "@/views/EmpView.vue";
import DeptView from "@/views/DeptView.vue";
import Layout from "@/layout/Layout.vue";

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect: '/emp',
    children:[
      {
        path: 'emp',
        name: 'emp',
        component: EmpView,
      },
      {
        path: '/dept',
        name: 'Department',
        component: DeptView
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
