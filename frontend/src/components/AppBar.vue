<template>
  <v-app-bar app color="error" dark>
    <v-icon large>mdi-book-minus-multiple</v-icon>
    <v-toolbar-title class="ml-5">拒绝学校强制购买课本</v-toolbar-title>
    <v-spacer></v-spacer>

    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn text dark v-bind="attrs" v-on="on">
          <v-icon class="mr-2">mdi-translate</v-icon>LANGUAGE
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in items" :key="index" link :to="item.link">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <v-btn href="https://github.com/vuetifyjs/vuetify/releases/latest" target="_blank" text>
      <span class="mr-2">code here</span>
      <v-icon>mdi-open-in-new</v-icon>
    </v-btn>
  </v-app-bar>
  
</template>

<script>
export default {
  name: "Zh",
  data: () => ({
    items: [
      { title: "简体中文", link: "/zh" },
      { title: "繁體中文", link: "/zh-tw" },
      { title: "ENGLISH", link: "/en" },
      // { title: "waiting for adding" },
    ],
  }),
};
</script>
