app.factory('bookService', [ '$resource', function($resource) {
	 return {
		 books: $resource('rest/book'),
	     books2: $resource('rest/book')
	    };
} ]);