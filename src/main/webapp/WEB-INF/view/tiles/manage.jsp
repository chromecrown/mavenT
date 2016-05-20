<%@ page language="java" contentType="text/html; charset=UTF-8"  
    pageEncoding="UTF-8"%>
<style type="text/css">  
    .menu_e{
        float:left;
    }
</style> 
<div class="content_wrap">
    <div class="zTreeDemoBackground right menu_e">
        <ul id="menuManage" class="ztree"></ul>
    </div>
    <div class="menu_e">
        <form action="">
            <div>
            	上级节点ID<input type="text" id="parentCode" value=""/>
            </div>
            <div>
            	名称<input type="text" id="menuName" value=""/>
            </div>
            <div>
	            链接<input type="text" id="menuHref" value="／"/>
            </div>
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
		var nodeId = treeNode.id;//当前节点id
		var nodeName = $("#menuName").val();//名称
		var menuHref = $("#menuHref").val();//链接
		
		console.log("manage.jsp addHoverFun,nodeId="+JSON.stringify(treeNode));
		console.log("manage.jsp addHoverFun,nodeId="+nodeId);
		
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
        		$("#parentCode").val(nodeId);//parent code
        		if(nodeName == ""){
        			$.scojs_message("请输入子节点名称", $.scojs_message.TYPE_ERROR);
        			$("#menuName").focus();
        			return false;
        		}
        		if(menuHref == ""){
        			$.scojs_message("请输入链接值", $.scojs_message.TYPE_ERROR);
        			$("#menuHref").focus();
        			return false;
        		}
                var zTree = $.fn.zTree.getZTreeObj("menuManage");
                zTree.addNodes(treeNode, {id:(100 + newCount), pId:nodeId, name:nodeName + (newCount++)});
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
    var menuNodes =[{ id:0, pId:null, name:"根节点", open:true}];
    $(document).ready(function(){
   	 $.fn.zTree.init($("#menuManage"), zTreeSetting, menuNodes);
    });
     
</script>