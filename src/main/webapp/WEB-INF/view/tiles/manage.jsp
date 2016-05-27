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
            	名称<input type="text" id="menuname" name="menuname"/>
            </div>
            <div>
	            链接<input type="text" id="menuhref" name="menuhref"/>
            </div>
            <div>
	            打开位置<select id="target" name="target">
					  <option value ="_blank">新窗口窗口</option>
					  <option value ="_self">当前窗口</option>
				</select>
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
            <div>
	            ID<input type="text" id="menucode" name="menucode" readonly/>
            </div>
            <div>
	            <input type="button" id="addBtn" value="新增"/>
	            <input type="button" id="editBtn" value="修改"/>
	            <input type="button" id="delBtn" value="删除"/>
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
            enable: true,
            showRenameBtn: false,
            showRemoveBtn: false
        },
        async:{
        	enable:true,
        	url:"",
        },
        callback:{
        	beforeRemove: beforeRemoveFunc,
        	onClick: nodeClick
        }
    };
    
    var newCount = 1;
    
	function addHover(treeId, treeNode) {
		var nodeId = treeNode.id;//当前节点id
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
			$.scojs_message("不能删除根节点", $.scojs_message.TYPE_ERROR);
			return false;
		}
	}
	
	//单击节点
	function nodeClick(event, treeId, treeNode){
		console.log("after click==>"+JSON.stringify(treeNode));
		 var nodeName = treeNode.name;
		 var href = treeNode.url;
		 var level = treeNode.level;
		 var id = treeNode.id;
		 var pId = treeNode.pId;
		 var target = treeNode.target;
		 $("#menuname").val(nodeName);
		 $("#menuhref").val(href);
		 $("#level").val(level);
		 $("#menucode").val(id);
		 $("#parentcode").val(pId);
		 //$("#target").val(target);
		 $("select option[value='"+target+"']").attr("selected", "selected"); 
	}
	
	
	//添加按钮点击
	$("#addBtn").click(function(){
		var zTree = $.fn.zTree.getZTreeObj("menuManage");
		var nodes = zTree.getSelectedNodes();
		var treeNode = nodes[0];
		if (treeNode) {
			//treeNode = zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, isParent:isParent, name:"new node" + (newCount++)});
			addMenu(treeNode);
		} else {
			$.scojs_message("请选择一个节点", $.scojs_message.TYPE_ERROR);
		}
	});
	
	
	//修改按钮点击
	$("#editBtn").click(function(){
		var zTree = $.fn.zTree.getZTreeObj("menuManage");
		var nodes = zTree.getSelectedNodes();
		if(nodes.length == 0){
			$.scojs_message("请选择一个节点", $.scojs_message.TYPE_ERROR);
			return;
		}
		var argObj = getArgObj("menuForm");
		console.log("argObj==>"+JSON.stringify(argObj));
		$.ajax({
			type:"POST",
			url:"manage/editMenu",
			data:argObj,
			dataType:"text",
	  		beforeSend:function(XMLHttpRequest){
	      	},
		   	success:function(data,status){
		   		var jsonData = $.parseJSON(data);
		   		var code = jsonData.code;
		   		if(code == 0){
		      		$.scojs_message("编辑成功", $.scojs_message.TYPE_OK);
		      		nodes[0].name = $("#menuname").val();
		      		nodes[0].url = $("#menuhref").val();
		      		zTree.updateNode(nodes[0]);
		   		}else if(code == -1){
		      		$.scojs_message("操作异常", $.scojs_message.TYPE_ERROR);
		   		}
		   		
		   	},
	      	error:function(){
	      		$.scojs_message("edit menu error", $.scojs_message.TYPE_ERROR);
	      	}
      });
	});

	//初始化菜单树
	function loadMenuLst(){
		var argObj = new Object();
		$.ajax({
			type:"POST",
			url:"manage/getMenuLst/",
			data:argObj,
			dataType:"text",
	  		beforeSend:function(XMLHttpRequest){
	      	},
		   	success:function(data,status){
		   	    //数据节点
		   	    var menuNodes =[{ id:0, pId:null, name:"根节点", open:true,level:-1}];
		   		//$.scojs_message("load menu list success", $.scojs_message.TYPE_OK);
		   		var menuLst = $.parseJSON(data);
		   		$.merge(menuNodes,menuLst);
		   	    $.fn.zTree.init($("#menuManage"), zTreeSetting, menuNodes);
		   	},
	      	complete:function(XMLHttpRequest,status){
	      	},
	      	error:function(){
	      		$.scojs_message("load menu list error", $.scojs_message.TYPE_ERROR);
	      	}
      });
	}
	
    $(document).ready(function(){
    	loadMenuLst();
    });
    
    /**
        新增菜单节点
        treeNode:node object
        parentId:parent node id
        nodeName:visual text
        href:link value
    **/
    function addMenu(treeNode){
        var nodeId = treeNode.id;
    	$("#parentcode").val(nodeId);//parent code
		var nodeName = $("#menuname").val();//名称
		var menuHref = $("#menuhref").val();//链接
		
		var level = treeNode.level;//当前节点级别
		var willAddedLevel = level + 1;
		var level = $("#level").val(willAddedLevel);//级别
		
		if(nodeName == ""){
			$.scojs_message("请输入子节点名称", $.scojs_message.TYPE_ERROR);
			$("#menuname").focus();
			return false;
		}
		if(menuHref == ""){
			$.scojs_message("请输入链接值", $.scojs_message.TYPE_ERROR);
			$("#menuhref").focus();
			return false;
		}
    	var argObj = {};//参数
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
	      		console.log("data:"+data);
	      		console.log("typeof data:"+typeof(data));
		   		var jsonData = $.parseJSON(data);
		   		var code = jsonData.code;
		   		if(jsonData.code == 0){
			   		var nodeId = jsonData.obj.menucode;
			   		var parentId = jsonData.obj.parentcode;
			   		var nodeName = jsonData.obj.menuname;
			   		var url = jsonData.obj.url;
			   		
			   		var zTree = $.fn.zTree.getZTreeObj("menuManage");//获取zTree对象
	                zTree.addNodes(treeNode, {id:nodeId, pId:parentId, name:nodeName,url:url});
		      		$.scojs_message("成功添加", $.scojs_message.TYPE_OK);
		   		}else if(code == 1){
		      		$.scojs_message("已经存在相同的记录", $.scojs_message.TYPE_ERROR);
		   		}else if(code == -1){
		      		$.scojs_message("操作没有成功", $.scojs_message.TYPE_ERROR);
		   		}
		   		
		   	},
	      	complete:function(XMLHttpRequest,status){
	      	},
	      	error:function(){
	      		$.scojs_message("add menu error", $.scojs_message.TYPE_ERROR);
	      	}
      });
    }
</script>