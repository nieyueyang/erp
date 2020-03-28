var domain = "http://localhost";
var port = 8080;
var projectName = "erp";
var baseURL = domain + ":" + port + "/" + projectName + "/";

function ajaxWrapper(url, options, successfn) {

    let param = options.param || {}
    param['_R'] = Math.random();

    let data = {}
    if (options.formatJSon) {
        data = param
    } else {
        data = $.param(param)
    }

    $.ajax({
        type: options.method,
        url: url,
        data: data,
        headers: options.formatJSon ? options.headers : {
            'Content-Type': 'application/x-www-form-urlencoded',
            'X-Requested-With': 'XMLHttpRequest',
        },
        beforeSend: function (xhr) {
            xhr.setRequestHeader("Authorization", localStorage.getItem("Authorization"));
        },
        success: function (result) {

            var code = result.code;
            var msg = result.msg;
            if (code && code == 200) {
                successfn(result);
            } else {
                if (code == 20001 || code == 20002 || code == 20003 || code == 20005) {
                    //返回错误页
                    parent.location.href = baseURL + "error.html"
                } else {
                    alert(msg);
                }
            }
        }
    });

}