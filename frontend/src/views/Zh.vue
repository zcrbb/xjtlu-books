<template>
  <div>
    <Index></Index>
    <v-app-bar app color="error" dark flat hide-on-scroll>
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

      <v-btn href="https://github.com/zcrbb/xjtlu-books" target="_blank" text>
        <span class="mr-2">source code here</span>
        <v-icon>mdi-open-in-new</v-icon>
      </v-btn>
    </v-app-bar>

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
        <v-col>
          <iframe
            width="640px"
            height="480px"
            src="https://forms.office.com/Pages/ResponsePage.aspx?id=DQSIkWdsW0yxEjajBLZtrQAAAAAAAAAAAAMAABMsmTdUNTY1MUdORVJYWVZPVFRLVzlPTlVNUU05TS4u&embed=true"
            frameborder="0"
            marginwidth="0"
            marginheight="0"
            style="border: none; max-width:100%; max-height:100vh"
            allowfullscreen
            webkitallowfullscreen
            mozallowfullscreen
            msallowfullscreen
          ></iframe>
        </v-col>
      </v-row>
    </v-container>

    <Count></Count>
    <Reason></Reason>
    <Commit></Commit>
    <Light></Light>
  </div>
</template>

<script>
import Commit from "../components/Commit";
import Reason from "../components/Reason";
import Light from "../components/Light";
import Index from "../components/Index";
import Count from "../components/Count";

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
    Count,
  },
};
</script>
