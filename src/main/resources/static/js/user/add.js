/**
 * 用户填写表单验证
 */
$(function () {
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
            userName: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '用户名不能为空'
                    },
                    stringLength: {//检测长度
                        min: 3,
                        max: 30,
                        message: '长度必须在3-30之间'
                    },
                    regexp: {//正则验证
                        regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                        message: '用户名只能由字母、数字、点、下划线和汉字组成'
                    }
                }
            },
            userCode: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '请登录账号不能为空'
                    },
                    stringLength: {//检测长度
                        min: 3,
                        max: 30,
                        message: '长度必须在3-30之间'
                    },
                    regexp: {//正则验证
                        regexp: /^[a-zA-Z0-9]+$/,
                        message: '用户名只能由字母、数字组成'
                    }
                }
            },
            email: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: 'email 不能为空'
                    },
                    emailAddress: {
                        message: '请输入正确的邮件地址如：123@qq.com'
                    }
                }
            },
            phone: {
                validators: {
                    notEmpty: {
                        message: '手机号不能为空'
                    },
                    regexp: {
                        regexp: "^([0-9]{11})?$",
                        message: '手机号码格式错误'
                    }
                }
            },
            address: {
                validators: {
                    notEmpty: {
                        message: '地址不能为空'
                    }, stringLength: {
                        min: 5,
                        max: 60,
                        message: '请输入5到60个字符'
                    }
                }
            },
            note: {
                validators: {
                    notEmpty: {
                        message: '备注不能为空'
                    }, stringLength: {
                        min: 5,
                        max: 60,
                        message: '请输入5到60个字符'
                    }
                }
            }




        }
    });
    /**
     * 添加
     */
    $("#addButton").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证

       // alert(JSON.stringify($('#fm').serializeObject()));
        $("#fm").bootstrapValidator('validate');//提交验证
        if ($("#fm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            $.ajax({
                url:"add",
                type:"post",
                data:JSON.stringify($('#fm').serializeObject()),
                contentType:"application/json",
                dataType:"json",
                success: function(e){
                    var info = "用户信息保存失败，请稍后再试！";
                   if(e == 0){
                       info="信息保存成功！";
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
                        parent.vm.switchpage('user/index');
                    });

                }
            });
        }
    });
    /**
     * 修改
     */
    $("#editButton").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        // alert(JSON.stringify($('#fm').serializeObject()));
        $("#fm").bootstrapValidator('validate');//提交验证
        if ($("#fm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            $.ajax({
                url:"../edit",
                type:"post",
                data:JSON.stringify($('#fm').serializeObject()),
                contentType:"application/json",
                dataType:"json",
                success: function(e){
                    var info = "用户信息修改失败，请稍后再试！";
                    if(e == 0){
                        info="信息修改成功！";
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
                        parent.vm.switchpage('user/index');
                    });

                }
            });
        }
    });
});
