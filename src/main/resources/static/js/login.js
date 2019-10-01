/**
 * 登录页面js
 */
$(function () {
    $('input').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' /* optional */
    });
    $('input:checkbox[name="rememberMe"]').on('ifChecked ifUnchecked', function(event){
        if (event.type == 'ifChecked') {
            vm.rememberMe=true;
        } else {
            vm.rememberMe=false;
        }
    });

});
//回车键登录
$(document).keyup(function(event){
    if(event.keyCode ==13){
       vm.submit();
    }
});


//获取验证码
function getVerify(obj){
    obj.src ="getVerify?rnd="+Math.random();
}

var vm =  new Vue({
    el: '#app',
    data: {
        //用户名
        userName:"",
        checkUserName:false,
        userNameMsg:"用户名不能为空，请输入用户名！",
        //密码
        passWord:"",
        checkPassWord:false,
        passWordMsg:"密码不能为空，请输入密码！",
        //验证码
        verify:"",
        checkVerify:false,
        verifyMsg:"验证码不能为空，请输入验证码!",
        //登录提示
        flag: false,
        msg:"这是一个错误的提示",
        //记住我
        rememberMe: false,
        //提交防止重复点击
        countClick:true
    },
    methods:{
        submit:function(){
            if(!this.countClick){
                return ;
            }
            this.countClick=false;
            if(!this.validateFrom()){
                this.countClick=true;
                return ;
            }
            $.post("login_in",{"username":this.userName,"password":this.passWord,"rememberMe":this.rememberMe,"verify":this.verify},function(val){
                var obj=JSON.parse(val);
                if(obj.code == "0001"){
                    vm.countClick=true;
                    vm.msg=obj.msg;
                    vm.flag=true;
                    $("#imgVerify").attr("src","getVerify?rnd="+Math.random());
                }else{
                    window.location.href="index";
                }
            })
        },
        validateFrom:function(){
            //用户名
            if(this.userName == ""){
                this.checkUserName=true;
                return false;
            }
            //密码
            if(this.passWord == ""){
                this.checkPassWord=true;
                return false;
            }
            //验证码
            if(this.verify == ""){
                this.checkVerify=true;
                return false;
            }
            return true;
        }
    },
    watch:{
        userName:function(val){
            if(val == ""){
                this.checkUserName=true;
                this.flag=false;
            }else{
                this.checkUserName=false;
            }
        },
        passWord:function(val){
            if(val == ""){
                this.checkPassWord=true;
                this.flag=false;
            }else{
                this.checkPassWord=false;
            }
        },
        verify:function(val){
            if(val == ""){
                this.checkVerify=true;
                this.flag=false;
            }else{
                this.checkVerify=false;
            }
        }

    }
})
