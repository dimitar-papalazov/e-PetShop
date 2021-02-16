import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Products from "../views/Products.vue";
import Collections from "../views/Collections.vue";
import Contact from "../views/Contact.vue";
import Details from "../views/Details.vue";
import Login from "../views/Login.vue";
import Orders from "../views/Orders.vue";
import ShoppingCart from "../views/ShoppingCart.vue";
import Payment from "../views/Payment.vue";
import Add from "../views/Add.vue";
import Edit from "../views/Edit.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home,
  },
  {
    path: "/products",
    name: "Products",
    component: Products,
  },
  {
    path: "/collections",
    name: "Collections",
    component: Collections,
  },
  {
    path: "/contact",
    name: "Contact",
    component: Contact,
  },
  {
    path: "/login",
    name: "Login",
    component: Login,
  },
  {
    path: "/orders",
    name: "Orders",
    component: Orders,
  },
  {
    path: "/shoppingCart",
    name: "ShoppingCart",
    component: ShoppingCart,
  },
  {
    path: "/payment",
    name: "Payment",
    component: Payment,
  },
  {
    path: "/details/:id",
    name: "Details",
    component: Details,
    props: true,
  },
  {
    path: "/edit/:id",
    name: "Edit",
    component: Edit,
    props: true,
  },
  {
    path: "/add",
    name: "Add",
    component: Add,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
  scrollBehavior() {
    return { x: 0, y: 0 };
  },
});

export default router;