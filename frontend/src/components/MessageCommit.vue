<template>
  <v-container class="fill-height" fluid>
    <v-row align-center justify-center>
      <v-col cols="12">
        <!-- 留言上传卡 -->
        <v-card class="mx-auto" max-width="76vw" v-if="!isCommit">
          <v-toolbar color="indigo" dark flat>
            <v-toolbar-title>请留言</v-toolbar-title>
          </v-toolbar>

          <v-card-text>
            <v-text-field
              label="姓名"
              name="username"
              prepend-icon="mdi-account"
              v-model="commitForm.name"
              :rules="nameRules"
              type="text"
            ></v-text-field>

            <v-textarea
              prepend-icon="mdi-comment"
              class="mt-3"
              v-model="commitForm.reason"
              fluid
              label="留言"
              auto-grow
              :rules="reasonRules"
            ></v-textarea>
          </v-card-text>
          <v-card-actions>
            <span class="grey--text text--lighten-1 ml-3">*请不要使用不文明词汇</span>
            <span class="text"></span>
            <v-spacer></v-spacer>
            <v-btn
              color="primary"
              type="submit"
              depressed
              large
              outlined
              @click="getAllMessage()"
            >提交</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
      <v-col cols="12">
        <v-card
          class="mx-auto text-center text-h2"
          dark
          max-width="76vw"
          height="350px"
          v-if="isCommit"
          color="indigo"
        >
          <v-container fill-height>
            <v-row align="center" justify="center">
              <v-col>感谢留言</v-col>
            </v-row>
          </v-container>
        </v-card>
      </v-col>
    </v-row>
    <v-snackbar v-model="snackbar">
      您已成功留言ヾ(≧▽≦*)o
      <template v-slot:action="{ attrs }">
        <v-btn color="red" text v-bind="attrs" @click="snackbar = false">Close</v-btn>
      </template>
    </v-snackbar>
  </v-container>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      snackbar: false,
      isCommit: false,
      commitForm: {
        name: "",
        reason: "",
        likeNumber: 0,
      },

      // 注册模式/登录模式
      nameRules: [
        (v) => {
          return v.length >= 2 || "太短啦 / Too short";
        },
      ],
      reasonRules: [
        (value) => {
          return value.length >= 5 || "太短啦 / Too short.";
        },
      ],
      responseResult: [],
    };
  },
  methods: {
    getAllMessage() {
      axios.post("commit/save", this.commitForm).then((response) => {
        if (response.data == true) {
          this.snackbar = true;
          this.commitForm.name = "";
          this.commitForm.reason = "";
          this.commitForm.likeNumber = 0;
          this.isCommit = true;
        }
      });
    },
  },
};
</script>