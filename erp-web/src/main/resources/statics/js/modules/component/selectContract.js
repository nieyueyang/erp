$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'produce/contract/queryNotImport',
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
            {label: '站点名称', name: 'stationId',index:'stationId', width: 75},
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
        height: 270,
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
        },
        ondblClickRow: function(rowid, iRow, iCol, e){
            var index = parent.layer.getFrameIndex(window.name);
            var rowData = $("#jqGrid").jqGrid("getRowData", rowid);
            parent.vm.setSelectContractData(index,rowData);
        }

    });
});

var callbackdata = function () {
    vue.contract = getSelectedOneRow();
    return vue.contract;
};

var vue = new Vue({
    el: '#app',
    data: {
        queryParam: {
            contractCode: ""
        },
        contract:{},
        selected:""
    },
    methods: {
        query: function () {
            vue.reload();
        },
        reload: function () {
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'contractCode': vue.queryParam.contractCode},
                page: page
            }).trigger("reloadGrid");
        }
    }
});