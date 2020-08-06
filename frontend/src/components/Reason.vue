<template>
  <div>
    <v-container>
      <v-row>
        <v-col cols="12" class="my-10">
          <v-card>
            <v-toolbar color="primary" dark flat dense class="text-center">
              <v-toolbar-title class="text-center">
                <v-icon>mdi-star</v-icon>我不一定赞成每一个人的留言, 但是我觉得每个人想法都渴望被表达
              </v-toolbar-title>
            </v-toolbar>
            <v-container>
              <v-row>
                <v-col v-for="(commit,index) in commits" :key="index">
                  <v-scroll-y-transition>
                    <v-card class="mx-auto" max-width="50vw" dense outlined>
                      <v-toolbar color="info" dark flat dense>
                        <v-toolbar-title>{{commit.name}} 留言:</v-toolbar-title>
                      </v-toolbar>
                      <v-card-text class="text-body-1">{{commit.reason}}</v-card-text>
                      <v-card-actions>
                        <span class="grey--text ml-3">{{commit.createdDate}}</span>
                        <v-spacer></v-spacer>
                        <v-btn
                          color="pink"
                          dark
                          depressed
                          @click="commit.isLike=true"
                          v-if="!commit.isLike"
                        >
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
                  </v-scroll-y-transition>
                </v-col>
                <v-col cols="12">
                  <v-pagination
                    @input="selectPage"
                    total-visible="10"
                    v-model="currPage"
                    class="my-4"
                    :length="totalPages"
                  ></v-pagination>
                </v-col>
              </v-row>
            </v-container>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
export default {
  data() {
    return {
      totalPages: null,
      currPage: 1,
      commits: [],
    };
  },
  created() {
    axios.get("http://localhost:7022/commit/find/0/10").then((resp) => {
      console.log(resp);
      this.commits = resp.data.content;
      this.totalPages = resp.data.totalPages;
    });
  },
  methods: {
    selectPage(currPage) {
      currPage--;
      axios
        .get("http://localhost:7022/commit/find/" + currPage + "/10")
        .then((resp) => {
          this.commits = resp.data.content;
        });
    },
  },
};
</script>

