<template>
    <el-container style="height: 100%; border: 1px solid #eee">
        <h3>你好吗？</h3>
        <el-input v-model="user.user_name" placeholder="请输入内容"></el-input>
        <el-input v-model="user.password" placeholder="请输入密码" show-password></el-input>
        <el-button class="ml-5" type="danger" @click="login">登录</el-button> 
    </el-container>
  </template>
  
  <script>
  // @ is an alias to /src
  import HelloWorld from '@/components/HelloWorld.vue'
import router from '../router'
  
  export default {
    name: 'Home',
    
    data() {
      return {
        tableData: [],
        value : 0,
        user: {
            user_name : "admin9527",
            password : "123456"
        }
      }
    },
    created(){
      //请求一个数据
        fetch("http://localhost:8081/login/getUser").then(res => res.json()).then(res =>{
          console.log(res)
          this.tableData = res
        })
    },
    methods:{
        checkUsername()
        {
            this.request.post("http://localhost:8081/login/checkUsername", this.user).then(res =>{
                console.log(res)
            })
        },
        login()
        {
            this.request.post("http://localhost:8081/login/Lo", this.user).then(res =>{
                console.log(res)
                if(res==0)
                {
                    this.$router.push('/')
                }
            })
        },
        
  }
}
  </script>
  