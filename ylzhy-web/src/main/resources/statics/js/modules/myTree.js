
 var zTreeObj;

    var setting = {
    	// view: {
     //        fontCss: getFontCss
     //    }
    };

    var zNodes = [
	    {name:"智慧运维平台", open:true, 
	   	    children:[
	   	    	{name:"公司-A",
	   	    		children:[
	   	    			{name:"1楼",
		   	    			children:[
		   	    				{name:"加热机"},
		   	    				{name:"压力机"},
		   	    				{name:"啊"}
		   	    			]
	   	    			},
	   	    			{name:"2楼",
		   	    			children:[
		   	    				{name:"加热机"},
		   	    				{name:"压力机"}
		   	    			]
	   	    			}
	   	    		]
	   	    	},

	   	    	{name:"公司-B",
	   	    		children:[
	   	    			{name:"1楼",
		   	    			children:[
		   	    				{name:"加热机"},
		   	    				{name:"压力机"}
		   	    			]
	   	    			},
	   	    			{name:"2楼",
		   	    			children:[
		   	    				{name:"加热机"},
		   	    				{name:"压力机"},
		   	    				{name:"啊"}
		   	    			]
	   	    			}
	   	    		]
	   	    	}
	        ]
	    }
    ];
    // $(document).ready(function(){
    //    zTreeObj = $.fn.zTree.init($("#tree-obj"), setting, zNodes);
    //    $("#search-bt").click(searchNodes);
    // });

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
	// 	updateNodes(true)
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