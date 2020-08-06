<template>
  <div>
    <!-- <v-progress-linear buffer-value="50" stream color="error"></v-progress-linear> -->
    <v-container>
      <v-row align="center" justify="center">
        <v-col cols="12">
          <v-card color="primary">
            <!-- <v-toolbar color="primary" flat>如果您支持本次活动, 请点个赞</v-toolbar> -->
            <v-container>
              <v-row align="center" justify="center">
                <v-col cols="12">
                  <div class="text-center text-h1 pt-10 white--text">{{count}}</div>
                </v-col>
                <v-col cols="4">
                  <v-text-field
                    :rules="countRules"
                    label="您的称呼"
                    v-model="name"
                    single-line
                    solo
                    class="mb-n8 pt-10"
                  ></v-text-field>
                </v-col>
                <v-col cols="12">
                  <div class="text-center">
                    <v-btn
                      dark
                      color="red darken-2"
                      v-if="!support"
                      large
                      @click="snackbar = true;support=!support;count++"
                    >我拒绝学校强制购买课本</v-btn>
                    <v-btn
                      dark
                      color="red darken-2"
                      v-else
                      disabled
                      large
                      @click="snackbar = true"
                    >您已发声</v-btn>

                    <v-snackbar v-model="snackbar" :multi-line="multiLine">
                      {{ text }}
                      <template v-slot:action="{ attrs }">
                        <v-btn color="red" text v-bind="attrs" @click="snackbar = false">Close</v-btn>
                      </template>
                    </v-snackbar>
                  </div>
                </v-col>
                <v-col></v-col>
              </v-row>
            </v-container>
          </v-card>
        </v-col>
      </v-row>
    </v-container>
  </div>
</template>

<script>
import Axios from 'axios';
export default {
  data() {
    return {
      multiLine: true,
      snackbar: false,
      text: "成功!",
      support: false,
      name: "",
      count: 500,
      countRules: [
        (v) => {
          return v.length >= 2 || "太短啦 / Too short";
        },
      ],
      created() {
        Axios.get("http://localhost:7022/count/")
      },
      methods: {
        sendCount(){
          this.count++;
          Axios.post("http://localhost:7022/count/add")
        }
      },
    };
  },
};
</script>

<style>
</style>