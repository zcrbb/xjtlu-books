<template>
  <v-app-bar app color="error" dark flat hide-on-scroll>
    <v-icon>mdi-book-minus-multiple</v-icon>
    <v-toolbar-title>拒绝学校强制购买课本</v-toolbar-title>
    <v-spacer></v-spacer>

    <v-menu offset-y>
      <template v-slot:activator="{ on, attrs }">
        <v-btn icon dark v-bind="attrs" v-on="on">
          <v-icon>mdi-translate</v-icon>
        </v-btn>
      </template>
      <v-list>
        <v-list-item v-for="(item, index) in items" :key="index" link :to="item.link">
          <v-list-item-title>{{ item.title }}</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-menu>

    <v-btn href="https://github.com/zcrbb/xjtlu-books" icon>
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
