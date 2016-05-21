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
        <form id="menuForm">
            <div>
            	上级节点ID<input type="text" id="parentcode" name="parentcode"/>
            </div>
            <div>
            	名称<input type="text" id="menuName" name="menuname"/>
            </div>
            <div>
	            链接<input type="text" id="menuHref" name="menuhref"/>
            </div>
            <div>
	            级别<input type="text" id="level" name="level"/>
            </div>
            <div>
	            可用<input type="radio" name="isenable" value="1" checked="checked"/>
	            禁用<input type="radio" name="isenable" value="0"/>
            </div>
            <div>
	            可见<input type="radio" name="isvisual" value="1" checked="checked"/>
	            隐藏<input type="radio" name="isvisual" value="0"/>
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
        		$("#parentcode").val(nodeId);//parent code
        		var level = treeNode.level;//当前节点级别
        		var willAddedLevel = level + 1;
        		var level = $("#level").val(willAddedLevel);//级别
        		
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
        		addMenu(treeNode);
                return false;
            });
        }
	};
	
	function removeHover(treeId, treeNode) {
	    //console.log("manage.jsp remove hover dom");
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
    
    /**
        新增菜单节点
        treeNode:node object
        parentId:parent node id
        nodeName:visual text
        href:link value
    **/
    function addMenu(treeNode){
    	var argObj = {};
    	argObj = getArgObj("menuForm");
    	console.log("argObj:"+JSON.stringify(argObj));
    	$.ajax({
			type:"POST",
			url:"manage/addMenu/",
			data:argObj,
			dataType:"text",
	  		beforeSend:function(XMLHttpRequest){
	      	},
		   	success:function(data,status){
	      		//$.scojs_message("information load success", $.scojs_message.TYPE_OK);
	      		console.log("data:"+data);
	      		console.log("typeof data:"+typeof(data));
		   		var jsonData = $.parseJSON(data);
		   		var nodeId = jsonData.menucode;
		   		var parentId = jsonData.parentcode;
		   		var nodeName = jsonData.menuname;
		   		
		   		var zTree = $.fn.zTree.getZTreeObj("menuManage");//获取zTree对象
                zTree.addNodes(treeNode, {id:nodeId, pId:parentId, name:nodeName});
	      		$.scojs_message("add menu success", $.scojs_message.TYPE_OK);
		   		
		   	},
	      	complete:function(XMLHttpRequest,status){
	      	},
	      	error:function(){
	      		$.scojs_message("add menu error", $.scojs_message.TYPE_ERROR);
	      	}
      });
    }
</script>