<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
    
<div class="content_wrap">
    <div class="zTreeDemoBackground right">
        <ul id="menuManage" class="ztree"></ul>
    </div>
</div>    
<script>
var zTreeSetting = {
        view: {
            addHoverDom: addHoverFun,
            removeHoverDom: removeHoverFun,
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
        }
    };
	function addHoverFun(treeId, treeNode) {
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
	            var zTree = $.fn.zTree.getZTreeObj("treeMenu");
	            zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
	            return false;
	        });
	    }
	};
	
	function removeHoverFun(treeId, treeNode) {
	    console.log("remove hover dom");
	};

    var menuNodes =[{ id:1, pId:0, name:"根节点", open:true}];
    $(document).ready(function(){
   	 $.fn.zTree.init($("#menuManage"), zTreeSetting, menuNodes);
    });
     
</script>