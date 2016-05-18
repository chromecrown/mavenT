<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
    
<div class="content_wrap">
    <div class="zTreeDemoBackground right">
        <ul id="menuManage" class="ztree"></ul>
    </div>
    <div>
        <form action="">
        
        </form>
    </div>
</div>    
<script>
    var zTreeSetting = {
		view: {
            addHoverDom: addHover,
            removeHoverDom: removeHover,
            selectedMulti: false
        },
        check: {
            enable: false
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        edit: {
            enable: true
        },
        async:{
        	enable:true,
        	url:"",
        },
        callback:{
        	beforeRemove: beforeRemoveFunc
        }
    };
    
    var newCount = 1;
    
	function addHover(treeId, treeNode) {
		console.log("manage.jsp addHoverFun");
		var sObj = $("#" + treeNode.tId + "_span");
        if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length > 0)
       	{
       	    return;
       	}
        var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
            + "' title='add node' onfocus='this.blur();'></span>";
        sObj.after(addStr);
        var btn = $("#addBtn_"+treeNode.tId);
        if(btn) 
        {
        	btn.bind("click", function(){
                var zTree = $.fn.zTree.getZTreeObj("menuManage");
                zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"newNodeManage" + (newCount++)});
                return false;
            });
        }
	};
	
	function removeHover(treeId, treeNode) {
	    console.log("manage.jsp remove hover dom");
	    $("#addBtn_"+treeNode.tId).unbind().remove();
	};
	
	//删除前检查
	function beforeRemoveFunc(treeId, treeNode){
		var parentNode = treeNode.getParentNode();
		if(parentNode == null){
			console.log("root node can not permit delete");
			return false;
		}
	}

	//数据节点
    var menuNodes =[{ id:1, pId:0, name:"根节点", open:true}];
    $(document).ready(function(){
   	 $.fn.zTree.init($("#menuManage"), zTreeSetting, menuNodes);
    });
     
</script>