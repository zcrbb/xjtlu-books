<template>
  <div>
    <Index></Index>
    <v-app-bar app color="error" dark flat scrollable>
      <v-icon large>mdi-book-minus-multiple</v-icon>
      <v-toolbar-title class="ml-5">我们不需要太多无用的课本</v-toolbar-title>
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
        <span class="mr-2">source code here</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>
    <v-footer color="error" app>
      <span class="white--text">希望XJTLU能在师生的共同努力下越来越好 &copy;</span>
    </v-footer>

    <v-container>
      <v-row class="text-justify">
        <v-col cols="12">
          在西浦, 学校会强制性出售给学生一些学生不大能用到的书籍, 比如
          <v-tooltip bottom>
            <template v-slot:activator="{ on }">
              <v-chip small v-on="on" color="primary" text-color="white" link>CCT系列书籍</v-chip>
            </template>
            <span>学校一门课程的名字, 为大一预备课程</span>
          </v-tooltip>, 但是这样的书本 大部分学生一个学期都未曾拆开封面, 最后只能非常惋惜的遗弃
        </v-col>
        <v-col>这样的情况绝非少见</v-col>
      </v-row>
    </v-container>

    <Commit></Commit>
    <Reason></Reason>
    <Light></Light>
  </div>
</template>

<script>
import Commit from "../components/Commit";
import Reason from "../components/Reason";
import Light from "../components/Light";
import Index from "../views/Index";

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
  components: {
    Commit,
    Reason,
    Index,
    Light,
  },
};
</script>
