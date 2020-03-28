$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'produce/contract/queryForPage',
        datatype: "json",
        colModel: [
            {label: 'ID', name: 'id', index: "id", width: 45, hidden: true, key: true},
            {
                label: '状态', name: 'status', width: 50, formatter: function (value, options, row) {
                    return value === 0 ?
                        '<span class="label label-info">草稿</span>' :
                        '<span class="label label-success">提交</span>';
                }
            },
            {label: '状态', name: 'status', index: "status",hidden: true,width: 45},
            {label: '合同编号', name: 'contractCode', index: "contractCode", width: 120},
            {label: '工程名称', name: 'projectName',index:'projectName', width: 200},
            {label: '客户ID', name: 'customerId',index:'customerId',hidden:true, width: 200},
            {label: '客户名称', name: 'customerName',index:'customerName', width: 200},
            {label: '站点ID', name: 'stationId',index:'stationId',hidden:true, width: 75},
            {label: '站点名称', name: 'stationName',index:'stationName', width: 75},
            {label: '施工单位', name: 'constructionUnit',index:'constructionUnit', width: 200},
            {label: '核算单位', name: 'accountingUnit',index:'accountingUnit', width: 200},
            {label: '合同类型', name: 'contractType',index:'contractType', width: 75},
            {label: '计划数量', name: 'planQuantity', width: 75},
            {label: '计划日期', name: 'planDate',index:'planDate', width: 75},
            {label: '供货日期', name: 'deliveryDate',index:'deliveryDate', width: 75},
            {label: '金额上限', name: 'maxAmount', width: 75},
            {label: '结算方式', name: 'settlementMethod',index:'settlementMethod', width: 75},
            {label: '合同负责人', name: 'contractResponsiblePerson', index:'contractResponsiblePerson', width: 75},
            {label: '施工地点', name: 'constructionPlace', index:'constructionPlace', width: 200},
            {label: '签订日期', name: 'signDate', index:'signDate', width: 75},
            {label: '联系人', name: 'liaisonPerson', index:'liaisonPerson', width: 75},
            {label: '联系电话', name: 'telephone', index:'telephone', width: 75},
            {label: '浇筑方式', name: 'pourMethod', index:'pourMethod', width: 75},
            {label: '浇筑部位', name: 'pourPart', index:'pourPart', width: 75},
            {label: '强度等级C', name: 'intensityLevel', index:'intensityLevel', width: 75},
            {label: '抗渗等级P', name: 'impermeabilityLevel', index:'impermeabilityLevel', width: 75},
            {label: '抗冻等级F', name: 'frostResistanceLevel', index:'frostResistanceLevel', width: 75},
            {label: '抗折等级Z', name: 'bendLevel', index:'bendLevel', width: 75},
            {label: '防腐等级P', name: 'anticorrosiveLevel', index:'anticorrosiveLevel', width: 75},
            {label: '技术要求', name: 'technicalRequirement', index:'technicalRequirement', width: 150},
            {label: '其他要求', name: 'otherRequirement', index:'otherRequirement', width: 150},
            {label: '坍落度', name: 'slump', index:'slump', width: 75},
            {label: '混凝土量(方)', name: 'concreteQuantity', index:'concreteQuantity', width: 75},
            {label: '产品规格', name: 'productSpec', index:'productSpec', width: 75},
            {label: '材料种类', name: 'materialType', index:'materialType', width: 75},
            {label: '石子种类', name: 'stoneType', index:'stoneType', width: 75},
            {label: '砂子种类', name: 'sandType', index:'sandType', width: 75},
            {label: '石子粒径', name: 'stoneDiameter', index:'stoneDiameter', width: 75},
            {label: '水泥品种', name: 'cementVariety', index:'cementVariety', width: 75},
            {label: '水泥标号', name: 'cementLable', index:'cementLable', width: 75}

        ],
        viewrecords: true,
        height: 340,
        rowNum: 10,
        rowList: [10, 20, 50, 100],
        rownumbers: true,
        rownumWidth: 25,
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
        }

    });
});


var vm = new Vue({
    el: '#app',
    data: {
        queryParam: {
            contractCode: ""
        },
        contract:{},
        stationList:[],
        selected:"",
        showList: true,
        title: null
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            //$("#contractCode").attr("readOnly",true);
            $("#saveAndSubmit").show();
            vm.title = "新增";
            vm.contract = {id:null,stationId:vm.stationList[0].id};
            vm.selected = vm.stationList[0].id;
            vm.showList = false;
        },
        getStation: function(){
            //加载搅拌站点数据
            $.get(baseURL + "base/station/queryForList", function(result){
                vm.stationList = result.data;
                vm.selected = vm.stationList[0].id;
                vm.contract.stationId = vm.stationList[0].id;
            })
        },
        changeSelect: function(event){
            vm.contract.stationId = event.target.value;

            //var station =  document.getElementById('station');
            //vm.contract.id = station.options[station.selectedIndex].value;
            //var text = station.options[station.selectedIndex].text;
        },
        update: function () {
            vm.contract = getSelectedOneRow();
            if (isBlank(this.contract.id)) {
                return;
            }
            if (vm.contract.status == 1) {
                alert("已提交的数据不能修改！");
                return;
            }
            $("#saveAndSubmit").hide();
            vm.selected = vm.contract.stationId;
            vm.showList = false;
            //vm.title = "修改";
        },
        saveAndSubmit: function(){
            $.ajax({
                type: "POST",
                url: baseURL + "produce/contract/saveAndSubmit",
                contentType: "application/json",
                data: JSON.stringify(vm.contract),
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
            var url = vm.contract.id == null ? "produce/contract/save" : "produce/contract/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.contract),
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
            var contractIds = getSelectedRows();
            if (contractIds == null) {
                return;
            }

            $.ajax({
                type: "POST",
                url: baseURL + "produce/contract/submit",
                contentType: "application/json",
                data: JSON.stringify(contractIds),
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
            var contractIds = getSelectedRows();
            if (contractIds == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "produce/contract/delete",
                    contentType: "application/json",
                    data: JSON.stringify(contractIds),
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
        importProject: function(){
            var rowDatas = getSelectedRowDatas();
            if (rowDatas == null && rowDatas.length > 0) {
                return;
            }

            $.ajax({
                type: "POST",
                url: baseURL + "produce/contract/importProject",
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
                postData: {'contractCode': vm.queryParam.contractCode},
                page: page
            }).trigger("reloadGrid");
        }
    },
    mounted:function(){
        this.getStation();
    }


});