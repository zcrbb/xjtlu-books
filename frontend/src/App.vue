<template>
  <v-app>
    <!-- <appbar></appbar> -->
    <v-main>
      <router-view></router-view>
    </v-main>
  </v-app>
</template>

<script lang="ts">
import Vue from "vue";
import appbar from "./components/AppBar.vue";

export default Vue.extend({
  name: "App",

  data: () => ({
    //
  }),
  components: { appbar },
});
</script>
