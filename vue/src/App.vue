<template>
  <div>
    <Header></Header>

    <div style="display: flex">
        <Aside></Aside>
      <router-view/>
    </div>
  </div>
</template>

<style>

</style>

<script>
  import Header from "@/components/Header.vue";
  import Aside from "@/components/Aside.vue";

  export default {
    name:"Layout",
    components:{
      Header,
      Aside
    }
  }
</script>
