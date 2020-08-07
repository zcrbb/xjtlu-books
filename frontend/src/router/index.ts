import Vue from "vue";
import VueRouter, { RouteConfig } from "vue-router";
import Zh from "../views/Zh.vue";
import error from "../views/Error.vue";

Vue.use(VueRouter);

const routes: Array<RouteConfig> = [
  {
    path: "/",
    redirect: "/zh",
  },
  {
    path: "/zh",
    name: "Zh",
    component: Zh,
  },
  {
    path: "*",
    name: "er",
    component: error,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
