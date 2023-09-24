<script setup>

import {Document, Location, Setting} from "@element-plus/icons-vue";
</script>

<template>
<div>
  <el-row class="tac">
    <el-col>
      <el-menu
          default-active="/emp"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          style="width: 300px;height: calc(100vh - 50px)"
          router
      >
        <el-menu-item index="/emp">
          <template #title>
            <el-icon><location></location></el-icon>
            <span>Employee Management</span>
          </template>
        </el-menu-item>
        <el-menu-item index="/dept">
          <el-icon><setting /></el-icon>
          <span>Department Management</span>
        </el-menu-item>
      </el-menu>
    </el-col>
  </el-row>
</div>
</template>

<style scoped>

</style>