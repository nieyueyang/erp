$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'produce/project/queryForPage',
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
            {label: '工程编号', name: 'projectCode', index: "projectCode", width: 120},
            {label: '工程名称', name: 'projectName', index: "projectName", width: 200},
            {label: '合同ID', name: 'contractId', index: "contractId",hidden: true, width: 120},
            {label: '合同编号', name: 'contractCode', index: "contractCode", width: 120},
            {
                label: '工程状态', name: 'projectStatus', width: 75, formatter: function (value, options, row) {
                    if(value ===0){
                        return '<span>施工</span>';
                    }else if(value ===1){
                        return '<span>竣工</span>';
                    }else if(value ===2){
                        return '<span>暂停</span>';
                    }else{
                        return '';
                    }
                }
            },
            {label: '工程状态', name: 'projectStatus', index: "projectStatus", hidden: true, width: 75},
            {label: '施工单位', name: 'constructionUnit', index: "constructionUnit",  width: 200},
            {label: '核算单位', name: 'accountingUnit', index:"accountingUnit", width: 200},
            {label: '投资单位', name: 'investmentUnit', index:"investmentUnit", width: 200},
            {label: '监理单位', name: 'supervisorsUnit', index:"supervisorsUnit", width: 200},
            {label: '混凝土方量',name: 'concreteQuantity', index:"concreteQuantity", width: 100},
            {label: '开工日期', name: 'commencementDate', index:"commencementDate", width: 85},
            {label: '计划工期', name: 'planPeriod', index:"planPeriod", width: 100},
            {label: '工程类别', name: 'projectCategory', index:"projectCategory", width: 100},
            {label: '工程区县', name: 'projectCounty', index:"projectCounty", width: 100},
            {label: '运输距离', name: 'transportDistance', index:"transportDistance", width: 100},
            {label: '运输费用', name: 'transportCost', index:"transportCost", width: 100},
            {label: '施工地点', name: 'constructionPlace', index:"constructionPlace", width: 100},
            {label: '联系电话', name: 'telephone', index:"telephone", width: 100},
            {label: '联系人', name: 'liaisonPerson', index:"liaisonPerson", width: 100},
            {label: '法定代表人', name: 'legalRepresentative', index:"legalRepresentative", width: 100},
            {label: '混凝土技术要求特点', name: 'technicalRequirement', index:"technicalRequirement", width: 200},
            {label: '混凝土供应企业', name: 'supplier', index:"supplier", width: 200}
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
            projectCode: ""
        },
        project:{},
        showList: true,
        title: null
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.project = {};
            $("#saveAndSubmit").show();
            vm.showList = false;
            vm.title = "新增";
            vm.project = {id:null};
        },
        update: function () {
            vm.project = getSelectedOneRow();
            if (isBlank(this.project.id)) {
                return;
            }
            if (vm.project.status == 1) {
                alert("已提交的数据不能修改！");
                return;
            }
            $("#saveAndSubmit").hide();
            vm.showList = false;
            vm.title = "修改";
        },
        selectContract:function(){
            layer.open({
                type: 2,
                //offset: ['100px', '200px'],
                offset: 'auto',
                skin: '',
                title: "选择合同",
                area: ['1000px', '500px'],
                shade: 0.3,
                fixed:true,
                resize:false,
                shadeClose: false,
                content: jQuery("#layer"),
                content: [baseURL + 'view/component/selectContract.html'],
                btn: ['确定', '取消'],
                yes: function (index) {
                    var data = window["layui-layer-iframe" + index].callbackdata();
                    if(data !=null){
                        vm.setSelectContractData(index,data);
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
                url: baseURL + "produce/project/saveAndSubmit",
                contentType: "application/json",
                data: JSON.stringify(vm.project),
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
            var url = vm.project.id == null ? "produce/project/save" : "produce/project/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.project),
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
            var projectIds = getSelectedRows();
            if (projectIds == null) {
                return;
            }

            $.ajax({
                type: "POST",
                url: baseURL + "produce/project/submit",
                contentType: "application/json",
                data: JSON.stringify(projectIds),
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
                var projectIds = getSelectedRows();
                if (projectIds == null) {
                    return;
                }
                $.ajax({
                    type: "POST",
                    url: baseURL + "produce/project/delete",
                    contentType: "application/json",
                    data: JSON.stringify(projectIds),
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
        setSelectContractData: function(index,data){
            this.$set(this.project, 'contractId', data.id);
            this.$set(this.project, 'contractCode', data.contractCode);
            this.$set(this.project, 'projectName', data.projectName);
            this.$set(this.project, 'constructionUnit', data.constructionUnit);
            this.$set(this.project, 'accountingUnit', data.accountingUnit);
            this.$set(this.project, 'constructionPlace', data.constructionPlace);
            this.$set(this.project, 'liaisonPerson', data.liaisonPerson);
            this.$set(this.project, 'telephone', data.telephone);
            this.$set(this.project, 'transportCost', data.transportCost);
            this.$set(this.project, 'concreteQuantity', data.concreteQuantity);
            this.$set(this.project, 'technicalRequirement', data.technicalRequirement);
            layer.close(index);
        },
        importTask: function(){
            var rowDatas = getSelectedRowDatas();
            if (rowDatas == null && rowDatas.length > 0) {
                return;
            }

            $.ajax({
                type: "POST",
                url: baseURL + "produce/project/importProject",
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
                postData: {'projectCode': vm.query.projectCode},
                page: page
            }).trigger("reloadGrid");
        }

    }


});
