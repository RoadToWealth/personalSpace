/**
 * 页面加载信息
 * Created by HuangZhiCheng on 2018/11/21.
 */

$(function(){
    vm.url="../role/query";
    vm.delUrl="../role/del";
    vm.loadData();
    //遍历树形结构
    $('#tree').treeview({
        data: getTree()//节点数据
    });
});
//设定角色编辑Vue
var roleVm = new Vue({
    el:"#myModal",
    data:{
        //编辑URL
        url:"",
        //角色信息
        RoleInfo:{ }
    },
    methods:{
        //赋值url地址信息
        setUrl:function(url){
            roleVm.url=url;
        },
        //赋值角色信息
        setInfo:function(info){
            roleVm.RoleInfo=info;
        }
    }
});

//打开添加角色信息弹窗
function addMyInfo(){
    //设定编辑保存URL
    roleVm.url="save";
    $("#myModalLabel").text("添加角色信息");
    $("#myModal").modal('show');
}

//打开编辑角色信息弹窗
function editMyInfo(role){
    //设定编辑保存URL
    roleVm.url="update";
    //赋值RoleInfo
    //alert(JSON.stringify(role));
    roleVm.setInfo(role);

    $("#myModalLabel").text("编辑角色信息");
    $("#myModal").modal('show');
}
//打开
function editPermissionInfo(info){
    $("#permissionModel").modal('show');
}

//编辑from清理
function myreset(){
    $("#fm")[0].reset();
    $("#fm").data('bootstrapValidator').destroy();
    $('#fm').data('bootstrapValidator', null);
    fromObjectValidate();
}

function getTree() {
    //节点上的数据遵循如下的格式：
    var tree = [{
        text: "Node 1", //节点显示的文本值  string
        icon: "glyphicon glyphicon-play-circle", //节点上显示的图标，支持bootstrap的图标  string
        selectedIcon: "glyphicon glyphicon-ok", //节点被选中时显示的图标       string
        color: "#ff0000", //节点的前景色      string
        backColor: "#1606ec", //节点的背景色      string
        href: "#http://www.baidu.com", //节点上的超链接
        selectable: true, //标记节点是否可以选择。false表示节点应该作为扩展标题，不会触发选择事件。  string
        state: { //描述节点的初始状态    Object
            checked: true, //是否选中节点
            /*disabled: true,*/ //是否禁用节点
            expanded: true, //是否展开节点
            selected: true //是否选中节点
        },
        tags: ['标签信息1', '标签信息2'], //向节点的右侧添加附加信息（类似与boostrap的徽章）    Array of Strings
        nodes: [

            {
            text: "Child 1",
            nodes: [{
                text: "Grandchild 1"
            }, {
                text: "Grandchild 2"
            }]
        }, {
            text: "Child 2"
        }]
    }, {
        text: "Parent 2",
        nodes: [{
            text: "Child 2",
            nodes: [{
                text: "Grandchild 3"
            }, {
                text: "Grandchild 4"
            }]
        }, {
            text: "Child 2"
        }]
    }, {
        text: "Parent 3"
    }, {
        text: "Parent 4"
    }, {
        text: "Parent 5"
    }
    ];

    return tree;
}
