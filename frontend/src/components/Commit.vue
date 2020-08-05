<template>
  <v-container class="fill-height" fluid>
    <v-row align-center justify-center>
      <v-col xs12 sm8 md4>
        <v-card class="mx-auto" max-width="600">
          <v-toolbar color="success" dark flat>
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
            <v-btn color="primary" type="submit" form="login-form" :loading="loading" depressed large outlined>提交</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      commitForm: {
        name: "",
        reason: "",
      },
      loading: false,
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
    commitInfo() {
      this.$axios
        .post("/login", {
          username: this.loginForm.username,
          password: this.loginForm.password,
        })
        .then((successResponse) => {
          if (successResponse.data.code === 200) {
            this.$router.replace({ path: "/index" });
          }
        })
        .catch((failResponse) => {});
    },
  },
};
</script>