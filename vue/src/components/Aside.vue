<script setup>

import {Document, Location, Setting} from "@element-plus/icons-vue";
</script>

<template>
<div>
  <el-row class="tac">
    <el-col>
      <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          style="width: 200px;height: calc(100vh - 50px)"
      >
        <el-menu-item index="1">
          <template #title>
            <el-icon><location></location></el-icon>
            <span>Navigator One</span>
          </template>
        </el-menu-item>
        <el-menu-item index="2">
          <el-icon><setting /></el-icon>
          <span>Navigator Two</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</div>
</template>

<style scoped>

</style>