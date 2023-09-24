<template>
  <div>
      <router-view/>
  </div>
</template>

<style>

</style>

<script>
  import Header from "@/components/Header.vue";
  import Aside from "@/components/Aside.vue";

  export default {
    name:"App",
    components:{
      Header,
      Aside
    }
  }
</script>
