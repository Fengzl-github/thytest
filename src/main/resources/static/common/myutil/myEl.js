'use strict'

var myEl = (function () {

    //设置消息弹出
    function elAlert(status, msg) {
        const h = vm.$createElement;
        vm.$notify({
            title: '成功',
            message: h('i', { style: 'color: teal'}, msg),
            type: status,
            offset: 100,
            duration: 1500,
            showClose: false
        });
    }




    return{
        elAlert: elAlert
    }
})();