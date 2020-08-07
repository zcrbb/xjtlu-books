<template>
  <div>
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
        <!-- <v-col cols="12" class="text-center">
          <iframe
            width="800px"
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
        </v-col>-->
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {};
</script>

<style>
</style>