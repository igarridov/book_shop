app.factory('bookService', [ '$resource', function($resource) {
	 return {
		 book: $resource('rest/book/:idbook'),
		 author: $resource('rest/book/:idbook/author'),
		 review: $resource('rest/book/:idbook/review')
	    };
} ]);