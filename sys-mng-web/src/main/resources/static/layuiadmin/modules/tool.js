/**
 * 工具模块
 */
layui.define(['jquery', 'layer'], function (exports) {
    //拿到模块变量
    var $ = layui.jquery,
        layer = parent.layer === undefined ? layui.layer : parent.layer;

    //工具函数
    /**
     * 格式化时间
     * @param _time Date类型时间
     * @return yyyy-mm-dd hh:mm
     * */
    function formatTime(_time) {
        var year = _time.getFullYear();
        var month = _time.getMonth() + 1 < 10 ? "0" + (_time.getMonth() + 1) : _time.getMonth() + 1;
        var day = _time.getDate() < 10 ? "0" + _time.getDate() : _time.getDate();
        var hour = _time.getHours() < 10 ? "0" + _time.getHours() : _time.getHours();
        var minute = _time.getMinutes() < 10 ? "0" + _time.getMinutes() : _time.getMinutes();
        return year + "-" + month + "-" + day + " " + hour + ":" + minute;
    }

    /**
     * 判断是否为空
     * @param str 字符串
     * */
    function isBlank(str) {
        if (typeof str === 'undefined' || str === null || $.trim(str) === '') {
            return true;
        }

        return false;
    }

    /**
     * 判断数组是否为空
     * @param arr
     * */
    function isEmpty(arr) {
        if (typeof arr === 'undefined' || arr === null || arr.length === 0) {
            return true;
        }

        return false;
    }

    /**
     * 获取查询字符串参数
     * */
    function getQueryParam() {
        var args = new Object();
        var query = location.search.substring(1);//获取查询串
        var pairs = query.split("&");//在逗号处断开
        for (var i = 0; i < pairs.length; i++) {
            var pos = pairs[i].indexOf('=');//查找name=value
            if (pos == -1) continue;//如果没有找到就跳过
            var argname = pairs[i].substring(0, pos);//提取name
            var value = pairs[i].substring(pos + 1);//提取value
            args[argname] = value;//存为属性
        }
        return args;
    }

    /**
     ** 除
     **/
    function div(arg1, arg2) {
        var t1 = 0, t2 = 0, r1, r2;
        try {
            t1 = arg1.toString().split(".")[1].length;
        }
        catch (e) {
        }
        try {
            t2 = arg2.toString().split(".")[1].length;
        }
        catch (e) {
        }
        with (Math) {
            r1 = Number(arg1.toString().replace(".", ""));
            r2 = Number(arg2.toString().replace(".", ""));
            return (r1 / r2) * pow(10, t2 - t1);
        }
    }

    /**
     * arg1与arg2相除，并以四舍五入的方式保留小数点后2位
     */
    function divide(arg1, arg2) {
        var d1, d2,
            n1 = Number(arg1.toString().replace(".", "")),
            n2 = Number(arg2.toString().replace(".", ""));
        try {d1 = arg1.toString().split(".")[1].length;} catch (e) {d1 = 0;}
        try {d2 = arg2.toString().split(".")[1].length;} catch (e) {d2 = 0;}
        return toFixed((n1 / n2) * Math.pow(10, d2 - d1), 2);
    }

    /**
     * arg以四舍五入的方式保留小数点后n位
     */
    function toFixed(arg, n) {
        if(n == 0) {
            return Math.round(arg)
        }
        try {
            var d, carryD, i,
                ds = arg.toString().split('.'),
                len = ds[1].length,
                b0 = '', k = 0
            if (len > n) {
                while(k < n && ds[1].substring(0, ++k) == '0') {
                    b0 += '0'
                }
                d = Number(ds[1].substring(0, n))
                carryD = Math.round(Number('0.' + ds[1].substring(n, len)))
                len = (d + carryD).toString().length
                if (len > n) {
                    return Number(ds[0]) + 1
                } else if (len == n) {
                    return Number(ds[0] + '.' + (d + carryD))
                }
                return Number(ds[0] + '.' + b0 + (d + carryD))
            }
        } catch (e) {}
        return arg
    }
    /**
     * json对象深拷贝
     * */
    function jsonClone(obj) {
        return JSON.parse(JSON.stringify(obj));
    }

    var $tool = {
        formatTime: formatTime,
        isBlank: isBlank,
        getQueryParam: getQueryParam,
        isEmpty: isEmpty,
        jsonClone:jsonClone,
        div:div,
        divide:divide
    };
    //输出扩展模块
    exports('$tool', $tool);
});
