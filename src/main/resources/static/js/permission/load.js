/**
 * 资源信息初始化
 * Created by HuangZhiCheng on 2018/11/23.
 */
//设定角色编辑Vue
var  permissionVm = new Vue({
    el:"#myModal",
    data:{
        //编辑URL
        url:"",
        //资源信息
        permissionInfo:{
         "type":"1",
         "viewFlag":"0",
         "parentid":"0"
        },
        //父菜单列表
        menuList:[  ]
    },
    methods:{
        //赋值url地址信息
        setUrl:function(url){
            permissionVm.url=url;
        },
        //赋值角色信息
        setInfo:function(info){
            permissionVm.permissionInfo=info;
        },
        //后台获取父类菜单
        findMeun:function(){
            $.ajaxSetup({
                contentType: "application/json"
            });
            $.post("findParentMenu",{},function(e){
                permissionVm.menuList= e.data;
            })
        }
    }
});

//打开添加资源信息弹窗
function addMyInfo(){
    //设定编辑保存URL
    permissionVm.url="save";
    $("#myModalLabel").text("添加资源信息");
    $("#myModal").modal('show');
}

//打开编辑资源信息弹窗
function editMyInfo(info){
    //设定编辑保存URL
    permissionVm.url="update";
    //赋值RoleInfo
    //alert(JSON.stringify(role));
    permissionVm.setInfo(info);

    $("#myModalLabel").text("编辑资源信息");
    $("#myModal").modal('show');
}
//修改用户状态
function editInfoStatus(info){
    Ewin.confirm({ message: "确认要修改数据状态？" }).on(function (e) {
        if (!e) {
            return ;
        }
        $.ajaxSetup({
            contentType: "application/json"
        });
        $.post(vm.delUrl,JSON.stringify(info),function(e){
            if(e == 0){
                //初始数据
                vm.loadData(vm.pageInfo.pageNum,vm.pageInfo.pageSize);
            }
        })
    })
}
//编辑from清理
function myreset(){
    $("#fm")[0].reset();
    $("#fm").data('bootstrapValidator').destroy();
    $('#fm').data('bootstrapValidator', null);
    fromObjectValidate();
}
