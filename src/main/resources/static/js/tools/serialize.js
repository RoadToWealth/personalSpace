/**
 * 表单序列化
 * Created by HuangZhiCheng on 2018/8/16.
 */

//表单序列化
$.fn.serializeObject = function()
{
    var o = {};
    var a = this.serializeArray();
    $.each(a, function() {
        if (o[this.name]) {
            if (!o[this.name].push) {
                o[this.name] = [o[this.name]];
            }
            o[this.name].push(this.value || '');
        } else {
            o[this.name] = this.value || '';
        }
    });
    return o;
};

/**
 * 使用方式   alert(JSON.stringify($('#fm').serializeObject()));
 * */