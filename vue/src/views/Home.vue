<!--

<template>
  <div class="home">
     <el-button type="danger">{{msg}}</el-button>
    <img alt="Vue logo" src="../assets/logo.png">
    
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  data(){
    return {
      msg: "嗷呜！"
    }
  }
}
</script>
-->

<template>
  <el-container style="height: 100%; border: 1px solid #eee">
      <el-aside width="200px" style="background-color: rgb(238, 241, 246) height: 100%">
        <el-menu :default-openeds="['1', '3']" style="min-height: 100%; overflow-x: hidden" background-color="rgb(48, 65, 86)"
                  text-color="#fff" >
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-message"></i>导航一</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="1-1">选项1</el-menu-item>
              <el-menu-item index="1-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="1-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="1-4">
              <template slot="title">选项4</template>
              <el-menu-item index="1-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="2">
            <template slot="title"><i class="el-icon-menu"></i>导航二</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="2-1">选项1</el-menu-item>
              <el-menu-item index="2-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="2-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="2-4">
              <template slot="title">选项4</template>
              <el-menu-item index="2-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
          <el-submenu index="3">
            <template slot="title"><i class="el-icon-setting"></i>导航三</template>
            <el-menu-item-group>
              <template slot="title">分组一</template>
              <el-menu-item index="3-1">选项1</el-menu-item>
              <el-menu-item index="3-2">选项2</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="分组2">
              <el-menu-item index="3-3">选项3</el-menu-item>
            </el-menu-item-group>
            <el-submenu index="3-4">
              <template slot="title">选项4</template>
              <el-menu-item index="3-4-1">选项4-1</el-menu-item>
            </el-submenu>
          </el-submenu>
        </el-menu>
      </el-aside>
      
      <el-container>
        <el-header style="text-align: right; font-size: 12px; border-bottom: 1px solid #ccc">
          <el-dropdown>
            <i class="el-icon-setting" style="margin-right: 15px"></i>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>查看</el-dropdown-item>
              <el-dropdown-item>新增</el-dropdown-item>
              <el-dropdown-item>删除</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
          <span>王小虎</span>
        </el-header>

        <div style="padding: 10px 0">
          <el-input style="width: 240px" suffix-icon="el-icon-search" placeholder="请输入名称" ></el-input>
          <el-input style="width: 240px" suffix-icon="el-icon-menu" placeholder="请输入品牌" ></el-input>
          <el-input style="width: 240px" suffix-icon="el-icon-chicken" placeholder="请选取价格" ></el-input>
          <el-button class="ml-5" type="danger" @click="$router.push('/register')">进入另一个页面</el-button> 
          <el-button class="ml-5" type="primary">搜索</el-button>
        </div>

        <div style="margin: 20px">
          <el-button class="ml-5" type="primary" icon="el-icon-circle-plus-outline">新增</el-button>
          <el-button class="ml-5" type="danger" icon="el-icon-remove-outline">批量删除</el-button> 
        </div>
        
        <el-main>
          <el-table :data="tableData">
            <el-table-column prop="phone_number" label="手机号" width="140">
            </el-table-column>
            <el-table-column prop="user_name" label="用户名" width="120">
            </el-table-column>
            <el-table-column prop="password" label="密码">
            </el-table-column>
            <el-table-column>
              <template slot-scope="scope">
                <el-button type="primary">编辑</el-button>
                <el-button type="danger">删除</el-button>
              </template>
            </el-table-column>
          </el-table>
        </el-main>
        <div style="padding: 10px 0">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage4"
            :page-sizes="[5, 10, 15, 20]"
            :page-size="10"
            layout="total, sizes, prev, pager, next, jumper"
            :total="400">
          </el-pagination>
        </div>
      </el-container>
  </el-container>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'

export default {
  name: 'Home',
  
  data() {
    return {
      tableData: [],

    }
  },
  created(){
    //请求一个数据
      fetch("http://localhost:8081/login/getUser").then(res => res.json()).then(res =>{
        console.log(res)
        this.tableData = res
      })
  }
}
</script>
