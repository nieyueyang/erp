//jqGrid的配置信息
$.jgrid.defaults.width = 1000;
$.jgrid.defaults.responsive = true;
$.jgrid.defaults.styleUI = 'Bootstrap';

//解析当前URL参数
function getQueryString(name) {
    //var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) {
        return decodeURI(r[2]);
    } else {
        return null;
    }
}

//重写alert
window.alert = function (msg, callback) {
    parent.layer.alert(msg, function (index) {
        parent.layer.close(index);
        if (typeof (callback) === "function") {
            callback("ok");
        }
    });
}

//ajax全局处理
if (window.jQuery) {

    //ajax预处理
    jQuery(document).bind("ajaxSend", function (event, request, settings) {
        var authorization = localStorage.getItem("Authorization");
        if (!isBlank(authorization)) {
            //var headers = settings.headers || {};
            //headers["Authorization"] = authorization;
            request.setRequestHeader("Authorization", authorization);
            //settings.headers = headers;
        } else {
            //返回错误页
            parent.location.href = baseURL + "error.html"
        }
    }).bind("ajaxComplete", function (event, result, settings) {  //后置处理
        var response = result.responseJSON;
        if (response == null) {
            return result;
        }
        var code = response.code;
        var msg = response.msg;
        if (code && code != 200) {
            if (code == 20001 || code == 20002 || code == 20003 || code == 20005) {
                //返回错误页
                parent.location.href = baseURL + "error.html"
            } else {
                alert(msg);
            }
        }
    });
}

//重写confirm式样框
window.confirm = function (msg, callback) {
    parent.layer.confirm(msg, {btn: ['确定', '取消']},
        function () {//确定事件
            if (typeof (callback) === "function") {
                callback("ok");
            }
        });
}

//选择一条记录
function getSelectedRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        alert("请选择一条记录");
        return;
    }

    var selectedIDs = grid.getGridParam("selarrrow");
    if (selectedIDs.length > 1) {
        alert("只能选择一条记录");
        return;
    }

    return selectedIDs[0];
}

//选择一条记录
function getSelectedOneRow() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        alert("请选择一条记录");
        return;
    }

    var selectedIDs = grid.getGridParam("selarrrow");
    if (selectedIDs.length > 1) {
        alert("只能选择一条记录");
        return;
    }
    var rowData = grid.getRowData(rowKey);
    return rowData;
}

//选择多条记录Id
function getSelectedRows() {
    var grid = $("#jqGrid");
    var rowKey = grid.getGridParam("selrow");
    if (!rowKey) {
        alert("请选择一条记录");
        return;
    }
    return grid.getGridParam("selarrrow");
}


//选择多条记录数据
function getSelectedRowDatas() {
    var grid = $("#jqGrid");
    var ids = grid.getGridParam("selarrrow");
    if(ids == 0){
        alert("至少选择一条记录");
        return;
    }
    var list = [];
    for (var i = 0; i < ids.length; i++) {
        list.push(grid.getRowData(ids[i]));
    }
    return list;
}



//判断是否为空
function isBlank(value) {
    return !value || !/\S/.test(value)
}

//判断是否为数字
function isRealNum(val) {
    // isNaN()函数 把空串 空格 以及NUll 按照0来处理 所以先去除
    if (val.trim() === "" || val.trim() == null) {
        return false;
    }
    if (!isNaN(val)) {
        return true;
    } else {
        return false;
    }
}

/* 检测鼠标移动事件 */
// document.addEventListener('mousemove', function() {
//     // 更新最后的操作时间
//     lastTime = new Date().getTime();
//     console.info('鼠标移动了')
//     var currentTime = new Date().getTime();
// })


/* 检测鼠标点击事件 */
document.addEventListener('click', function () {
    // 更新最后的操作时间
    if (localStorage.getItem("Authorization") != null) {
        localStorage.setItem("lastTime" ,new Date().getTime());
    }
});


//设置超时时间： 29分
var timeOut = 1000 * 60 * 29;

/* 定时器  间隔1分钟，检测是否长时间未操作页面  */
var quitTime = window.setInterval(checkTimeout, 60000);

// 检查超时函数
function checkTimeout() {
    //更新当前时间
    var currentTime = new Date().getTime();
    //判断是否超时
    if (currentTime - localStorage.getItem("lastTime") >= timeOut) {
        localStorage.clear();
        clearInterval(quitTime);
    } else {
        getToken(currentTime);
    }
}

function getToken(currentTime) {
    if (currentTime - localStorage.getItem("beginTime") >= timeOut) {
        $.ajax({
            type: "GET",
            url: baseURL + "token",
            data: "",
            success: function (result) {
                if (result.code == 200) {
                    localStorage.setItem("Authorization", result.data);
                    localStorage.setItem("beginTime",new Date().getTime());
                }
            }
        });
    }
}

//监控 localStorage 的变化
// window.addEventListener('storage', function (e) {
//     console.log('key', e.key); console.log('oldValue', e.oldValue);
//     console.log('newValue', e.newValue); console.log('url', e.url);
// });