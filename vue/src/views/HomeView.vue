<template>
  <div style="width:100%;padding: 10px">

    <div style="display: flex; padding: 10px;">
      <!--    functional button-->
      <el-button type="primary">Add new data</el-button>

      <!--    search bar-->
      <div style="margin:0 auto; display: flex;width:20%;">
      <el-input v-model="search" placeholder="Enter keyword"></el-input>
        <div style="margin-left: 5px">
          <el-button type="primary">Search</el-button>
        </div>
      </div>
    </div>
    <el-table :data="tableData" stripe border style="width: 100%">

      <el-table-column prop="date" label="Date" sortable/>
      <el-table-column prop="name" label="Name"/>
      <el-table-column prop="address" label="Address" />

      <el-table-column label="Operations" width="120">

<!--        operations-->
        <template #default>
          <el-button link type="primary" size="default" @click="handleEdit">Edit</el-button>
          <el-popconfirm title="Are you sure to delete?">
            <template #reference>
          <el-button link type="primary" size="default" @click="handleDelete">Delete</el-button>
            </template>
          </el-popconfirm>
        </template>

      </el-table-column>

    </el-table>
    <div style="position: absolute;bottom: 50px; left : 50% ">
      <el-pagination
          :page-size="[5,10,20]"
          :pager-count="6"
          layout="prev, pager, next, jumper"
          :total="total"
          :current-page="currentPage"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

export default {
  name: 'HomeView',
  components: {

  },
  data(){
    return {
      search:'',
      currentPage : 1,
      total:100,
      tableData : [
        {
          date:'2016-05-03',
          name:'Tom',
          address:'132'
        }
      ]
    }
  },
  methods: {
    handleEdit() {},
    handleDelete() {},
    handleSizeChange() {},
    handleCurrentChange() {}

  }
}
</script>
