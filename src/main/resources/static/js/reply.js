const replyManager = (() => {
	const getAll = (obj, callback) => {
		console.log("get All....");
	};
	
	const add = (obj, callback) => {
		console.log("add...");
	};
	
	const update = (obj, callback) => {
		console.log("update...");
	};
	
	const remove = (obj, callback) => {
		console.log("remove...");
	};
	
	return {
		getAll: getAll,
		add: add,
		update: update,
		remove: remove
	};
})();