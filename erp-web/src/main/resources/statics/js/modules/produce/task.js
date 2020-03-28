$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'produce/task/queryForPage',
        datatype: "json",
        colModel: [
            {label: 'ID', name: 'id', type:"hidden", width: 45,hidden: true, key: true},
            {
                label: '状态', name: 'status', width: 50, formatter: function (value, options, row) {
                    return value === 0 ?
                        '<span class="label label-info">草稿</span>' :
                        '<span class="label label-success">提交</span>';
                }
            },
            {label: '状态', name: 'status', index: "status",hidden: true,width: 45},
            {label: '任务单号', name: 'taskCode', index: "taskCode", width: 120},
            {label: '工程ID', name: 'projectId', index: "projectId",hidden: true, width: 100},
            {label: '工程编号', name: 'projectCode', index: "projectCode", width: 120},
            {label: '工程名称', name: 'projectName', index: "projectName", width: 200},
            {label: '合同编号', name: 'contractCode', index: "contractCode", width: 120},
            {label: '合同ID', name: 'contractId', index: "contractId",hidden: true, width: 120},
            {label: '站别ID', name: 'stationId', index: "stationId",  hidden: true,width: 80},
            {label: '站别',    name: 'stationName', index: "stationName", width: 80},
            {label: '客户ID', name: 'customerId',index:'customerId',hidden:true, width: 200},
            {label: '客户名称', name: 'customerName',index:'customerName', width: 200},
            {label: '施工单位', name: 'constructionUnit', index: "constructionUnit",  width: 200},
            {label: '浇筑方式', name: 'pourMethod', index:"pourMethod", width: 100},
            {label: '浇筑部位', name: 'pourPart', index:"pourPart", width: 200},
            {label: '配比编号', name: 'recipeId', index:"recipeId", width: 100},
            {label: '强度等级C', name: 'intensityLevel', index:"intensityLevel", width: 100},
            {label: '供货日期', name: 'deliveryDate', index:"deliveryDate", width: 100},
            {label: '计划日期', name: 'planDate', index:"planDate", width: 100},
            {label: '计划数量', name: 'planQuantity', index:"planQuantity", width: 100},
            {label: '超出数量', name: 'outQuantity', index:"outQuantity", width: 100},
            {label: '结束数量', name: 'endQuantity', index:"endQuantity", width: 100},
            {label: '产品规格', name: 'productSpec', index:'productSpec', width: 75},
            {label: '顺序ID', name: 'orderId', index:"orderId", width: 100},
            {label: '核算单位', name: 'accountingUnit',index:'accountingUnit', width: 200},
            {label: '坍落度', name: 'slump',index:'slump', width: 100},
            {label: '抗渗等级P', name: 'impermeabilityLevel', index:'impermeabilityLevel', width: 75},
            {label: '抗冻等级F', name: 'frostResistanceLevel', index:'frostResistanceLevel', width: 75},
            {label: '抗折等级Z', name: 'bendLevel', index:'bendLevel', width: 75},
            {label: '防腐等级P', name: 'anticorrosiveLevel', index:'anticorrosiveLevel', width: 75},
            {label: '技术要求', name: 'technicalRequirement', index:'technicalRequirement', width: 150},
            {label: '其他要求', name: 'otherRequirement', index:'otherRequirement', width: 150},
            {label: '负责人ID', name: 'employeeId', index:"employeeId",hidden: true, width: 100},
            {label: '负责人', name: 'employeeName', index:"employeeName", width: 100},
            {label: '工程核心信息', name: 'projectCoreInfo', index:"projectCoreInfo", width: 100},
            {label: '运输距离', name: 'transportDistance', index:"transportDistance", width: 100},
            {label: '送货地址电话', name: 'deliveryTelephone', index:"deliveryTelephone", width: 100}

        ],
        viewrecords: true,
        height: 340,
        rowNum: 10,
        rowList: [10, 20, 50, 100],
        rownumbers: true,
        rownumHight:10,
        autowidth: true,
        shrinkToFit:false,
        autoScroll:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "data.list",
            page: "data.pageNum",
            total: "data.pages",
            records: "data.total"
        },
        prmNames:{
            page:"pageNum",
            rows:"pageSize"
        },
        // loadComplete:function(){
        //     var grid = $("#jqGrid");
        //     for (var i = 0; i < 10; i++) {
        //         grid.setRowData ( 10, false, {height: 35+i*2} );
        // }}

    });
});

