/**
 * Created by HuangZhiCheng on 2018/11/21.
 * 角色信息编辑信息
 */
$(function () {
     //表单验证
    fromObjectValidate();

    //添加角色信息
    $("#editButton").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证
        // alert(JSON.stringify($('#fm').serializeObject()));
        $("#fm").bootstrapValidator('validate');//提交验证
        if ($("#fm").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
            $.ajax({
                url:roleVm.url,
                type:"post",
                data:JSON.stringify($('#fm').serializeObject()),
                contentType:"application/json",
                dataType:"json",
                success: function(e){
                    var info = "角色信息保存失败，请稍后再试！";
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
                        //关闭模态窗
                        $("#myModal").modal('hide');
                        //重载页面数据信息
                        vm.loadData();
                        //清理from 表单
                        myreset();
                    });

                }
            });
        }
    });


});


//表单验证
function fromObjectValidate(){
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
            name: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '角色名称不能为空！'
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
            remark: {
                validators: {
                    notEmpty: {//检测非空,radio也可用
                        message: '角色备注不能为空！'
                    },
                    stringLength: {//检测长度
                        min: 3,
                        max: 30,
                        message: '长度必须在3-15之间'
                    },
                    regexp: {//正则验证
                        regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 ]+$/,
                        message: '用户名只能由字母、数字、点、下划线和汉字组成'
                    }
                }
            }
        }
    });
}