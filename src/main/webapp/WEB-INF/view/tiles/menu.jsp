<h1>Metro Style</h1>
<h6>[ file path: super/metro.html ]</h6>
<div class="content_wrap">
    <div class="zTreeDemoBackground left">
        <ul id="treeDemo" class="ztree"></ul>
    </div>
</div>


<SCRIPT type="text/javascript" charset="utf-8">
        <!--
        var setting = {
            view: {
                addHoverDom: addHoverDom,
                removeHoverDom: removeHoverDom,
                selectedMulti: false
            },
            check: {
                enable: true
            },
            data: {
                simpleData: {
                    enable: true
                }
            },
            edit: {
                enable: true
            }
        };

        var zNodes =[
            { id:1, pId:0, name:"P11", open:true},
            { id:11, pId:1, name:"P1111"},
            { id:111, pId:11, name:"Leaf111"},
            { id:112, pId:11, name:"Leaf112"},
            { id:113, pId:11, name:"Leaf113"},
            { id:114, pId:11, name:"Leaf114"},
            { id:12, pId:1, name:"P12"},
            { id:121, pId:12, name:"Leaf121"},
            { id:122, pId:12, name:"Leaf122"},
            { id:123, pId:12, name:"Leaf123"},
            { id:124, pId:12, name:"Leaf124"},
            { id:13, pId:1, name:"P13", isParent:true},
            { id:2, pId:0, name:"P2"},
            { id:21, pId:2, name:"P21", open:true},
            { id:211, pId:21, name:"Leaf211"},
            { id:212, pId:21, name:"Leaf212"},
            { id:213, pId:21, name:"Leaf213"},
            { id:214, pId:21, name:"Leaf214"},
            { id:22, pId:2, name:"P22"},
            { id:221, pId:22, name:"Leaf221"},
            { id:222, pId:22, name:"Leaf222"},
            { id:223, pId:22, name:"Leaf223"},
            { id:224, pId:22, name:"Leaf224"},
            { id:23, pId:2, name:"P23"},
            { id:231, pId:23, name:"Leaf231"},
            { id:232, pId:23, name:"Leaf232"},
            { id:233, pId:23, name:"Leaf233"},
            { id:234, pId:23, name:"Leaf234"},
            { id:3, pId:0, name:"P3", isParent:true}
        ];

        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });

        var newCount = 1;
        function addHoverDom(treeId, treeNode) {
            var sObj = $("#" + treeNode.tId + "_span");
            if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
            var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                + "' title='add node' onfocus='this.blur();'></span>";
            sObj.after(addStr);
            var btn = $("#addBtn_"+treeNode.tId);
            if (btn) btn.bind("click", function(){
                var zTree = $.fn.zTree.getZTreeObj("treeDemo");
                zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
                return false;
            });
        };
        function removeHoverDom(treeId, treeNode) {
            $("#addBtn_"+treeNode.tId).unbind().remove();
        };
        //-->
    </SCRIPT>
</SCRIPT>