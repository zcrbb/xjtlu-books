<template>
  <div>
    <AppBar></AppBar>
    <Index></Index>
    <Articlezh></Articlezh>
    <Count></Count>
    <MessageDisplay></MessageDisplay>
    <MessageCommit></MessageCommit>
    <Ending></Ending>
  </div>
</template>

<script>
import MessageCommit from "../components/MessageCommit";
import MessageDisplay from "../components/MessageDisplay";
import Ending from "../components/Ending";
import Index from "../components/Index";
import Count from "../components/Count";
import AppBar from "../components/AppBar";
import Articlezh from "../components/ArticleZh";

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
    MessageCommit,
    MessageDisplay,
    Index,
    Ending,
    Count,
    AppBar,
    Articlezh
  },
};
</script>
