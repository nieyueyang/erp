$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'produce/recipe/queryForPage',
        datatype: "json",
        colModel: [
            {label: 'ID', name: 'id', index: "id", width: 45, hidden: true, key: true},
            {
                label: '状态', name: 'status', width: 50, formatter: function (value, options, row) {
                    return value === 0 ?
                        '<span class="label label-info">启用</span>' :
                        '<span class="label label-success">禁用</span>';
                }
            },
            {label: '状态', name: 'status', index: "status", width: 120,hidden: true},
            {label: '配比编号', name: 'recipeCode', index: "recipeCode", width: 120},
            {label: '配比名称', name: 'recipeName',index:'recipeName', width: 200},
            {
                label: '是否导入', name: 'importFlag', index: "importFlag", width: 100, formatter: function (value, options, row) {
                    return value === 1 ?
                        '<span class="label label-info">导入</span>' :
                        '<span class="label label-success">未导入</span>';
                }
            },
            {label: '是否导入', name: 'importFlag', index: "importFlag", width: 75,hidden: true},
            {label: '强度等级', name: 'intensityLevel',index:'intensityLevel', width: 100},
            {label: '水胶比', name: 'waterBinderRatio',index:'waterBinderRatio', width: 100},
            {label: '砂率', name: 'sandRate',index:'sandRate', width: 100},
            {label: '坍落度', name: 'slump',index:'slump', width: 100},
            {label: '水泥1', name: 'cement1',index:'cement1', width: 100},
            {label: '水泥2', name: 'cement2',index:'cement2', width: 100},
            {label: '水泥3', name: 'cement3',index:'cement3', width: 100},
            {label: '砂子1', name: 'sand1',index:'sand1', width: 100},
            {label: '砂子2', name: 'sand2',index:'sand2', width: 100},
            {label: '砂子31', name: 'sand3',index:'sand3', width: 100},
            {label: '大石量', name: 'bigStone',index:'bigStone', width: 100},
            {label: '中石量', name: 'middleStone',index:'middleStone', width: 100},
            {label: '小石量', name: 'smallStone',index:'smallStone', width: 100},
            {label: '粉煤灰', name: 'flyash',index:'flyash', width: 100},
            {label: '矿粉', name: 'minePowder',index:'minePowder', width: 100},
            {label: '外加剂1', name: 'additive1',index:'additive1', width: 100},
            {label: '外加剂2', name: 'additive2',index:'additive2', width: 100},
            {label: '外加剂3', name: 'additive3',index:'additive3', width: 100},
            {label: '外加剂4', name: 'additive4',index:'additive4', width: 100},
            {label: '水', name: 'water',index:'water', width: 100},
            {label: '其他1', name: 'other1',index:'other1', width: 100},
            {label: '其他2', name: 'other2',index:'other2', width: 100},
            {label: '抗渗等级', name: 'impermeabilityLevel',index:'impermeabilityLevel', width: 100},
            {label: '抗折等级', name: 'bendLevel',index:'bendLevel', width: 100},
            {label: '砂等级', name: 'sandLevel',index:'sandLevel', width: 100},
            {label: '石子最大粒径', name: 'stoneDiameter',index:'stoneDiameter', width: 100},
            {label: '石子最大粒径', name: 'apparentDensity',index:'apparentDensity', width: 100}

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
            recipeCode: ""
        },
        recipe:{},
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
            vm.title = "新增";
            vm.recipe = {id:null};
            vm.recipe.status = 0;
            vm.showList = false;
        },
        update: function () {
            vm.recipe = getSelectedOneRow();
            if (isBlank(this.recipe.id)) {
                return;
            }
            vm.showList = false;
            vm.title = "修改";
        },
        saveOrUpdate: function () {
            var url = vm.recipe.id == null ? "produce/recipe/save" : "produce/recipe/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.recipe),
                success: function (result) {
                    if (result.code === 200) {
                        alert(result.msg, function () {
                            vm.reload();
                        });
                    }
                }
            });
        },
        del: function(){
            var recipeIds = getSelectedRows();
            if (recipeIds == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "produce/recipe/delete",
                    contentType: "application/json",
                    data: JSON.stringify(recipeIds),
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
        importMixingPlant: function(){
            var recipeIds = getSelectedRows();
            if (recipeIds == null) {
                return;
            }
            $.ajax({
                type: "POST",
                url: baseURL + "produce/recipe/import",
                contentType: "application/json",
                data: JSON.stringify(recipeIds),
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
                postData: {'recipeCode': vm.queryParam.recipeCode},
                page: page
            }).trigger("reloadGrid");
        }
    },
    mounted:function(){

    }


});