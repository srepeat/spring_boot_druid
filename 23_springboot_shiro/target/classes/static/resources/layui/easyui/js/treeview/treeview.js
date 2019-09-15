



function initTree(data) {
    var $treeview=$('#treeview-checkable').treeview({
        data: data,
        showIcon: false,
        showCheckbox: true,
        onNodeChecked: function(event, node) { //选中节点
            updateChecked($treeview,node,true);
            levelCheck($treeview,node);
        },
        onNodeUnchecked: function(event, node) { //取消选中节点
            updateChecked($treeview,node,false);
        }
    });
}

function updateChecked(treeview,node,check) {
    var nodes=node.nodes;
    $.each(nodes, function (idx,obj) {
        treeview.treeview(check ? 'checkNode':'uncheckNode', [obj.nodeId, { silent: true }]);
        updateChecked(treeview,obj,check);
    })
}

function levelCheck(treeview,node) {
    var parentNode=treeview.treeview('getParent', node);
    while(parentNode.nodeId){
        treeview.treeview('checkNode', [parentNode.nodeId, { silent: true }]);
        parentNode=treeview.treeview('getParent', parentNode);
    }

}