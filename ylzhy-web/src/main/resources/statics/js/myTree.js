	
	var zTreeObj;
	var setting = {
		data: {  
	        simpleData: {  
	            enable:true
	        }  
	    },
	    callback: {
			onClick: zTreeOnClick,
			onAsyncSuccess: zTreeOnAsyncSuccess
		}
	};
	var zNodes = [];

	$.ajax({
        type: "POST",
        url: "http://localhost:8086/ylzhy/company/api/loadSbtreelist",
        data: {
            
        },
        dataType: "json",
        success: function(data){
            console.log(data)
            zNodes = data.treeList;
            zTreeObj = $.fn.zTree.init($("#tree-obj"), setting, zNodes);
            zTreeOnAsyncSuccess()
        }
    });

	function zTreeOnAsyncSuccess(event, treeId, treeNode, msg){
      	var treeObj = $.fn.zTree.getZTreeObj("tree-obj");
      	var nodes = treeObj.getNodes();
      	var childNodes = treeObj.transformToArray(nodes[0]);
      	treeObj.selectNode(childNodes[1])
         if (nodes.length>0) {
          	for(var i=0;i<nodes.length;i++){
          		treeObj.expandNode(nodes[0], true);
          	}
      	}
      	$('#loop').attr("value",childNodes[1].id);
    }
	
	function zTreeOnClick(event, treeId, treeNode) {
		//console.log(event.target)
	    console.log(treeNode.id);
	    var loopId = treeNode.id;
	    $('#loop').attr("value",loopId);
	};







	//用按钮查询节点
	// function searchNodes(){
	// 	var treeObj = $.fn.zTree.getZTreeObj("tree-obj");
	// 	var keywords =$ ("#keyword").val();
	//     var nodes = treeObj.getNodesByParamFuzzy("name", keywords, null);
	// 	if (nodes.length>0) {
	// 		treeObj.selectNode(nodes[0]);
	// 	}
	// }

	//input框变化时查询节点
	// document.getElementById("keyword").addEventListener("input", test, false);
	// function test(){
	// 	var treeObj = $.fn.zTree.getZTreeObj("tree-obj");
	// 	var keywords = $("#keyword").val();
	//     var nodes = treeObj.getNodesByParamFuzzy("name", keywords, null);
	// 	for( var i=0, l=nodes.length; i<l; i++) {
	// 		treeObj.selectNode(nodes[i]);
	// 		console.log(nodes[i])
	// 		nodes.addClass("curSelectedNode");
	// 	}
	// 	 updateNodes(true)
	// }

	//将nodeList指标设为高亮，并更新
	// function updateNodes(highlight) {
	// 	var treeObj = $.fn.zTree.getZTreeObj("tree-obj");
	// 	var keywords = $("#keyword").val();
	//     var nodes = treeObj.getNodesByParamFuzzy("name", keywords, null);
	// 	for( var i=0, l=nodes.length; i<l; i++) {
	// 		nodes[i].highlight = highlight;
	// 		treeObj.updateNode(nodes[i]);
	// 	}
	// }
	// function getFontCss(treeId, treeNode) {
	// 	return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
	// }