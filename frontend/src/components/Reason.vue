<template>
  <div>
    <v-container>
      <v-row>
        <v-col cols="12" class="my-10">
          <v-toolbar color="primary" dark flat dense class="text-center">
            <v-toolbar-title class="text-center">
              <v-icon>mdi-star</v-icon>我不一定赞成每一个人的留言, 但是我觉得每个人想法都渴望被表达
            </v-toolbar-title>
          </v-toolbar>
        </v-col>

        <v-col v-for="(commit,index) in commits" :key="index">
          <v-card class="mx-auto" max-width="50vw" dense>
            <v-toolbar color="info" dark flat dense>
              <v-toolbar-title>{{commit.user}} 留言:</v-toolbar-title>
            </v-toolbar>
            <v-card-text class="text-body-1">{{commit.reason}}</v-card-text>
            <v-card-actions>
              <span class="grey--text ml-3">{{commit.createdDate}}</span>
              <v-spacer></v-spacer>
              <v-btn color="pink" dark depressed @click="commit.isLike=true" v-if="!commit.isLike">
                <v-icon>mdi-heart</v-icon>
                {{commit.likeNumber}}
              </v-btn>
              <v-scroll-y-transition>
                <v-btn color="pink" text disabled v-if="commit.isLike">
                  <span>已赞同</span>
                  {{commit.likeNumber}}
                </v-btn>
              </v-scroll-y-transition>
            </v-card-actions>
          </v-card>
        </v-col>
        <v-col cols="12">
          <v-pagination v-model="page" class="my-4" :length="5"></v-pagination>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      page: 1,
      commits: [
        {
          user: "一位不愿透露姓名的陌生人",
          reason: "学校这么做不对",
          likeNumber: "1100",
          createdDate: "2020-08-03",
          isLike: false,
        },
        {
          user: "一位不愿透露姓名的陌生人2",
          reason: "学校这么应该做不对",
          createdDate: "2020-08-03",
          likeNumber: "1101",
          isLike: false,
        },
        {
          user: "另一位不愿透露姓名的陌生人2",
          reason: "学校这么也许做不对",
          createdDate: "2020-08-03",
          likeNumber: "10",
          isLike: false,
        },
        {
          user: "另一位不愿透露姓名的陌生人2",
          reason: "学校这么也许做不对",
          createdDate: "2020-08-03",
          likeNumber: "10",
          isLike: false,
        },
      ],
    };
  },
};
</script>

<style>
</style>