var vm = new Vue({
    el: '#app',
    data: {
        quqery: {
            taskCode: ""
        },
        task:{},
        selected:"",
        stationList:[],
        showList: true,
        title: null
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.task = {};
            $("#saveAndSubmit").show();
            vm.showList = false;
            vm.title = "新增";
        },
        update: function() {
            vm.task = getSelectedOneRow();
            if (isBlank(this.task.id)) {
                return;
            }
            if (vm.task.status == 1) {
                alert("已提交的数据不能修改！");
                return;
            }
            $("#saveAndSubmit").hide();
            vm.showList = false;
            vm.title = "修改";
        },
        selectProject:function(){
            layer.open({
                type: 2,
                //offset: ['100px', '200px'],
                offset: 'auto',
                skin: '',
                title: "选择工程",
                area: ['1000px', '500px'],
                shade: 0.3,
                fixed:true,
                resize:false,
                shadeClose: false,
                content: jQuery("#layer"),
                content: [baseURL + 'view/component/selectProject.html'],
                btn: ['确定', '取消'],
                yes: function (index) {
                    var data = window["layui-layer-iframe" + index].callbackdata();
                    if(data !=null){
                        vm.setSelectProjectData(index,data);
                    }

                },
                success:function(layero,index){
                   //弹出层初始化调用此方法
                },
                end: function(){
                    //弹出层销毁调用此方法
                }

            });

        },
        saveAndSubmit: function(){
            $.ajax({
                type: "POST",
                url: baseURL + "produce/task/saveAndSubmit",
                contentType: "application/json",
                data: JSON.stringify(vm.task),
                success: function (result) {
                    if (result.code === 200) {
                        alert(result.msg, function () {
                            vm.reload();
                        });
                    }
                }
            });
        },
        saveOrUpdate: function () {
            var url = vm.task.id == null ? "produce/task/save" : "produce/task/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.task),
                success: function (result) {
                    if (result.code === 200) {
                        alert(result.msg, function () {
                            vm.reload();
                        });
                    }
                }
            });
        },
        submit: function(){
            var taskIds = getSelectedRows();
            if (taskIds == null) {
                return;
            }

            $.ajax({
                type: "POST",
                url: baseURL + "produce/task/submit",
                contentType: "application/json",
                data: JSON.stringify(taskIds),
                success: function (result) {
                    if (result.code === 200) {
                        if(result.data > 0 ){
                            alert(result.msg, function () {
                                vm.reload();
                            });
                        }else{
                            alert(result.data);
                        }

                    }
                }
            });
        },
        del: function(){
            confirm('确定要删除选中的记录？', function () {
                var taskIds = getSelectedRows();
                if (taskIds == null) {
                    return;
                }
                $.ajax({
                    type: "POST",
                    url: baseURL + "produce/task/delete",
                    contentType: "application/json",
                    data: JSON.stringify(taskIds),
                    success: function (result) {
                        if (result.code === 200) {
                            if(result.data > 0 ){
                                alert(result.msg, function () {
                                    vm.reload();
                                });
                            }else{
                                alert(result.data);
                            }

                        }
                    }
                });
            });
        },
        setSelectProjectData: function(index,data){
            this.$set(this.task, 'contractCode', data.contractCode);
            this.$set(this.task, 'projectId', data.id);
            this.$set(this.task, 'projectCode', data.projectCode);
            this.$set(this.task, 'projectName', data.projectName);
            this.$set(this.task, 'stationId', data.stationId);
            this.$set(this.task, 'stationName', data.stationName);
            this.$set(this.task, 'constructionUnit', data.constructionUnit);
            this.$set(this.task, 'accountingUnit', data.accountingUnit);
            this.$set(this.task, 'deliveryDate', data.delivery_date);
            this.$set(this.task, 'pourMethod', data.pourMethod);
            this.$set(this.task, 'pourPart', data.pourPart);
            this.$set(this.task, 'planQuantity', data.planQuantity);
            this.$set(this.task, 'intensityLevel', data.intensityLevel);
            this.$set(this.task, 'impermeabilityLevel', data.impermeabilityLevel);
            this.$set(this.task, 'frostResistanceLevel', data.frostResistanceLevel);
            this.$set(this.task, 'bendLevel', data.bendLevel);
            this.$set(this.task, 'anticorrosiveLevel', data.anticorrosiveLevel);
            this.$set(this.task, 'slump', data.slump);
            this.$set(this.task, 'transportDistance', data.transportDistance);
            this.$set(this.task, 'customerId', data.customerId);
            this.$set(this.task, 'customerName', data.customerName);
            this.$set(this.task, 'planDate', data.planDate);
            layer.close(index);
        },
        importTask: function(){
            var rowDatas = getSelectedRowDatas();
            if (rowDatas == null && rowDatas.length > 0) {
                return;
            }

            $.ajax({
                type: "POST",
                url: baseURL + "produce/task/importProject",
                contentType: "application/json",
                data: JSON.stringify(rowDatas),
                success: function (result) {
                    if (result.code === 200) {
                        if(result.data > 0 ){
                            alert(result.msg, function () {
                                vm.reload();
                            });
                        }else{
                            alert(result.data);
                        }

                    }
                }
            });

        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'projectCode': vm.query.taskCode},
                page: page
            }).trigger("reloadGrid");
        }

    }


});
