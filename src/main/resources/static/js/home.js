/**
 * Created by HuangZhiCheng on 2018/9/26.
 */

//修改密码
$(function () {

   //表单验证
    fromValidate();

    //提交
    $("#editButton").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        // alert(JSON.stringify($('#fm').serializeObject()));
        $("#fm").bootstrapValidator('validate');//提交验证
        if ($("#fm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            var data={"passwd":$("#passwd").val()};
            $.ajax({
                url:"pwEdit",
                type:"post",
                data:JSON.stringify(data),
                contentType:"application/json",
                dataType:"json",
                success: function(e){
                    var info = "密码失败，请稍后再试！";
                    if(e == 0){
                        info="密码修改成功！！";
                    }
                    //提示话语
                    Ewin.alert({
                        title:"温馨提示",
                        message: info,
                        auto:true
                    }).on(function (e) {
                        if (!e) {
                            return;
                        }
                        //退出
                        window.location.href="logout";
                    });

                }
            });
        }
    });

});


//表单验证
function fromValidate(){
    $("#fm").bootstrapValidator({
        live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的
        submitButtons: '#btn-test',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
        message: '通用的验证失败消息',//好像从来没出现过
        feedbackIcons: {//根据验证结果显示的各种图标
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
            pw: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '原密码不能为空'
                    },
                    stringLength: {//检测长度
                        min: 6,
                        max: 30,
                        message: '长度必须在6-30之间'
                    },
                    regexp: {//正则验证
                        regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                        message: '原密码只能由字母、数字、点、下划线和汉字组成'
                    },
                    remote: {//将内容发送至指定页面验证，返回验证结果，比如查询用户名是否存在
                        url: 'getPassword',
                        message: '原密码输入不正确！'
                    }
                }
            },
            passwd: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '新密码不能为空'
                    },
                    stringLength: {//检测长度
                        min: 6,
                        max: 30,
                        message: '长度必须在6-30之间'
                    },
                    regexp: {//正则验证
                        regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                        message: '新密码只能由字母、数字、点、下划线和汉字组成'
                    }
                }
            },
            repasswd: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '确认密码不能为空'
                    },
                    stringLength: {//检测长度
                        min: 6,
                        max: 30,
                        message: '长度必须在6-30之间'
                    },
                    regexp: {//正则验证
                        regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                        message: '确认密码只能由字母、数字、点、下划线和汉字组成'
                    },
                    identical: {//与指定控件内容比较是否相同，比如两次密码不一致
                        field: 'passwd',//指定控件name
                        message: '两次密码不一致'
                    }
                }
            }

        }
    });

}

