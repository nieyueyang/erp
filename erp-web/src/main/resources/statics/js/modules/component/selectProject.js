$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'produce/project/queryNotImport',
        datatype: "json",
        colModel: [
            {label: 'ID', name: 'id', width: 45,hidden: true, key: true},
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


            {label: '站点ID', name: 'stationId', width: 45,hidden: true},
            {label: '站点名称', name: 'stationName', width: 45,hidden: true},
            {label: '客户ID', name: 'customerId', width: 45,hidden: true},
            {label: '客户名称', name: 'customerName', width: 45,hidden: true},
            {label: '送货日期', name: 'deliveryDate', width: 45,hidden: true},
            {label: '浇筑方式', name: 'pourMethod', width: 45,hidden: true},
            {label: '浇筑部位', name: 'pourPart', width: 45,hidden: true},
            {label: '计划日期', name: 'planDate', width: 45,hidden: true},
            {label: '计划数量', name: 'planQuantity', width: 45,hidden: true},
            {label: '强度等级C', name: 'intensityLevel', width: 45,hidden: true},
            {label: '抗渗等级P', name: 'impermeabilityLevel',width: 75,hidden: true},
            {label: '抗冻等级F', name: 'frostResistanceLevel',width: 75,hidden: true},
            {label: '抗折等级Z', name: 'bendLevel',width: 75,hidden: true},
            {label: '防腐等级P', name: 'anticorrosiveLevel',width: 75,hidden: true},
            {label: '防腐等级P', name: 'slump',width: 75,hidden: true},

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
        height: 270,
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
        ondblClickRow: function(rowid, iRow, iCol, e){
            var index = parent.layer.getFrameIndex(window.name);
            var rowData = $("#jqGrid").jqGrid("getRowData", rowid);
            parent.vm.setSelectProjectData(index,rowData);
        }

    });
});


var callbackdata = function () {
    vue.projectCode = getSelectedOneRow();
    return vue.projectCode;
};

var vue = new Vue({
    el: '#app',
    data: {
        queryParam: {
            projectCode: ""
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
                postData: {'projectCode': vue.queryParam.projectCode},
                page: page
            }).trigger("reloadGrid");
        }
    }
});

