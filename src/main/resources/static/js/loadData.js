/**
 * Created by HuangZhiCheng on 2018/7/26.
 * 初始化查询数据公共js
 */
var vm=new Vue({
    el:"#app",
    data:{
        //数据读取虚地址
        url:"",
        //逻辑删除地址
        delUrl:"",
        //分页信息
        pageInfo :{
            "firstPage": 1, //首页
            "lastPage": 2, //尾页
            //数据
            "list": [ ],
            //列表展示页码
            "navigatepageNums": [1],
            "nextPage": 2,//下一页
            "pageNum": 1, //当前页
            "pageSize": 10, //一页展示多少条数据
            "pages": 2, //总共多少页
            "prePage": 0, //上一页
            "total": 15 //总记录数
        },
        //参数
        params : { }

    },
    methods : {
        //初始化数据
        loadData:  function (){
            $.ajaxSetup({
                contentType: "application/json"
            });
            $.post(this.url+"/"+this.pageInfo.pageNum+"/"+this.pageInfo.pageSize,JSON.stringify(vm.params),function(e){
                vm.pageInfo= e.data;
            })
           /* $.ajax({
                url:this.url+"/"+this.pageInfo.pageNum+"/"+this.pageInfo.pageSize,
                type:"post",
                data:JSON.stringify(vm.params),
                contentType:"application/json",
                dataType:"json",
                success: function(e){
                    vm.pageInfo= e.data;
                }
            });*/
        },
        // 切换数据
        pageData: function (page){
            //判断传入值是否在合理范围内
            if(page <= 0){
                page = 1;
            }
            if(page > this.pageInfo.pages){
                page = this.pageInfo.pages
            }
            //判断穿入值是否是当前值
            if(page == this.pageInfo.pageNum){
                return ;
            }
            //更新当前值
            this.pageInfo.pageNum=page;
            //初始数据
            this.loadData(this.pageInfo.pageNum,this.pageInfo.pageSize);
        },
        //搜索
        search:function(){
            this.loadData();
        },
        //重置
        reset:function(){
            vm.params={};
            //初始数据
            this.loadData(this.pageInfo.pageNum,this.pageInfo.pageSize)
        },
        //删除
        del:function(id){
            Ewin.confirm({ message: "确认要删除选择的数据吗？" }).on(function (e) {
                if (!e) {
                    return ;
                }
                $.ajaxSetup({
                    contentType: "application/json"
                });
                var data={"id":id};
                $.post(vm.delUrl,JSON.stringify(data),function(e){
                   if(e == 0){
                       //初始数据
                       vm.loadData(vm.pageInfo.pageNum,vm.pageInfo.pageSize);
                   }
                })
            })
        },
        //拼接字符
        concat:function(str1,str2){
            return str1+str2;
        },
        //添加
        addInfo:function(){
            //各个子页面添加函数
            addMyInfo();
        },
        //修改信息
        editInfo:function(info){
            editMyInfo(info);
        },
        //修改用户状态
        editInfoStatus:function(info){
            editInfoStatus(info);
        },
        //资源授权
        editPermissionInfo:function(info){
            editPermissionInfo(info);
        }


    },
    filters: {
        /* 时间过滤器 */
        formatDate(time) {
            var date = new Date(time);
            return formatDate(date, "yyyy-MM-dd HH:mm:ss");
        }
    }
});

//回车键登录
$(document).keyup(function(event){
    if(event.keyCode ==13){
        vm.loadData();
    }
});