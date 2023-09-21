<script>
import {defineComponent} from "vue";
import {ArrowDownBold} from "@element-plus/icons-vue";

{

}

export default defineComponent({
  components: {ArrowDownBold}
})
</script>

<template>
  <div style ="height:50px;line-height: 50px; border-bottom: 1px solid #ccc;
   display: flex">
    <div style="width:200px; padding-left: 30px; font-weight: bold; color: dodgerblue">
      Management System
    </div>

    <div style="flex: 1">
    </div>

    <div style="width:150px;font-weight: bold;padding-top: 18px">
      <el-dropdown>
    <span class="el-dropdown-link">
      Dropdown List
      <el-icon class="el-icon--right">
        <arrow-down-bold />
      </el-icon>
    </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item>Action 1</el-dropdown-item>
            <el-dropdown-item>Action 2</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<style scoped>
.el-dropdown-link:focus{outline: none;}
</style>