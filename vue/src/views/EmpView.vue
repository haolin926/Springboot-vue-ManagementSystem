<template>
  <div style="width:100%;padding: 10px">

    <div style="display: flex; padding: 10px;">
      <!--    functional button add new data-->
      <el-button type="primary" @click = "add()">Add new data</el-button>
      <!--dialog for input user data-->
      <el-dialog
          v-model="dialogVisible"
          title="Tips"
          width="35%"
          :before-close="handleClose"
      >
        <span style="justify-content: center; align-self: center">
          <el-form :model="newDataForm" label-width="25%">
            <el-form-item label="Name">
              <el-input v-model="newDataForm.name"/>
            </el-form-item>
            <el-form-item label="Age">
              <el-input v-model="newDataForm.age" />
            </el-form-item>
            <el-form-item label="Gender">
              <el-radio-group v-model="newDataForm.gender">
                <el-radio label="Male" />
                <el-radio label="Female" />
              </el-radio-group>
            </el-form-item>
            <el-form-item label="Address">
              <el-input v-model="newDataForm.address" type="textarea"/>
            </el-form-item>
            <el-form-item label="Department ID">
              <el-input v-model="newDataForm.deptId" />
            </el-form-item>
          </el-form>
        </span>
        <template #footer>
          <span class="dialog-footer">
            <el-button @click="dialogVisible = false">Cancel</el-button>
            <el-button type="primary" @click="submitNewData()">
              Confirm
            </el-button>
          </span>
        </template>
      </el-dialog>

      <!--search bar-->
      <div style="margin:0 auto; display: flex;width:20%;">
        <el-input v-model="search" placeholder="Enter name to search..." clearable></el-input>
          <div style="margin-left: 5px">
              <el-button type="primary" @click ="load">Search</el-button>
          </div>
      </div>
    </div>

    <!--table to display data-->
    <el-table :data="tableData" stripe border style="width: 100%">
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="name" label="Name"/>
      <el-table-column prop="age" label="Age" />
      <el-table-column prop="address" label="Address" />
      <el-table-column prop="deptId" label="Department ID" />

      <!--operations-->
      <el-table-column label="Operations" width="120">
        <template #default = "scope">
          <el-button link type="primary" size="default" @click="handleEdit(scope.row)">Edit</el-button>
          <el-popconfirm title="Are you sure to delete?" @confirm = "handleDelete(scope.row.id)">
          <template #reference>
            <el-button link type="primary" size="default">Delete</el-button>
          </template>
          </el-popconfirm>
        </template>
      </el-table-column>

    </el-table>

    <!--pagination-->
    <div style="position: absolute;bottom: 50px; left : 50% ">
      <el-pagination
          :page-size="pageSize"
          :pager-count="6"
          layout="prev, pager, next, jumper"
          :total="total"
          :current-page="pageNum"
          @current-change="handleCurrentChange"
      />
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

import request from "@/utils/request";

export default {
  name: 'HomeView',
  components: {

  },
  data(){
    return {
      search:'',
      pageNum : 1,
      total:100,
      dialogVisible : false,
      pageSize : 5,
      newDataForm: {},
      tableData : []
    }
  },
  methods: {
    handleEdit(row) {
      this.newDataForm = JSON.parse(JSON.stringify(row))
      this.dialogVisible = true
    },
    resultCheck(res)
    {
      console.log(res)
      if(res.code === "1")
      {
        this.$message({
          type: "success",
          message: res.msg
        })
      }
      else
      {
        this.$message({
          type: "error",
          message : res.msg
        })
      }
    },
    handleDelete(id) {
      request.delete("/emp/" + id).then(res =>{
        this.resultCheck(res)
        this.load()
      })
    },
    handleCurrentChange(pageNum) {
      this.pageNum = pageNum
      this.load()
    },
    add(){
      this.dialogVisible = true
      this.newDataForm = {}
    },
    submitNewData()
    {
      // if there is a id inside form shows this is a update request
      if(this.newDataForm.id)
      {
        request.put("emp/update",this.newDataForm).then(res => {
          this.resultCheck(res)
        })
      }
      else {
        request.post("/emp/save", this.newDataForm).then(res => {
          this.resultCheck(res)
        })
      }
      //close dialog
      this.dialogVisible = false
      this.load()//refresh data displaying
    },
    load()
    {
      request.get("/emp", {
        params: {
          pageNum: this.pageNum,
          pageSize: this.pageSize,
          search: this.search
        }
          }).then(res =>{
            console.log(res)
            this.tableData = res.data.rows
            this.total = res.data.total
      })

      request.get("/emp/dept").then(res =>{
        console.log(res)
      })

      console.log(this.tableData)
    },
  },
  mounted() {
    this.load()
  }
}
</script>
